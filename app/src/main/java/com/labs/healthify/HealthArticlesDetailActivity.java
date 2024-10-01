package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticlesDetailActivity extends AppCompatActivity {

    TextView tv1;
    ImageView img;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_detail);

        btnback=findViewById(R.id.btnbackHA);
        tv1=findViewById(R.id.tvdef);
        img=findViewById(R.id.imageviewha);

        Intent intent = getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){
            int resID = bundle.getInt("text2");
            img.setImageResource(resID);
        }

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticlesDetailActivity.this,HealthArticlesActivity.class));
            }
        });
    }
}