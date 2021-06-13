package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    DbHelper db;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.email1);
        password=findViewById(R.id.password1);

        login=findViewById(R.id.login);
        db=new DbHelper(this);
        sessionManager=new SessionManager(getApplicationContext());


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=email.getText().toString();
                String pass=password.getText().toString();
                if(username.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checklogin=db.checkemailpassword(username,pass);
                    if(checklogin==true){
                        sessionManager.setLogin(true);
                        sessionManager.setusername(username);
                        Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}