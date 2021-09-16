package com.fh.md;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamMainApplication.class);
    }
}
