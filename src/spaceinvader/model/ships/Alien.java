/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import spaceinvader.model.GameLevel;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.projectiles.Projectile;

/**
 *
 * @author asus
 */
public abstract class Alien extends Ship{
    
    private GameLevel level;
    
    public Alien(Moves moves, Rectangle body, Dimension ground, String imagePath, GameLevel level, int life, String secondSpriteRef) {
        super(moves, body, ground, imagePath, life, secondSpriteRef);
        this.level = level;
    }

    @Override
    public abstract ArrayList<Projectile> shoot();

    public GameLevel getLevel() {
        return level;
    }
    
}
