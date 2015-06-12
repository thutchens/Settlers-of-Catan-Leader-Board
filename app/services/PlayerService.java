package services;

import models.Player;

import java.util.List;

public interface PlayerService {

    boolean addPlayer(Player player);
    List<Player> getAllPlayers();

}