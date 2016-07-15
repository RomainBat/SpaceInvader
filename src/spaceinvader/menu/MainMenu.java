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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import spaceinvader.model.Game;
import spaceinvader.model.GameLevel;

/**
 * @version 1.0
 * @author asus
 */
public class MainMenu extends JFrame implements KeyListener{
    
    public static final int WIDTH = 800; //Size...
    public static final int HEIGHT = 600; //Of the window
    
    private final ArrayList<Button> listOfButton = new ArrayList<>(); //List of Button of the menu
    private static final int SIZE = 3; //Number of buttons of the menu
    private int selection = 0; //The index of the button currently selected by the user
    
    private boolean[] keys = new boolean[100]; //needed for key listener
    
    private boolean pressed = false; //needed to not change the selection several times in a row
    
    private final JPanel line1 =new JPanel(); //first line of button
    private final JPanel line2 =new JPanel(); //seconfd line of button
    private final JPanel line3 =new JPanel(); //third line of button
    private final JPanel finalPan = new JPanel(); //global JPanel containing the others
    
    /**
     * Creates the menu :
     *  -create the window
     *  -adds the list of button
     *  -print the buttons in the window
     */
    public MainMenu() {
        
        this.addKeyListener(this);
        
        this.setTitle("Space Invader");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.listOfButton.add(new Button("src/spaceinvader/menu/newRun",225,50,true));
        this.listOfButton.add(new Button("src/spaceinvader/menu/continue",225,50));
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
        
        select();
    }
    
    /**
     * Begins the selection process
     */
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
    
    /**
     * Creates the menu and launchs it
     */
    public void launchMainMenu(){
        MainMenu mainMenu = new MainMenu();
        mainMenu.select();
    }
    
    
    /**
     * Nothing to declare
     * @param ke 
     */
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    /**
     * Called when a key is pressed
     * updates which key is pressed
     * @param ke 
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    /**
     * Called when a key is released
     * updates the key is released, that no more key is pressed and repaint all the button to visually update which one is selected
     * @param ke 
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
        this.pressed = false;
        this.finalPan.repaint();
    }
    
    /**
     * check which key is pressed, and act in consequences :
     * - up/down : change the selection
     * - enter/space : confirm the selection
     * - esc : quit the application
     */
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
            Game game;
            GameLevel gamel = new GameLevel(this);
            switch(this.selection){
                case 0:
                    System.out.println("New Run");
                    finalPan.setVisible(false);
                    //game = new Game(this);
                    //game.playGame();
                    gamel.initTestGameLevel();
                    gamel.run();
                    gamel.transition(100);
                    gamel.initTestGameLevelBoss();
                    gamel.run();
                    gamel.transition(100);
                    break;
                case 1:
                    System.out.println("Continue");
                    finalPan.setVisible(false);
                    gamel.initTestGameLevelBoss();
                    gamel.run();
                    //JOptionPane.showMessageDialog(this, "We're working on it !", "Hold your horses", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    System.out.println("Settings");
                    JOptionPane.showMessageDialog(this, "We're working on it !", "Hold your horses", JOptionPane.INFORMATION_MESSAGE);
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
    
    /**
     * increase current selection
     */
    public void increaseSelection(){
        this.selection ++;
        if(this.selection == this.SIZE)
            this.selection = 0;
    }
    
    /**
     * decrease current selection
     */
    public void decreaseSelection(){
        this.selection --;
        if(this.selection == -1)
            this.selection = this.SIZE - 1;
        
    }
    
}
