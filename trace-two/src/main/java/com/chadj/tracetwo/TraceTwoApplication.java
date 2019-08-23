package com.chadj.tracetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TraceTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraceTwoApplication.class, args);
    }

}
