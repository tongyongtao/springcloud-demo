package com.tong.nacosconfig.controller;

import com.tong.nacosconfig.config.DynamicNacosConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tongyt
 * @date 2025-02-26
 */
@RestController
public class HelloController {

    @Autowired
    private DynamicNacosConfigProperties dynamicNacosConfigProperties;

    @GetMapping("/hello")
    public String hello() {
        return "hello " + dynamicNacosConfigProperties.getName() + ", " + dynamicNacosConfigProperties.getUsername() + ", " + dynamicNacosConfigProperties.getHost();
    }

}
