package models;

import play.data.validation.Constraints.Required;

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

    @Column(name = "name")
    @Required(message="player.name")
    private String name;

    @Column(name = "wins")
    @Required(message="player.wins")
    private Integer wins;

    @Column(name = "games")
    @Required(message="player.games")
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