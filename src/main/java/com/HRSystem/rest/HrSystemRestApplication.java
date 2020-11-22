package com.HRSystem.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"com.api.employee", "com.HRSystem"})
/*
 * Until we define scanBasePackages here, we cant autowire employee beans of API project. Unlike norman Spring project we dont need to 
 * define <context:component-scan base-package="com.*in xml file. In Spring boot, this annotation @SpringBootApplication takes care of hat as
 * long as this class in under root. If you want to autowire any class that is not in root(com.HRSyste.rest), must be mentioned here under scanBasePackages
 */
public class HrSystemRestApplication {

	public static void main(String[] args) {
		System.out.println("*****Before run**********");
		SpringApplication.run(HrSystemRestApplication.class, args);
		System.out.println("*****After run**********");
		
		
	}

}
