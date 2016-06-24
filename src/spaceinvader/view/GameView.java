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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import spaceinvader.controler.ShipControler;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.Observer;
import spaceinvader.model.ships.Spaceship;

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
    
    //L'instance de notre objet contrôleur
    private ShipControler controler;


    public GameView(ShipControler controler, GameLevel gameLevel){ 
        this.controler = controler;     
        this.gameLevel = gameLevel;
        this.elementsList = gameLevel.getGameElements();
        
        initComposant();                

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
        g.setColor(Color.white);
        g.fillRect(10, 10, gameLevel.getGroundDimension().width, gameLevel.getGroundDimension().height);
        
        this.elementsList = gameLevel.getGameElements();
        for(GameElement ge : elementsList){
            ge.draw(g);
        }
        
        g.dispose();
        strategy.show();
        //this.repaint();
    }
   
 
    /*public void paintComponent(Graphics g){
        //super.paintComponent(g);
        if(!graphicList.isEmpty()){
            for(int i=0;i<graphicList.size();i++){
                MyGraphic graphic = graphicList.get(i);
                Graphics2D g2d = (Graphics2D)g;
                try {
                    BufferedImage image = ImageIO.read(new File(graphic.getMyImagePath()));
                    g2d.drawImage(image, graphic.getCoordinate().x, graphic.getCoordinate().y, graphic.getDimension().height,graphic.getDimension().width,null);
                } catch (IOException ex) {
                    //Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }*/
    
}
