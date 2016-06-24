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
    public void updateTrajectory() {
        /**double oldDX = this.trajectory.getdX();
        double oldDY = this.trajectory.getdY();
        double newDX = oldDX;
        double newDY = oldDY;
        if(oldDX+oldDY == 0){
            if(oldDX<0)
                newDX=oldDX*circularPivot;
            else
                newDY=oldDX*circularPivot;
        }else if(oldDX+oldDY < 0){
            newDY=oldDX*circularPivot;
        }else{
            newDX=oldDX*circularPivot;
        }
        this.trajectory.setdX(newDX);
        this.trajectory.setdY(newDY);
        */
    }

    @Override
    public void invertTrajectory() {
        circularPivot *= -1;
    }

    @Override
    public Point nextPosition(Point pos, Point direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
