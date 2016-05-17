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
    
    //For example (water, fire, blast, explosion, etc)
    private String typeOfProjectile;

    public Projectile(String typeOfProjectile, Trajectory trajectory, Rectangle body, Dimension ground) {
        super(trajectory, body, ground);
        this.typeOfProjectile = typeOfProjectile;
    }

    public String getTypeOfProjectile() {
        return typeOfProjectile;
    }

    public void setTypeOfProjectile(String typeOfProjectile) {
        this.typeOfProjectile = typeOfProjectile;
    }

    @Override
    public void react() {
        this.move();
    }

    @Override
    public String toString() {
        return "Projectile{x="+this.getPosition().x+", y="+this.getPosition().y+'}';
    }
    
}
