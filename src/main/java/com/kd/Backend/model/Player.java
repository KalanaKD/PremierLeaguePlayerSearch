package com.kd.Backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "player_data")
public class Player {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", position='" + position + '\'' +
                ", club=" + club +
                ", matchesPlayed=" + matchesPlayed +
                ", nation=" + nation +
                ", appearances=" + appearances +
                ", goals=" + goals +
                ", assists=" + assists +
                ", penalties=" + penalties +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                '}';
    }
}
