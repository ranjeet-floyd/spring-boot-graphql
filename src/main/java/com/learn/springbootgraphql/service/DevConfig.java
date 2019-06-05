package com.learn.springbootgraphql.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("dev")
@Configuration
@Slf4j
public class DevConfig {

    @PostConstruct
    private void init() {
        log.info("Loading Dev profile");
    }
}
