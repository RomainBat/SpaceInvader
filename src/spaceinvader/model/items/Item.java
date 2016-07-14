/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.items;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.controler.ObserverItem;
import spaceinvader.controler.ObserverShot;
import spaceinvader.model.GameElement;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.MovingElement;
import spaceinvader.model.ships.Spaceship;
import spaceinvader.model.weapons.Weapon;

/**
 *
 * @author asus
 */
public abstract class Item extends MovingElement{

    private Weapon weapon;
    private Spaceship spaceship;
    private ObserverItem observer;

    public Item(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
    } 
    
    public Item(Moves moves, Rectangle body, Dimension ground, String imagePath, Weapon weapon) {
        super(moves, body, ground, imagePath);
        this.weapon = weapon;
    } 
    
    public abstract void useItem(Spaceship spaceship);
    
    public void setSpaceship(Spaceship spaceship){
        this.spaceship = spaceship;
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

    @Override
    public void collidedWith(GameElement other) {
        if(other instanceof Spaceship){
            this.setSpaceship((Spaceship)other);
            this.useItem(spaceship);
            notifyObserver(other);
        }
    }
    
    public void addObserver(ObserverItem obs) {
        this.observer=obs;
    }

    public void removeObserver() {
        this.observer=null;
    }
    
    public void notifyObserver(GameElement other) {
        this.observer.update(this, other);
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
}
