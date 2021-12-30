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
import javax.persistence.Table;

@Entity
@Table(name = "Round")
public class Round {
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
	private Long objectId;
	
    private String name;
    private Date fromDate;
    private Date toDate;
    private boolean isFinished;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "round_id")
    private List<MatchEntity> matcheList;

	
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

	public List<MatchEntity> getMatcheList() {
		return matcheList;
	}

	public void setMatcheList(List<MatchEntity> matcheList) {
		this.matcheList = matcheList;
	}
    
    
}
