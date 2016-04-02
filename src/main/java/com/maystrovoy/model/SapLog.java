package com.maystrovoy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAP_LOG")
public class SapLog implements Serializable {

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

    public SapLog() {
    }

    public SapLog(String targetObject) {
        this.targetObject = targetObject;
    }

    public String getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }
}
