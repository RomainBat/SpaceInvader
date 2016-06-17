/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.movements;

/**
 *
 * @author qmatejka
 */
public class Trajectory {
    
    private double gravity;
    private double dX;
    private double dY;

    public Trajectory(double gravity, double dX, double dY) {
        this.gravity = gravity;
        this.dX = dX;
        this.dY = dY;
    }

    public double nextPosX(){
        return dX;
    }
    
    public double nextPosY(){
        return dY+gravity;
    }
    
    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getdX() {
        return dX;
    }

    public void setdX(double dX) {
        this.dX = dX;
    }

    public double getdY() {
        return dY;
    }

    public void setdY(double dY) {
        this.dY = dY;
    }
    
    public void invertTrajectory(){
        this.dX *= -1;
        this.dY *= -1;
    }
}
