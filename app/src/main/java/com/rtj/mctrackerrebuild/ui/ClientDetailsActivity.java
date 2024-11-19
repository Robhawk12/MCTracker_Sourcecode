package com.rtj.mctrackerrebuild.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.rtj.mctrackerrebuild.R;
import com.rtj.mctrackerrebuild.data.Repository;
import com.rtj.mctrackerrebuild.entities.Client;

public class ClientDetailsActivity extends AppCompatActivity {
    Client currentClient = null;
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
    Repository repository ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);
        repository = new Repository(getApplication());
        editName = findViewById(R.id.clientName);
        editEmail = findViewById(R.id.email);
        editPhone = findViewById(R.id.phoneNumber);
        editPayment = findViewById(R.id.amountDue);
        clientID = getIntent().getIntExtra("id", -1);
        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phone");
        paymentAmount = getIntent().getStringExtra("paymentamount");
        editName.setText(name);
        editEmail.setText(email);
        editPhone.setText(phone);
        editPayment.setText(paymentAmount);
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