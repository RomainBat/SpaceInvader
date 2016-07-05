/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.movements;

import java.awt.Point;
import static java.lang.Math.abs;

/**
 *
 * @author asus
 */
public class CrcularMove implements Moves{

    @Override
    public Point nextDirection(Point pos, Point direction) {
        double x = pos.getX();
        double y = pos.getY();
        double dx = direction.getX();
        double dy = direction.getY();
        if ((x <= 50) || (x >= 1150))
            dx = -dx;
        if( dy == 0)
            dy = 1;
        if ((y <= 50) || (y >= 500))
            dy = -dy;
        return new Point((int)dx, (int)dy);
    }
    
}
