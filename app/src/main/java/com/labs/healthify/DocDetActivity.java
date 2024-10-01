package com.labs.healthify;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DocDetActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
    {
        {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
        {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
        {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
        {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898800000", "500"},
        {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
    };


    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898800000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };


    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898800000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };


    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898800000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };


    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898" ,"300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898800000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };

    TextView tv;
    Button btn;
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    String[][] doctor_detail = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_det);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_detail=doctor_details1;
        else

        if(title.compareTo("Dietitian")==0)
        doctor_detail=doctor_details2;
        else

        if(title.compareTo("Dentist")==0)
            doctor_detail=doctor_details3;
        else

        if(title.compareTo("Surgeon")==0)
            doctor_detail=doctor_details4;
        else
            doctor_detail=doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocDetActivity.this,FinDocActivity.class));
            }
        });

        list = new ArrayList();

        for(int i=0;i<doctor_detail.length;i++){
            item = new HashMap<String,String>();
            item.put("Line1",doctor_detail[i][0]);
            item.put("Line2",doctor_detail[i][1]);
            item.put("Line3",doctor_detail[i][2]);
            item.put("Line4",doctor_detail[i][3]);
            item.put("Line5","Cons Fees : "+doctor_detail[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DocDetActivity.this ,BookAppointActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_detail[i][0]);
                it.putExtra("text3",doctor_detail[i][1]);
                it.putExtra("text4",doctor_detail[i][3]);
                it.putExtra("text5",doctor_detail[i][4]);
                startActivity(it);
            }
        });
    }
}