package com.rtj.mctrackerrebuild.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rtj.mctrackerrebuild.R;

public class MainActivity extends AppCompatActivity {
        private EditText editUsername;
        private EditText editPassword;
        private SharedPreferences sharedPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username = "Massage";
        String password = "therapy";
        sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putString("username",username)
                .putString("password",password)
                .apply();

        editUsername = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);


        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLogin();
            }
        });
    }

    private void handleLogin(){
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            return;
        }
            String savedUsername = sharedPreferences.getString("username",null);
            String savedPassword = sharedPreferences.getString("password",null);
            if (username.equals(savedUsername) && password.equals(savedPassword)){
                Toast.makeText(this,"Welcome back "+username,Toast.LENGTH_LONG ).show();
                Intent intent = new Intent(MainActivity.this,ClientListActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show();
            }
        }
    }


