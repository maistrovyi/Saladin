//package com.maystrovoy.model;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
//@Entity
//@Table(name ="PERSON")
//public class Person implements Serializable {
//
//    @Id
//    @SequenceGenerator(name="person_seq",
//            sequenceName="person_seq",
//            allocationSize=1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//            generator="person_seq")
//    @Column(name = "person_id", updatable=false)
//    private long id;
//    @Column(name = "login_name")
//    private String  loginName;
//    @Column(name = "password")
//    private String  password;
//    @Column(name = "first_name")
//    private String  firstName;
//    @Column(name = "second_name")
//    private String  secondName;
//    @Column(name = "birth_date")
//    private Date birthDate;
//
//    public Person() {
//    }
//
//    public Person(String loginName, String password, String firstName, String secondName, Date birthDate) {
//        this.loginName = loginName;
//        this.password = password;
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.birthDate = birthDate;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getLoginName() {
//        return loginName;
//    }
//
//    public void setLoginName(String loginName) {
//        this.loginName = loginName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getSecondName() {
//        return secondName;
//    }
//
//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//}
