package com.wbt.fullstack.talentdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TalentDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentDiscoveryServiceApplication.class, args);
	}

}
