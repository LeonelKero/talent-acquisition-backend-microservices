package com.wbt.fullstack.talentapigetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TalentApiGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentApiGetwayApplication.class, args);
	}

}
