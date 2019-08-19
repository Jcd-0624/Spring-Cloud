package com.chadj.nacosproducer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: Hello访问控制</p>
 * <p>Copyright: Copyright (c)2019</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019-08-12</P>
 * <P>@version 1.0</P>
 */
@Controller
@Slf4j
public class HelloController {

    @ResponseBody
    @GetMapping("hello")
    public String hello(String name) {
        log.info("invoked name = " + name);
        return "hello " + name;
    }
}
