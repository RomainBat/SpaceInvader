/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model;

/**
 *
 * @author qmatejka
 */
public class AlternativeMove implements Moves{

    private Trajectory trajectory;
    private int circularPivot = -1;

    public AlternativeMove() {
        this.trajectory = new Trajectory(0, 5, -5);
    }
    
    @Override
    public void updateTrajectory() {
        double oldDX = this.trajectory.getdX();
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
    }

    @Override
    public void invertTrajectory() {
        circularPivot *= -1;
    }

    @Override
    public double nextPosX() {
        double posX = trajectory.nextPosX();
        return posX;
    }

    @Override
    public double nextPosY() {
        double posY = trajectory.nextPosY();
        updateTrajectory();
        return posY;
    }

    @Override
    public Trajectory getTrajectory() {
        return this.trajectory;
    }
    
}
