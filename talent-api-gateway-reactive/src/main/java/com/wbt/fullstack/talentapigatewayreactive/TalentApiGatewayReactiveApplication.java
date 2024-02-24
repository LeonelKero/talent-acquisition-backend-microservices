package com.wbt.fullstack.talentapigatewayreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TalentApiGatewayReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalentApiGatewayReactiveApplication.class, args);
    }

}
