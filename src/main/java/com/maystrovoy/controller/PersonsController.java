package com.maystrovoy.controller;

import com.maystrovoy.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonsController extends AbstractLoginController {

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
        String login = getPersonLoginName(request);
        personService.updatePersonsRights(login, editedPersonLoginName, editedPersonRole);
        return "redirect:/persons";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removePerson(HttpServletRequest request) {
        String removedPersonLoginName = request.getParameter("removedPersonLoginName");
        String login = getPersonLoginName(request);
        personService.removePersonByLogin(login, removedPersonLoginName);
        request.getSession().invalidate();
        return "redirect:/persons";
    }

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    public String resetPersonPassword(HttpServletRequest request) {
        String resetPersonLoginName = request.getParameter("resetPersonLoginName");
        String login = getPersonLoginName(request);
        personService.resetPersonPassword(login, resetPersonLoginName);
        return "redirect:/persons";
    }
}
