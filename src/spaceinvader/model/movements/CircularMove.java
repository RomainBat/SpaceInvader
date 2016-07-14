/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.movements;

import java.awt.Point;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author asus
 */
public class CircularMove implements Moves
{
    private double angle = 0;
    private int radius;
    private int ox;
    private int oy;

    public CircularMove(int ox, int oy, int radius) {
        this.ox = ox;
        this.oy = oy;
        this.radius = radius;
        angle = Math.random()*(2*Math.PI);
    }
    
    public void setAll(int ox, int oy, int radius) {
        this.ox = ox;
        this.oy = oy;
        this.radius = radius;
        angle = Math.random()*(2*Math.PI);
    } 
    
    @Override
    public Point nextDirection(Point pos, Point direction) {
        double x = pos.getX();
        double y = pos.getY();
        
        double nx = ox+cos(angle)*radius;
        double ny = oy+sin(angle)*radius;

        angle += 2*Math.PI/200;

        return new Point((int)(nx - x), (int)(ny - y));
        
    }
    
}
