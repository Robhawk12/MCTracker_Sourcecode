package com.rtj.mctrackerrebuild.entities;

import android.content.Context;
import android.widget.Toast;

/*Illustrative of Inheritance*
 * For future payment pocessing*/
public class CashPayment extends Payment{
    Context context;
    public CashPayment(double amount){
        super(amount);
    }

 public void processPayment(Context context) {
        System.out.println("Processing cash payment of "+ amount);
        Toast.makeText(context,"Processing cash payment of $"+amount,Toast.LENGTH_LONG).show();
         }
}
