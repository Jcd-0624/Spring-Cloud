package com.chadj.traceone.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
@RequestMapping("trace-1")
public class TraceOneController {

    private final Logger logger = Logger.getLogger(getClass().toString());

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping()
    public String trace() {
        logger.info("----- call trace-1 -----");
        return restTemplate().getForEntity("http://localhost:8102/trace-2", String.class).getBody();
    }
}
