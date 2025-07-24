package com.kd.Backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_data")
public class Player {

    @Id
    @Column(name = "full_name", unique = true)
    private String name;
    private String nation;
    private String position;
    private String club;
    private Integer age;
    private Integer appearances;
    private Integer goals;
    private Integer assists;
    private Integer yellowCards;
    private Integer redCards;
    private Integer matchesPlayed;
    private Integer penalties;

    public Player() {
    }

    public Player(String name, String nation, String position, String club, Integer age, Integer appearances,
                  Integer goals, Integer assists, Integer yellowCards, Integer redCards, Integer matchesPlayed,
                  Integer penalties) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.club = club;
        this.age = age;
        this.appearances = appearances;
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.matchesPlayed = matchesPlayed;
        this.penalties = penalties;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getClub() {
        return club;
    }
    public void setClub(String club) {
        this.club = club;   
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAppearances() {
        return appearances;
    }
    public void setAppearances(Integer appearances) {
        this.appearances = appearances; 
    }
    public Integer getGoals() {
        return goals;
    }
    public void setGoals(Integer goals) {
        this.goals = goals;
    }
    public Integer getAssists() {
        return assists;
    }
    public void setAssists(Integer assists) {
        this.assists = assists;
    }
    public Integer getYellowCards() {
        return yellowCards;
    }
    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }
    public Integer getRedCards() {
        return redCards;
    }
    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }
    public Integer getMatchesPlayed() {
        return matchesPlayed;
    }
    public void setMatchesPlayed(Integer matchesPlayed) {   
        this.matchesPlayed = matchesPlayed;
    }
    public Integer getPenalties() {
        return penalties;
    }
    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }
}
