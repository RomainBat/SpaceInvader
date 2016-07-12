/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import spaceinvader.controler.ObserverShot;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.projectiles.ClassicProjectile;
import spaceinvader.model.projectiles.Projectile;

/**
 *
 * @author qmatejka
 */
public abstract class TrashMob extends Alien{
    
    public TrashMob(Dimension ground, GameLevel level, String imagePath, int life, Moves movement, String secondSpriteRef) {
        super(movement, new Rectangle(70, 56), ground, imagePath, level, life, secondSpriteRef);
    }

    @Override
    public boolean react() {
        super.react();
        this.move();
        boolean shoot = (int)(Math.random()*1000)==1;
        if(shoot){
            Projectile proj = this.shoot();
            if(proj != null){
                proj.addObserver(new ObserverShot(getLevel()));
                getLevel().addGameElementToList(proj);
            }
        }
        return true;
    }

    @Override
    public Projectile shoot() {
        Projectile proj = this.weapon.shoot();
        if(proj!=null){
            proj.setGround(this.getGround());
            Point pos = this.getPosition();
            pos.setLocation(pos.getX()+(this.getBody().width-proj.getBody().width)/2, pos.getY()/*+proj.getBody().height*/);
            proj.setPosition(pos);
        }
        return proj;
    }

    @Override
    public void collidedWith(GameElement ge) {
        if(ge instanceof ClassicProjectile){
            
        }
    }
    
    
}
