/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.weapons;

import java.util.ArrayList;
import spaceinvader.model.projectiles.Projectile;

/**
 *
 * @author asus
 */
public abstract class Weapon {
    
    protected int charging = 0;
    protected int chargingMax;
    protected boolean holdByPlayer;
    
    public abstract ArrayList<Projectile> shoot();
    
    public boolean reload() {
        if(this.charging<=0)
            return false;
        else
            this.charging--;
        return true;
    }
}
