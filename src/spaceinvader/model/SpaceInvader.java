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
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvader.controler.ShipControler;
import spaceinvader.model.movements.AlternativeMove;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.projectiles.Projectile;
import spaceinvader.model.ships.Spaceship;
import spaceinvader.model.ships.TrashMob;
import spaceinvader.view.GameView;

/**
 *
 * @author asus
 */
public class SpaceInvader {
    
    public static final boolean isDebugOn = true;
    private static int gameTime = 6;
    private static String image = "/image/img.png";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        /***************************************************/
        /***********CODE AVANT MAJ SELON DIAGRAMME**********/
        /***************************************************/
        Dimension ground=new Dimension(1280,720);
        
        Spaceship ship = new Spaceship(ground);
        ship.setPosition(new Point(250, 680));

        GameLevel gameLevel = new GameLevel(ground);
        gameLevel.addGameElementToList(ship);
        
        for(int i=0;i<12;i++){
            TrashMob trash = new TrashMob(ground, gameLevel);
            trash.setPosition(new Point((int) (100+i*(20+trash.getBody().getWidth())), 100));
            gameLevel.addGameElementToList(trash);
        }
        
        ShipControler sc = new ShipControler(ship, gameLevel);
        
        GameView gv = new GameView(sc, gameLevel);
        
        ship.addObserver(gv);
        
        while(true){
            sc.update();
            gameLevel.makeGameElementsReact();
            try {
                Thread.sleep(1000/100);
            } catch (InterruptedException ex) {
                Logger.getLogger(SpaceInvader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
