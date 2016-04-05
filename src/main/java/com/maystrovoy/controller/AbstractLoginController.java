package com.maystrovoy.controller;

import com.maystrovoy.model.Person;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public abstract class AbstractLoginController {

    protected String getPersonLoginName(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Person person = (Person) httpSession.getAttribute("person");
        String login = person.getLoginName();
        return login;
    }
}
