package com.tong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author tongyt
 * @date 2025-04-20
 */
@EnableAsync
@SpringBootApplication
public class SpringEventApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEventApplication.class, args);
    }
}
