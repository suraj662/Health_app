package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailActivity extends AppCompatActivity {
TextView tvPacknaame,tvTotalCost;
EditText edDetails;
Button btnldgotocart,buttonLDBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);
        tvPacknaame=findViewById(R.id.tvldpackages);
        tvTotalCost=findViewById(R.id.tvtotalcost);
        edDetails=findViewById(R.id.editTextTextMultiLine);
        btnldgotocart=findViewById(R.id.btnldgotocart);
        buttonLDBack=findViewById(R.id.buttonLDBack);

        edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvPacknaame.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        buttonLDBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailActivity.this,LabTestActivity.class));
            }
        });
        btnldgotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvPacknaame.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(),"healthify",null,1);

                if (db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(),"Product already Added",Toast.LENGTH_SHORT).show();
                }else {
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(),"Product Added",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailActivity.this,LabTestActivity.class));
                }
            }
        });
    }
}