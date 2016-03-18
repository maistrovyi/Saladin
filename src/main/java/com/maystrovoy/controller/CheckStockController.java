package com.maystrovoy.controller;

import com.maystrovoy.model.Person;
import com.maystrovoy.service.CheckStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CheckStockController {

    @Autowired
    private CheckStockService checkStockService;

    @RequestMapping(value = "check_stock", method = RequestMethod.GET)
    public String showCheckStockForm() {
        return "check_stock";
    }

    @RequestMapping(value = "check_stock", method = RequestMethod.POST)
    public String processCheckStockForm(HttpServletRequest request) {
        String location = request.getParameter("location");
        String material = request.getParameter("material");
        HttpSession httpSession = request.getSession();
        Person person = (Person) httpSession.getAttribute("person");
        String login = person.getLoginName();
        checkStockService.processCheckStock(location, material, login);
        return "redirect:/check_stock";
    }

}
