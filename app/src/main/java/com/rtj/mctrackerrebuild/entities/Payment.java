package com.rtj.mctrackerrebuild.entities;
/*Illustrative of Inheritance*
* For future payment pocessing*/
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
