package com.hfad.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserFormActivity extends AppCompatActivity {
    private Button insertUserBtn;
    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextPhone;
    private User user;
    private boolean new_user = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        user = (User) getIntent().getSerializableExtra("user");
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPhone = findViewById(R.id.editTextPhone);
        insertUserBtn = findViewById(R.id.insertUserBtn);
        if(user != null){ // Если редактируем юзера
            editTextName.setText(user.getUserName());
            editTextLastName.setText(user.getUserLastName());
            editTextPhone.setText(user.getPhone());
        }else{ // если добавляем нового
            new_user = true;
            user = new User();
        }

        insertUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setUserName(editTextName.getText().toString());
                user.setUserLastName(editTextLastName.getText().toString());
                user.setPhone(editTextPhone.getText().toString());
                Users users = new Users(UserFormActivity.this);
                if(new_user) users.addUser(user);
                else users.updateUser(user);
                onBackPressed();
            }
        });
    }
}