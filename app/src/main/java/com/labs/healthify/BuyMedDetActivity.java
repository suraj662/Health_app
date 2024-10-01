package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyMedDetActivity extends AppCompatActivity {

    TextView totcost,tvpackname;
    EditText multiline;
    Button btnaddtocart,btnback;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_med_det);

        tvpackname=findViewById(R.id.tvmedpackages);
        totcost=findViewById(R.id.tvtotalcost);
        multiline=findViewById(R.id.editTextTextMultiLineBMD);
        multiline.setKeyListener(null);
        btnaddtocart=findViewById(R.id.btnBMDaddtocart);
        btnback=findViewById(R.id.btnBMDBack);

        Intent intent = getIntent();
        tvpackname.setText(intent.getStringExtra("text1"));
        multiline.setText(intent.getStringExtra("text2"));
        totcost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedDetActivity.this,BuyMedActivity.class));
            }
        });

        btnaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvpackname.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(),"healthify",null,1);

                if (db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(),"Product already Added",Toast.LENGTH_SHORT).show();
                }else {
                    db.addCart(username,product,price,"medicine");
                    Toast.makeText(getApplicationContext(),"Product Added",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedDetActivity.this,BuyMedActivity.class));
                }
            }
        });
    }
}