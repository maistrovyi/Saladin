package com.maystrovoy.dao;

import com.maystrovoy.model.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class QueueDAO {

    private static final Logger LOGGER = LogManager.getLogger(QueueDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void addQueue(Queue queue) {
        LOGGER.info("add into Queue objectid : " + queue.getTargetObject() + "," + " objecttype : " + queue.getObjectType());
        entityManager.persist(queue);
    }

    public List<Queue> getActiveQueue() {
        Query getActiveQueueQuery = entityManager.createQuery("select q from Queue q where q.status = :activeParameter");
        getActiveQueueQuery.setParameter("activeParameter", "ACTIVE");
        List<Queue> activeQueueList = getActiveQueueQuery.getResultList();
        return activeQueueList;
    }

}
