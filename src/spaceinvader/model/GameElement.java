/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import spaceinvader.view.Sprite;
import spaceinvader.view.SpriteStore;

/**
 *
 * @author qmatejka
 */
public abstract class GameElement {
    
    private Rectangle body;
    private Dimension ground;
    private Sprite sprite;
    private double x;
    private double y;

    public GameElement(Rectangle body, Dimension ground, String imagePath){
        this.body = body;
        this.ground = ground;
        this.sprite = SpriteStore.getStore().getSprite(imagePath);
    }

    public void draw(Graphics g){
        sprite.draw(g, body.x, body.y, body.width, body.height);
    }
    
    public boolean isCollidingWith(GameElement other){
        return other.getBody().intersects(body);
    }
    
    public abstract boolean react();
    
    public abstract void collidedWith(GameElement other);
    
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

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    
}
