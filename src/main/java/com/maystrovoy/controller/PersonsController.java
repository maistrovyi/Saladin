package com.maystrovoy.controller;

import com.maystrovoy.model.MenuType;
import com.maystrovoy.model.PersonRoleType;
import com.maystrovoy.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonsController extends AbstractLoginDataController {

    public static final String ALL_PERSONS_LIST = "allPersonsList";

    @Inject
    private PersonService personService;

    @RequestMapping(value = "persons", method = RequestMethod.GET)
    private ModelAndView showActiveQueue(HttpServletRequest request) {
        return createModelViewAccordingToRole(request, ALL_PERSONS_LIST, personService.getAllPersonsData());
    }

    @Override
    protected boolean meetCondition(String role) {
        return role.equals(PersonRoleType.ADMIN.getRoleType());
    }

    @Override
    protected boolean isAdminOrConfirmed(HttpServletRequest request) {
        return super.isAdminOrConfirmed(request);
    }

    @RequestMapping(value = "persons", method = RequestMethod.POST)
    public String updatePersonsRightForm(HttpServletRequest request) {
        String editedPersonRole = request.getParameter("editedPersonRightValue");
        String editedPersonLoginName = request.getParameter("editedPersonLoginName");
        String login = getPersonLoginName(request);
        personService.updatePersonsRole(login, editedPersonLoginName, editedPersonRole);
        return "redirect:/persons";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removePerson(HttpServletRequest request) {
        String removedPersonLoginName = request.getParameter("removedPersonLoginName");
        String login = getPersonLoginName(request);
        personService.removePersonByLogin(login, removedPersonLoginName, request);
        return "redirect:/persons";
    }

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    public String resetPersonPassword(HttpServletRequest request) {
        String resetPersonLoginName = request.getParameter("resetPersonLoginName");
        String login = getPersonLoginName(request);
        personService.resetPersonPassword(login, resetPersonLoginName, request);
        return "redirect:/persons";
    }

    @Override
    protected MenuType getMenuTypeText() {
        return MenuType.PERSONS;
    }
}
