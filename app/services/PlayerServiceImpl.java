package services;

import models.Player;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Service
public class PlayerServiceImpl implements PlayerService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public boolean addPlayer(Player player) {
        try {
            Player p = null;
            p = em.createQuery("SELECT p FROM Player p WHERE p.firstName LIKE :firstName and p.lastName LIKE :lastName", Player.class)
                            .setParameter("firstName", player.getFirstName()).setParameter("lastName", player.getLastName()).getSingleResult();
        } catch (NoResultException e) {
            em.persist(player);
            return true;
        }
        return false;
    }

    @Override
    public List<Player> getAllPlayers() {
        return em.createQuery("from Player order by wins desc",Player.class).getResultList();
    }

}