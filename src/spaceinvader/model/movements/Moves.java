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
public interface Moves {
    
    public void updateTrajectory();
    
    public void invertTrajectory();
    
    public Point nextPosition(Point pos, Point direction);
        
}
