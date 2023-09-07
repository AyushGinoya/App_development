package com.example.music_player_demo;

import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button pauseButton;
    private Button stopButton;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start);
        pauseButton = findViewById(R.id.pause);
        stopButton = findViewById(R.id.stop);
        mp = new MediaPlayer();

        // Set audio stream type to STREAM_MUSIC
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        // Set the data source for MediaPlayer
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tere_sang_yara);
        try {
            mp.setDataSource(getApplicationContext(), uri);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start playing the audio
                mp.start();
                Toast.makeText(MainActivity.this, "Start Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pause audio playback
                mp.pause();
                Toast.makeText(MainActivity.this, "Pause Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pause audio playback and reset to the beginning
                mp.pause();
                mp.seekTo(0);
                Toast.makeText(MainActivity.this, "Stop Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
