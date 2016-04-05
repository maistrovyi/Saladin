package com.maystrovoy.controller;

import com.maystrovoy.model.Person;
import com.maystrovoy.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PersonsController {

    @Inject
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    private ModelAndView showActiveQueue(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("persons");
        mav.addObject("allPersonsList", personService.getAllPersonsData());
        return mav;
    }

    @RequestMapping(value = "persons", method = RequestMethod.POST)
    public String updatePersonsRightForm(HttpServletRequest request) {
        String editedPersonRole = request.getParameter("editedPersonRightValue");
        String editedPersonLoginName = request.getParameter("editedPersonLoginName");
        HttpSession httpSession = request.getSession();
        Person person = (Person) httpSession.getAttribute("person");
        String login = person.getLoginName();
        personService.updatePersonsRights(login, editedPersonLoginName, editedPersonRole);
        return "redirect:/persons";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removePerson(HttpServletRequest request) {
        String removedPersonLoginName = request.getParameter("removedPersonLoginName");
        HttpSession httpSession = request.getSession();
        Person person = (Person) httpSession.getAttribute("person");
        String login = person.getLoginName();
        personService.removePersonByLogin(login, removedPersonLoginName);
        return "redirect:/persons";
    }
}
