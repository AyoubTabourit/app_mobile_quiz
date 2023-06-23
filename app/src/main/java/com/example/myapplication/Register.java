package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {


        EditText email;
        EditText password;
        EditText password2;
        Button btnregi;
        TextView loginne;


        protected void onCreate(Bundle saveInstanceState){

            super.onCreate(saveInstanceState);
            setContentView(R.layout.activity2);


            email=findViewById(R.id.Email2);
            password=findViewById(R.id.password2R);
            password2=findViewById(R.id.confirmpassword2);
            btnregi=findViewById(R.id.btn);
            loginne=findViewById(R.id.register);
            btnregi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("message",email.getText().toString());

                    if(password.getText().toString().trim().equals(password2)){
                        Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                    }
                }
            });

            loginne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(Register.this,Signin.class);
                    startActivity(intent);
                    finish();
                }
            });
        };

    }

