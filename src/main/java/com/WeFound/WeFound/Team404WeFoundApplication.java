package com.WeFound.WeFound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Team404WeFoundApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team404WeFoundApplication.class, args);
	}

}
