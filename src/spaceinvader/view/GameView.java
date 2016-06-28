/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import spaceinvader.controler.ShipControler;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.Observer;

/**
 *
 * @author qmatejka
 */
public class GameView extends Canvas implements Observer{

    private JFrame container = new JFrame();
    private JPanel panel;
    private BufferStrategy strategy;
    
    private JLabel ecran = new JLabel();
    private Dimension dim = new Dimension(50, 40);
    private Dimension dim2 = new Dimension(50, 31);
    private boolean update = false;
    
    private ArrayList<GameElement> elementsList = new ArrayList<GameElement>();
    
    private GameLevel gameLevel;
    
    private Sprite background;
    
    //L'instance de notre objet contrôleur
    private ShipControler controler;


    public GameView(ShipControler controler, GameLevel gameLevel){ 
        this.controler = controler;     
        this.gameLevel = gameLevel;
        this.elementsList = gameLevel.getGameElements();
        
        initComposant();                

        background = SpriteStore.getStore().getSprite("spaceinvader/view/test_bg.jpg");
        
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
    
    @Override
    public void update() {
        Graphics g = strategy.getDrawGraphics();
        //Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(10, 10, gameLevel.getGroundDimension().width, gameLevel.getGroundDimension().height);
        
        
        background.draw(g, 10, 10, 1280, 720);
        
        this.elementsList = gameLevel.getGameElements();
        for(GameElement ge : elementsList){
            ge.draw(g);
        }
        
        g.dispose();
        strategy.show();
        //this.repaint();
    }
    
}
