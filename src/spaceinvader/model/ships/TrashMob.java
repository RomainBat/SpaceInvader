/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.projectiles.ClassicProjectile;
import spaceinvader.model.projectiles.Projectile;

/**
 *
 * @author qmatejka
 */
public abstract class TrashMob extends Alien{
    
    public TrashMob(Dimension ground, GameLevel level, String imagePath) {
        super(new StraightMove(), new Rectangle(70, 70), ground, imagePath, level);
    }

    @Override
    public Projectile shoot() {
        Projectile proj = weapon.shoot();
        if(proj!=null){
            proj.setDy(3);
            proj.setGround(this.getGround());
            Point pos = this.getPosition();
            pos.setLocation(pos.getX()+(this.getBody().width-proj.getBody().width)/2, pos.getY()+proj.getBody().height);
            proj.setPosition(pos);
        }
        return proj;
    }

    @Override
    public void collidedWith(GameElement ge) {
        if(ge instanceof ClassicProjectile){
            
        }
    }
    
    
}
