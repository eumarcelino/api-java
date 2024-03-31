package com.example.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EstudanteShedule {

    @Scheduled(cron = "0 0 12 * * *")
    public void executarTarefa() {
        log.info("Tarefa Executada!");
    }
}
