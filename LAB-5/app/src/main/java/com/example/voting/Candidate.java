package com.example.voting;

import java.util.HashMap;
import java.util.Map;


public class Candidate {
    private int vote;
    private String name;

    public static Map<String, Integer> candidateVotesMap = new HashMap<>();
    Candidate(int vote,String name){
        this.vote = vote;
        this.name = name;
        candidateVotesMap.put(name, vote);
    }

    public int getVote() {
        return vote;
    }

    public String getName() {
        return name;
    }

    public void countVote(){
        this.vote++;
        candidateVotesMap.put(name, this.vote);
    }
}
