package com.gov.bank.masr.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gov.bank.masr.domain.MatchEntity;
import com.gov.bank.masr.repository.MatchRepository;
import com.gov.bank.masr.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService{

	@Autowired
	private MatchRepository matchRepository;
	
	@Override
	@Transactional
	public MatchEntity updateMatchData(Long matchId, Long winnerId, String firstParticipantResult, 
			String secondParticipantResult , String matchResult) {
		matchRepository.updateRoundStatus(matchId, winnerId, 
				firstParticipantResult, secondParticipantResult, matchResult);
		Optional<MatchEntity> findById = matchRepository.findById(matchId);
		return findById.get();
	}
	@Override
	public MatchEntity save(MatchEntity match) {
		return matchRepository.save(match);
	}

}
