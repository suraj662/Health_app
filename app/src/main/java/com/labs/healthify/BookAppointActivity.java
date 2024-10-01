package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.net.URI;
import java.util.Calendar;

public class BookAppointActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    TextView tv;
    private Button dateButton , timeButton ,btnbookappoint , btnback;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appoint);
        tv=findViewById(R.id.tvba);
        ed1=findViewById(R.id.etbaname);
        ed2=findViewById(R.id.etbaAdd);
        ed3=findViewById(R.id.etbaconum);
        ed4=findViewById(R.id.etconfees);
        dateButton=findViewById(R.id.btnseldate);
        timeButton=findViewById(R.id.btnseltime);
        btnbookappoint=findViewById(R.id.btnbookappoint);
        btnback=findViewById(R.id.btnback);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title=it.getStringExtra("text1");
        String fname=it.getStringExtra("text2");
        String add=it.getStringExtra("text3");
        String connum=it.getStringExtra("text4");
        String confees=it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fname);
        ed2.setText(add);
        ed3.setText(connum);
        ed4.setText("Con Fees : "+confees+"/-");

        //datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
        //timepicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppointActivity.this , FinDocActivity.class));
            }
        });

        btnbookappoint.setOnClickListener(new View.OnClickListener() {
            TextView web;

                    @Override
                    public void onClick(View view) {

                        openMeetUrl("https://meet.google.com/");
                    }

                });
            }

            private void openMeetUrl(String url) {
                try {
                    Uri uri = Uri.parse(url);
                    startActivity(new Intent(Intent.ACTION_VIEW,uri));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                }
    }
    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i+":"+i1);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);


        int style= AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        timePickerDialog = new TimePickerDialog(this,style,timeSetListener,hrs,mins,false);

    }
}