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
public class ClassicWeapon implements Weapon{

    private int charging = 100;
    private boolean automatique;
    
    public ClassicWeapon(boolean auto) {
        automatique = auto;
    }
    
    @Override
    public Projectile shoot() {
        
        System.out.println("shoot");
        
        if(!automatique){
            if(charging<=0){
                charging = 100;
                return new ClassicProjectile();
            }else{
                return null;
            }
        }else{
            return new ClassicProjectileEnnemy();
        }
    }

    @Override
    public boolean reload() {
        if(charging<=0)
            return false;
        else
            charging--;
        return true;
    }
    
    

}
