/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.weapons;

import spaceinvader.model.projectiles.Projectile;

/**
 *
 * @author qmatejka
 */
public interface Weapon {
    
    public Projectile shoot();
    
}