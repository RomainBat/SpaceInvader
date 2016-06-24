/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.items;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.GameElement;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.MovingElement;
import spaceinvader.model.weapons.Weapon;

/**
 *
 * @author asus
 */
public abstract class Item extends MovingElement{

    Weapon weapon;

    public Item(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
    } 
    
    public Item(Moves moves, Rectangle body, Dimension ground, String imagePath, Weapon weapon) {
        super(moves, body, ground, imagePath);
        this.weapon = weapon;
    } 
    
    public abstract void useItem();
    
    @Override
    public boolean react() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void collidedWith(GameElement ge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
