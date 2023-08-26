package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtName, txtNumber;
    private Button btnSave;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtNumber = findViewById(R.id.txtNumber);
        btnSave = findViewById(R.id.btnSave);

        dbHandler = new DbHandler(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String number = txtNumber.getText().toString();

                if (!name.isEmpty() && !number.isEmpty()) {
                    dbHandler.addUserNumber(name, number);
                    Toast.makeText(MainActivity.this, "User details saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter name and number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
