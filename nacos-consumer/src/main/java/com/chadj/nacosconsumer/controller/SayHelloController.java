package com.chadj.nacosconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description: RestTemplate调用的两种方式</p>
 * <p>Copyright: Copyright (c)2019</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019-08-12</P>
 * <P>@version 1.0</P>
 */
@Slf4j
@RestController
@RequestMapping()
public class SayHelloController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/say")
    public String sayHello() {
        // 负载均衡选取
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-producer");

        String url = serviceInstance.getUri() + "/hello?name=" + "ChadJ";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }

    @GetMapping("hello")
    public String hello() {
        String result = restTemplate.getForObject("http://nacos-producer/hello?name=ChadJ", String.class);
        return result;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
