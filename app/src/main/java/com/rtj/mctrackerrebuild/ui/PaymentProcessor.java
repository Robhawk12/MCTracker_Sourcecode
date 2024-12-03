package com.rtj.mctrackerrebuild.ui;

import android.content.Context;
import android.widget.Toast;

import com.rtj.mctrackerrebuild.entities.Payment;

public class PaymentProcessor {
    Context context;
    //For future payment integration. Illustrative of polymorphism
    public void handlePayment(Payment payment){

        payment.processPayment();
    }
}
