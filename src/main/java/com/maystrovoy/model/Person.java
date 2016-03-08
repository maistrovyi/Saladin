package com.maystrovoy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name ="PERSON")
public class Person implements Serializable {

    @Id
    @SequenceGenerator(name="person_seq", sequenceName="person_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="person_seq")
    @Column(name = "ID_PERSON", updatable=false)
    private long id;
    @Column(name = "LOGIN_NAME")
    private String  loginName;
    @Column(name = "FIRST_NAME")
    private String  firstName;
    @Column(name = "SECOND_NAME")
    private String  secondName;
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    @Column(name = "PASSWORD")
    private String password;


    public Person() {
    }

    public Person(String loginName, String password, String secondName, Date creationDate, String password1) {
        this.loginName = loginName;
        this.password = password;
        this.secondName = secondName;
        this.creationDate = creationDate;
        password = password1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(getCreationDate());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", creationDate=" + creationDate +
                ", password='" + password + '\'' +
                '}';
    }

}
