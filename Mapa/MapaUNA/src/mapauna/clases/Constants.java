/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapauna.clases;

/**
 *
 * @author natal
 */
public class Constants{
    public static enum Algoritmo {
        FLOYD,
        DIJKSTRA
    }
    public static enum Clase {
        CERRADO("cerrado"),
        ACCIDENTE("accidente"),
        PROVISIONAL("provisional"),
        CAMINO("camino");
        
        private final String name;
        Clase(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
    
}
