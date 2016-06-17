/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.awt.Rectangle;

/**
 *
 * @author qmatejka
 */
public abstract class TrashMob extends MovingElement{
    
    private Weapon weapon;
    private Moves movement;
    private double life;
    
    public TrashMob(Moves moves, Rectangle body, Dimension ground, double life) {
        super(moves, body, ground);
        this.life = life;
    }
    
    
    
    
}
