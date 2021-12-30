package com.gov.bank.masr.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gov.bank.masr.domain.Participant;
import com.gov.bank.masr.repository.ParticipantRepository;
import com.gov.bank.masr.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;

	@Override
	public List<Participant> getAllParticipants() {
		return participantRepository.findAll();
	}

	@Override
	public Participant save(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public void save(List<Participant> participants) {
		participantRepository.saveAll(participants);
	}

}
