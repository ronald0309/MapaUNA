package mapauna.clases;
import java.util.ArrayList;
import java.util.List;


public class Dijkstra{
  
    public Dijkstra(){
        
    }
    public final int NO_PARENT = -1; 
  

    public void dijkstra(int[][] matrizPesos,int iniVertice, int finalVertice){ 
        int nVertices = matrizPesos[0].length; //83
  
        // DistanciasMasCortas[i] guarda
        // distancia mas corta desde el origen hasta i
        int[] DistanciasMasCortas = new int[nVertices];
  

        boolean[] revisados = new boolean[nVertices];

        for (int VerticeIndice = 0; VerticeIndice < nVertices; VerticeIndice++){ 
            DistanciasMasCortas[VerticeIndice] = Integer.MAX_VALUE; 
            revisados[VerticeIndice] = false; 
        } 

        DistanciasMasCortas[iniVertice] = 0;
  
        // Arreglo de nodos padre mas cercanos
        int[] padres = new int[nVertices];
  
        // El nodo inicial
        // no tiene padre
        padres[iniVertice] = NO_PARENT; 
  
        // Encuentra el camino mas corto hacia todos los nodos 
        // desde el nodo inicial
        for (int i = 1; i < nVertices; i++){ 
            // selecciono el vertice con nodo con minima distancia 
            // en los vertices que aun no han sido procesados
            // la varuable verticeCercano es  
            // igaul al nodo inicial en la primera iteracion 
            // first iteration. 
            int verticeCercano = -1; 
            int DistanciaMasCorta = Integer.MAX_VALUE; 
            for (int VerticeIndice = 0;VerticeIndice < nVertices; VerticeIndice++){ 
                if (!revisados[VerticeIndice] && DistanciasMasCortas[VerticeIndice] < DistanciaMasCorta){ 
                    verticeCercano = VerticeIndice; 
                    DistanciaMasCorta = DistanciasMasCortas[VerticeIndice]; 
                } 
            } 
  
            // se marca el nodo seleccionado 
            // como procesado 
            revisados[verticeCercano] = true; 
  
            // actualiza el valor de la arista 
            // de los nodos adyacentes
            // al nodo seleccionado. 
            for (int VerticeIndice = 0;VerticeIndice < nVertices;VerticeIndice++){ 
                int PesoArista = matrizPesos[verticeCercano][VerticeIndice]; 
                  
                if (PesoArista > 0 && ((DistanciaMasCorta + PesoArista) <  DistanciasMasCortas[VerticeIndice])){ 
                    padres[VerticeIndice] = verticeCercano; 
                    DistanciasMasCortas[VerticeIndice] = DistanciaMasCorta + PesoArista; 
                } 
            } 
        } 
  
        printSolution(iniVertice, DistanciasMasCortas, padres, finalVertice); 
    } 
    
    //Imprime todas las rutas mas cortas del vertice inical a todos los demas vertices
    public void printSolution(int iniVertice,int[] distances,int[] padres, int finalVertice) 
    { 
        int nVertices = distances.length; 
        System.out.print("Vertex\t Distance\tPath"); 
          
        for (int VerticeIndice = 0;VerticeIndice < nVertices; VerticeIndice++){
            if (VerticeIndice != iniVertice){ 
                System.out.print("\n" + iniVertice + " -> "); 
                System.out.print(VerticeIndice + " \t\t "); 
                System.out.print(distances[VerticeIndice] + "\t\t"); //distancia hacia el vertice i
                if(VerticeIndice == finalVertice){
                    peso = distances[VerticeIndice];
                }
                printPath(VerticeIndice,VerticeIndice, padres,finalVertice);
            } 
        } 
    } 
  
    //Arreglo que almacena la ruta mas corta desde el nodo inicial al nodo final enviados
    private List<Integer> road = new ArrayList<>();
    private int peso = -1;
    
    // Funcion que imprime el camino mas corto
    // desd el origen al nodo final enviado por parametro
    // usando el arreglo de padres
    public void printPath(int verticeInicial,int VerticeIndice,int[] padres, int finalVertice ){ 
        
        if (verticeInicial == NO_PARENT){
            return; 
        } 
        printPath(padres[verticeInicial],VerticeIndice, padres,finalVertice);
        System.out.print(verticeInicial + " "); 
        
        if(VerticeIndice == finalVertice){
            road.add(verticeInicial);
        }
    } 

    public List<Integer> getRoad() {
        return road;
    }

    public void setRoad(List<Integer> road) {
        this.road = road;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}