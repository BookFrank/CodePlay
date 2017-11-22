package com.tazine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.tazine.*")
public class CodeplaySpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeplaySpringbootApplication.class, args);
	}
}
