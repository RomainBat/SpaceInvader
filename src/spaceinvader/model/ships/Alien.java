/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Rectangle;
import spaceinvader.model.movements.Moves;

/**
 *
 * @author asus
 */
public class Alien extends Ship{
    
    public Alien(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(moves, body, ground, imagePath);
    }
    
    
}
