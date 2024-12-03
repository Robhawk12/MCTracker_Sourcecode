package com.rtj.mctrackerrebuild.entities;

import android.content.Context;
import android.widget.Toast;

import com.rtj.mctrackerrebuild.ui.ClientDetailsActivity;
import com.rtj.mctrackerrebuild.ui.PaymentProcessor;

/*Illustrative of Inheritance*
 * For future payment pocessing*/
public class CreditCardPayment extends Payment{
    private String cardNumber;
    Context context;

    public CreditCardPayment(double amount, String cardNumber){
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(){
        System.out.println("Processing credit card payment amount of $"+amount+" using card"+
                cardNumber);
        Toast.makeText(context,"Processing credit card payment amount of $"+amount+" using card"+
                cardNumber,Toast.LENGTH_LONG).show();
    }
}
