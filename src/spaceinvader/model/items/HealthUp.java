/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.items;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.ships.Spaceship;

/**
 *
 * @author asus
 */
public class HealthUp extends Item{

    public HealthUp(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
    }
    
    public HealthUp(Dimension ground){
        super(new StraightMove(), new Rectangle(34, 30), ground, "spaceinvader/view/heart_full.png");
        this.setDy(2);
    }

    @Override
    public void useItem(Spaceship ship) {
        this.setSpaceship(ship);
        this.getSpaceship().heal(1);
    }
    
    
}
