/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import spaceinvader.controler.ObserverItem;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.items.HealthUp;
import spaceinvader.model.items.Item;
import spaceinvader.model.items.LaserCannon;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.projectiles.ClassicProjectile;

/**
 *
 * @author qmatejka
 */
public class BonusAlien extends TrashMob{

    private Item bonusItem;
    
    public BonusAlien(Dimension ground, GameLevel level, String imagePath, int life, Moves movement, String secondSpriteRef) {
        super(ground, level, imagePath, life, movement, secondSpriteRef); 
    }

    public BonusAlien(Dimension ground, GameLevel level){
        super(ground, level, "spaceinvader/view/bonus_alien.png", 1, new StraightMove(), "spaceinvader/view/bonus_alien.png");
        this.setPosition(new Point(0, 10));
        this.setDx(2);
        if((int)(Math.random()*2)==1)
            bonusItem=new HealthUp(ground);
        else
            bonusItem=new LaserCannon(ground);
        bonusItem.addObserver(new ObserverItem(getLevel()));
    }

    @Override
    public boolean react() {
        this.move();
        return true;
    }

    @Override
    public void hurt(int value) {
        super.hurt(value); 
        if(this.isDead()){
            bonusItem.setPosition(new Point((int) (this.getPosition().getX()+(this.getBody().width-bonusItem.getBody().width)/2), (int)this.getPosition().getY()));
            getLevel().addGameElementToList(bonusItem);
        }
    }
   
    @Override
    public void collidedWith(GameElement other) {
        if(other instanceof ClassicProjectile){
            bonusItem.setPosition(new Point((int) (this.getPosition().getX()+(this.getBody().width-bonusItem.getBody().width)/2), (int)this.getPosition().getY()));
            getLevel().addGameElementToList(bonusItem);
        }
    }
    
    
}
