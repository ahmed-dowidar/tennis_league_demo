package com.gov.bank.masr.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Participant")
public class Participant {
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO )
	private Long objectId;
	
    private @JsonProperty(required = true) String name;
    private @JsonProperty(required = true) String age;
    private @JsonProperty(required = true) String height;
    private @JsonProperty(required = true) String weight;
    private @JsonProperty(required = true) String rank;
	
    //----------- Setters and getters --------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
    
}
