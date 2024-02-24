package com.wbt.fullstack.talentfulfillmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TalentFulfillmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentFulfillmentServiceApplication.class, args);
	}

}
