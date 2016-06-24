/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.menu;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author asus
 */
public class Button extends JPanel{
    int x;
    int y;
    private String imagePath;
    private boolean selected = false;

    public Button(String imagePath, int x, int y) {
        this.imagePath = imagePath;
        this.x = x;
        this.y = y;
    } 
    
    public Button(String imagePath, int x, int y, boolean selected) {
        this.imagePath = imagePath;
        this.x = x;
        this.y = y;
        this.selected = selected;
    }  
    
    @Override
    public void paintComponent(Graphics g){
        Image img;
        try {
            if(this.selected){
                img = ImageIO.read(new File(imagePath+"1.png"));
                
            }
            else{
                img = ImageIO.read(new File(imagePath+"0.png"));
            }
            g.drawImage(img, x, y, this);
            //Pour une image de fond
             //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
             e.printStackTrace();
        }
    }     
    
    
    public void setSelected(boolean selected){
        this.selected = selected;
    }
    
}
