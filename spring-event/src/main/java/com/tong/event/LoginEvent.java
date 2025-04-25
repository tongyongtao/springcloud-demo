package com.tong.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author tongyt
 * @date 2025-04-20
 */
public class LoginEvent extends ApplicationEvent {

    private Long userId;

    public LoginEvent(Long userId) {
        super(new Object());
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
