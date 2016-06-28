/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qmatejka
 */
public class GameLevel extends Thread{
    private Dimension groundDimension;
    private ArrayList<GameElement> gameElements;
    //private ArrayList<Observer> observatorAttempts;

    public GameLevel(Dimension groundDimension) {
        this.groundDimension = groundDimension;
        gameElements = new ArrayList<GameElement>();
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
        boolean gameIsNotFinished = true;
        while(gameIsNotFinished){
            makeGameElementsReact();
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameLevel.class.getName()).log(Level.SEVERE, null, ex);
            }
            interrupt();
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
    
}
