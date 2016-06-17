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
public interface Observable {
    public void addObserver(Observer obs);
    public void removeObserver();
    public void notifyObserver();
}
