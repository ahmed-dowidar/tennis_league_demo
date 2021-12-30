package com.gov.bank.masr.service;

import com.gov.bank.masr.domain.MatchEntity;

public interface MatchService {
	public MatchEntity updateMatchData(
			Long matchId, Long winnerId, String firstParticipantResult, 
			String secondParticipantResult , String matchResult); 
	
	public MatchEntity save(MatchEntity match);
}
