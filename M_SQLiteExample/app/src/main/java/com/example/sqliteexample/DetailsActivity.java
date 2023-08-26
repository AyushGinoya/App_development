package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    private ListView contactListView;
    private DbHandler dbHandler;
    private ArrayList<ContactDetails> contactList;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        dbHandler = new DbHandler(this);
        contactListView = findViewById(R.id.contact_list);
        contactList = dbHandler.getDetails();

        List<Map<String, String>> contactDataList = new ArrayList<>();
        for (ContactDetails contact : contactList) {
            Map<String, String> contactMap = new HashMap<>();
            contactMap.put("name", contact.name);
            contactMap.put("number", contact.number);
            contactDataList.add(contactMap);
        }

        String[] from = {"name", "number"};
        int[] to = {R.id.name1, R.id.number1};

        ListAdapter simpleAdapter = new SimpleAdapter(
                DetailsActivity.this,
                contactDataList,
                R.layout.list_row,
                from,
                to
        );
        contactListView.setAdapter(simpleAdapter);

        Button back = (Button)findViewById(R.id.btnBackToHome);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(DetailsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
