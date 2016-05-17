/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author qmatejka
 */
public abstract class GameElement {
    
    private Rectangle body;
    private Dimension ground;
    
    public GameElement(Rectangle body, Dimension ground){
        this.body = body;
        this.ground = ground;
    }

    public Point getPosition(){
        return body.getLocation();
    }
    
    public Rectangle getBody() {
        return body;
    }

    public void setBody(Rectangle body) {
        this.body = body;
    }

    public Dimension getGround() {
        return ground;
    }

    public void setGround(Dimension ground) {
        this.ground = ground;
    }
    
    public abstract void react();
    
}