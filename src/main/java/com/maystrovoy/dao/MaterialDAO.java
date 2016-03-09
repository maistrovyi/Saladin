package com.maystrovoy.dao;

import com.maystrovoy.model.Queue;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class MaterialDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void addQueue(Queue queue) {
        System.out.println("add material " + "objectType = " + queue.getObjectType());
        entityManager.persist(queue);
    }
}
