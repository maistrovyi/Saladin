package com.maystrovoy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "QUEUE")
public class Queue implements Serializable {

    @Id
    @SequenceGenerator(name="oracle_jpa_seq",
            sequenceName="oracle_jpa_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="oracle_jpa_seq")

    @Column(name = "QUEUEID")
    private long queueId;

    @Column(name = "OBJECTID")
    private String objectId;

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

    public Queue(long queueId, String objectId, int objectType, String status, Date startDate, Date finishDate, String userName, String message) {
        this.queueId = queueId;
        this.objectId = objectId;
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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
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
