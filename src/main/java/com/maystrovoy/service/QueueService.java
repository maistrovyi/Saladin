package com.maystrovoy.service;

import com.maystrovoy.dao.QueueDAO;
import com.maystrovoy.model.Queue;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class QueueService {

    @Inject
    private QueueDAO queueDAO;

    public List<Queue> processActiveQueue(HttpServletRequest request) {
        List<Queue> queueList = (List<Queue>) request.getAttribute("activeQueueList");
        queueList = queueDAO.getActiveQueue();
        return queueList;
    }

}
