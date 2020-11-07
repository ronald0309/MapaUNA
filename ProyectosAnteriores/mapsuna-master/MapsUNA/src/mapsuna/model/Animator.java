/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapsuna.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

/**
 *
 * @author engel
 */
public class Animator {
    
    private Queue<Polyline> queue;
    private int way;
    private Polyline origin;
    private ArrayList<Line> lines;
    private Line delayLine;
    private Queue<Line> graphicQueue;
    private boolean lock;
    private int[][] m;
    private int currentCost;
    private AnchorPane pane;
    private int x;
    private int y;
    private int finalCost;
    private String nextPoint;
    private String init;
    private String last;
    public Animator() {
        way = 1;
        lock = true;
        queue = new LinkedList<>();
        graphicQueue = new LinkedList<>();
        Polyline l = new Polyline();
        Polyline l1 = new Polyline();
        lines = new ArrayList<>();
    }
    
    public void set(ArrayList<Double> logics, ArrayList<Line> lines, ArrayList<Line> aux, 
            AnchorPane pane, int[][] m, String init) {
        this.init = init;
        Polyline l1 = new Polyline();
        Queue<Line> gl;
        currentCost = 0;
        finalCost = 0;
        for (int i = 0; i < logics.size(); i+=4) {
            Polyline l = new Polyline();
            l.getPoints().addAll(new Double[]{logics.get(i),
                                                logics.get(i+1),
                                                logics.get(i+2),
                                                logics.get(i+3)});
            queue.add(l);
        }
        this.pane = pane;
        this.m = m;
        
        lines.forEach(x->graphicQueue.add(x));
        
        lines.forEach(l->{
            searchNode(l);
        });
        
        currentCost = 0;
        delayLine = lines.get(0);
        lock = true;
    }
    
    public Polyline pop() {
        Queue<Line> auxiliarQueue;
        Line auxiliarLine;
        Polyline p = queue.peek();
        if (!lock) {
            delayLine.setStyle("-fx-stroke: rgba(0, 255, 0,0.4);");
        }
        Line l = new Line(p.getPoints().get(0),
                        p.getPoints().get(1),
                        p.getPoints().get(2),
                        p.getPoints().get(3));
        delayLine = graphicQueue.peek();
        searchNode(l);
        
        graphicQueue.remove();
        
        lock = false;
        way++;
        queue.remove();
        if (init.equals(search(l).get(0).getId())) {
            init = search(l).get(1).getId();
        }
        else {
            
            init = search(l).get(0).getId();
        }
        nextPoint= init;
        
        return p;
    }
    
    public Line getDelayLine() {
        delayLine.setStyle("-fx-stroke: rgba(0, 255, 0,0.4);");
        return delayLine;
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public void resetWay() {
        way = 1;
    }
    
    private void searchNode(Line l) {
        ArrayList<RadioButton> radios = new ArrayList<>();
        ArrayList<RadioButton> conected = new ArrayList<>();

        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radios.add(radio);
            }
        });

        radios.forEach(x -> {
            if ((x.getLayoutX() == l.getStartX() - 7 || x.getLayoutX() == l.getEndX() - 7)
                    && (x.getLayoutY() == l.getStartY() - 9 || x.getLayoutY() == l.getEndY() - 9)) {

                conected.add(x);
            }
        });
        x =Integer.valueOf(conected.get(0).getId().replaceAll("\\D+", ""));
        y =Integer.valueOf(conected.get(1).getId().replaceAll("\\D+", ""));
        x--;
        y--;
        currentCost = currentCost + m[x][y];
        finalCost = finalCost + m[x][y];
    }
    
    public ArrayList<RadioButton> search(Line l) {
        ArrayList<RadioButton> radios = new ArrayList<>();
        ArrayList<RadioButton> conected = new ArrayList<>();

        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radios.add(radio);
            }
        });

        radios.forEach(x -> {
            if ((x.getLayoutX() == l.getStartX() - 7 || x.getLayoutX() == l.getEndX() - 7)
                    && (x.getLayoutY() == l.getStartY() - 9 || x.getLayoutY() == l.getEndY() - 9)) {

                conected.add(x);
            }
        });
        return conected;
    }
    
    public int getCurrentCost() {
        return currentCost;
    }
    
    public void setCurrentCost(int currentCost) {
        this.currentCost = currentCost;
    }
    public int getFinalCost() {
        return finalCost;
    }
    
    public void reset() {
        while(!queue.isEmpty()) queue.remove();
        while(!graphicQueue.isEmpty()) graphicQueue.remove();
        lock = true;
    }
    
    public ArrayList<Line> getLines() {
        return lines;
    }
    
    public Queue<Polyline> getQ() {
        return queue;
    }
    
    public String getNextPoint() {
        return nextPoint;
    }
}
