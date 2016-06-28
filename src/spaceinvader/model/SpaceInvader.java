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
import spaceinvader.model.ships.ClassicTrashMob;
import spaceinvader.model.ships.Spaceship;
import spaceinvader.model.ships.TrashMob;
import spaceinvader.view.GameView;

/**
 *
 * @author asus
 */
public class SpaceInvader {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        /***************************************************/
        /***********CODE AVANT MAJ SELON DIAGRAMME**********/
        /***************************************************/
        /*Dimension ground=new Dimension(1280,720);
        
        Spaceship ship = new Spaceship(ground);
        ship.setPosition(new Point(250, 650));

        GameLevel gameLevel = new GameLevel(ground);
        gameLevel.addGameElementToList(ship);
        
        for(int i=0;i<3;i++){
            for(int j=0;j<12;j++){
                TrashMob trash = new ClassicTrashMob(ground, gameLevel);
                trash.setPosition(new Point((int) (110+j*(20+trash.getBody().getWidth())), (int)(100+i*(20+trash.getBody().getHeight()))));
                gameLevel.addGameElementToList(trash);
            }
        }
        
        ShipControler sc = new ShipControler(ship, gameLevel);
        
        GameView gv = new GameView(sc, gameLevel);
        
        ship.addObserver(gv);
        
        while(true){
            sc.update();
            gv.update();
            //gameLevel.makeGameElementsReact();
            try {
                Thread.sleep(1000/100);
            } catch (InterruptedException ex) {
                Logger.getLogger(SpaceInvader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
        GameLevel lvlTest = new GameLevel();
        
        lvlTest.setLevelTest();
        
        lvlTest.doIt();
    }

}
