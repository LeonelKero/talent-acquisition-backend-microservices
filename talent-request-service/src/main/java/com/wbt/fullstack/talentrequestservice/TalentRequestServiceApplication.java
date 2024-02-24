package com.wbt.fullstack.talentrequestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TalentRequestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentRequestServiceApplication.class, args);
	}

}
