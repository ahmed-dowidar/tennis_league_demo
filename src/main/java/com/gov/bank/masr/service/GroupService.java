package com.gov.bank.masr.service;

import java.util.List;

import com.gov.bank.masr.domain.GroupEntity;

public interface GroupService {
	
	public List<GroupEntity> groupRandomlyParticipaints();
	
	public List<GroupEntity>getAllGroups();

}
