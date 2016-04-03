package com.maystrovoy.service;

import com.maystrovoy.dao.PersonDAO;
import com.maystrovoy.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PersonService {

    private static final Logger LOGGER = LogManager.getLogger(PersonService.class);

    @Autowired
    private PersonDAO personDAO;

    @Inject
    private MessageSource messageSource;

    public String checkPersonAuthentication(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String authenticationError = null;
        Person person = personDAO.getPersonByLogin(request.getParameter("loginName"));
        if (person == null || !getHashedPassword(request.getParameter("password"), person.getCreationDay()).equals(person.getPassword())) {
            authenticationError = messageSource.getMessage("authenticationError", null, null, null);
            LOGGER.info("Authentication error by login :" + request.getParameter("loginName") + ", Error: " + authenticationError);
        } else {
            definePersonInSession(person, request.getSession());
        }
        return authenticationError;
    }

    public void definePersonInSession(Person person, HttpSession httpSession) {
        httpSession.setAttribute("person", person);
        LOGGER.info("Log in : " + person.getLoginName());
    }

    public void updatePersonsRights(Person editedPerson) {
        personDAO.updatePersons(editedPerson);
    }

    public void registerPerson(Person person) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        person.setPassword(getHashedPassword(person.getPassword(), person.getCreationDay()));
        personDAO.addPerson(person);
    }

    public List<Person> getAllPersonsData() {
        return personDAO.getAllPersons();
    }

    public static String getHashedPassword(String password, String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String generatedPassword = null;
        String passwordToHash = password + salt;

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(passwordToHash.getBytes("UTF-8"));

        byte[] bytes = messageDigest.digest();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = stringBuilder.toString();
        return generatedPassword;
    }

}