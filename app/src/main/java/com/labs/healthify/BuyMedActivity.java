package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedActivity extends AppCompatActivity {

    private String[][] medicines ={
            {"Sinarest"," "," "," ","59"},
            {"Dolo 650"," "," "," ","49"},
            {"Parasip"," "," "," ","89"},
            {"Corflam"," "," "," ","35"},
            {"Clomin"," "," "," ","79"},
            {"Zifi 200"," "," "," ","109"},
            {"Limcee"," "," "," ","69"},
            {"Strepsils"," "," "," ","65"},
            {"Dynapar"," "," "," ","95"},
            {"Mentat"," "," "," ","115"},
            {"Dipsonil"," "," "," ","109"},

    };

    private String[] med_det={
            "Helps in extreme cold",
            "Helps in extreme fever\n"+"Consist of Paracetamol",
            "Its a 500mg paracetamol for kids",
            "It is a pain killer provied relief in body pains",
            "It is for Stomach ache provide relief immediately",
            "Zifi 200 provide an antibiotic drug to the body for bacteria killing",
            "It is a vitamin C tablets ",
            "It is used to get relief in cough",
            "It is a high power diclofenec for head ache",
            "It is an ayurvedic tablets",
            "It is for sleep !Should not be advised to consume everyday!"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button back,gotocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_med);

        lst = findViewById(R.id.listViewBM);
        back=findViewById(R.id.buttonBMBack);
        gotocart=findViewById(R.id.btnBMgotocart);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedActivity.this,HomeActivity.class));
            }
        });

        gotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedActivity.this,CartBuyMedActivity.class));
            }
        });

        list = new ArrayList();
        for (int i =0;i<medicines.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",medicines[i][0]);
            item.put("line2",medicines[i][1]);
            item.put("line3",medicines[i][2]);
            item.put("line4",medicines[i][3]);
            item.put("line5","Total Cost : "+medicines[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedActivity.this,BuyMedDetActivity.class);
                it.putExtra("text1",medicines[i][0]);
                it.putExtra("text2",med_det[i]);
                it.putExtra("text3",medicines[i][4]);
                startActivity(it);
            }
        });
    }

}