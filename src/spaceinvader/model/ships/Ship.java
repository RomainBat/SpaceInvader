/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.MovingElement;
import spaceinvader.model.projectiles.Projectile;
import spaceinvader.model.weapons.Weapon;

/**
 *
 * @author asus
 */
public abstract class Ship extends MovingElement{

    protected int life;
    protected Weapon weapon;
    
    public Ship(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
    }

    @Override
    public boolean react() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    
    public abstract Projectile shoot();
    
    public void heal(int value){
        this.life += value;
    }
    
    public void hurt(int value){
        this.life -= value;
    }
}
