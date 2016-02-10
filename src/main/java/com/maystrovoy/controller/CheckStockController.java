package com.maystrovoy.controller;

import java.lang.String;
import com.maystrovoy.service.CheckStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckStockController {
    @Autowired
    private CheckStockService checkStockService;

    @RequestMapping(value = "check_stock", method = RequestMethod.GET)
    public java.lang.String showCheckStockForm() {
        return "check_stock";
    }

    @RequestMapping(value = "check_stock", method = RequestMethod.POST)
    public String processCheckStockForm(HttpServletRequest request) {
        String location = request.getParameter("location");
        String material = request.getParameter("material");
        checkStockService.processCheckStock(location, material);
        return "check_stock";
    }

}
