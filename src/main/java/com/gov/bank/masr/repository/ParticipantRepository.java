package com.gov.bank.masr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gov.bank.masr.domain.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	
	
}
