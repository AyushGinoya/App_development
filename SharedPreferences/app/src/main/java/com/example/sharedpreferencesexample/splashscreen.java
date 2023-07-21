package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {

    TextView txt;
    SharedPreferences spref;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        spref = getSharedPreferences("user_detail",MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    boolean check = spref.getBoolean("flag",false);

                    if(check){
                        intent = new Intent(splashscreen.this, HomeActivity.class);
                    } else {
                        intent = new Intent(splashscreen.this, MainActivity.class);
                    }
                    startActivity(intent);
            }
        },4000);
    }
}