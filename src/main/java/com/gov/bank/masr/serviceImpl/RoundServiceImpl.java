package com.gov.bank.masr.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gov.bank.masr.domain.GroupEntity;
import com.gov.bank.masr.domain.MatchEntity;
import com.gov.bank.masr.domain.Participant;
import com.gov.bank.masr.domain.Round;
import com.gov.bank.masr.repository.RoundRepository;
import com.gov.bank.masr.service.GroupService;
import com.gov.bank.masr.service.RoundService;

@Service
public class RoundServiceImpl implements RoundService{

	@Autowired
	private RoundRepository roundRepository;
	
	@Autowired
	private GroupService groupService;
	
	@Override
	public List<Round> getRoundData() {
		List<GroupEntity> allGroups = groupService.getAllGroups();
		List<MatchEntity> matchList= new ArrayList<MatchEntity>(); 
		for (GroupEntity group : allGroups) {
			Set<Participant> participantList = group.getParticipantList();
			if(participantList != null) {
				int counter =0;
				MatchEntity match = null;
				for (Participant item : participantList) {
					if(counter == 1 ) {
						match.setFirstParticipant(item);
						matchList.add(
								getFreshMatchEntity(match.getFirstParticipant(), match.getSecondParticipant()));
						counter= -1;
					}else {
						match= new MatchEntity();
						match.setSecondParticipant(item);
					}
					counter++;
				}
			}
		}
		Round round = new Round();
		round.setName("Round One");
		round.setFromDate(new Date());
		round.setToDate(getDatePlus(3));
		round.setFinished(false);
		round.setMatcheList(matchList);
		roundRepository.save(round);
		return roundRepository.findAll();
	}
	
	private MatchEntity getFreshMatchEntity(Participant firstParticipant , Participant secondParticipant) {
		MatchEntity match =new MatchEntity();
		match.setFirstParticipant(firstParticipant);
		match.setSecondParticipant(secondParticipant);
		match.setMatchDate(new Date());
		match.setFinished(false);
		return match;
	}
	public Date getDatePlus(int days) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days); 
		return c.getTime();  
	}

	@Override
	@Transactional
	public Round updateRoundData(Long roundId,boolean isClosed) {
		roundRepository.updateRoundStatus(roundId, isClosed);
		return roundRepository.getOne(roundId);
	}

	@Override
	public List<Round> getListOfRounds() {
		return roundRepository.findAll();
	}
	
	
}
