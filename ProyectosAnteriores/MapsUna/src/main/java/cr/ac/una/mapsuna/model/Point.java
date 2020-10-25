/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.mapsuna.model;

import javafx.scene.Node;

/**
 *
 * @author engel
 */
public class Point {
    private int xPosition;
    private int yPosition;
    private String id;
    
    public Point() {
        xPosition = -1;
        yPosition = -1;
        id = "-1";
    }
    
    public void update(Node n) {
        xPosition = (int) ((n.getLayoutX()) + 7) ;
        yPosition = (int) ((n.getLayoutY()) + 9);
        id = n.getId();
    }
    
    public void update(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    
    public int getXPosition() {
        return xPosition;
    }
    
    public int getYPosition() {
        return yPosition;
    }
    
    public String getId() {
        return id;
    }
    
    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void print() {
        System.out.println(xPosition);
        System.out.println(yPosition);
        System.out.println(id);
    }
}
