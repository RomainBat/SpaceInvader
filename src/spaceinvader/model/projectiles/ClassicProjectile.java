/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.projectiles;

import java.awt.Rectangle;
import spaceinvader.controler.ObserverShot;
import spaceinvader.model.GameElement;
import spaceinvader.model.Observer;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.ships.Alien;

/**
 *
 * @author asus
 */
public class ClassicProjectile extends Projectile{
        
    public ClassicProjectile() {
        super(new StraightMove(), new Rectangle(16, 36), null, "spaceinvader/view/classic_projectile_.png", 1);
    }

    @Override
    public void collidedWith(GameElement other) {
        if(other instanceof Alien){
            System.out.println("touché");
            notifyObserver(other);
        }
    }
    
}
