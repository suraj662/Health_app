package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FinDocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_doc);

        CardView home = findViewById(R.id.cardFDback);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinDocActivity.this , HomeActivity.class));
            }
        });
        CardView famphy = findViewById(R.id.cardFDfamilyphy);
        famphy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinDocActivity.this , DocDetActivity.class);
                it.putExtra("title" , "Family Physician");
                startActivity(it);
            }
        });
        CardView diet = findViewById(R.id.cardFDdiet);
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinDocActivity.this , DocDetActivity.class);
                it.putExtra("title" , "Dietitian");
                startActivity(it);
            }
        });

        CardView dentist = findViewById(R.id.cardFDdentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinDocActivity.this , DocDetActivity.class);
                it.putExtra("title" , "Dentist");
                startActivity(it);
            }
        });
        CardView cardio = findViewById(R.id.cardFDcardiologist);
        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinDocActivity.this , DocDetActivity.class);
                it.putExtra("title" , "Cardiologist");
                startActivity(it);
            }
        });
        CardView surgeon = findViewById(R.id.cardFDsurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FinDocActivity.this , DocDetActivity.class);
                it.putExtra("title" , "Surgeon");
                startActivity(it);
            }
        });
    }
}