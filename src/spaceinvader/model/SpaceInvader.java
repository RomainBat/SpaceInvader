/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvader.controler.ShipControler;
import spaceinvader.menu.MainMenu;
import spaceinvader.model.ships.ClassicTrashMob;
import spaceinvader.model.ships.Spaceship;
import spaceinvader.model.ships.TrashMob;
import spaceinvader.view.GameView;

/**
 *
 * @author asus
 */
public class SpaceInvader {
    
    public static final boolean isDebugOn = false;
    private static int gameTime = 6;
    private static String image = "/image/img.png";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        /*GameLevel gameLevel = new GameLevel();
        
        gameLevel.initTestGameLevel();
        
        gameLevel.run();*/
        
        MainMenu menu = new MainMenu();
        menu.select();
    }

}
