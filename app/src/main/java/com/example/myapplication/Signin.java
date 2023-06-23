package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    EditText email;
    EditText password;
    Button signin;
    TextView toregister;
    private FirebaseAuth mauth;

    protected void onCreate(Bundle saveInstanceState) {
        mauth = FirebaseAuth.getInstance();
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email1);
        password = findViewById(R.id.password1);
        signin = findViewById(R.id.login);
        toregister = findViewById(R.id.toRegister);

        signin.setOnClickListener(view -> {
            loginUser();
        });
        toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signin.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        //String email = email.getText().toString();
        //String password2 = password.getText().toString();
        if (TextUtils.isEmpty(email.getText().toString())) {
            email.setError("Email cannot be empty");
            password.requestFocus();
        } else if (TextUtils.isEmpty(password.getText().toString())) {
            password.setError("Password cannot be empty");
            password.requestFocus();
        } else {
            mauth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(Signin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Signin.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                                //start our quiz activity
                                startActivity(new Intent(Signin.this,QuizActivity.class));
                            } else {
                                Toast.makeText(Signin.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });


        }
    }
}