package services;

import models.Player;

import java.util.List;

public interface PlayerService {

    void addPlayer(Player player);
    List<Player> getAllPlayers();

}