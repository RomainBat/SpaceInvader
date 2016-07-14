/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.view;

import java.awt.Graphics;
import spaceinvader.model.ships.Spaceship;

/**
 *
 * @author qmatejka
 */
public class HealthBar{
    
    private boolean white = true;
    
    private Spaceship ship;
    private Sprite heart;
    private Sprite emptyHeart;
    private int heartSize;

    public HealthBar(Spaceship ship) {
        this.ship = ship;
        if(white){
            this.heart = SpriteStore.getStore().getSprite("spaceinvader/view/heart_full_white.png");
            this.emptyHeart = SpriteStore.getStore().getSprite("spaceinvader/view/heart_empty_white.png");
        }else{
            this.heart = SpriteStore.getStore().getSprite("spaceinvader/view/heart_full.png");
            this.emptyHeart = SpriteStore.getStore().getSprite("spaceinvader/view/heart_empty.png");
        }
        this.heartSize = 30;
    }
    
    public void draw(Graphics g){
        //Dimension resolution = ship.getGround();
        for(int i=0;i<ship.getLiveMax();i++){
            if(i<ship.getLife())
                heart.draw(g, 10+(heartSize+10)*i, 10, heartSize, heartSize);
            else
                emptyHeart.draw(g, 10+(heartSize+10)*i, 10, heartSize, heartSize);
        }
    }
    
    
}
