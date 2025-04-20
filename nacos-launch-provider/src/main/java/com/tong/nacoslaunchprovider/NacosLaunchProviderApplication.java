package com.tong.nacoslaunchprovider;

import com.tong.nacos.launch.TongApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosLaunchProviderApplication {

    public static void main(String[] args) {
        TongApplication.run("nacos-launch-provider", NacosLaunchProviderApplication.class, args);
    }

}
