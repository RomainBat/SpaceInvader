/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.menu;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author asus
 */
public class MainMenu extends JFrame{
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    
    public MainMenu() {
        this.setTitle("Space Invader");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        JPanel pan =new JPanel();
        pan.setBackground(Color.gray);
        
        this.setContentPane(pan);
        this.setContentPane(new Panneau(300,10,200,50));
        this.setVisible(true);
    }
    
}
