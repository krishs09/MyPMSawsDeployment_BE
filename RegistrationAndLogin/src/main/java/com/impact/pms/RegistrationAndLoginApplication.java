package com.impact.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"com.impact.pms","com.impact.pms.controller"})
public class RegistrationAndLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationAndLoginApplication.class, args);
	}

}
