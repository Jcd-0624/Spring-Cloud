package com.chadj.tracetwo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("trace-2")
public class TraceTwoController {

    private final Logger logger = Logger.getLogger(getClass().toString());

    @GetMapping
    public String trace() {
        logger.info("----- call trace-2 -----");
        return "Tracee";
    }
}
