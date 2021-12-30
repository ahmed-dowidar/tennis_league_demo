package com.gov.bank.masr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gov.bank.masr.domain.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
	
}
