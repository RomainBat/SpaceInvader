/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.controler;

import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.items.Item;
import spaceinvader.model.ships.Spaceship;

/**
 *
 * @author qmatejka
 */
public class ObserverItem {
    
    private GameLevel gl;
    
    public ObserverItem(GameLevel game){
        this.gl=game;
    }

    public void update(Item item, GameElement other) {        
        if(other instanceof Spaceship)
            gl.removeGameElementFromList(item);
    }
}
