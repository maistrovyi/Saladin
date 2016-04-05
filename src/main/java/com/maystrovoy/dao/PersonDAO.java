package com.maystrovoy.dao;

import com.maystrovoy.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class PersonDAO {

    private static final Logger LOGGER = LogManager.getLogger(PersonDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void addPerson(Person person) {
        person.setRole("read");
        entityManager.persist(person);
    }

    public void mergePerson(Person person) {
        entityManager.merge(person);
    }

    public void removePersonByLoginName(String adminLogin, String personLoginName) {
        Person person = getPersonByLogin(personLoginName);
        if (person != null) {
            entityManager.remove(person);
            LOGGER.info("admin :" + adminLogin + " removed person :" + personLoginName);
        }
    }

    public void updatePersons(String login, String editedPersonLoginName, String editedPersonRole) {
        Person editedPerson = getPersonByLogin(editedPersonLoginName);
        editedPerson.setRole(editedPersonRole);
        LOGGER.info("Admin: " + login + " changed user " + editedPersonLoginName + " priviliges to " + editedPersonRole);
        entityManager.persist(editedPerson);
    }

    public List<Person> getAllPersons() {
        Query getAllPersonsQuery = entityManager.createQuery("select q from Person q");
        List<Person> allPersonsList = getAllPersonsQuery.getResultList();
        return allPersonsList;
    }

    public Person getPersonByLogin(String loginName) {
        Person labor = null;
        Query getPersonQuery = entityManager.createQuery("select p from Person p where p.loginName = :loginParameter");
        getPersonQuery.setParameter("loginParameter", loginName);
        List<Person> laborList = getPersonQuery.getResultList();
        if (laborList.size() > 0) {
            labor = laborList.get(0);
        }
        return labor;
    }

    public boolean isLoginExist(String loginName) {
        boolean isLoginExist = false;
        Query getPersonQuery = entityManager.createQuery("select p from Person p where p.loginName = :loginParameter");
        getPersonQuery.setParameter("loginParameter", loginName);
        List<Person> laborList = getPersonQuery.getResultList();
        if (laborList.size() > 0) {
            isLoginExist = true;
        }
        return isLoginExist;
    }

}
