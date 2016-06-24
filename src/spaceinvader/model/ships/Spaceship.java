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
    protected int liveMax;
    
    public Spaceship(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
    }

    public Spaceship(Dimension ground) {
        super(new StraightMove(), new Rectangle(50, 50), ground, "src/spaceinvader/view/classic_ship.png");
        weapon = new ClassicWeapon(false);
    }

    @Override
    public boolean react() {
        //if(this.isCollidingWith(instanceof Projectile)){
        weapon.reload();
        return true;
    }
    
    public Projectile shoot(){
        Projectile proj = weapon.shoot();
        if(proj!=null){
            proj.setDy(-3);
            proj.setGround(this.getGround());
            Point pos = this.getPosition();
            pos.setLocation(pos.getX()+(this.getBody().width-proj.getBody().width)/2, pos.getY()+proj.getBody().height);
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
