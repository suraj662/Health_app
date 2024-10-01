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

public class BuyMedBookActivity extends AppCompatActivity {

    EditText name,add,pin,connum;
    Button bookmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_med_book);

        name=findViewById(R.id.etmedbookname);
        add=findViewById(R.id.etmedbookAdd);
        pin=findViewById(R.id.etmedbookpin);
        connum=findViewById(R.id.etmedbookconum);
        bookmed=findViewById(R.id.btnbookmed);

        Intent intent=getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");


        bookmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                Database db = new Database(getApplicationContext(),"healthify",null,1);
                db.addOrder(username,name.getText().toString(),add.getText().toString(),connum.getText().toString(),Integer.parseInt(pin.getText().toString()),date.toString()," ",Float.parseFloat(price[1].toString()),"medicine");
                db.removeCart(username,"medicine");
                Toast.makeText(getApplicationContext(),"Your Booking is Succesfully Done",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedBookActivity.this,HomeActivity.class));
            }
        });
    }
}