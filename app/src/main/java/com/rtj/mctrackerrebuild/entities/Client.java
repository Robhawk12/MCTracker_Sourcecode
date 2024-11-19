package com.rtj.mctrackerrebuild.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_client")
public class Client {
    @PrimaryKey(autoGenerate = true)
    private int clientid;
    private String name;
    private String email;
    private String phoneNumber;

    private PayMethod payMethod;

    public Client(int clientid, String name, String email, String phoneNumber, PayMethod payMethod ) {
        this.clientid = clientid;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;

        this.payMethod = payMethod;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
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


}
