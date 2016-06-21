/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
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

    public Spaceship(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
    }

    public Spaceship(Dimension ground) {
        super(new StraightMove(), new Rectangle(50, 50), ground, "src/spaceinvader/view/classic_ship.png");
        weapon = new ClassicWeapon();
    }

    @Override
    public boolean react() {
        this.move();
        return true;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public Projectile shoot(){
        Projectile proj = weapon.shoot();
        proj.setGround(this.getGround());
        Point pos = this.getPosition();
        pos.setLocation(pos.getX()+(this.getBody().width-proj.getBody().width)/2, pos.getY()+proj.getBody().height);
        proj.setPosition(pos);
        return proj;
    }
}
