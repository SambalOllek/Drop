/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badlogic.drop;

import java.io.Serializable;

/**
 *
 * @author TE4
 */
public class Score implements Serializable {
    private int points;

public Score(int points) {
    this.points = points;
}
public int getPoints() {
    return points;
}
}

