package com.maystrovoy.controller;

import com.maystrovoy.service.QueueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class QueueController {

    @Inject
    private QueueService queueService;

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    private ModelAndView showActiveQueue(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("active");
        queueService.processActiveQueue(request);
        mav.addObject("activeQueueList");
        return mav;
    }

}
