package com.gov.bank.masr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gov.bank.masr.domain.GroupEntity;
import com.gov.bank.masr.service.GroupService;

@RestController
@RequestMapping("/group/")
public class GroupController {

	@Autowired
	private GroupService groupService;
	
	@GetMapping("participant_group")
	public ResponseEntity<List<GroupEntity>> getAllParticipantGroup() {
		List<GroupEntity> groupRandomlyParticipaints = groupService.groupRandomlyParticipaints();
		return ResponseEntity.ok(groupRandomlyParticipaints);
	}
	
}
