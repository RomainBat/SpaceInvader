/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.menu;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author asus
 */
public class Panneau extends JPanel{
    private int x;
    private int y;
    private int width;
    private int height;
    
    public Panneau(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;                
    }
    
    
    public void paintComponent(Graphics g){
    //x1, y1, width, height, arcWidth, arcHeight
    g.drawRoundRect(x, y, width, height, 10, 10);
  }  
}
