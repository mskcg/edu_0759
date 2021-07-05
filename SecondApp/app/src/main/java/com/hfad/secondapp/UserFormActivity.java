package com.hfad.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserFormActivity extends AppCompatActivity {
    TextView AddUserTextView;
    Button insertUserBtn;
    EditText editTextName;
    EditText editTextLastName;
    EditText editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        AddUserTextView = findViewById(R.id.AddUserTextView);
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPhone = findViewById(R.id.editTextPhone);
        insertUserBtn = findViewById(R.id.insertUserBtn);

        // если активность открылась для отображения текущей записи, заполним поля, закроем для редактирования и спрячем лишние элементы
        if(getIntent().getBooleanExtra("ReadOnly", false) == true) {
            editTextName.setText(getIntent().getStringExtra("UserName"));
            editTextLastName.setText(getIntent().getStringExtra("UserLastName"));
            editTextPhone.setText(getIntent().getStringExtra("Phone"));
            insertUserBtn.setVisibility(View.INVISIBLE);
            AddUserTextView.setVisibility(View.INVISIBLE);
            editTextName.setKeyListener(null);
            editTextLastName.setKeyListener(null);
            editTextPhone.setKeyListener(null);
        }

        insertUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUserName(editTextName.getText().toString());
                user.setUserLastName(editTextLastName.getText().toString());
                user.setPhone(editTextPhone.getText().toString());
                Users users = new Users(UserFormActivity.this);
                users.addUser(user);
                onBackPressed();
            }
        });
    }
}