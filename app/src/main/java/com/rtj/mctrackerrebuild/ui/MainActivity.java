package com.rtj.mctrackerrebuild.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rtj.mctrackerrebuild.R;

public class MainActivity extends AppCompatActivity {
        EditText editUsername;
        EditText editPassword;
        String n = "Admin";
        String p = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UserRepository repository = new UserRepository(getApplication());
        //User user = new User();
        editUsername = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);

        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                Intent intent = new Intent(MainActivity.this,ClientListActivity.class);
               //user = repository.getUserByUserame(name);
               if(name.equals("Admin") && password.equals("Password")) {
                   startActivity(intent);
                   Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
               }
           }
        });
    }
}