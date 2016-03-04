package com.maystrovoy.service;

import com.maystrovoy.dao.PersonDAO;
import com.maystrovoy.model.Person;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class PersonService {

    @Inject
    PersonDAO personDAO;
    @Inject
    private MessageSource messageSource;

    public String checkPersonAuthentication(HttpServletRequest request) {
        String authenticationError = null;
        Person person = personDAO.getPersonByLogin(request.getParameter("loginName"));
        if (person == null || !request.getParameter("password").equals(person.getPassword())) {
            authenticationError = messageSource.getMessage("authorizationerr", null, null, null);
        } else {
            definePersonInSession(person, request.getSession());
        }
        return authenticationError;
    }

    public void definePersonInSession(Person person, HttpSession httpSession) {
        httpSession.setAttribute("person", person);
    }

    public void registerPerson(Person person) {
        personDAO.addPerson(person);
    }

}