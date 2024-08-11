package com.example.recursive.encryption;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@OpenAPIDefinition(info = @Info(title = "Recursive design", version = "1", description = "Project to show encryption and decryption recursion"))
@SpringBootApplication
public class EncryptionApplication {
	private static final Logger logger = LoggerFactory.getLogger(EncryptionApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EncryptionApplication.class, args);
		logger.info("http://localhost:8080/swagger-ui/index.html#/");

	}

}
