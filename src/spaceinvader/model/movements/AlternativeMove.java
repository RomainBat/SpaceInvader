/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.movements;

import java.awt.Point;

/**
 *
 * @author qmatejka
 */
public class AlternativeMove implements Moves{

    private int circularPivot = -1;

    public AlternativeMove() {
        //this.trajectory = new Trajectory(0, 5, -5);
    }

    @Override
    public Point nextDirection(Point pos, Point direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
