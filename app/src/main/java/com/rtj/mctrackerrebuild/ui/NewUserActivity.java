package com.rtj.mctrackerrebuild.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.rtj.mctrackerrebuild.R;
import com.rtj.mctrackerrebuild.data.Repository;

public class NewUserActivity extends AppCompatActivity {
    Repository repository;
    EditText editUserName;
    EditText editPassword;
    Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        repository = new Repository(getApplication());
       editUserName = findViewById(R.id.editTextUsername2);
       editPassword = findViewById(R.id.editTextPassword2);
       buttonSave = findViewById(R.id.save_user_button);

       buttonSave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String username = editUserName.getText().toString();
               String password = editPassword.getText().toString();


           }
       });

    }
}
