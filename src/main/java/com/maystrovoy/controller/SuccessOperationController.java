package com.maystrovoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuccessOperationController {

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String successPage() {
        return "success";
    }

}
