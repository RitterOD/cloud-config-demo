package org.maslov.template.controller;

import lombok.extern.slf4j.Slf4j;
import org.maslov.template.service.DemoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@Slf4j
public class AppWebController {

    private final DemoService demoService;
    private final ApplicationEventPublisher eventPublisher;


    public AppWebController(@Qualifier("configurableDemoService") DemoService demoService, ApplicationEventPublisher eventPublisher) {
        this.demoService = demoService;
        this.eventPublisher = eventPublisher;
    }



    @GetMapping("/")
    public ModelAndView getIndex(){
        return new ModelAndView("index", Map.of("network", demoService.getNetwork(),
                "contractAddress", demoService.getContractAddress(),
                "invorkerAddress", demoService.getInworkerAddress(),
                "invorkerPrivateKey", demoService.getInworkerPK(),
                "commit", demoService.getCommitHash()));
    }


    @PostMapping("/reload")
    public ModelAndView processReload() {
        log.info("IN RELOAD");
        eventPublisher.publishEvent(new RefreshEvent(this, "RefreshEvent", "Refreshing scope"));
        return new ModelAndView("redirect:/");
    }
}
