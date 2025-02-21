package com.tong.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tongyt
 * @date 2025-02-21
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer")
    public String consumer() {
        return restTemplate.getForObject("http://nacos-provider/hello", String.class);
    }

}
