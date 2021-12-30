package com.gov.bank.masr.serviceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gov.bank.masr.domain.League;
import com.gov.bank.masr.repository.LeagueRepository;
import com.gov.bank.masr.service.LeagueService;

@Service
public class LeagueServiceImpl implements LeagueService {

	@Autowired
	private LeagueRepository leagueRepository;
	
	@Override
	public League createNewLeague(League league) {
		return leagueRepository.save(league);
	}

	@Override
	public List<League> getLeagueList() {
		return leagueRepository.findAll();
	}

	@Override
	public League getLastAddedLeague() {
		List<League> leagueList = getLeagueList();
		League last= new League();
		if(leagueList.size() > 0 ) {
			last = leagueList.get(leagueList.size() - 1);
		}else {
			League league= new League();
			league.setName("Tennis League 2021");
			league.setFromDate(new Date());
			league.setToDate(getDatePlus(15));
			league.setFinished(false);
			last= leagueRepository.save(league);
		}
		return last;
	}
	
	public Date getDatePlus(int days) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days);
		return c.getTime();
	}

	@Override
	public League updateLeagueWinner(Long leagueId, Long winnerId) {
		leagueRepository.updateLeagueStatus(leagueId, winnerId);
		return leagueRepository.getOne(leagueId);
	}
}