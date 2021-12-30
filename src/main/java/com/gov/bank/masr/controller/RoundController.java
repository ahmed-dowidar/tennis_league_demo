package com.gov.bank.masr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gov.bank.masr.domain.MatchEntity;
import com.gov.bank.masr.domain.Round;
import com.gov.bank.masr.service.RoundService;

@RestController
@RequestMapping("/round/")
public class RoundController {

	@Autowired
	private RoundService roundService;
	
	@GetMapping("round_data")
	public ResponseEntity<List<Round>> getRoundData() {
		/* validate over only one round as per Task Requirement.
		 	this needs to enhance to be more than one Round 
		 */
		List<Round> listOfRounds = roundService.getListOfRounds();
		if(listOfRounds.size() > 0 ) {
			return ResponseEntity.ok(listOfRounds);
		}
		List<Round> groupRandomlyParticipaints = roundService.getRoundData();
		return ResponseEntity.ok(groupRandomlyParticipaints);
	}
	
	@PostMapping(path = "close")
	public ResponseEntity<Round> getRoundData(@RequestParam(name = "roundId", required = true) Long roundId) {
		Round updateRoundData = roundService.updateRoundData(roundId, true);
		return ResponseEntity.ok(updateRoundData);
	}
}
