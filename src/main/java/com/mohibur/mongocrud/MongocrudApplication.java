package com.mohibur.mongocrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MongocrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongocrudApplication.class, args);
	}

}
