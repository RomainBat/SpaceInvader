/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.weapons;

import spaceinvader.model.projectiles.ClassicProjectile;
import spaceinvader.model.projectiles.ClassicProjectileEnnemy;
import spaceinvader.model.projectiles.Projectile;

/**
 *
 * @author qmatejka
 */
public class ClassicWeapon extends Weapon{
    
    public ClassicWeapon(boolean isHoldByPlayer) {
        this.holdByPlayer = isHoldByPlayer;
        this.chargingMax = 100;
    }
    
    @Override
    public Projectile shoot() {
        if(this.charging<=0){
            this.charging = this.chargingMax;
            if(this.holdByPlayer)
                return new ClassicProjectile();
            else
                return new ClassicProjectileEnnemy();
        }else
            return null;
    }
    
    
    

}
