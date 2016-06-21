/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.weapons;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.projectiles.Projectile;

/**
 *
 * @author qmatejka
 */
public class ClassicWeapon implements Weapon{

    public ClassicWeapon() {}

    @Override
    public Projectile shoot() {
        return new Projectile(new StraightMove(), new Rectangle(20, 20), null, "src/spaceinvader/view/classic_projectile.png");
    }

}
