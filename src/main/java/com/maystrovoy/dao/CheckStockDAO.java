package com.maystrovoy.dao;

import com.maystrovoy.model.Queue;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CheckStockDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void addQueue(Queue queue) {
        entityManager.persist(queue);
        System.out.println("add queue " + "objectType = " + queue.getObjectType());
    }
}
