package com.gov.bank.masr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gov.bank.masr.domain.Participant;
import com.gov.bank.masr.service.ParticipantService;

@RestController
@RequestMapping("/participant/")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;
	
	@GetMapping("participant_list")
	public ResponseEntity<List<Participant>> getAllParticipantList() {
		List<Participant> allParticipants = participantService.getAllParticipants();
		return ResponseEntity.ok(allParticipants);
	}
	
	@PostMapping("new_participant" )
	public ResponseEntity<?> createNewParticipant(@RequestBody Participant newParticipant) {
		List<Participant> allParticipants = participantService.getAllParticipants();
		if(allParticipants.size() >= 12) {
			return ResponseEntity.ok("Maximum 12 participants allowed per League ");
		}
		Participant user = participantService.save(newParticipant);
	    if (user == null) {
	    	return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
	    } else {
	        return new ResponseEntity<>(user, HttpStatus.CREATED);
	    }
	}
	
}
