package com.rtj.mctrackerrebuild.entities;

public abstract class Payment {
    public double amount;

    public Payment(double amount){
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    public void processPayment(){

    }

}
