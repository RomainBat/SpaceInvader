/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.weapons;

import java.util.ArrayList;
import spaceinvader.model.projectiles.ClassicProjectile;
import spaceinvader.model.projectiles.ClassicProjectileEnnemy;
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
    public ArrayList<Projectile> shoot() {
        ArrayList<Projectile> projs = new ArrayList<Projectile>();
        if(this.charging<=0){
            this.charging = this.chargingMax;
            if(this.holdByPlayer)
                projs.add(new StrongProjectile());
            else
                projs.add(new StrongProjectileEnnemy());
        }
        return projs;
    }
    
}
