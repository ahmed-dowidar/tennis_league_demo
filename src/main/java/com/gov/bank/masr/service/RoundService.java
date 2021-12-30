package com.gov.bank.masr.service;

import java.util.List;

import com.gov.bank.masr.domain.Round;

public interface RoundService {
	
	public List<Round> getRoundData();
	
	public List<Round> getListOfRounds();
	
	public Round updateRoundData(Long roundId, boolean isClosed);
}
