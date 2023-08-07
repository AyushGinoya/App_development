package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button vote1,vote2;
    private TextView c1,c2;

    int ct1=0,ct2=0,ct=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vote1 = findViewById(R.id.button1);
        vote2 = findViewById(R.id.button2);

        c1=findViewById(R.id.vote1);
        c2=findViewById(R.id.vote2);

        Candidate Priyansh = new Candidate(ct1,"Priyansh");
        Candidate Priyanshi = new Candidate(ct2,"Priyanshi");
        vote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Priyansh.countVote();
                c1.setText(Priyansh.getVote()+"");
                Toast.makeText(MainActivity.this, "Priyansh received your vote", Toast.LENGTH_SHORT).show();
            }
        });

        vote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Priyanshi.countVote();
                c2.setText(Priyanshi.getVote()+"");
                Toast.makeText(MainActivity.this, "Priyanshi received your vote", Toast.LENGTH_SHORT).show();
            }
        });

        for (Map.Entry<String, Integer> entry : Candidate.candidateVotesMap.entrySet()) {
            String candidateName = entry.getKey();
            int voteCount = entry.getValue();
            Log.d("CandidateVotes", "Candidate: " + candidateName + ", Votes: " + voteCount);
        }
    }
}