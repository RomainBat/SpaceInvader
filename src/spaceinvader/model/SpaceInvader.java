/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import spaceinvader.controler.ShipControler;
import spaceinvader.model.movements.AlternativeMove;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.projectiles.Projectile;
import spaceinvader.model.ships.Spaceship;
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
    public static void main(String[] args) throws InterruptedException { 
        
        /***************************************************/
        /***********CODE AVANT MAJ SELON DIAGRAMME**********/
        /***************************************************/
        Dimension ground=new Dimension(1280,720);
        
        Spaceship ship = new Spaceship(ground);
        ship.setPosition(new Point(250, 680));
        
        
        GameLevel gameLevel = new GameLevel(ground);
        gameLevel.addGameElementToList(ship);
        
        ShipControler sc = new ShipControler(ship, gameLevel);
        
        GameView gv = new GameView(sc, gameLevel);
        
        
        while(true){
            sc.update();
            gameLevel.makeGameElementsReact();
            gv.update();
            sleep(1000/60);
        }
    }

}
