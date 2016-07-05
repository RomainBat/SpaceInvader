/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.movements;

import java.awt.Point;

/**
 *
 * @author asus
 */
public class RightLeftMove implements Moves{

    @Override
    public Point nextPosition(Point pos, Point direction) {
        System.out.println("yo");
        double x = pos.getX();
        double dx = direction.getX();
        double dy = direction.getY();
        if ((x <= 200) || (x >= 600))
            dx = -dx;
        return new Point((int)dx, (int)dy);
    }
    
}
