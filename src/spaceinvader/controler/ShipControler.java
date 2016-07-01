/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import spaceinvader.model.GameLevel;
import spaceinvader.model.Observer;
import spaceinvader.model.projectiles.Projectile;
import spaceinvader.model.ships.Spaceship;

/**
 * @version 1.0
 * @author qmatejka
 */
public class ShipControler implements KeyListener{

    private Spaceship ship;
    private GameLevel gameLevel;
    private boolean[] keys = new boolean[100];

    public ShipControler(Spaceship ship, GameLevel gl) {
        this.ship = ship;
        gameLevel = gl;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
        ship.setDx(0);
    }
    
    
    public void update() {
        if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP]){
        }

        if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]){
        }

        if(keys[KeyEvent.VK_Q] || keys[KeyEvent.VK_LEFT]){
            ship.setDx(-4);
            ship.move();
            //ship.notifyObs();
        }

        if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT]){
            ship.setDx(4);
            ship.move();
            //ship.notifyObs();
        }
        
        if(keys[KeyEvent.VK_SPACE]){
            Projectile proj = ship.shoot();
            if(proj!=null){
                proj.addObserver(new ObserverShot(gameLevel));
                gameLevel.addGameElementToList(proj);
            }
        }
            
    }

    public Spaceship getShip() {
        return ship;
    }
    
}
