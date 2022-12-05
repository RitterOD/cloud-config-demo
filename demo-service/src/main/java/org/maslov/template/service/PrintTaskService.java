package org.maslov.template.service;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RefreshScope
public class PrintTaskService {


    public String getMessage() {
        return message;
    }

    private final String message;

    public PrintTaskService(@Value("${demoprinttask.message}")String message) {
        this.message = message;
    }

    void executeTask() {
        log.info("Print Task Message: " + message);
    }

    @PreDestroy
    void predestroy() {
        log.info("predestroy BEGIN className: " + this.getClass().getName());
        log.info("In predestroy message: " + message);
        log.info("predestroy END className: " + this.getClass().getName());
    }
}
