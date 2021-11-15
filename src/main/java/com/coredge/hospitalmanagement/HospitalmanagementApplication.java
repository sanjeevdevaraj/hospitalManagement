package com.coredge.hospitalmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hospital Management API", version = "1.0", description = "Hospital Information"))
public class HospitalmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalmanagementApplication.class, args);
	}

}
