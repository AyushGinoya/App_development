package com.example.asyncktaskdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button runButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        runButton = findViewById(R.id.runButton);
        textView = findViewById(R.id.textView);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Execute the AsyncTask
                MyAsyncTask task = new MyAsyncTask();
                //noinspection deprecation
                task.execute(editText.getText().toString());
            }
        });
    }
    class MyAsyncTask extends AsyncTask<String, String, String> {
        ProgressDialog dialog;
        String response;

        @Override
        protected void onPreExecute() {
            //noinspection deprecation
            super.onPreExecute();
            //noinspection deprecation
            dialog = ProgressDialog.show(MainActivity.this, "Waiting", "Wait for, " + editText.getText().toString() + " Seconds");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //noinspection deprecation
            super.onProgressUpdate(values);
            textView.setText(values[0]);
        }

        @Override
        protected String doInBackground(String... strings) {
            //noinspection deprecation
            publishProgress("Sleeping.............");

            int timeInSec = Integer.parseInt(editText.getText().toString());

            for (int i = 0; i < timeInSec; i++) {
                try {
                    Thread.sleep(1000);
                    response = "Slept for " + (i + 1) + " of " + timeInSec + " seconds ";
                    //noinspection deprecation
                    publishProgress(response);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            //noinspection deprecation
            super.onPostExecute(s);
            dialog.dismiss();
            textView.setText(s);
        }
    }
}
