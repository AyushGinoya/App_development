package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.user_list);

        String json=getData();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            ArrayList<HashMap<String,String>>hashMapArrayList=new ArrayList<>();

            for (int i=0;i<jsonArray.length();i++){
                HashMap<String,String>map=new HashMap<>();
                JSONObject object = jsonArray.getJSONObject(i);
                map.put("id", String.valueOf(object.getInt("id")));
                map.put("employee_name",object.getString("employee_name"));
                map.put("employee_salary", String.valueOf(object.getInt("employee_salary")));
                hashMapArrayList.add(map);
            }

           // ListAdapter adapter = new SimpleAdapter(MainActivity.this,R.layout.list_row,new String[] {"id","\employee_name","employee_name"}, new [] {R.id.id, R.id.employee_name,R.id.employee_salary});
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this,
                    hashMapArrayList,
                    R.layout.list_row,
                    new String[]{"id", "employee_name", "employee_salary"},
                    new int[]{R.id.id, R.id.employee_name, R.id.employee_salary}
            );
            listView.setAdapter(adapter);
            listView.setAdapter(adapter);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private  String getData(){
        String originalJson = "{\"status\":\"success\",\"data\":[{\"id\":1,\"employee_name\":\"Tiger Nixon\",\"employee_salary\":320800,\"employee_age\":61,\"profile_image\":\"\"},{\"id\":2,\"employee_name\":\"Garrett Winters\",\"employee_salary\":170750,\"employee_age\":63,\"profile_image\":\"\"},{\"id\":3,\"employee_name\":\"Ashton Cox\",\"employee_salary\":86000,\"employee_age\":66,\"profile_image\":\"\"},{\"id\":4,\"employee_name\":\"Cedric Kelly\",\"employee_salary\":433060,\"employee_age\":22,\"profile_image\":\"\"}]}";
        return originalJson;
    }
}