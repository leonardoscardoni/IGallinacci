package com.IGallinari.LastGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class LastGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(LastGameApplication.class, args);
	}

}
