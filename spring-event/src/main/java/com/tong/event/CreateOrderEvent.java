package com.tong.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author tongyt
 * @date 2025-04-22
 */
public class CreateOrderEvent extends ApplicationEvent {

    public CreateOrderEvent(Object source) {
        super(source);
    }
}
