/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.projectiles;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.MovingElement;

/**
 *
 * @author qmatejka
 */
public class Projectile extends MovingElement{
    
    int damage;
    private int duration;

    public Projectile(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
        setDy(-3);
        duration = 100;
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
