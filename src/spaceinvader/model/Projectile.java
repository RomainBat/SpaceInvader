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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
