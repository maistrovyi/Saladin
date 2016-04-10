package com.maystrovoy.controller;

import com.maystrovoy.model.MenuType;
import com.maystrovoy.service.QueueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class QueueController extends AbstractLoginDataController {

    public static final String ACTIVE_QUEUE_LIST = "activeQueueList";

    @Inject
    private QueueService queueService;

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    private ModelAndView showActiveQueue(HttpServletRequest request) {
        return createModelViewAccordingToRole(request, ACTIVE_QUEUE_LIST, queueService.getActiveQueueData());
    }

    @Override
    protected MenuType getMenuTypeText() {
        return MenuType.ACTIVE_QUEUE;
    }

}
