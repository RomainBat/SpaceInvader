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

/**
 *
 * @author qmatejka
 */
public class DoubleShotWeapon extends Weapon{

    private int projNumber=2;
    
    public DoubleShotWeapon(boolean isHoldByPlayer) {
        this.holdByPlayer = isHoldByPlayer;
        this.chargingMax = 20;
    }

    @Override
    public ArrayList<Projectile> shoot() {
        ArrayList<Projectile> projs = new ArrayList<Projectile>();
        if(this.charging<=0){
            this.charging = this.chargingMax;
            for(int i=0;i<projNumber;i++){
                if(this.holdByPlayer)
                    projs.add(new ClassicProjectile());
                else
                    projs.add(new ClassicProjectileEnnemy());
            }
        }
        return projs;
    }
    
}
