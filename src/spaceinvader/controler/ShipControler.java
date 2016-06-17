/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import spaceinvader.model.GameLevel;
import spaceinvader.model.ships.Spaceship;

/**
 *
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
        ship.getMoves().getTrajectory().setdX(0);
    }
    
    
    public void update() {
        if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP]){
            System.out.println("UP");
        }

        if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]){
            System.out.println("DOWN");
        }

        if(keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT]){
            ship.getMoves().getTrajectory().setdX(-2);
        }

        if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT]){
            ship.getMoves().getTrajectory().setdX(2);
        }
        
        if(keys[KeyEvent.VK_SPACE])
            gameLevel.addGameElementToList(ship.shoot());
    }

    public Spaceship getShip() {
        return ship;
    }
    
}