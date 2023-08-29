package com.example.canvasdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyCanvas myCanvas = findViewById(R.id.myView);


        Button leftButton = findViewById(R.id.button);
        Button rightButton = findViewById(R.id.button3);
        Button upButton = findViewById(R.id.button4);
        Button downButton = findViewById(R.id.button5);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCanvas.check=true;
                myCanvas.left=true;
                myCanvas.right=false;
                myCanvas.up=false;
                myCanvas.down=false;
                myCanvas.invalidate();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCanvas.check=true;
                myCanvas.left=false;
                myCanvas.right=true;
                myCanvas.up=false;
                myCanvas.down=false;
                myCanvas.invalidate();
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCanvas.check=true;
                myCanvas.left=false;
                myCanvas.right=false;
                myCanvas.up=true;
                myCanvas.down=false;
                myCanvas.invalidate();
            }
        });

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCanvas.check=true;
                myCanvas.left=false;
                myCanvas.right=false;
                myCanvas.up=false;
                myCanvas.down=true;
                myCanvas.invalidate();
            }
        });

    }
}