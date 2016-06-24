/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author asus
 */
public class MainMenu extends JFrame implements KeyListener{
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    private final ArrayList<Button> listOfButton = new ArrayList<>();
    private static final int SIZE = 3;
    private int selection = 0;
    
    private boolean[] keys = new boolean[100];
    private boolean pressed = false;
    
    private final JPanel line1 =new JPanel();
    private final JPanel line2 =new JPanel();
    private final JPanel line3 =new JPanel();
    private final JPanel finalPan = new JPanel();
    
    public MainMenu() {
        
        this.addKeyListener(this);
        
        this.setTitle("Space Invader");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.listOfButton.add(new Button("src/spaceinvader/menu/continue",225,50,true));
        this.listOfButton.add(new Button("src/spaceinvader/menu/newRun",225,50));
        this.listOfButton.add(new Button("src/spaceinvader/menu/settings",225,50));
        
        line1.setLayout(new BoxLayout(line1, BoxLayout.LINE_AXIS));
        line1.add((JPanel)this.listOfButton.get(0));
        
        line2.setLayout(new BoxLayout(line2, BoxLayout.LINE_AXIS));
        line2.add((JPanel)this.listOfButton.get(1));
        
        line3.setLayout(new BoxLayout(line3, BoxLayout.LINE_AXIS));
        line3.add((JPanel)this.listOfButton.get(2));
        
        finalPan.setLayout(new BoxLayout(finalPan, BoxLayout.PAGE_AXIS));
        finalPan.add(line1);
        finalPan.add(line2);
        finalPan.add(line3);
        
        this.getContentPane().add(finalPan);
        this.setVisible(true);
    }
    
    public void select(){
        while(true){
            if(!pressed){
                this.update();
            }
            try {
                sleep(1000/60);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("sleep error");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
        this.pressed = false;
        this.finalPan.repaint();
    }
    
    public void update() {
        
        if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP]){
            this.listOfButton.get(this.selection).setSelected(false);
            decreaseSelection();
            this.listOfButton.get(this.selection).setSelected(true);
            
            this.pressed = true;
        }

        if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]){
            this.listOfButton.get(this.selection).setSelected(false);
            increaseSelection();
            this.listOfButton.get(this.selection).setSelected(true);
            
            this.pressed = true;
        }
        
        if(keys[KeyEvent.VK_SPACE] || keys[KeyEvent.VK_ENTER]){
            switch(this.selection){
                case 0:
                    System.out.println("Continue");
                    break;
                case 1:
                    System.out.println("New Run");
                    break;
                case 2:
                    System.out.println("Settings");
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            
            this.pressed = true;
        }
        
        if(keys[KeyEvent.VK_ESCAPE]){
            System.exit(0);
        }
    }
    
    public void increaseSelection(){
        this.selection ++;
        if(this.selection == this.SIZE)
            this.selection = 0;
    }
    
    public void decreaseSelection(){
        this.selection --;
        if(this.selection == -1)
            this.selection = this.SIZE - 1;
        
    }
    
}
