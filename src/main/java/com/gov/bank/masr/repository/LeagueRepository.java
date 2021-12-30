package com.gov.bank.masr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gov.bank.masr.domain.League;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

	@Transactional
	@Modifying
	@Query(value = " update League set winner_participant= :winnerId where objectId= :leagueId")
	public void updateLeagueStatus(
			@Param("leagueId")Long matchId, @Param("winnerId") Long winnerId);
}
