package com.demo.application;

import com.demo.common.model.SharedModel;
import io.quarkus.scheduler.Scheduled;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Slf4j
@ApplicationScoped
public class Application {

    @Transactional
    @Scheduled(every = "20s")
    void schedule() {

        SharedModel model = new SharedModel();

        model.setCreatedAt(LocalDateTime.now());
        model.setName("test");

        model.persist();

        log.info("shared model entries: " + SharedModel.count());
    }

}
