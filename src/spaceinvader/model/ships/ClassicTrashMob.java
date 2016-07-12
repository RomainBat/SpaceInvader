/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import spaceinvader.model.GameLevel;
import spaceinvader.model.movements.CircularMove;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.weapons.ClassicWeapon;

/**
 *
 * @author asus
 */
public class ClassicTrashMob extends TrashMob{
    
    public ClassicTrashMob(Dimension ground, GameLevel level) {
        super(ground, level, "spaceinvader/view/classic_alien_sharpened.png", 2, new StraightMove(), "spaceinvader/view/classic_alien_sharpened_broken.png");
        weapon = new ClassicWeapon(false, 0);
        this.setDx(3);
    }
    
    public void changerPosition(Point p){
        this.setPosition(p);
        ((CircularMove)(this.getMoves())).setAll(this.getPosition().x, this.getPosition().y, 100);
    }
    
}
