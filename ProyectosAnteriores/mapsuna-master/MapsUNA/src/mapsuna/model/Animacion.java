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
    private boolean enabled;
    private int[][] m;
    private int acarreo;
    private AnchorPane pane;
    private int x;
    private int y;
    private int costoFinal;
    private String puntoS;
    private String inicio;
    private String last;
    public Animacion() {
        camino = 1;
        enabled = true;
        cola = new LinkedList<>();
        colGra = new LinkedList<>();
        lineas = new ArrayList<>();
    }
    
    public void set(ArrayList<Double> lg,  AnchorPane p,ArrayList<Line> ln, ArrayList<Line> a, int[][] mat, String inic) {
        inicio = inic;
        Polyline l1 = new Polyline();
        Queue<Line> gl;
        acarreo = 0;
        costoFinal = 0;
        for (int i = 0; i < lg.size(); i+=4) {
            Polyline l = new Polyline();
            l.getPoints().addAll(new Double[]{lg.get(i), lg.get(i+1), lg.get(i+2), lg.get(i+3)});
            cola.add(l);
        }
        pane = p;
        m = mat;
        
        ln.forEach(x->colGra.add(x));
        
        ln.forEach(l->{
            BuscarVertice(l);
        });
        
        acarreo = 0;
        lineE = ln.get(0);
        enabled = true;
    }
    
    public Polyline saca() {
        Queue<Line> auxiliarQueue;
        Line auxiliarLine;
        Polyline p = cola.peek();
        if (!enabled) {
            lineE.setStyle("-fx-stroke: rgba(0, 255, 0,0.4);");
        }
       lineE = new Line(p.getPoints().get(0),p.getPoints().get(1),p.getPoints().get(2),p.getPoints().get(3));
        lineE = colGra.peek();
        BuscarVertice(lineE);
        
        colGra.remove();
        
        enabled = false;
        camino++;
        cola.remove();
        if (inicio.equals(Ruta(lineE).get(0).getId())) 
            inicio = Ruta(lineE).get(1).getId();
        else 
            inicio = Ruta(lineE).get(0).getId();
        
        puntoS= inicio;
        return p;
    }

    public Line getLineE() {
        lineE.setStyle("-fx-stroke: rgba(0, 255, 0,0.4);");
        return lineE;
    }
      public ArrayList<RadioButton> Ruta(Line l) {
        ArrayList<RadioButton> radios = new ArrayList<>();
        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radios.add(radio);
            }
        });
        
        ArrayList<RadioButton> conectadi = new ArrayList<>();
        radios.forEach(x -> {
            if ((x.getLayoutX() == l.getStartX() - 7 || x.getLayoutX() == l.getEndX() - 7)
                    && (x.getLayoutY() == l.getStartY() - 9 || x.getLayoutY() == l.getEndY() - 9)) {

                conectadi.add(x);
            }
        });
        return conectadi;
    }
    
    private void BuscarVertice(Line line) {
        ArrayList<RadioButton> radios = new ArrayList<>();
        ArrayList<RadioButton> conected = new ArrayList<>();

        pane.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radios.add(radio);
            }
        });
        radios.forEach(x -> {
            if ((x.getLayoutX() == line.getStartX() - 7 || x.getLayoutX() == line.getEndX() - 7)
                    && (x.getLayoutY() == line.getStartY() - 9 || x.getLayoutY() == line.getEndY() - 9)) {
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
    
  

    public int getFinalCost() {
        return costoFinal;
    }
    
    public void Restablecer() {
        while(!cola.isEmpty()) cola.remove();
        while(!colGra.isEmpty()) colGra.remove();
        enabled = true;
    }
     public int getAcarreo() {
        return acarreo;
    }
     
    public ArrayList<Line> getlinea() {
        return lineas;
    }
    
    public void setAcarreo(int acarreo) {
        this.acarreo = acarreo;
    }

        
    public String getPuntos() {
        return puntoS;
    }
    
    public Queue<Polyline> getQue() {
        return cola;
    }
            
    public boolean isEmpty() {
        return cola.isEmpty();
    }
    
    public void resetear() {
        camino = 1;
    }
    

}
