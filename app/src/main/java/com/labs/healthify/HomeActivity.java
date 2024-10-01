package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Welcome "+username,Toast.LENGTH_SHORT).show();

        CardView logout = findViewById(R.id.cardlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            }
        });
        CardView findoc = findViewById(R.id.cardfindoc);
        findoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , FinDocActivity.class));
            }
        });

        CardView labtest = findViewById(R.id.cardlabtest);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , LabTestActivity.class));
            }
        });

        CardView orderdetails = findViewById(R.id.cardorderdet);
        orderdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , OrderDetailsActivity.class));
            }
        });

        CardView buyMed = findViewById(R.id.cardbuymedicine);
        buyMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , BuyMedActivity.class));
            }
        });

        CardView healtharticles = findViewById(R.id.cardhealthdoc);
        healtharticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , HealthArticlesActivity.class));
            }
        });

    }
}