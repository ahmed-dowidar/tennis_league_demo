package com.gov.bank.masr.service;

import java.util.List;

import com.gov.bank.masr.domain.Participant;

public interface ParticipantService {

	public List<Participant> getAllParticipants();

	public Participant save(Participant user);

	public void save(List<Participant> users);
}
