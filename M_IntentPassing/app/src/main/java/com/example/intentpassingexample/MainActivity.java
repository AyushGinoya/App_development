package com.example.intentpassingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.nextPage);
        Intent iNext = new Intent(MainActivity.this, SecondMainActivity.class);

        iNext.putExtra("tital","Home");
        iNext.putExtra("Name","Ayush");
        iNext.putExtra("ID",6);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iNext);
            }
        });


    }
}