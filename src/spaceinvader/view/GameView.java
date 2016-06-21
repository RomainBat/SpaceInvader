/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
public class GameView extends JPanel implements Observer{

    private JFrame window = new JFrame();
    private JPanel container = new JPanel();
  
    private JLabel ecran = new JLabel();
    private Dimension dim = new Dimension(50, 40);
    private Dimension dim2 = new Dimension(50, 31);
    private boolean update = false;
    
    private ArrayList<MyGraphic> graphicList = new ArrayList<MyGraphic>();
    private ArrayList<GameElement> elementsList = new ArrayList<GameElement>();
    
    private GameLevel gameLevel;
    
    //L'instance de notre objet contrôleur
    private ShipControler controler;


    public GameView(ShipControler controler, GameLevel gameLevel){ 
        this.controler = controler;     
        this.gameLevel = gameLevel;
        this.elementsList = gameLevel.getGameElements();
        
        this.setPreferredSize(gameLevel.getGroundDimension());
        this.setMinimumSize(gameLevel.getGroundDimension());
	this.setSize(this.getPreferredSize());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
        
        initComposant();                
        
        JPanel panel3=new JPanel();
        panel3.add(this);
        panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));

        this.window.addKeyListener(controler);
        this.window.setContentPane(panel3);
        this.window.pack();
        this.window.setBackground(Color.white);
        this.window.setTitle("Space Invaders 1.0");
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setLocationRelativeTo(null);
        this.window.setResizable(false);
        this.window.setVisible(true);
        
        for(GameElement ge : elementsList){
            graphicList.add(new MyGraphic(ge.getPosition(), ge.getBody().getSize(), Color.yellow, Color.black, ge.getImagePath()));
        }
        
    }
    
    private void initComposant(){
        Font police = new Font("Arial", Font.BOLD, 20);
        ecran = new JLabel("0");
        ecran.setFont(police);
        ecran.setHorizontalAlignment(JLabel.RIGHT);
        ecran.setPreferredSize(new Dimension(220, 20));
    }
    
    @Override
    public void update() {
        this.elementsList = gameLevel.getGameElements();
        graphicList.clear();
        for(GameElement ge : elementsList){
                graphicList.add(new MyGraphic(ge.getPosition(), ge.getBody().getSize(), Color.yellow, Color.black, ge.getImagePath()));
        }
        this.repaint();
    }
 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
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
        
    }
    
}
