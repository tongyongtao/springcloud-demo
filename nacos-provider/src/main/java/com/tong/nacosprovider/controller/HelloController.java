package com.tong.nacosprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tongyt
 * @date 2025-02-21
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello nacos";
    }

}
