package com.rating.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatingServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceAppApplication.class, args);
		System.out.println("========== rating service mein method completed ===========");
	}

}
