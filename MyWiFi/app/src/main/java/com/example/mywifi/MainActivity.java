package com.example.mywifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WifiManager wifiManager;  // Declare wifiManager as a global variable
    private Button on, off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        on = findViewById(R.id.on);
        off = findViewById(R.id.off);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE); 

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wifiManager != null) {
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this, "Turned On", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "WifiManager is null", Toast.LENGTH_SHORT).show();
                }
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wifiManager != null) {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this, "Turned Off", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "WifiManager is null", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
