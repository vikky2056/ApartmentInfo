package com.example.ApartmentInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.ApartmentInfo")
public class ApartmentInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentInfoApplication.class, args);
	}

}
