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
    public void addPlayer(Player bar) {
        em.persist(bar);
    }

    @Override
    public List<Player> getAllPlayers() {
        /*CriteriaQuery<Bar> c = em.getCriteriaBuilder().createQuery(Bar.class);
        c.from(Bar.class);
        return em.createQuery(c).getResultList();*/

        return em.createQuery("from Player order by wins desc",Player.class).getResultList();
    }

}