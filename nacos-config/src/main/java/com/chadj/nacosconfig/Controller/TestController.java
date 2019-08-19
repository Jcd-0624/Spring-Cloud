package com.chadj.nacosconfig.Controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description:</p>
 * <p>Copyright: Copyright (c)2019</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019-08-12</P>
 * <P>@version 1.0</P>
 */
@Slf4j
@RestController
@Reference
public class TestController {

    @Value("${author.name}")
    private String author;

    @GetMapping("/test")
    public String test() {
        return "作者：" + author;
    }
}
