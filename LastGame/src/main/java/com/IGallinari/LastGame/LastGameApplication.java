package com.IGallinari.LastGame;

import com.IGallinari.LastGame.service.API_to_DB.PopulateDB;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LastGameApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(LastGameApplication.class, args);
	}

}
