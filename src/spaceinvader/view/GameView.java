/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import spaceinvader.controler.ShipControler;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;

/**
 *
 * @author qmatejka
 */
public class GameView extends Canvas{

    private JFrame container;
    private JPanel panel;
    private BufferStrategy strategy;
    
    private JLabel ecran = new JLabel();
    private Dimension dim = new Dimension(50, 40);
    private Dimension dim2 = new Dimension(50, 31);
    private boolean update = false;
    
    private ArrayList<GameElement> elementsList = new ArrayList<GameElement>();
    
    private HealthBar healthBar;
    
    private GameLevel gameLevel;
    
    private Sprite background, gameover;
    
    private ShipControler controler;

    /**
     * Constructor of the gameview, with initialisation of the swing components.
     * @param controler player controler
     * @param gameLevel level to display to the player
     */
    public GameView(ShipControler controler, GameLevel gameLevel, JFrame frame){ 
        this.controler = controler;     
        this.gameLevel = gameLevel;
        this.elementsList = gameLevel.getGameElements();
        this.healthBar = new HealthBar(controler.getShip());
        this.container = frame;
        
        initComposant();                

        background = SpriteStore.getStore().getSprite("spaceinvader/view/test_bg.jpg");
        gameover = SpriteStore.getStore().getSprite("spaceinvader/view/game_over.png");
        
        addKeyListener(controler);
        requestFocus();
        
        createBufferStrategy(3);
	strategy = getBufferStrategy();
    }
    
    
    
    private void initComposant(){
        /*
        Font police = new Font("Arial", Font.BOLD, 20);
        ecran = new JLabel("0");
        ecran.setFont(police);
        ecran.setHorizontalAlignment(JLabel.RIGHT);
        ecran.setPreferredSize(new Dimension(220, 20));
        */
        panel=(JPanel)container.getContentPane();
        panel.setPreferredSize(gameLevel.getGroundDimension());
        panel.setMinimumSize(gameLevel.getGroundDimension());
	panel.setSize(this.getPreferredSize());
        panel.setLayout(null);
        
        setBounds(0, 0, gameLevel.getGroundDimension().width, gameLevel.getGroundDimension().height);
        panel.add(this);
        
        setIgnoreRepaint(true);        
        
        this.container.add(this);
        this.container.pack();
        this.container.setBackground(Color.white);
        this.container.setTitle("Space Invaders 1.0");
        this.container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.container.setLocationRelativeTo(null);
        this.container.setResizable(false);
        this.container.setVisible(true);
    }
    
    /**
     * The update is called every frame by the main loop while.
     * It erases all the sprites and repaint it according to their new position.
     */
    public void update() {
        Graphics g = strategy.getDrawGraphics();
        //Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        g.setFont(new Font("Arial", Font.BOLD, 80));
        g.setColor(Color.black);
        g.fillRect(0, 0, gameLevel.getGroundDimension().width, gameLevel.getGroundDimension().height);
        
        
        background.draw(g, 0, 0, 1280, 720);
        
        
        this.elementsList = gameLevel.getGameElements();
        for(GameElement ge : elementsList){
            ge.draw(g);
        }
        
        healthBar.draw(g);
        
        if(gameLevel.isPaused())
            g.drawString("PAUSED",gameLevel.getGroundDimension().width/2-(int)(27.5*6), gameLevel.getGroundDimension().height/2+30);
        
        
        if(controler.getShip().isDead())
            gameover.draw(g, (gameLevel.getGroundDimension().width-560)/2, (gameLevel.getGroundDimension().height-76)/2, 560, 76);
        
        if(gameLevel.getBoss().isDead())
            g.drawString("CONGRATULATIONS!",gameLevel.getGroundDimension().width/2-(int)(27.5*16), gameLevel.getGroundDimension().height/2+30);
        
        
        g.dispose();
        strategy.show();
    }
        
}
