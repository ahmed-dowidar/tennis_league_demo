package com.gov.bank.masr.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "League")
public class League {
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @JsonIgnore
	private Long objectId;
	
    private String name;
    private Date fromDate;
    private Date toDate;
    private boolean isFinished;
    
    @OneToOne
    @JoinColumn(name = "winner_participant")
    private Participant winner;

    @OneToMany(
    		mappedBy = "league", 
    		cascade = CascadeType.ALL, 
    		orphanRemoval = true )
    @JsonIgnore
    private List<GroupEntity> groupList;
    
	
    //----------- Setters and getters --------
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public Participant getWinner() {
		return winner;
	}

	public void setWinner(Participant winner) {
		this.winner = winner;
	}
    
    
}
