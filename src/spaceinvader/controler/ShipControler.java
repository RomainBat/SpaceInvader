/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import spaceinvader.model.GameLevel;
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
    private boolean escPressed = false;

    public ShipControler(Spaceship ship, GameLevel gl) {
        this.ship = ship;
        gameLevel = gl;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    /*
    * When a key is pressed, make her boolean at true in the boolean array
    */
    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    /*
    * When a key is released, make her boolean at false in the boolean array and set the direction of the spaceship at 0.
    */
    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
        ship.setDx(0);
        this.escPressed = false;
    }
    
    /**
     * This method is called in every frame in the while loop to see if the player pressed a key.
     * We don't use a switch to be able to manage 2 events if the player hits 2 key in the same time.
     */
    public void update() {
        if(!gameLevel.isPaused()){
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
                ArrayList<Projectile> projs = ship.shoot();
                for(Projectile proj : projs){
                    if(proj!=null){
                        proj.addObserver(new ObserverShot(gameLevel));
                        gameLevel.addGameElementToList(proj);
                    }
                }
            }
        }
        if(keys[KeyEvent.VK_ESCAPE] && (!this.escPressed)){
            System.out.println("pause");
            gameLevel.breakTime();
            this.escPressed = true;
        }
            
    }

    public Spaceship getShip() {
        return ship;
    }
    
}
