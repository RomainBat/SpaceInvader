/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.weapons;

import spaceinvader.model.projectiles.Projectile;
import spaceinvader.model.projectiles.StrongProjectile;
import spaceinvader.model.projectiles.StrongProjectileEnnemy;

/**
 *
 * @author asus
 */
public class StrongWeapon extends Weapon{

    public StrongWeapon(boolean isHoldByPlayer) {
        this.holdByPlayer = isHoldByPlayer;
        this.chargingMax = 200;
    }

    @Override
    public Projectile shoot() {
        if(this.charging<=0){
            this.charging = this.chargingMax;
            if(this.holdByPlayer)
                return new StrongProjectile();
            else
                return new StrongProjectileEnnemy();
        }else
            return null;
    }
    
}
