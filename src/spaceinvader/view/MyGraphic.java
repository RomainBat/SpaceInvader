/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvader.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author qmatejka
 */
public class MyGraphic {
    
    private Rectangle rect;
    private Point location ; 
    private Dimension dimension;
    private Dimension dimensionPanel;
    private Color fillcolor ; 
    private Color boundcolor ;
    private String myImagePath;

    public MyGraphic(Point coordinate, Dimension dimension, Color Fillcolor, Color boundcolor, String image){ 
        this.rect= new Rectangle(coordinate, dimension); 
        this.fillcolor=Fillcolor;  	
        this.boundcolor=boundcolor;  	
        this.location=coordinate; 
        this.dimension=dimension;
        this.myImagePath=image;
    } 
    
    public void setDimensionPanel(Dimension dimension) {
            this.dimensionPanel = dimension;
    }

    public Point getCoordinate() {
            return location;
    }

    public void setCoordinate(Point coordinate) {
            if((coordinate.x>0 && coordinate.x+dimension.width<=dimensionPanel.width)&&(coordinate.y>0 && coordinate.y+dimension.height<=dimensionPanel.height))
                    this.location = coordinate;
    }

    public Dimension getDimension() {
            return dimension;
    }

    public void setDimension(Dimension dimension) {
            this.dimension = dimension;
    }

    public Color getFillcolor() {
            return fillcolor;
    }

    public void setFillcolor(Color fillcolor) {
            this.fillcolor = fillcolor;
    }

    public String getMyImagePath() {
        return myImagePath;
    }
    
}
