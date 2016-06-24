/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import spaceinvader.model.GameLevel;
import spaceinvader.model.weapons.ClassicWeapon;

/**
 *
 * @author asus
 */
public class ClassicTrashMob extends TrashMob{
    
    public ClassicTrashMob(Dimension ground, GameLevel level) {
        super(ground, level, "src/spaceinvader/view/classic_alien.png");
        weapon = new ClassicWeapon(true);
    }
    
}
