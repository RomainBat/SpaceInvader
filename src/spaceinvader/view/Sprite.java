/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.color.ColorSpace;
import static java.awt.color.ColorSpace.CS_GRAY;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

/**
 *
 * @author qmatejka
 */
public class Sprite {
    
    private Image image;
    private Sprite negative;
    
    public Sprite(Image img){
        this.image=img;
        //this.negative=new Sprite(negativeImage());
    }
    
    public void draw(Graphics g, int x, int y, int width, int height){
        g.drawImage(image, x, y, (int)(width*1), (int)(height*1), null);
    }
    
    public BufferedImage negativeImage(){
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(CS_GRAY), null);
        return op.filter((BufferedImage)image, null);
    }
    
    public Sprite getNegative(){
        return negative;
    }
    
}
