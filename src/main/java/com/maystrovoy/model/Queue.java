package com.maystrovoy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "QUEUE")
public class Queue implements Serializable {

    @Id
    @SequenceGenerator(name="queue_seq", sequenceName="queue_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="queue_seq")
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

    public Queue() {
    }

    public Queue(String targetObject, String userName, int objectType) {
        this.targetObject = targetObject;
        this.userName = userName;
        this.objectType = objectType;
        status = "ACTIVE";
        startDate = new Date();
        finishDate = null;
        message = null;
    }

    public Queue(long queueId, String targetObject, int objectType, String status, Date startDate, Date finishDate, String userName, String message) {
        this.queueId = queueId;
        this.targetObject = targetObject;
        this.objectType = objectType;
        this.status = status;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.userName = userName;
        this.message = message;
    }

    public long getQueueId() {
        return queueId;
    }

    public void setQueueId(long queueId) {
        this.queueId = queueId;
    }

    public String getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
