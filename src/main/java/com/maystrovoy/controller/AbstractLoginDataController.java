package com.maystrovoy.controller;

import com.maystrovoy.model.MenuType;
import com.maystrovoy.model.Person;
import com.maystrovoy.model.PersonRoleType;
import com.maystrovoy.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public abstract class AbstractLoginDataController {

    private static final Logger LOGGER = LogManager.getLogger(AbstractLoginDataController.class);

    public static final String ACCESS_DENIED = "access_denied";

    protected abstract MenuType getMenuTypeText();

    @Inject
    PersonService personService;

    protected String getMenuTypeAccordingToRole(HttpServletRequest request) {
        if (isAdminOrConfirmed(request)) {
            return getMenuTypeText().getMenuType();
        } else {
            LOGGER.info("Person : " + getPersonLoginName(request) + " tried to enter on " + getMenuTypeText().getMenuName() + " page. Access denied!");
            return ACCESS_DENIED;
        }
    }

    protected ModelAndView createModelViewAccordingToRole(HttpServletRequest request, String objStr, Object attributeValue) {
        ModelAndView mav = new ModelAndView(getMenuTypeText().getMenuType());
        if (isAdminOrConfirmed(request)) {
            mav.addObject(objStr, attributeValue);
        } else {
            LOGGER.info("Person : " + getPersonLoginName(request) + " tried to enter on " + getMenuTypeText().getMenuName() + " page. Access denied!");
            mav.setViewName(ACCESS_DENIED);
        }
        return mav;
    }

    protected boolean isAdminOrConfirmed(HttpServletRequest request) {
        String login = getPersonLoginName(request);
        String role = personService.getPersonRole(login);
        return meetCondition(role);
    }

    protected boolean meetCondition(String role) {
        return role.equals(PersonRoleType.ADMIN.getRoleType()) || role.equals(PersonRoleType.CONFIRMED_USER.getRoleType());
    }

    protected String getPersonLoginName(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Person person = (Person) httpSession.getAttribute("person");
        String login = person.getLoginName();
        return login;
    }

}
