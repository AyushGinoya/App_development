package com.example.lab_6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoAcitivity extends AppCompatActivity {

    private VideoView v;
    private Intent i;
    private Button start;
    private final static int REQ_CODE_VIDEO_CAPTURE = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_acitivity);

        v = findViewById(R.id.videoView);
        start = findViewById(R.id.button);

        MediaController mc = new MediaController(this);
        mc.setAnchorView(v);
        v.setMediaController(mc);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,REQ_CODE_VIDEO_CAPTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {  
            if (requestCode == REQ_CODE_VIDEO_CAPTURE) {
                v.setVideoURI(data.getData());
                v.start();
            }
        }
    }

}