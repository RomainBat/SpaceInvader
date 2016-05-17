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
public abstract class MovingElement extends GameElement{
    
    private Trajectory trajectory;

    public MovingElement(Trajectory trajectory, Rectangle body, Dimension ground) {
        super(body, ground);
        this.trajectory = trajectory;
    }

    public void setPosition(Point p){
        //Check if the point P is inside the map
        double x = p.getX();
        double y = p.getY();
        double height = this.getGround().getHeight();
        double width = this.getGround().getWidth();
        
        if(x>width)
            p.setLocation(width, p.getY());
        else if(x<0)
            p.setLocation(0, p.getY());
        
        if(y>height)
            p.setLocation(width, p.getX());
        else if(y<0)
            p.setLocation(0, p.getX());
        
        this.getBody().setLocation(p);
    }
    
    public abstract void react();
    
}
