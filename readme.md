## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [EndPoints](#EndPoints)

## General info
* This project is simple tennis_league_demo Demo for task about interview at bank Masr Company.
* in application load Json (participant.json) File loaded that's contains sample data for League Participants.


## Technologies
Project is created with:
* Java version: 8
* Spring Boot version: 2.1.10.RELEASE
* lombok
* Spring Data JPA
	
## Setup
To run this project, import it locally using any IDE and 

* I'm Using H2 database (In memory Database and can be accessed through this link )
* http://localhost:8080/h2-console/login.do
* 	driver class: org.h2.Driver
	datasource: jdbc:h2:mem:leaguedb
	user name: sa
	password: sa

* 	make maven install to update all maven dependancies and build executable jar file 
* 	maven clean and Install
* 	you can go to this Class  TennisLeagueDemo.java and run SpringBootApplication or you can directly go to the 		target folder which maven generates wars and open cmd in this path 
		type java -jar tennis_league_demo-0.0.1-SNAPSHOT.jar and run 

## EndPoints
Project Exposed these API's End Points :

** {{url}} :  http://localhost:8080  <br />

** ▪ Get a list of all participants ( Request Type: GET , Request Parameters: None ) : **  {{url}}/participant/participant_list <br />

** ▪ Submit a participant request ( Request Type: POST , Request Body: Json {name, age, height, weight, rank} ) : **  {{url}}/participant/new_participant <br />

** ▪ Group randomly participants into (n) groups ( Request Type: GET , Request Parameters: None ) :**  {{url}}/group/participant_group <br />

** ▪ Get list of all automatically created the first-round matches ( Request Type: GET , Request Parameters: None ) : **  {{url}}/round/round_data <br />

**▪ Close round ( Request Type: POST , Request Parameter: roundId ) :**  {{url}}/round/close <br />

** ▪ Update match winner and results  ( Request Type: POST , Request Parameters { matchId, winnerId, firstParticipantResult, secondParticipantResult, matchResult }) : **  {{url}}/match/close <br />

** ▪ Submit a request of new match (players and time) ( Request Type: POST , Request Body: Json {matchDate, firstParticipant{}, secondParticipant{}, round{}} ) :**  {{url}}/match/new_match <br />

** ▪ Submit league champion ( Request Type: POST , Request Parameter: leagueId, winnerId ) :**  {{url}}/league/champion <br />

Thanks and Best Regards
Ahmed Dowidar
