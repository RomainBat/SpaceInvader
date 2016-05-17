/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.awt.Rectangle;

/**
 *
 * @author asus
 */
public class SpaceInvader {
    
    public static final boolean isDebugOn = true;
    private static int gameTime = 5;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Projectile P = new Projectile("fire", new Trajectory(10, 0, 0), new Rectangle(10, 10, 4, 12), new Dimension(500, 1000));
        
        while(gameTime>0){
            P.react();
            Thread.sleep(1000);
            gameTime--;
        }
    }
    
}
