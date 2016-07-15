/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.util.ArrayList;
import spaceinvader.menu.MainMenu;

/**
 *
 * @author asus
 */
public class Game {
    
    private ArrayList<GameLevel> levels;
    
    public Game(MainMenu menu){
        
        levels = new ArrayList<GameLevel>();
        GameLevel gl1 = new GameLevel(menu);
        gl1.initTestGameLevel();
        GameLevel gl2 = new GameLevel(menu);
        GameLevel gl3 = new GameLevel(menu);
        gl3.initTestGameLevelBoss();
        levels.add(gl1);
        levels.add(gl2);
        levels.add(gl3);
        
    }
    
    public void playGame(){
        for(GameLevel gl : levels){
            gl.initTestGameLevel();
            gl.run();
            gl.transition(100);
        }
    }
    
}
