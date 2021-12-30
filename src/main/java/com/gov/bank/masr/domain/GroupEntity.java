package com.gov.bank.masr.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GroupEntity")
public class GroupEntity {
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @JsonIgnore
	private Long objectId;
	
    private String name;
    
    @OneToMany
    @JoinColumn(name="group_entity_id")
    private Set<Participant> participantList= new HashSet<>();

    @ManyToOne
    @JoinColumn(name="league_id")
    private League league;
    
	
    //----------- Setters and getters --------
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Participant> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(Set<Participant> participantList) {
		this.participantList = participantList;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
    
    
}
