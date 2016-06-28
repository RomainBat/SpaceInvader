/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.projectiles;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.GameElement;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.MovingElement;

/**
 *
 * @author qmatejka
 */
public abstract class Projectile extends MovingElement{
    
    int damage;
    private int duration;

    public Projectile(Moves moves, Rectangle body, Dimension ground, String imagePath, int damage) {
        super(moves, body, ground, imagePath);
        duration = 100;
        this.damage = damage;
    }    

    @Override
    public boolean react() {
        if(duration<=0)
            return false;
        else{
            duration--;
            this.move();
            return true;
        }
    }

    @Override
    public String toString() {
        return "Projectile{x="+this.getPosition().x+", y="+this.getPosition().y+'}';
    }

    @Override
    public void collidedWith(GameElement ge) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
