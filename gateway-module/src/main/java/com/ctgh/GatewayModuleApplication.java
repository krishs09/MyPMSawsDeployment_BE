package com.ctgh;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@EnableEurekaClient
@CrossOrigin(methods = {RequestMethod.GET , RequestMethod.POST , RequestMethod.PATCH , RequestMethod.PUT})
public class GatewayModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayModuleApplication.class, args);
	}

}
