package com.satish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;
@Configuration
@EnableAutoConfiguration
/*@EnableAdminServer*/
@SpringBootApplication
public class SpringSwaggerApApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSwaggerApApplication.class, args);
	}
}
