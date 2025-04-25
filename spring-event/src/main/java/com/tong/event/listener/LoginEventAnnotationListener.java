package com.tong.event.listener;

import com.tong.event.CreateOrderEvent;
import com.tong.event.LoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author tongyt
 * @date 2025-04-22
 */
@Component
public class LoginEventAnnotationListener {

    //@Async
    @Order(10)
    @EventListener
    public void onApplicationEvent(LoginEvent loginEvent) {
        LocalDateTime start = LocalDateTime.now();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("线程:[%s],监听器1,接收时间:[%s],处理完成时间:[%s],接收到事件:%s\n", Thread.currentThread().getName(), start, LocalDateTime.now(), loginEvent.getClass().getName());

    }

    //@Async
    @Order(11)
    @EventListener
    public void onApplicationEvent2(LoginEvent loginEvent) {
        LocalDateTime start = LocalDateTime.now();
        System.out.printf("线程:[%s],监听器2,接收时间:[%s],处理完成时间:[%s],接收到事件:%s\n", Thread.currentThread().getName(), start, LocalDateTime.now(), loginEvent.getClass().getName());
    }

    @EventListener
    public void onApplicationEvent(CreateOrderEvent createOrderEvent) {
        System.out.println("LoginEventAnnotationListener: " + createOrderEvent.getSource());
    }


}
