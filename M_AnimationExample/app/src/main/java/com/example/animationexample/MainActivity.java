package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button MoveLeft;
    private Button MoveRight;
    private Button alpha;
    private Button rotateLeft;
    private Button rotateRight;
    private Button zoom_in;
    private Button zoom_out;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MoveLeft = findViewById(R.id.Move_left);
        MoveRight = findViewById(R.id.Move_Right);
        alpha = findViewById(R.id.Alpha);
        zoom_in = findViewById(R.id.Zoom_In);
        rotateLeft = findViewById(R.id.Rotate_Left);
        rotateRight = findViewById(R.id.Rotate_Rightt);
        zoom_out = findViewById(R.id.Zoom_Out);
        img = findViewById(R.id.high_five);

        MoveLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation moveLeft = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);
                img.startAnimation(moveLeft);
            }
        });

        MoveRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation moveRight = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_right);
                img.startAnimation(moveRight);
            }
        });

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                img.startAnimation(alpha);
            }
        });

        rotateLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation rotate_left = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_left);
                img.startAnimation(rotate_left);
            }
        });

        rotateRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation rotate_right = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_right);
                img.startAnimation(rotate_right);
            }
        });

        zoom_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation zoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                img.startAnimation(zoomIn);
            }
        });

        zoom_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation zoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
                img.startAnimation(zoomOut);
            }
        });
    }
}