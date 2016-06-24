/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.view;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author qmatejka
 */
public class SpriteStore {
    
    private static SpriteStore store = new SpriteStore();
    private HashMap sprites = new HashMap();
    
    public static SpriteStore getStore(){
        return store;
    }
    
    public Sprite getSprite(String ref){
        if(sprites.get(ref) != null){
            return (Sprite)sprites.get(ref);
        }else{
            BufferedImage sourceImage = null;
            
            try {     
                URL url = this.getClass().getClassLoader().getResource(ref);
			
                if (url == null) {
                        System.err.println("Can't find ref: "+ref);
                }

                // use ImageIO to read the image in

                sourceImage = ImageIO.read(url);

                //sourceImage = ImageIO.read(new File("src/spaceinvader/view/classic_alien.png"));
            } catch (IOException ex) {
                Logger.getLogger(SpriteStore.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.BITMASK);
            image.getGraphics().drawImage(sourceImage, 0, 0, null);
            
            Sprite sprite = new Sprite(image);
            sprites.put(ref, sprite);
            return sprite;
        }    
    }
    
}
