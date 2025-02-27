package com.tong.nacosconfig.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author tongyt
 * @date 2025-02-26
 */
@RefreshScope
@Data
@Component
public class DynamicNacosConfigProperties {

    @Value("${tong.name}")
    private String name;

    @Value("${database.username}")
    private String username;

    @Value("${spring.redis.host}")
    private String host;

}
