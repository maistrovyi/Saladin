package com.maystrovoy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAP_LOG")
public class Sap_Log implements Serializable {

    @Id
    @Column(name = "QUEUEID")
    private long queueId;
    @Column(name = "OBJECTID")
    private String targetObject;
    @Column(name = "OBJECTTYPE")
    private int objectType;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "STARTDATE")
    private Date startDate;
    @Column(name = "FINISHDATE")
    private Date finishDate;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "MESSAGE")
    private String message;

    public Sap_Log() {
    }

    public Sap_Log(String targetObject) {
        this.targetObject = targetObject;
    }

    public String getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }
}
