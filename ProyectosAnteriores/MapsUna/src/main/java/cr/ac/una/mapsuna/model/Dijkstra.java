package cr.ac.una.mapsuna.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jona
 */
public class Dijkstra {

    static final int dim = 80;
    final int V = 80;
    final int NO_PARENT = -1;
    List<String> ruta = new ArrayList<>();
    private int[][] matPeso = new int[80][80];
    List<String> lista = new ArrayList<String>();
    private int costoTotal;
    private long iniTime;
    private long resultTime;
    public void dijkstra(int origen, int destino) {
        iniTime = System.nanoTime();
        lista = new ArrayList<String>();
        int nVertices = matPeso[0].length;
        int[] shortestDistances = new int[nVertices];
        boolean[] added = new boolean[nVertices];
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        shortestDistances[origen] = 0;

        int[] parents = new int[nVertices];

        parents[origen] = NO_PARENT;

        for (int i = 1; i < nVertices; i++) {
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            added[nearestVertex] = true;

            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                int edgeDistance = matPeso[nearestVertex][vertexIndex];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }
        printSolution(origen, shortestDistances, parents, destino);
        resultTime =  System.nanoTime() - iniTime;
    }

    private void printSolution(int origen, int[] distances, int[] parents, int destino) {
        int nVertices = distances.length;
//        System.out.print("Vertex\t Distance\tPath");
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            if (vertexIndex != origen) {
                if (vertexIndex == destino) {
                    boolean primera = false;
                    costoTotal = distances[vertexIndex];
//                    System.out.print("\n" + origen + " -> ");
//                    System.out.print(vertexIndex + " \t\t ");
//                    System.out.print(distances[vertexIndex] + "\t\t");
                    printPath(vertexIndex, parents, primera);
                }

            }
        }
    }

    private void printPath(int currentVertex, int[] parents, boolean primera) {
//            System.out.print(currentVertex + " "); 
        if (!primera) {
            this.lista.add(String.valueOf(currentVertex));

        }
        primera = true;
        if (currentVertex == NO_PARENT) {
            return;
        }
        int nodo = parents[currentVertex];
        if (nodo != -1) {
            this.lista.add(String.valueOf(nodo));
        }

        printPath(parents[currentVertex], parents, primera);
//            System.out.print(currentVertex + " "); 

    }

    private void printSolution(int dist[], int n) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " tt " + dist[i]);
        }
    }

    private int distanciaMinima(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public int[][] getMatPeso() {
        return matPeso;
    }

    public void setMatPeso(int[][] matPeso) {
        this.matPeso = matPeso;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
    
    public List<String> retornaLista(){
        Collections.reverse(lista);
        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, String.valueOf("A"+((Integer.parseInt(lista.get(i)+1)))));
        }
        return lista;
    } 

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public long getResultTime() {
        return resultTime;
    }

    public void setResultTime(long resultTime) {
        this.resultTime = resultTime;
    }
    
}
