package com.maystrovoy.controller;

import com.maystrovoy.model.Person;
import com.maystrovoy.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "simple_material", method = RequestMethod.GET)
    public String showCheckStockForm() {
        return "simple_material";
    }

    @RequestMapping(value = "simple_material", method = RequestMethod.POST)
    public String processCheckStockForm(HttpServletRequest request) {
        String material = request.getParameter("material");
        System.out.println("material : " + material);
        HttpSession httpSession = request.getSession();
        Person person = (Person) httpSession.getAttribute("person");
        String login = person.getLoginName();
        materialService.processMaterial(material, login);
        return "redirect:/simple_material";
    }
}
