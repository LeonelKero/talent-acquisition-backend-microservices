package com.wbt.fullstack.careerportalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CareerPortalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareerPortalServiceApplication.class, args);
	}

}
