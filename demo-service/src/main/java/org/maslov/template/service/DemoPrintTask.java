package org.maslov.template.service;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoPrintTask {

    private final PrintTaskService printTaskService;

    public DemoPrintTask(PrintTaskService printTaskService) {
        this.printTaskService = printTaskService;
    }


    @Scheduled(fixedDelay = 1000)
    void printTask() {
        printTaskService.executeTask();
    }

    @PreDestroy
    void predestroy() {
        log.info("predestroy BEGIN className: " + this.getClass().getName());
        log.info("In predestroy message: " + printTaskService.getMessage());
        log.info("predestroy END className: " + this.getClass().getName());
    }


}
