/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author qmatejka
 */
public class ClassicWeapon extends MovingElement implements Weapon{

    private Projectile projectile;

    public ClassicWeapon(Moves moves, Rectangle body, Dimension ground) {
        super(moves, body, ground);
        //projectile = new Projectile(new Trajectory(0, 0, 10), new Rectangle(4, 12), ground);
        projectile = new Projectile(new StraightMove(), new Rectangle(20, 20), this.getGround());
       
    }
    
    @Override
    public Projectile shoot() {
        return new Projectile(new StraightMove(), new Rectangle(20, 20), this.getGround());
    }

    @Override
    public boolean react() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
