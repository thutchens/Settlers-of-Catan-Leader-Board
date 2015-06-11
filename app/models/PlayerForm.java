package models;

import play.data.validation.Constraints.Required;

public class PlayerForm {

    @Required(message="player.name")
    private String name;

    @Required(message="player.wins")
    private Integer wins;

    @Required(message="player.games")
    private Integer games;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "name = " + name + ", wins = " + wins + ", games = " + games;
    }

}