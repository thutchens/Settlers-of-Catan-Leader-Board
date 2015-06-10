package models;

import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {

    @Id
    @GeneratedValue
    private int id;

    @Constraints.Required(message = "The name is required")
    @Column(name = "name")
    private String name;

    @Constraints.Required(message = "The number of wins is required")
    @Column(name = "wins")
    private Integer wins;

    @Constraints.Required(message = "Total games played is required")
    @Column(name = "games")
    private Integer games;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "name = " + name + ", wins = " + wins + ", games = " + games;
    }

}