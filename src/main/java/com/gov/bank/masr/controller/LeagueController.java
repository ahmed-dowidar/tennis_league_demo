package com.gov.bank.masr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gov.bank.masr.domain.League;
import com.gov.bank.masr.domain.MatchEntity;
import com.gov.bank.masr.service.LeagueService;
import com.gov.bank.masr.service.MatchService;

@RestController
@RequestMapping("/league/")
public class LeagueController {

	@Autowired
	private LeagueService leagueService;
	
	@PostMapping(path = "champion")
	public ResponseEntity<League> submitLeagueChampion(
			@RequestParam(value = "leagueId", required = true) Long leagueId
			,@RequestParam(value = "winnerId", required = true) Long winnerId) {
		League league = leagueService.updateLeagueWinner(leagueId, winnerId);
	    if (league == null) {
	    	return new ResponseEntity<>(league, HttpStatus.BAD_REQUEST);
	    } else {
	        return new ResponseEntity<>(league, HttpStatus.CREATED);
	    }
	}

}
