package com.example.loginlogout ;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginlogout.Model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    TextView email , password ;
    ArrayList<User> users = new ArrayList<User>();
    User newUser ;
    User userFinded = null ;
    SharedPreferences sharedPreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        auth = FirebaseAuth.getInstance();
    }

    public void handleRegister(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Register.class);
        startActivityForResult(intent , Register.RESULT);
    }

    public void handleLogin(View view){
        String emailc = email.getText().toString();
        String pass = password.getText().toString();
        if (!emailc.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailc).matches()) {
            if (!pass.isEmpty()) {
                auth.signInWithEmailAndPassword(emailc, pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, Home.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                password.setError("Password cannot be empty");
            }
        } else if(emailc.isEmpty()) {
            email.setError("Email cannot be empty");
        } else {
            email.setError("Please enter valid email");
        }
    }




}