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
import spaceinvader.model.weapons.DoubleShotWeapon;

/**
 *
 * @author qmatejka
 */
public class LaserCannon extends Item{
    
    public LaserCannon(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
    }
    
    public LaserCannon(Dimension ground){
        super(new StraightMove(), new Rectangle(30, 40), ground, "spaceinvader/view/double_cannon_test.png");
        this.setDy(2);
        this.setWeapon(new DoubleShotWeapon(true));
    }

    @Override
    public void useItem(Spaceship spaceship) {
        spaceship.setWeapon(this.getWeapon());
    }

}
