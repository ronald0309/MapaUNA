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
public class Animacion {
    
    private Queue<Polyline> cola;
    private int camino;
    private ArrayList<Line> lineas;
    private Line lineE;
    private Queue<Line> colGra;
    private boolean enable;
    private int[][] m;
    private int acarreo;
    private AnchorPane pane;
    private int x;
    private int y;
    private int costoFinal;
    private String puntos;
    private String inicio;
    private String last;
    public Animacion() {
        camino = 1;
        enable = true;
        cola = new LinkedList<>();
        colGra = new LinkedList<>();
        lineas = new ArrayList<>();
    }
    
    public void set(ArrayList<Double> logics, ArrayList<Line> lines, ArrayList<Line> aux, 
            AnchorPane pane, int[][] m, String init) {
        this.inicio = init;
        Polyline l1 = new Polyline();
        Queue<Line> gl;
        acarreo = 0;
        costoFinal = 0;
        for (int i = 0; i < logics.size(); i+=4) {
            Polyline l = new Polyline();
            l.getPoints().addAll(new Double[]{logics.get(i),
                                                logics.get(i+1),
                                                logics.get(i+2),
                                                logics.get(i+3)});
            cola.add(l);
        }
        this.pane = pane;
        this.m = m;
        
        lines.forEach(x->colGra.add(x));
        
        lines.forEach(l->{
            searchNode(l);
        });
        
        acarreo = 0;
        lineE = lines.get(0);
        enable = true;
    }
    
    public Polyline pop() {
        Queue<Line> auxiliarQueue;
        Line auxiliarLine;
        Polyline p = cola.peek();
        if (!enable) {
            lineE.setStyle("-fx-stroke: rgba(0, 255, 0,0.4);");
        }
        Line l = new Line(p.getPoints().get(0),
                        p.getPoints().get(1),
                        p.getPoints().get(2),
                        p.getPoints().get(3));
        lineE = colGra.peek();
        searchNode(l);
        
        colGra.remove();
        
        enable = false;
        camino++;
        cola.remove();
        if (inicio.equals(search(l).get(0).getId())) {
            inicio = search(l).get(1).getId();
        }
        else {
            
            inicio = search(l).get(0).getId();
        }
        puntos= inicio;
        
        return p;
    }
    
    public Line getDelayLine() {
        lineE.setStyle("-fx-stroke: rgba(0, 255, 0,0.4);");
        return lineE;
    }
    
    public boolean isEmpty() {
        return cola.isEmpty();
    }
    
    public void Resetear() {
        camino = 1;
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
        acarreo = acarreo + m[x][y];
        costoFinal = costoFinal + m[x][y];
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
    
    public int getAcarreo() {
        return acarreo;
    }
    
    public void setAcarreo(int acarreo) {
        this.acarreo = acarreo;
    }
    public int getFinalCost() {
        return costoFinal;
    }
    
    public void Restablecer() {
        while(!cola.isEmpty()) cola.remove();
        while(!colGra.isEmpty()) colGra.remove();
        enable = true;
    }
    
    public ArrayList<Line> getLines() {
        return lineas;
    }
    
    
    public String getPuntos() {
        return puntos;
    }
}
