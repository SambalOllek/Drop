/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import static com.badlogic.gdx.Input.Keys.R;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;
import com.badlogic.gdx.graphics.OrthographicCamera;
import java.util.Random;

/**
 *
 * @author TE4
 */
public class HighScoreScreen implements Screen {
    
    final Drop game;
    OrthographicCamera camera;
    HighScoreList highscoreList;
    
    
    public HighScoreScreen(final Drop game) {
        this.highscore();
        this.game = game;
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);
    }
    
    public void highscore() {
    
        highscoreList = new HighScoreList(10);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
        int points = random.nextInt(10) + 1;
        
        }
    }
        
    
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        
        game.batch.begin();
        game.font.draw(game.batch,"Highscore", 350, 350);
        game.font.draw(game.batch,"Click to restart", 350, 150);
        
        game.font.draw(game.batch,highscoreList.toString(), 340, 350);
        game.batch.end();
    
        if (Gdx.input.isButtonPressed(R)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
        
    }

    @Override
    public void show() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resize(int arg0, int arg1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
