package com.rtj.mctrackerrebuild.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Client_Insurance")
public class Insurance {
    @PrimaryKey(autoGenerate = true)
    private int insuranceID;
    private int clientID;
    private String insuranceName;
    private String copayAmount;

    public Insurance(int insuranceID, int clientID, String insuranceName, String copayAmount) {
        this.insuranceID = insuranceID;
        this.clientID = clientID;
        this.insuranceName = insuranceName;
        this.copayAmount = copayAmount;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getCopayAmount() {
        return copayAmount;
    }

    public void setCopayAmount(String copayAmount) {
        this.copayAmount = copayAmount;
    }
}
