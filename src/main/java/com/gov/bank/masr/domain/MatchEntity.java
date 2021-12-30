package com.gov.bank.masr.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class MatchEntity {
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
	private Long objectId;
	
	@JsonProperty(required = true)
    private Date matchDate;
	
    private boolean isFinished;
    private String firstParticipantResult;
    private String secondParticipantResult;
    private String matchResult;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "first_participant")
    @JsonProperty(required = true)
    private Participant firstParticipant;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "second_participant")
    @JsonProperty(required = true)
    private Participant secondParticipant;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "winner_participant")
    private Participant winner;

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public String getFirstParticipantResult() {
		return firstParticipantResult;
	}

	public void setFirstParticipantResult(String firstParticipantResult) {
		this.firstParticipantResult = firstParticipantResult;
	}

	public String getSecondParticipantResult() {
		return secondParticipantResult;
	}

	public void setSecondParticipantResult(String secondParticipantResult) {
		this.secondParticipantResult = secondParticipantResult;
	}

	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}

	public Participant getFirstParticipant() {
		return firstParticipant;
	}

	public void setFirstParticipant(Participant firstParticipant) {
		this.firstParticipant = firstParticipant;
	}

	public Participant getSecondParticipant() {
		return secondParticipant;
	}

	public void setSecondParticipant(Participant secondParticipant) {
		this.secondParticipant = secondParticipant;
	}

	public Participant getWinner() {
		return winner;
	}

	public void setWinner(Participant winner) {
		this.winner = winner;
	}
	
}
