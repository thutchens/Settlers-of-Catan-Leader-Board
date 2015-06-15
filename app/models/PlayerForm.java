package models;

import play.data.validation.Constraints.Required;

public class PlayerForm {

    @Required(message = "player.firstName")
    private String firstName;

    @Required(message = "player.lastName")
    private String lastName;

    @Required(message = "player.wins")
    private Integer wins;

    @Required(message = "player.games")
    private Integer games;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "name = " + firstName + " " + lastName + ", wins = " + wins + ", games = " + games;
    }

}
