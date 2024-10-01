package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {

    EditText name,add,pin,connum;
    Button booklt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        name=findViewById(R.id.etltbname);
        add=findViewById(R.id.etltbAdd);
        pin=findViewById(R.id.etltbpin);
        connum=findViewById(R.id.etltbconum);
        booklt=findViewById(R.id.btnbooklt);

        Intent intent=getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        booklt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                Database db = new Database(getApplicationContext(),"healthify",null,1);
                db.addOrder(username,name.getText().toString(),add.getText().toString(),connum.getText().toString(),Integer.parseInt(pin.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price[1].toString()),"lab");
                db.removeCart(username,"lab");
                Toast.makeText(getApplicationContext(),"Your Booking is Succesfully Done",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this,HomeActivity.class));
            }
        });
    }
}