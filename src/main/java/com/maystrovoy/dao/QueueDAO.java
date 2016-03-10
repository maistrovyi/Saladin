package com.maystrovoy.dao;

import com.maystrovoy.model.Queue;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class QueueDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void addQueue(Queue queue) {
        System.out.println("add into Queue objectid : " + queue.getTargetObject() + " objecttype : " + queue.getObjectType());
        entityManager.persist(queue);
    }

    public List<Queue> getActiveQueue() {
        Query getActiveQueueQuery = entityManager.createQuery("select q from Queue q where q.status = :activeParameter");
        getActiveQueueQuery.setParameter("activeParameter", "ACTIVE");
        List<Queue> activeQueueList = getActiveQueueQuery.getResultList();
        return activeQueueList;
    }

}
