/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import spaceinvader.controler.ObserverShot;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.movements.Moves;
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
            this.shoot();
        }
        return true;
    }

    @Override
    public ArrayList<Projectile> shoot() {
        ArrayList<Projectile> projs = this.weapon.shoot();
        for(Projectile proj : projs){
            if(proj!=null){
                proj.setGround(this.getGround());
                Point pos = this.getPosition();
                pos.setLocation(pos.getX()+(this.getBody().width-proj.getBody().width)/2, pos.getY()/*+proj.getBody().height*/);
                proj.setPosition(pos);
                proj.addObserver(new ObserverShot(getLevel()));
                getLevel().addGameElementToList(proj);
            }
        }
        return projs;
    }


    @Override
    public String toString() {
        return "TrashMob{ x=" + this.getPosition().x + " | y=" + this.getPosition().y + '}';
    }
    
    
}
