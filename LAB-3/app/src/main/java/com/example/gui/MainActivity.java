package com.example.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private String user_name,password;
    private EditText u_name,u_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btnLog);
        u_name= findViewById(R.id.user_name);
        u_pass= findViewById(R.id.paas);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name=u_name.getText().toString();
                password=u_pass.getText().toString();
                if(user_name.equals("Admin") && password.equals("Admin")){
                   // Toast.makeText(getBaseContext(), "Succesfully Login", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Succesfully Login", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(getBaseContext(), "Try again", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        


    }


}