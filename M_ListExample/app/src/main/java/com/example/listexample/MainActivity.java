package com.example.listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Spinner spinner;
    private AutoCompleteTextView autoCompleteTextView;
    ArrayList<String> arrName = new ArrayList<>();
    ArrayList<String> arrId = new ArrayList<>();
    ArrayList<String> arrLanguage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.actv);

        arrName.add("Ayushi");
        arrName.add("Ayush");
        arrName.add("Chetan");
        arrName.add("Deepika");
        arrName.add("Esha");
        arrName.add("Farhan");
        arrName.add("Gita");
        arrName.add("Harish");
        arrName.add("Ishita");
        arrName.add("Jai");
        arrName.add("Kavya");
        arrName.add("Lalita");
        arrName.add("Manish");
        arrName.add("Neha");
        arrName.add("Om");
        arrName.add("Pooja");
        arrName.add("Qamar");
        arrName.add("Rajesh");
        arrName.add("Smita");
        arrName.add("Tarun");
        arrName.add("Usha");
        arrName.add("Varun");
        arrName.add("Wasi");
        arrName.add("Xena");
        arrName.add("Yogesh");
        arrName.add("Zara");
        arrName.add("Amit");
        arrName.add("Bina");
        arrName.add("Chirag");
        arrName.add("Devi");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrName);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(MainActivity.this, "Ayushi is clicked", Toast.LENGTH_SHORT).show();
                }
                if(position == 1){
                    Toast.makeText(MainActivity.this, "Ayush is clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });



        //spinner
        arrId.add("Adhar id");
        arrId.add("Student id");
        arrId.add("School id");
        arrId.add("Bus id");

        ArrayAdapter<String> adapterId = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrId);
        spinner.setAdapter(adapterId);


        //autoCompleteTextView
        arrLanguage.add("C++");
        arrLanguage.add("C");
        arrLanguage.add("Java");
        arrLanguage.add("Dart");
        arrLanguage.add("Flutter");
        arrLanguage.add("JS");

        ArrayAdapter<String> languageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLanguage);
        autoCompleteTextView.setAdapter(languageAdapter);
        autoCompleteTextView.setThreshold(1);


    }
}


