/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.controler;

import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.projectiles.Projectile;

/**
 *
 * @author qmatejka
 */
public class ObserverShot{
    
    private GameLevel gl;
    
    public ObserverShot(GameLevel game){
        this.gl=game;
    }

    public void update(Projectile o, GameElement o1) {
        gl.removeGameElementFromList(o);
        gl.removeGameElementFromList(o1);
    }
    
}
