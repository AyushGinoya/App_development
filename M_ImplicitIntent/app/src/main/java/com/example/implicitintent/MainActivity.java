package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTxt;
    private EditText editSubject;
    private EditText editEmail;
    private Button btnDial;
    private Button btnMsg;
    private Button btnEmail;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxt = findViewById(R.id.edit_txt);
        editSubject = findViewById(R.id.edit_subject);
        editEmail = findViewById(R.id.edit_email);
        btnDial = findViewById(R.id.btn_dial);
        btnMsg = findViewById(R.id.btn_msg);
        btnEmail = findViewById(R.id.btn_email);
        btnShare = findViewById(R.id.btn_Share);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent id = new Intent(Intent.ACTION_DIAL);
                // id.setAction(ACTION_DIAL):
                id.setData(Uri.parse("Tel : +91 1111122222"));
                startActivity(id);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(Intent.ACTION_SENDTO);
                im.setData(Uri.parse("smsto : " + Uri.encode("9911001199")));
                im.putExtra("sms_body",editTxt.getText());
                startActivity(im);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie = new Intent(Intent.ACTION_SEND);
                ie.setType("massage/rfc822");
                ie.putExtra(Intent.EXTRA_EMAIL,editEmail.getText());
                ie.putExtra(Intent.EXTRA_SUBJECT,editSubject.getText());
                ie.putExtra(Intent.EXTRA_TEXT,editTxt.getText());
                startActivity(ie);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(Intent.ACTION_SEND);
                is.setType("text/plain");
                is.putExtra(Intent.EXTRA_TEXT,"Download this AI , https://chat.openai.com/");
                startActivity(is);
            }
        });
    }
}
