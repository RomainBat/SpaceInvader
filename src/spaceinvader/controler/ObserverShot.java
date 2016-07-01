/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.controler;

import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.projectiles.Projectile;
import spaceinvader.model.ships.Ship;

/**
 *
 * @author qmatejka
 */
public class ObserverShot{
    
    private GameLevel gl;
    
    public ObserverShot(GameLevel game){
        this.gl=game;
    }

    public void update(Projectile proj, GameElement other) {
        ((Ship)other).hurt(proj.getDamage());
        gl.removeGameElementFromList(proj);
        if(((Ship)other).isDead())
            gl.removeGameElementFromList(other);
    }
    
}
