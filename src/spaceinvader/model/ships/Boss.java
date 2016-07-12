/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import spaceinvader.controler.ObserverShot;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.movements.Moves;
import spaceinvader.model.movements.RightLeftMove;
import spaceinvader.model.movements.StraightMove;
import spaceinvader.model.projectiles.ClassicProjectileEnnemy;
import spaceinvader.model.projectiles.Projectile;
import spaceinvader.model.weapons.ClassicWeapon;

/**
 *
 * @author asus
 */
public abstract class Boss extends Alien{

    private int shotCounting = 0;
    private int charging = 200;
    
    public Boss(Moves moves, Rectangle body, Dimension ground, String imagePath, GameLevel level, int life, String secondSpriteRef) {
        super(moves, body, ground, imagePath, level, life, secondSpriteRef);
        this.weapon=new ClassicWeapon(false, 0);
    }
    
    public Boss(Dimension ground, GameLevel level){
        super(new StraightMove(), new Rectangle(171, 172), ground, "spaceinvader/view/classic_boss_brown.png", level, 30, "spaceinvader/view/classic_boss_brown_broken.png");
        this.weapon=new ClassicWeapon(false, 0);
    }

    @Override
    public boolean react() {
        super.react();
        this.move();
        if(this.charging<=0){
            this.charging = 200;
            for(int shot=1;shot<=5;shot++){
                shotCounting=shot;
                Projectile proj = this.shoot();
                if(proj != null){
                    proj.addObserver(new ObserverShot(getLevel()));
                    proj.setGround(this.getGround());
                    Point pos = this.getPosition();
                    pos.setLocation(pos.getX()+(this.getBody().width-proj.getBody().width)/2, pos.getY()+(this.getBody().height/2));
                    proj.setPosition(pos);
                    getLevel().addGameElementToList(proj);
                }
                
            }
        }else
            this.charging--;
        return true;
    }
    
    @Override
    public Projectile shoot() {
        Projectile shot = new ClassicProjectileEnnemy();
        switch(shotCounting){
            case 1:
                shot.setDx(2);
                shot.setDy(1.8);
                break;
                
            case 2:
                shot.setDx(1);
                shot.setDy(2);
                break;
                
            case 3:
                shot.setDx(0);
                shot.setDy(3);
                break;
                
            case 4:
                shot.setDx(-1);
                shot.setDy(2);
                break;
               
            case 5:
                shot.setDx(-2);
                shot.setDy(1.8);
                break;
                
            default:
                System.out.println(shotCounting+" chiffre inconnu");
                break;
        }
        shot.setDy(shot.getDy()*1.5);
        return shot;
    }

    @Override
    public void collidedWith(GameElement ge) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
