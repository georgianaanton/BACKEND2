package com.georgiana.certification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import com.georgiana.certification.infra.configurations.AppConfiguration;

@SpringBootApplication
@EnableEurekaClient
@Import(AppConfiguration.class)
public class CertificationApplication {
	public static void main(String[] args) {
		SpringApplication.run(CertificationApplication.class, args);
	}

}

