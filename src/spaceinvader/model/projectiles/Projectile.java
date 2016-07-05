/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.projectiles;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.controler.ObserverShot;
import spaceinvader.model.GameElement;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.MovingElement;

/**
 *
 * @author qmatejka
 */
public abstract class Projectile extends MovingElement{
    
    int                 damage;
    private ObserverShot    observer;

    public Projectile(Moves moves, Rectangle body, Dimension ground, String imagePath, int damage) {
        super(moves, body, ground, imagePath);
        this.damage = damage;
    }    

    @Override
    public boolean react() {
        if(isOutOfTheScreen()){
            return false;
        }else{
            this.move();
            return true;
        }
    }

    public boolean isOutOfTheScreen(){
        int x = (int)this.getPosition().getX();
        int y = (int)this.getPosition().getY();
        return this.getGround().width<x && this.getGround().height<y;
    }
    
    public void addObserver(ObserverShot obs) {
        this.observer=obs;
    }

    public void removeObserver() {
        this.observer=null;
    }
    
    public void notifyObserver(GameElement other) {
        this.observer.update(this, other);
    }

    public int getDamage() {
        return damage;
    }
    
    @Override
    public String toString() {
        return "Projectile{x="+this.getPosition().x+", y="+this.getPosition().y+'}';
    }
    
}
