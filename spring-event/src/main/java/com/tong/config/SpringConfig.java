package com.tong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author tongyt
 * @date 2025-04-25
 */
@Configuration
public class SpringConfig {

    /**
     * 配置自定义事件广播器，异步处理事件，这样监听器就不用使用@Async注解了
     */
    @Bean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
    public SimpleApplicationEventMulticaster simpleApplicationEventMulticaster(ThreadPoolTaskExecutor executor) {
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(executor);
        simpleApplicationEventMulticaster.setErrorHandler((e) -> {
            System.out.println("事件广播器出错了");
            e.printStackTrace();
        });
        return simpleApplicationEventMulticaster;
    }


}
