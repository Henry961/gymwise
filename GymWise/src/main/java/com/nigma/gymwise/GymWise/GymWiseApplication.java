package com.nigma.gymwise.GymWise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GymWiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymWiseApplication.class, args);
	}

}
