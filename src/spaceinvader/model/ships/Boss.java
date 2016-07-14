/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.model.ships;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import spaceinvader.controler.ObserverShot;
import spaceinvader.model.GameElement;
import spaceinvader.model.GameLevel;
import spaceinvader.model.movements.CircularMove;
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
    private boolean isInvicible = true;
    
    public Boss(Moves moves, Rectangle body, Dimension ground, String imagePath, GameLevel level, int life, String secondSpriteRef) {
        super(moves, body, ground, imagePath, level, life, secondSpriteRef);
        this.weapon=new ClassicWeapon(false, 0);
    }
    
    public Boss(Dimension ground, GameLevel level){
        super(new StraightMove(), new Rectangle(220, 220), ground, "spaceinvader/view/classic_boss_brown.png", level, 30, "spaceinvader/view/classic_boss_brown_broken.png");
        this.weapon=new ClassicWeapon(false, 0);
    }

    @Override
    public boolean react() {
        super.react();
        this.move();
        if(this.charging<=0){
            this.charging = 200;
            this.shoot();     
        }else
            this.charging--;
        return true;
    }
    
    @Override
    public ArrayList<Projectile> shoot() {
        Projectile shot;
        ArrayList<Projectile> projs = new ArrayList<Projectile>();
        for(int counter=1;counter<=5;counter++){
            shot = new ClassicProjectileEnnemy();
            switch(counter){
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
            if(shot != null){
                shot.addObserver(new ObserverShot(getLevel()));
                shot.setGround(this.getGround());
                Point pos = this.getPosition();
                pos.setLocation(pos.getX()+(this.getBody().width-shot.getBody().width)/2, pos.getY()+(this.getBody().height/2));
                shot.setPosition(pos);
                getLevel().addGameElementToList(shot);
            }
            projs.add(shot);
        }
        
        return projs;
    }

    @Override
    public void hurt(int value) {
        if(!isInvicible){
            this.life -= value;
            this.counterHit = 15;
            swapSprites();
        }  
    }

    
    
    @Override
    public void collidedWith(GameElement ge) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void IsInvicible(boolean isInvicible) {
        this.isInvicible = isInvicible;
    }
    
}
