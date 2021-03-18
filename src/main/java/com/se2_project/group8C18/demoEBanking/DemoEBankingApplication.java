package com.se2_project.group8C18.demoEBanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoEBankingApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoEBankingApplication.class, args);
		
	}
	
	

}
	