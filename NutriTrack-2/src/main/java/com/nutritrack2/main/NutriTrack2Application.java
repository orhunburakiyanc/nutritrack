package com.nutritrack2.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = {"com.nutritrack2.*"})
@EnableMongoRepositories(basePackages = "com.nutritrack2.repository")
public class NutriTrack2Application {

	public static void main(String[] args) {
		SpringApplication.run(NutriTrack2Application.class, args);
	}

}
