/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.ships.BonusAlien;

/**
 *
 * @author qmatejka
 */
public abstract class MovingElement extends GameElement {
    
    private Moves moves;
    private double dx;
    private double dy;

    public MovingElement(Moves moves, Rectangle body, Dimension ground, String imagePath) {
        super(body, ground, imagePath);
        this.moves = moves;
    }

    public void setPosition(Point p){
        //Check if the point P is inside the map
        double x = p.getX();
        double y = p.getY();
        double height = this.getGround().getHeight();
        double width = this.getGround().getWidth();
        
        if(x>width-this.getBody().width)
            p.setLocation(width-this.getBody().width, p.getY());
        else if(x<0)
            p.setLocation(0, p.getY());
        
        this.getBody().setLocation(p);
    }
    
    public void move(){
        //get new dir, then update the position
        Point newDir = moves.nextDirection(this.getPosition(), new Point((int)dx, (int)dy));
        this.dx = newDir.x;
        this.dy = newDir.y;
        double x = this.getPosition().x + this.dx;
        double y = this.getPosition().y + this.dy;
        if(this instanceof BonusAlien)
            this.getBody().setLocation(new Point((int)x,(int)y));
        else
            setPosition(new Point((int)x,(int)y));
    }
    
    public boolean isOutOfTheScreen(){
        int x = (int)this.getPosition().getX();
        int y = (int)this.getPosition().getY();
        return this.getGround().width<x || this.getGround().height<y;
    }
    
    public abstract boolean react();
    
    public Moves getMoves() {
        return moves;
    }

    public void setMoves(Moves moves) {
        this.moves = moves;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
    
}
