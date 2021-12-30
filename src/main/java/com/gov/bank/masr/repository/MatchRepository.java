package com.gov.bank.masr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gov.bank.masr.domain.MatchEntity;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long>{
	
	@Transactional
	@Modifying
	@Query(value = " update MatchEntity set "
			+ " winner_participant= :winnerId, firstParticipantResult= :firstParticipantResult,"
			+ " secondParticipantResult= :secondParticipantResult, matchResult=:matchResult "
			+ " where objectId= :matchId")
	public void updateRoundStatus(@Param("matchId")Long matchId, 
			@Param("winnerId") Long winnerId,
			@Param("firstParticipantResult") String firstParticipantResult, 
			@Param("secondParticipantResult") String secondParticipantResult ,
			@Param("matchResult") String matchResult );
	
}
