package com.example.m_implicitintentdemo;

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
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:+91111122222"));
                startActivity(dialIntent);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:" + Uri.encode("9911001199")));
                smsIntent.putExtra("sms_body", editTxt.getText().toString());
                startActivity(smsIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{editEmail.getText().toString()});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, editSubject.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, editTxt.getText().toString());
                startActivity(emailIntent);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Download this AI, https://chat.openai.com/");
                startActivity(shareIntent);
            }
        });
    }
}
