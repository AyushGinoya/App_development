package com.example.intentpassingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        Intent fromMain = getIntent();

        String s_name = fromMain.getStringExtra("Name");
        int ro_num = fromMain.getIntExtra("ID",0);

        TextView textView = findViewById(R.id.sData);

        textView.setText("name : "+s_name+" id: " + ro_num);

        //getSupportActionBar().setTitle("tital");
    }
}