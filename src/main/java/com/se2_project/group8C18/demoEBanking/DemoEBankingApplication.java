package com.se2_project.group8C18.demoEBanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DemoEBankingApplication extends ServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DemoEBankingApplication.class, args);
		
	}

}
	