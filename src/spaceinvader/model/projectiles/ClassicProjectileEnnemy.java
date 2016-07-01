/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.projectiles;

import java.awt.Rectangle;
import spaceinvader.model.GameElement;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.ships.Spaceship;

/**
 *
 * @author asus
 */
public class ClassicProjectileEnnemy extends Projectile{
     
    public ClassicProjectileEnnemy() {
        super(new StraightMove(), new Rectangle(20, 20), null, "spaceinvader/view/classic_projectile_enemy.png", 1);
    }

    @Override
    public void collidedWith(GameElement other) {
        if(other instanceof Spaceship){
            notifyObserver(other);
        }
    }
}
