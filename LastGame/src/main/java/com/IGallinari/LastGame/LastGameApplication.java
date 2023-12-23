package com.IGallinari.LastGame;

import com.IGallinari.LastGame.service.API_to_DB.PopulateDB;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class LastGameApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(LastGameApplication.class, args);
	}

}
