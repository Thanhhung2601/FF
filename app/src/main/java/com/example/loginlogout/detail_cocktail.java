package com.example.loginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detail_cocktail extends AppCompatActivity {
    TextView title , price ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocktail_detail);
        title = findViewById(R.id.detail_title);
        price = findViewById(R.id.detail_price);

        Cocktail cocktail = (Cocktail) getIntent().getSerializableExtra("dataCocktail");

    }
}