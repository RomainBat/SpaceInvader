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
import spaceinvader.model.GameElement;
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

    private int liveMax;
    
    public Spaceship(Moves moves, Rectangle body, Dimension ground, String imagePath, String secondSpriteRef) {
        super(moves, body, ground, imagePath, 3, secondSpriteRef);
    }

    public Spaceship(Dimension ground) {
        super(new StraightMove(), new Rectangle(54, 54), ground, "spaceinvader/view/classic_ship.png", 3, "spaceinvader/view/classic_ship_broken.png");
        weapon = new ClassicWeapon(true, 10);
        //weapon = new DoubleShotWeapon(true);
        this.liveMax=5;
    }

    @Override
    public boolean react() {
        //if(this.isCollidingWith(instanceof Projectile)){
        //move();
        super.react();
        this.weapon.reload();
        return true;
    }
    
    /**
     * This method is called when the player press SPACE. It uses the weapon of the spaceship to generate a Projectile.
     * We use the position of the spaceship to place the projectile on the map.
     * @return the list of Projectiles shoot by the weapon.
     */
    public ArrayList<Projectile> shoot(){
        ArrayList<Projectile> projs = weapon.shoot();
        for(int i=0;i<projs.size();i++){
            Projectile proj = projs.get(i);
            if(proj!=null){
                proj.setGround(this.getGround());
                Point pos = this.getPosition();
                if(projs.size()>1){
                    pos.setLocation(pos.getX()+(this.getBody().width-proj.getBody().width)*i/2*projs.size(), pos.getY());
                    //pos.setLocation(pos.getX()+(this.getBody().width*(1+2*i)/2*projs.size())-proj.getBody().width/2, pos.getY());
                    //pos.setLocation(pos.getX()+(this.getBody().width/projs.size()+1)*i-proj.getBody().width/2,pos.getY());
                }else
                    pos.setLocation(pos.getX()+(this.getBody().width-proj.getBody().width)/2, pos.getY());
                proj.setPosition(pos);
            }
        }
        return projs;
    }

    @Override
    public void collidedWith(GameElement ge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
