package com.tong.nacos.launch;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.*;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

/**
 * @author tongyt
 * @date 2025-03-03
 */
public class TongApplication {

    public TongApplication() {
    }

    public static ConfigurableApplicationContext run(String applicationName, Class<?> source, String[] args) {
        SpringApplicationBuilder builder = createSpringApplicationBuilder(applicationName, source, args);
        return builder.run(args);
    }

    private static SpringApplicationBuilder createSpringApplicationBuilder(String applicationName, Class<?> source, String[] args) {
        // 获取环境profile
        ConfigurableEnvironment environment = new StandardEnvironment();
        // 加载环境变量，命令行参数，系统环境变量，系统属性
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new SimpleCommandLinePropertySource(args));
        propertySources.addLast(new MapPropertySource("systemProperties", environment.getSystemProperties()));
        propertySources.addLast(new SystemEnvironmentPropertySource("systemEnvironment", environment.getSystemEnvironment()));
        String[] activeProfiles = environment.getActiveProfiles();
        List<String> profiles = Arrays.asList(activeProfiles);
        List<String> presetProfiles = new ArrayList(Arrays.asList("dev", "test", "prod"));
        presetProfiles.retainAll(profiles);
        List<String> activeProfileList = new ArrayList(profiles);
        Function<Object[], String> joinFun = StringUtils::arrayToCommaDelimitedString;
        SpringApplicationBuilder builder = new SpringApplicationBuilder(new Class[]{source});
        String profile;
        if (activeProfileList.isEmpty()) {
            profile = "dev";
            activeProfileList.add(profile);
            builder.profiles(new String[]{profile});
        } else {
            if (activeProfileList.size() != 1) {
                throw new RuntimeException("同时存在环境变量:[" + StringUtils.arrayToCommaDelimitedString(activeProfiles) + "]");
            }

            profile = (String)activeProfileList.get(0);
        }

        String startJarPath = TongApplication.class.getResource("/").getPath().split("!")[0];
        String activePros = (String)joinFun.apply(activeProfileList.toArray());
        System.out.printf("----启动中，读取到的环境变量:[%s]，jar地址:[%s]----%n", activePros, startJarPath);

        Properties props = System.getProperties();
        // 加载通用配置项
        props.setProperty("spring.application.name", applicationName);
        props.setProperty("spring.profiles.active", profile);
        props.setProperty("file.encoding", StandardCharsets.UTF_8.name());
        // 加载nacos配置项
        props.setProperty("spring.cloud.nacos.discovery.server-addr", "localhost:8848");
        props.setProperty("spring.cloud.nacos.discovery.namespace", profile);
        props.setProperty("spring.cloud.nacos.config.server-addr", "localhost:8848");
        props.setProperty("spring.cloud.nacos.config.username", "nacos");
        props.setProperty("spring.cloud.nacos.config.password", "nacos");
        props.setProperty("spring.cloud.nacos.discovery.username", "nacos");
        props.setProperty("spring.cloud.nacos.discovery.password", "nacos");
        props.setProperty("spring.cloud.nacos.config.namespace", profile);
        props.setProperty("spring.cloud.nacos.config.file-extension", "yml");
        props.setProperty("spring.cloud.nacos.config.shared-configs[0].data-id", "share-db-config.yml");
        props.setProperty("spring.cloud.nacos.config.shared-configs[0].group", "DEFAULT_GROUP");
        props.setProperty("spring.cloud.nacos.config.shared-configs[0].refresh", "true");
        props.setProperty("spring.cloud.nacos.config.shared-configs[1].data-id", "share-redis-config.yml");
        props.setProperty("spring.cloud.nacos.config.shared-configs[1].group", "DEFAULT_GROUP");
        props.setProperty("spring.cloud.nacos.config.shared-configs[1].refresh", "true");
        return builder;
    }


}
