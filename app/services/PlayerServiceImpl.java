package services;

import models.Player;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class PlayerServiceImpl implements PlayerService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public boolean addPlayer(Player player) {
        if (player == null ||
            player.getFirstName() == null || player.getFirstName().trim().length() == 0 ||
            player.getLastName() == null || player.getLastName().trim().length() == 0 ||
            player.getWins() == null ||
            player.getGames() == null) {
            return false;
        }
        List<Player> p = em.createQuery("from Player where firstName = :pfirstName and lastName = :plastName", Player.class)
                           .setParameter("pfirstName", player.getFirstName())
                           .setParameter("plastName", player.getLastName())
                           .getResultList();
        if (p.isEmpty()) {
            em.persist(player);
            return true;
        }
        return false;
    }

    @Override
    public List<Player> getAllPlayers() {
        return em.createQuery("from Player order by wins desc", Player.class).getResultList();
    }

}
