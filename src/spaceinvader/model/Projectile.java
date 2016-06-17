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
 * @author qmatejka
 */
public class Projectile extends MovingElement{
    
    private int duration;
    
    public Projectile(Moves trajectory, Rectangle body, Dimension ground) {
        super(trajectory, body, ground);
        duration = 50;
        setImagePath("src/spaceinvader/view/classic_projectile_.png");
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
    
}
