package com.example.loginlogout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListOrder extends AppCompatActivity {
    ListView listViewCocktail ;
    ArrayList<Cocktail> arrCocktail;
    CocktailAdapter adapter;
    DatabaseReference database ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);
        listViewCocktail = findViewById(R.id.listOrder);
        arrCocktail = new ArrayList<>();
        database = FirebaseDatabase.getInstance().getReference("Users");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Cocktail cocktail = dataSnapshot.getValue(Cocktail.class);
                    arrCocktail.add((cocktail));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        adapter = new CocktailAdapter(this , R.layout.row_order , arrCocktail);
        listViewCocktail.setAdapter(adapter);

        listViewCocktail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cocktail cocktail = arrCocktail.get(i);
                Intent intent = new Intent();
                intent.setClass(ListOrder.this , detail_cocktail.class);
                intent.putExtra("dataCocktail",cocktail);
                startActivity(intent);
            }
        });
        listViewCocktail.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alerdialog = new AlertDialog.Builder(ListOrder.this);
                alerdialog.setTitle("Thong bao");
                alerdialog.setMessage("Ban co muon xoa khong");
                alerdialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int ih) {
                        arrCocktail.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                });
                alerdialog.setNegativeButton("khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int ih) {
                    }
                });
                alerdialog.show();
                return false;
            }
        });
    }
}