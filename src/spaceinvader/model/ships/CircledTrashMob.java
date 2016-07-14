/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.movements.CircularMove;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.weapons.ClassicWeapon;

/**
 *
 * @author asus
 */
public class CircledTrashMob extends TrashMob{
    
    public CircledTrashMob(Dimension ground, GameLevel level, int x, int y, int radius) {
        super(ground, level, "spaceinvader/view/classic_alien_sharpened.png", 2, new CircularMove(x, y, radius), "spaceinvader/view/classic_alien_sharpened_broken.png");
        weapon = new ClassicWeapon(false, 0);
    }
    
    public void changerPosition(Point p){
        this.setPosition(p);
        ((CircularMove)(this.getMoves())).setAll(this.getPosition().x, this.getPosition().y, 100);
    }

    @Override
    public void collidedWith(GameElement other) {
        
    }
    
}
