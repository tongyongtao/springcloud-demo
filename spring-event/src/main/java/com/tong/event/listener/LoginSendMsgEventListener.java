package com.tong.event.listener;

import com.tong.event.LoginEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author tongyt
 * @date 2025-04-21
 */
@Order(5)
@Component
public class LoginSendMsgEventListener implements ApplicationListener<LoginEvent> {

    //@Async
    @Override
    public void onApplicationEvent(LoginEvent loginEvent) {
        LocalDateTime start = LocalDateTime.now();
        int i = 1 / 0;
        System.out.printf("线程:[%s],LoginSendMsgEventListener,接收时间:[%s],处理完成时间:[%s],接收到事件:%s\n", Thread.currentThread().getName(), start, LocalDateTime.now(), loginEvent.getClass().getName());
    }
}
