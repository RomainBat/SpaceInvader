/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.weapons;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.movements.StraightMove;
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
        if(!automatique){
            if(charging<=0){
                charging = 100;
                return new Projectile(new StraightMove(), new Rectangle(20, 20), null, "src/spaceinvader/view/classic_projectile.png");
            }else{
                return null;
            }
        }else{
            return new Projectile(new StraightMove(), new Rectangle(20, 20), null, "src/spaceinvader/view/classic_projectile_enemy.png");
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
