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
    private String imagePath;

    public GameElement(Rectangle body, Dimension ground, String imagePath){
        this.body = body;
        this.ground = ground;
        this.imagePath = imagePath;
    }

    public Point getPosition(){
        return body.getLocation();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
    
    public abstract boolean react();
    
}
