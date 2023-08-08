package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText u_name,u_pass;
    Intent intent;
    SharedPreferences spref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=findViewById(R.id.l_btn);
        u_name=findViewById(R.id.u_name);
        u_pass=findViewById(R.id.u_paas);

        intent = new Intent(MainActivity.this, HomeActivity.class);
        spref = getSharedPreferences("user_detail",MODE_PRIVATE);

//        Finoya

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = u_name.getText().toString();
                String pass = u_pass.getText().toString();

                if(name.equals("Ayush") && pass.equals("Ginoya")){
                    SharedPreferences.Editor editor = spref.edit();
                    editor.putString("username",name);
                    editor.putString("password",pass);
                    editor.putBoolean("flag",true);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Succesfully login", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}