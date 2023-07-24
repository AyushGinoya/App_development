package com.example.sharedprefexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home_Activity extends AppCompatActivity {

    private TextView text;
    private Button logout;
    Intent intent;
    SharedPreferences spref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        text = findViewById(R.id.text);
        logout = findViewById(R.id.lout_btn);

        spref = getSharedPreferences("user_detail",MODE_PRIVATE);
        text.setText("Hello " + spref.getString("username",null));
        intent = new Intent(Home_Activity.this,MainActivity.class);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = spref.edit();
                editor.clear();
                editor.commit();
                startActivity(intent);
            }
        });
    }
}