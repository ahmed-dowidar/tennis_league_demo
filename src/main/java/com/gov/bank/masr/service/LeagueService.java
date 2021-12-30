package com.gov.bank.masr.service;

import java.util.List;

import com.gov.bank.masr.domain.League;

public interface LeagueService {
	
	public League createNewLeague(League league);
	
	public List<League> getLeagueList();
	
	public League getLastAddedLeague();
	
	public League updateLeagueWinner(Long leagueId, Long winnerId);
}
