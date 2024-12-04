package com.rtj.mctrackerrebuild.entities;

import android.content.Context;
import android.widget.Toast;

/*Illustrative of Inheritance*
 * For future payment pocessing*/
public class InsurancePayment extends Payment{
    private String insuranceProvider;
    Context context;
    public InsurancePayment(double amount, String insuranceProvider){
        super(amount);
        this.insuranceProvider = insuranceProvider;
    }


    public void processPayment(Context context){
        System.out.println("Processing insurance payment of $"+ amount +" with provider"
        +insuranceProvider);
        Toast.makeText(context,"Processing insurance payment of $"+ amount +" with provider"
                +insuranceProvider,Toast.LENGTH_LONG).show();
    }
}
