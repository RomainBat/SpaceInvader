/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.movements;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author qmatejka
 */
public class StraightMove implements Moves{
        
    public StraightMove(){
        //this.trajectory = new Trajectory(0, 0, -6);
    }

    @Override
    public void updateTrajectory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void invertTrajectory() {
        //trajectory.invertTrajectory();
    }

    @Override
    public Point nextPosition(Point pos, Point direction) {
        double dX = direction.getX();
        double dY = direction.getY();
        double pX = pos.getX();
        double pY = pos.getY();
        return new Point((int)(dX+pX), (int)(pY+dY));
    }
    
}
