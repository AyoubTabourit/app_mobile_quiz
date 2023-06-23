package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {


    EditText email;
    EditText password;
    EditText password2;
    Button btnregi;
    TextView loginne;

         FirebaseAuth mAuth;
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_register);


        email = findViewById(R.id.Email2);
        password = findViewById(R.id.password2R);
        password2 = findViewById(R.id.confirmpassword2);
        btnregi = findViewById(R.id.btn);
        loginne = findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();
          loginne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(RegisterActivity.this,Signin.class);
                        startActivity(intent);
                       // finish();
                    }

            });
        btnregi.setOnClickListener(view -> {
            createUser();
           Intent intent= new Intent(RegisterActivity.this,Signin.class);
            startActivity(intent);
                            Log.i("message",intent.getAction().toString());
            //finish();

        });
    }
          private void createUser() {



              if (TextUtils.isEmpty(email.getText().toString())) {
                  email.setError("Email cannot be empty");
                  email.requestFocus();
              } else if (TextUtils.isEmpty(password.getText().toString())) {
                  password.setError("Password cannot be empty");
                  password.requestFocus();
              } else if (TextUtils.isEmpty(password2.getText().toString())) {
                  password2.setError("Password cannot be empty");
                  password2.requestFocus();
              } else {
                  mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if (task.isSuccessful()){
                                 Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();

                                           Intent intent= new Intent(RegisterActivity.this,Signin.class);
                                           startActivity(intent);
                             }else{
                                 Toast.makeText(RegisterActivity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                             }
                          }
              });
          }
      }
}