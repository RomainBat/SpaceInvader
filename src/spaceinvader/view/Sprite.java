/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.view;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author qmatejka
 */
public class Sprite {
    
    private Image image;
    
    public Sprite(Image img){
        this.image=img;
    }
    
    public void draw(Graphics g, int x, int y, int height, int width){
        g.drawImage(image, x, y, height, width, null);
    }
    
}
