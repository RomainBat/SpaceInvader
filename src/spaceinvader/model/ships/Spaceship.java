/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import spaceinvader.controler.ShipObserver;
import spaceinvader.model.GameElement;
import spaceinvader.model.Observer;
import spaceinvader.model.items.Item;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.projectiles.Projectile;
import spaceinvader.model.weapons.ClassicWeapon;
import spaceinvader.model.weapons.Weapon;

/**
 *
 * @author qmatejka
 */
public class Spaceship extends Ship{

    protected Observer obs;
    private int liveMax;
    
    public Spaceship(Moves moves, Rectangle body, Dimension ground, String imagePath, String secondSpriteRef) {
        super(moves, body, ground, imagePath, 3, secondSpriteRef);
    }

    public Spaceship(Dimension ground) {
        super(new StraightMove(), new Rectangle(70, 70), ground, "spaceinvader/view/classic_ship.png", 3, null);
        weapon = new ClassicWeapon(true, 10);
        this.liveMax=5;
    }

    @Override
    public boolean react() {
        //if(this.isCollidingWith(instanceof Projectile)){
        //move();
        this.weapon.reload();
        return true;
    }
    
    public Projectile shoot(){
        Projectile proj = weapon.shoot();
        if(proj!=null){
            proj.setGround(this.getGround());
            Point pos = this.getPosition();
            pos.setLocation(pos.getX()+(this.getBody().width-proj.getBody().width)/2, pos.getY());
            proj.setPosition(pos);
        }
        return proj;
    }

    @Override
    public void collidedWith(GameElement ge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void notifyObs(){
        obs.update();
    }
    
    public void addObserver(Observer obs){
        this.obs=obs;
    }
    
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getLiveMax() {
        return liveMax;
    }
    
    public void setLiveMax(int value){
        this.liveMax = value;
    }
    
    public void changeLiveMax(int value){
        this.liveMax += value;
    }
    
    public void useItem(Item item){
        
    }

    @Override
    public String toString() {
        return "Spaceship{x="+this.getPosition().x+", y="+this.getPosition().y+'}';
    }
    
}
