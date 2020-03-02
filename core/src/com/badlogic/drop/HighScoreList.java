/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badlogic.drop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author TE4
 */
public class HighScoreList implements Serializable {
    private List<Score> scores;
    private int numberOfEntries;


    public HighScoreList(int numberOfEntries) {
        scores = new ArrayList<>();
        this.numberOfEntries = numberOfEntries;
    }
//Sorterar scores
    private void sort() {
        scores.sort(new Comparator<Score>() {
            @Override
            public int compare(Score score1, Score score2) {
                Integer int1 = score1.getPoints();
                Integer int2 = score2.getPoints();
                return int1.compareTo(int2);
            }
        });
    }
//jämför storleken på scores med numberOfEntries
    public boolean addScore(Score score) {
        if (scores.size() < numberOfEntries) {
            scores.add(score);
            sort();
            return true;
        }
//tar bort minsta poängen och lägger till en ny
        Score lowestScore = scores.get(0);
        if (score.getPoints() > lowestScore.getPoints()) {
            scores.remove(lowestScore);
            scores.add(score);
            sort();
    
            }
            return true;
        }

    @Override
    public String toString() {
        StringBuilder returnValue = new StringBuilder();
        returnValue.append("\n\n");
        for (Score score : scores) {
            returnValue.append(" - ");
            returnValue.append(score.getPoints());
            returnValue.append("\n");
        }
        return returnValue.toString();
    }
}