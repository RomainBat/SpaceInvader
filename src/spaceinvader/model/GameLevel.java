/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import spaceinvader.controler.ShipControler;
import spaceinvader.model.ships.ClassicTrashMob;
import spaceinvader.model.ships.Spaceship;
import spaceinvader.model.ships.TrashMob;
import spaceinvader.view.GameView;

/**
 *
 * @author qmatejka
 */
public class GameLevel extends Thread{
    
    private Dimension groundDimension;
    private ArrayList<GameElement> gameElements;
    //private ArrayList<Observer> observatorAttempts;
    private ShipControler sc;
    private GameView gv;
    

    public GameLevel(Dimension groundDimension) {
        this.groundDimension = groundDimension;
        gameElements = new ArrayList<GameElement>();
        
        Spaceship ship = new Spaceship(this.groundDimension);
        ship.setPosition(new Point(250, 650));
        ship.addObserver(gv);
        this.addGameElementToList(ship);
        this.sc = new ShipControler(ship, this);
        this.gv = new GameView(sc, this);
    }
    
    public GameLevel() {
        this.groundDimension = new Dimension(1280,720);
        gameElements = new ArrayList<GameElement>();
        
        Spaceship ship = new Spaceship(this.groundDimension);
        ship.setPosition(new Point(this.groundDimension.width/2-ship.getBody().width/2, 650));
        ship.addObserver(gv);
        this.addGameElementToList(ship);
        this.sc = new ShipControler(ship, this);
        this.gv = new GameView(sc, this);
    }
    
    public GameLevel(JFrame frame) {
        this.groundDimension = new Dimension(1280,720);
        gameElements = new ArrayList<GameElement>();
        
        Spaceship ship = new Spaceship(this.groundDimension);
        ship.setPosition(new Point(this.groundDimension.width/2-ship.getBody().width/2, 650));
        ship.addObserver(gv);
        this.addGameElementToList(ship);
        this.sc = new ShipControler(ship, this);
        this.gv = new GameView(sc, this, frame);
    }

    public ArrayList<GameElement> getGameElements() {
        return gameElements;
    }
    
    public void notifyObservators(){
        //for(Observer obs : observatorAttempts){
        //    obs.update();
        //}
    }
    
    public void makeGameElementsReact(){
        GameElement element, other;
        for(int i=0;i<gameElements.size();i++){
            element = gameElements.get(i);
            if(!element.react())
                    gameElements.remove(element);
            for(int j=i+1;j<gameElements.size();j++){
                other = gameElements.get(j);
                
                if(element.isCollidingWith(other))
                    element.collidedWith(other);
            }
        }
        //notifyObservators();
    }

    @Override
    public void run() {
        while(true){
            this.sc.update();
            this.gv.update();
            this.makeGameElementsReact();
            try {
                Thread.sleep(1000/100);
            } catch (InterruptedException ex) {
                Logger.getLogger(SpaceInvader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addGameElementToList(GameElement e){
        gameElements.add(0, e);
    }
    
    public void removeGameElementFromList(GameElement ge){
        gameElements.remove(ge);
    }

    public Dimension getGroundDimension() {
        return groundDimension;
    }
    
    public void initTestGameLevel(){
        for(int i=0;i<3;i++){
            for(int j=0;j<12;j++){
                TrashMob trash = new ClassicTrashMob(this.groundDimension, this);
                trash.setPosition(new Point((int) (110+j*(20+trash.getBody().getWidth())), (int)(100+i*(20+trash.getBody().getHeight()))));
                this.addGameElementToList(trash);
            }
        }
    }
    
}
