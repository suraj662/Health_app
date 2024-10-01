package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername , edEmail , edpass , edconpass;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.etregname);
        edEmail = findViewById(R.id.etmail);
        edpass = findViewById(R.id.etregpass);
        edconpass = findViewById(R.id.etconpass);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.tvlog);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this , LoginActivity.class ));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String pass = edpass.getText().toString();
                String conpass = edconpass.getText().toString();
                Database db = new Database(getApplicationContext(),"healthify",null,1);

                if (username.length()==0 || pass.length()==0 || email.length()==0 || conpass.length()==0){
                    Toast.makeText(getApplicationContext(),"Fill the Details !!!",Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.compareTo(conpass)==0){
                    if(isvalid(pass)){
                        db.register(username,email,pass);
                        Toast.makeText(getApplicationContext(),"Registered Succesfully!!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this , LoginActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(),"Password does not match the criteria",Toast.LENGTH_SHORT).show();
                    }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password and Confirm Password doesn't match",Toast.LENGTH_SHORT).show();
                    }
            }}
        });
    }
    public static boolean isvalid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if (passwordhere.length()<8){
            return false;
        }else{
            for(int p=0;p<passwordhere.length();p++){
                if (Character.isLetter((passwordhere.charAt(p)))){
                    f1=1;
                }
            }
            for(int r=0;r<passwordhere.length();r++){
                if (Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s=0;s<passwordhere.length();s++){
                char c = passwordhere.charAt(s);
                if (c>=33 &&c<=46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1 )
                return true;
            return false;
        }

    }
}