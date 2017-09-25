package com.springboot.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootService01Application {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootService01Application.class, args);
	}


}
