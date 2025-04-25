package com.tong.controller;

import com.tong.event.LoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author tongyt
 * @date 2025-04-20
 */
@RestController
public class LoginController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/login")
    public String login() {
        long userId = new Random().nextInt(1000);
        System.out.println("用户: " + userId + "登录");
        applicationEventPublisher.publishEvent(new LoginEvent(userId));
        return "用户: " + userId + "登录";
    }

}
