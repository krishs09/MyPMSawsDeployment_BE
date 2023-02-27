package com.impact.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VisitDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitDetailsApplication.class, args);
	}

}
