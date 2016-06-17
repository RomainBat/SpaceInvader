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
        Projectile P2 = new Projectile(new StraightMove(), new Rectangle(10, 10, 4, 12), new Dimension(500, 1000));
        /*
        while(gameTime>0){
            if(gameTime==2)
                P2.getMoves().invertTrajectory();
            P2.react();
            Thread.sleep(400);
            gameTime--;
        }
        */
        Dimension ground=new Dimension(1280,720);
        
        Projectile P = new Projectile(new AlternativeMove(), new Rectangle(10, 10, 4, 12), new Dimension(10, 10));
        P.setImagePath("src/spaceinvader/view/classic_projectile.png");
        
        Spaceship ship = new Spaceship(ground);
        ship.setImagePath("src/spaceinvader/view/classic_ship.png");
        ship.setPosition(new Point(250, 680));
        
        
        GameLevel gameLevel = new GameLevel(ground);
        gameLevel.addGameElementToList(ship);
        
        ShipControler sc = new ShipControler(ship, gameLevel);
        
        GameView gv = new GameView(sc, gameLevel);
        
        
        while(true){
            //System.out.println(ship.getPosition());
            sc.update();
            gameLevel.makeGameElementsReact();
            gv.update();
            sleep(1000/60);
        }
    }

}
