/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.projectiles.Projectile;

/**
 *
 * @author asus
 */
public abstract class Boss extends Alien{

    public Boss(Moves moves, Rectangle body, Dimension ground, String imagePath, GameLevel level, int life, String secondSpriteRef) {
        super(moves, body, ground, imagePath, level, life, secondSpriteRef);
    }

    @Override
    public Projectile shoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void collidedWith(GameElement ge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
