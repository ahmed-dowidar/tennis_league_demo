package com.gov.bank.masr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gov.bank.masr.domain.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "update Round set isFinished= :isFinished where objectId= :roundId")
	public void updateRoundStatus(@Param("roundId")Long roundId, @Param("isFinished") boolean isFinished);
}
