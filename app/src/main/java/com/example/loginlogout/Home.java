package com.example.loginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginlogout.Model.User;

import java.util.List;

public class Home extends AppCompatActivity {
    TextView userName , email ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        userName = findViewById(R.id.textView8);
        email = findViewById(R.id.textView9);
    }

    public void handleLogout (View view){
        finish();
    }

    public void navigateListView(View view){
        Toast.makeText(this, "Runn", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(Home.this , ListOrder.class);
        startActivity(intent);
    }
}