/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.items;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.ships.Spaceship;

/**
 *
 * @author asus
 */
public class HealthUp extends Item{

    Spaceship spaceship;
    
    public HealthUp(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
    }

    @Override
    public void useItem() {
        spaceship.changeLiveMax(1);
    }
    
    public void setSpaceShip(Spaceship spaceship){
        this.spaceship = spaceship;
    }
    
}
