package com.rtj.mctrackerrebuild.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.rtj.mctrackerrebuild.R;
import com.rtj.mctrackerrebuild.data.Repository;
import com.rtj.mctrackerrebuild.entities.Client;

public class ClientDetailsActivity extends AppCompatActivity {
    Client currentClient;
    int clientID;
    String name;
    String email;
    String phone;
    String paymentAmount;
    String nameOfInsurance;
    EditText editNameOfInsurance;
    EditText editName;
    EditText editEmail;
    EditText editPhone;
    EditText editPayment;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);

        editName =findViewById(R.id.clientName);
        editEmail =findViewById(R.id.email);
        editPhone =findViewById(R.id.phoneNumber);
        editPayment=findViewById(R.id.amountDue);
        clientID=getIntent().getIntExtra("id",-1);
        name=getIntent().getStringExtra("name");
        email=getIntent().getStringExtra("email");
        phone=getIntent().getStringExtra("phone");
        paymentAmount=getIntent().getStringExtra("paymentamount");
        editName.setText(name);
        editEmail.setText(email);
        editPhone.setText(phone);
        editPayment.setText(paymentAmount);
    }



}
