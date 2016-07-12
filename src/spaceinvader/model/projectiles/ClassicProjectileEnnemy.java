/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.projectiles;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.GameElement;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.ships.Spaceship;

/**
 *
 * @author asus
 */
public class ClassicProjectileEnnemy extends Projectile{

    public ClassicProjectileEnnemy(Moves moves, Rectangle body, Dimension ground, String imagePath, int damage) {
        super(moves, body, ground, imagePath, damage);
    }
     
    public ClassicProjectileEnnemy() {
        super(new StraightMove(), new Rectangle(30, 30), null, "spaceinvader/view/classic_projectile_enemy_3.png", 1);
        setDy(3);
    }

    @Override
    public void collidedWith(GameElement other) {
        if(other instanceof Spaceship){
            notifyObserver(other);
        }
    }
}
