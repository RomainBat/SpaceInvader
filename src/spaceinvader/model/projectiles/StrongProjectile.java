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

/**
 *
 * @author asus
 */
public class StrongProjectile extends Projectile {
    
    public StrongProjectile() {
        super(new StraightMove(), new Rectangle(40, 40), null, "spaceinvader/view/classic_projectile_.png", 3);
    }

    @Override
    public void collidedWith(GameElement other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
