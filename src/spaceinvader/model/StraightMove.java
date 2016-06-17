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
public class StraightMove implements Moves{
    
    private Trajectory trajectory;
    
    public StraightMove(){
        this.trajectory = new Trajectory(0, 0, -6);
    }

    @Override
    public void updateTrajectory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public double nextPosX() {
        return trajectory.nextPosX();
    }

    @Override
    public double nextPosY() {
        return trajectory.nextPosY();
    }

    @Override
    public void invertTrajectory() {
        trajectory.invertTrajectory();
    }

    public Trajectory getTrajectory() {
        return trajectory;
    } 
    
}
