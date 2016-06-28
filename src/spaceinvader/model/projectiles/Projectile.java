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
import spaceinvader.model.Observable;
import spaceinvader.model.Observer;

/**
 *
 * @author qmatejka
 */
public abstract class Projectile extends MovingElement{
    
    int                 damage;
    private int         duration;
    private ObserverShot    observer;

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

    public void addObserver(ObserverShot obs) {
        this.observer=obs;
    }

    public void removeObserver() {
        this.observer=null;
    }
    
    public void notifyObserver(GameElement other) {
        this.observer.update(this, other);
    }
    
    @Override
    public String toString() {
        return "Projectile{x="+this.getPosition().x+", y="+this.getPosition().y+'}';
    }
    
}
