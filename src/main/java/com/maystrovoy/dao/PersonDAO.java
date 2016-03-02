//package com.maystrovoy.dao;
//
//import com.maystrovoy.model.Person;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
//
//@Repository
//@Transactional
//public class PersonDAO {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void addPerson(Person person){
//        entityManager.persist(person);
//    }
//
//    public  void mergePerson(Person person){
//        entityManager.merge(person);
//    }
//
//    public Person getPersonByLogin(String loginName){
//        Person labor = null;
//        Query getPersonQuery = entityManager.createQuery("select p from Person p where p.loginName = :loginParameter");
//        getPersonQuery.setParameter("loginParameter", loginName);
//        List<Person> laborList = getPersonQuery.getResultList();
//        if(laborList.size() > 0){
//            labor = laborList.get(0);
//        }
//        return labor;
//    }
//
//    public boolean isLoginExist(String loginName){
//        boolean isLoginExist = false;
//        Query getPersonQuery = entityManager.createQuery("select p from Person p where p.loginName = :loginParameter");
//        getPersonQuery.setParameter("loginParameter", loginName);
//        List<Person> laborList = getPersonQuery.getResultList();
//        if(laborList.size() > 0){
//            isLoginExist = true;
//        }
//        return isLoginExist;
//    }
//
//}
