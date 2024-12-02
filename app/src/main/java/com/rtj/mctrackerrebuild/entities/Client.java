package com.rtj.mctrackerrebuild.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "table_client")
public class Client {
    @PrimaryKey(autoGenerate = true)
    private int clientid;
    private String name;
    private String email;
    private String phoneNumber;
    private PayMethod payMethod;
    private String amountDue;
    private String payType;
    private String timestamp;
    public Client(int clientid, String name, String email, String phoneNumber, PayMethod payMethod, String amountDue, String payType ,String timestamp) {
        this.clientid = clientid;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.payMethod = payMethod;
        this.payType = payType;
        this.amountDue = amountDue;
        this.timestamp =timestamp;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }

    public String getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(String amountDue) {
        this.amountDue = amountDue;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String setTimestamp(String timestamp) {
        Date date = new Date();
        timestamp = date.toString();
        return timestamp;
    }
}
