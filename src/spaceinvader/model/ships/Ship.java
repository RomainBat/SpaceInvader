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
import spaceinvader.view.Sprite;
import spaceinvader.view.SpriteStore;

/**
 *
 * @author asus
 */
public abstract class Ship extends MovingElement{

    protected int life;
    protected Weapon weapon;
    private int counterHit = -1;
    private Sprite secondSprite;

    
    public Ship(Moves moves, Rectangle body, Dimension ground, String imagePath, int life, String secondSpriteRef) {
        super(moves, body, ground, imagePath);
        this.life=life;
        if(secondSpriteRef!=null)
            this.secondSprite = SpriteStore.getStore().getSprite(secondSpriteRef);
        else
            this.secondSprite = null;
    }

    @Override
    public boolean react() {
        if(counterHit>0){
            this.counterHit--;
        }else if(counterHit==0){
            swapSprites();
            counterHit=-1;
        }
        return true;
    } 
    
    public abstract Projectile shoot();
    
    public boolean isDead(){
        return (life <= 0);
    }
    
    public void heal(int value){
        this.life += value;
    }
    
    public void hurt(int value){
        this.life -= value;
        this.counterHit = 15;
        swapSprites();
        //this.setSprite(this.getSprite().getNegative());
    }
    
    public void swapSprites(){
        if(this.getSecondSprite()!=null){
            Sprite pivot = this.getSprite();
            this.setSprite(this.getSecondSprite());
            this.setSecondSprite(pivot);
        }
    }
    
    public int getLife() {
        return life;
    }
    
    public Sprite getSecondSprite() {
        return secondSprite;
    }

    public void setSecondSprite(Sprite secondSprite) {
        this.secondSprite = secondSprite;
    }
    
}
