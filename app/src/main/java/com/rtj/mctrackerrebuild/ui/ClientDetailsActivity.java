package com.rtj.mctrackerrebuild.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.rtj.mctrackerrebuild.R;
import com.rtj.mctrackerrebuild.data.Repository;
import com.rtj.mctrackerrebuild.entities.Client;
import com.rtj.mctrackerrebuild.entities.PayMethod;

public class ClientDetailsActivity extends AppCompatActivity {
    Client currentClient = null;
    int clientID;
    String name;
    String email;
    String phone;
    String paymentAmount;
    String payType;
    PayMethod payMethod;
    TextView editPayType;
    EditText editName;
    EditText editEmail;
    EditText editPhone;
    TextView editPayment;
    Repository repository ;
    int payMethodID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);
        repository = new Repository(getApplication());

        Intent intent = getIntent();
        editName = findViewById(R.id.clientName);
        editEmail = findViewById(R.id.email);
        editPhone = findViewById(R.id.phoneNumber);
        editPayment = findViewById(R.id.amountDue);
        editPayType = findViewById(R.id.payType);
        clientID = getIntent().getIntExtra("id", -1);
        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phone");
        payMethod = (PayMethod) intent.getSerializableExtra("paymethod");
        if(payMethod != null){
            payMethodID = payMethod.getId();
        }
        paymentAmount = getIntent().getStringExtra("amountdue");
        payType = getIntent().getStringExtra("paytype");
        editName.setText(name);
        editEmail.setText(email);
        editPhone.setText(phone);
        editPayment.setText(paymentAmount);
        editPayType.setText(payType);

        //Spinner
        Spinner paySpinner = findViewById(R.id.paySpinner);
        PayMethod[] payMethods = PayMethod.values();
        ArrayAdapter<PayMethod> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, payMethods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paySpinner.setAdapter(adapter);
        if(payMethod != null) {
            paySpinner.setSelection(payMethodID);
        }
        paySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                PayMethod selectedPayMethod = (PayMethod) adapterView.getItemAtPosition(position);
                if(selectedPayMethod == PayMethod.CASH){
                    payType = selectedPayMethod.getDisplayName();
                    paymentAmount = selectedPayMethod.getAmountDue();
                    editPayment.setText(paymentAmount);
                    editPayType.setText(payType);
                    payMethod = PayMethod.CASH;
                }
                if(selectedPayMethod == PayMethod.FirstGroup){
                    payType = selectedPayMethod.getDisplayName();
                    paymentAmount = selectedPayMethod.getAmountDue();
                    editPayment.setText(paymentAmount);
                    editPayType.setText(payType);
                    payMethod = PayMethod.FirstGroup;
                }
                if(selectedPayMethod == PayMethod.UnitedHealth){
                    payType = selectedPayMethod.getDisplayName();
                    paymentAmount = selectedPayMethod.getAmountDue();
                    editPayment.setText(paymentAmount);
                    editPayType.setText(payType);
                    payMethod = PayMethod.UnitedHealth;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
           }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save_delete, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete) {

            for (Client c : repository.getAllClients()) {
                if (c.getClientid() == clientID) currentClient = c;
                showDeleteDialog();

            }
        }
        if(item.getItemId()==R.id.save){
            Client client;
            int listSize = repository.getAllClients().size();
            if(clientID == -1){
                if(listSize == 0) clientID = 0;
                else
                    clientID = repository.getAllClients()
                            .get(repository.getAllClients().size() - 1).getClientid() + 1;
                client = new Client(clientID,editName.getText().toString(),editEmail.getText().toString(),
                        editPhone.getText().toString(),payMethod,editPayment.getText().toString()
                        ,editPayType.getText().toString());
                repository.insert(client);
                this.finish();
            }else {
                client = new Client(clientID,editName.getText().toString(),editEmail.getText().toString(),
                        editPhone.getText().toString(),payMethod,editPayment.getText().toString()
                        ,editPayType.getText().toString());
                repository.update(client);
                this.finish();
            }
        }
        return true;

    }

    private void showDeleteDialog(){
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog_delete_alert,null);
        TextView alertTitle = alertLayout.findViewById(R.id.alertTitle);
        TextView alertMessage = alertLayout.findViewById(R.id.alertMessage);
        Button cancelButton = alertLayout.findViewById(R.id.cancelButton);
        Button confirmButton = alertLayout.findViewById(R.id.confirmButton);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(alertLayout);
        alert.setCancelable(false);
        AlertDialog dialog = alert.create();

        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.dismiss();
            }
        });
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                repository.delete(currentClient);
                Toast.makeText(ClientDetailsActivity.this,currentClient.getName()+" was deleted",
                        Toast.LENGTH_LONG).show();
                dialog.dismiss();
              finish();
            }
        });
        dialog.show();
    }

}