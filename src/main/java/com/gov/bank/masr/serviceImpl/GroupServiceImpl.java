package com.gov.bank.masr.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gov.bank.masr.domain.GroupEntity;
import com.gov.bank.masr.domain.League;
import com.gov.bank.masr.domain.Participant;
import com.gov.bank.masr.repository.GroupRepository;
import com.gov.bank.masr.service.GroupService;
import com.gov.bank.masr.service.LeagueService;
import com.gov.bank.masr.service.ParticipantService;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	private ParticipantService participantService;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private LeagueService leagueService;
	
	String[] groupNames= {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
	
	@Override
	public List<GroupEntity> groupRandomlyParticipaints() {
		League league= leagueService.getLastAddedLeague();
		List<Participant> allParticipants = participantService.getAllParticipants();
		Set<Participant> groupParticipaints= new HashSet<Participant>();
		GroupEntity groupObject= null;
		int counter =0;
		for (Participant item : allParticipants) {
			groupParticipaints.add(item);
			if(groupParticipaints.size() == 4 ) {
				groupObject= new GroupEntity();
				groupObject.setName(groupNames[counter]);
				groupObject.setParticipantList(groupParticipaints);
				groupObject.setLeague(league);
				groupRepository.save(groupObject);
				counter++;
				groupParticipaints= new HashSet<Participant>();
			}
		}
		List<GroupEntity> groups = groupRepository.findAll();
		return groups;
	}

	@Override
	public List<GroupEntity> getAllGroups() {
		return groupRepository.findAll();
	}
	
	
}
