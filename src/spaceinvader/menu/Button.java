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
 * @version 1.0
 * @author asus
 */
public class Button extends JPanel{
    int x; //where to print...
    int y; //...the button
    private String imagePath; //path of the image to print
    private boolean selected = false; //to know if the button is currently selected by the user

    /**
     * Create an unselected Button for the main menu, only use png files
     * The image files must be in 2 copies, one "unselected" ending with "0.png" and one "selected" ending with "1.png"
     * @param imagePath if you want to use "image0.png" and "image1.png", give it "image"
     * @param x were to print...
     * @param y ...the button
     */
    public Button(String imagePath, int x, int y) {
        this.imagePath = imagePath;
        this.x = x;
        this.y = y;
    } 
    
    /**
     * Create an Button for the main menu, selected or unselected, only use png files
     * The image files must be in 2 copies, one "unselected" ending with "0.png" and one "selected" ending with "1.png"
     * @param imagePath if you want to use "image0.png" and "image1.png", give it "image"
     * @param x were to print...
     * @param y ...the button
     * @param selected is your button selected by default ?
     */
    public Button(String imagePath, int x, int y, boolean selected) {
        this.imagePath = imagePath;
        this.x = x;
        this.y = y;
        this.selected = selected;
    }  
    
    /**
     * Called for printing the button.
     * Automatically print the rigth image, depending if the button is selected or not
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        Image img;
        try {
            if(this.selected)
                img = ImageIO.read(new File(imagePath+"1.png"));
            else
                img = ImageIO.read(new File(imagePath+"0.png"));
            g.drawImage(img, x, y, this);
        } catch (IOException e) {
             e.printStackTrace();
        }
    }     
    
    /**
     * Set if the button is currently selected or not
     * @param selected true if selected, false if not
     */
    public void setSelected(boolean selected){
        this.selected = selected;
    }
    
}
