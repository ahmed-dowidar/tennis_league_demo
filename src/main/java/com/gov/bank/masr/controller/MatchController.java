package com.gov.bank.masr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gov.bank.masr.domain.MatchEntity;
import com.gov.bank.masr.service.MatchService;

@RestController
@RequestMapping("/match/")
public class MatchController {

	@Autowired
	private MatchService matchService;
	
	@PostMapping(path = "new_match")
	public ResponseEntity<MatchEntity> createNewMatchEntity(
			@Valid@RequestBody(required = true) MatchEntity newMatchEntity) {
		MatchEntity match = matchService.save(newMatchEntity);
	    if (match == null) {
	    	return new ResponseEntity<>(match, HttpStatus.BAD_REQUEST);
	    } else {
	        return new ResponseEntity<>(match, HttpStatus.CREATED);
	    }
	}
	
	@PostMapping(path = "close")
	public ResponseEntity<MatchEntity> updateMatchData(
			@RequestParam(name = "matchId", required = true) Long matchId,
			@RequestParam(name = "winnerId", required = true) Long winnerId,
			@RequestParam(name = "firstParticipantResult", required = true) String firstParticipantResult, 
			@RequestParam(name = "secondParticipantResult", required = true) String secondParticipantResult ,
			@RequestParam(name = "matchResult", required = true) String matchResult ) {
		MatchEntity updateMatchData = matchService.updateMatchData(
				matchId, winnerId, firstParticipantResult, secondParticipantResult, matchResult);
		return ResponseEntity.ok(updateMatchData);
	}

}
