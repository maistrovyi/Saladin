package com.maystrovoy.service;

import com.maystrovoy.dao.QueueDAO;
import com.maystrovoy.model.Queue;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class QueueService {

    @Inject
    private QueueDAO queueDAO;

    public List<Queue> getActiveQueueData() {
        return queueDAO.getActiveQueue();
    }

}
