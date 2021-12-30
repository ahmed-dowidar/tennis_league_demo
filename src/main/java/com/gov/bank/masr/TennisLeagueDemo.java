package com.gov.bank.masr;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gov.bank.masr.domain.Participant;
import com.gov.bank.masr.service.ParticipantService;

@SpringBootApplication
public class TennisLeagueDemo {
	
	@Autowired
	private ParticipantService participantService;
	
	public static void main(String[] args) {
		SpringApplication.run(TennisLeagueDemo.class, args);
	}


	@Bean
	CommandLineRunner runner() {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Participant>> typeReference = new TypeReference<List<Participant>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/participant.json");
			try {
				List<Participant> participants = mapper.readValue(inputStream, typeReference);
				participantService.save(participants);
				System.out.println("participants Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save participants: " + e.getMessage());
			}
		};
	}
}
