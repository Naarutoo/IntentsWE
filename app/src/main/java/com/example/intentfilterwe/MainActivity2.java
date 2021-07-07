package com.example.intentfilterwe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView btntext1ac2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btntext1ac2=findViewById(R.id.tvUsername);
        Intent intent=getIntent();
        String name=getIntent().getStringExtra("username");
        btntext1ac2.setText(name);
    }
}