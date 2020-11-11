package mapauna.clases;
import java.util.ArrayList;
import java.util.List;

public class Floyd {

    private int traza[][];
    private int D[][];
    private int n;
    private List<Integer> road = new ArrayList<>();
    private int peso;

    public Floyd() {

    }

    public int getPeso() {
        return peso;
    }
    
    public void floyd(int n, GrafoMatriz g, int q, int r) {
        n = g.OnumeroDeVertices();
        D = new int[n][n];
        traza = new int[n][n];
        // matriz inicial es la de pesos.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = g.Ovalor(i, j);
                traza[i][j] = -1; // para decodificar los caminos
            }
        }

        int i, j, k;
        // Camino mínimo de un vértice a si mismo: 0
        for (i = 0; i < n; i++) {
            D[i][i] = 0;
        }
        /* En el caso de que no se realice esta inicialización el algoritmo
            obtiene en la diagonal los ciclos o bucles de longitud mínima */
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if ((D[i][k] + D[k][j]) < D[i][j]) // nuevo mínimo
                    {
                        D[i][j] = D[i][k] + D[k][j];
                        traza[i][j] = k;

                    }
                }
            }
        }
        System.out.println(q+" - "+r);
        recuperaCamino(q, r);
    }

    public void recuperaCamino(int i, int j) {
        road = new ArrayList<>();
        System.out.println(" camino para ir de " + i + " a " +j);
        this.peso=D[i][j];
        road.add(i);
        System.out.println(i);
        recupera(i, j);
        road.add(j);
        System.out.println(j);
    }

    ;
    public void recupera(int i, int j) {
        int k = traza[i][j];
        if (k != -1) {
            recupera(i, k);
            System.out.println(k);
            road.add(k);
            recupera(k, j);
        }
    }

    public List<Integer> getRoad() {
        return road;
    }

    public void setRoad(List<Integer> road) {
        this.road = road;
    }

}