package mapauna.clases;
import java.util.ArrayList;
import java.util.List;

public class Floyd {
    
    public static List<Vertice> evaluate(int[][] matrizPesos, int ini, int fin) {
        int traza[][];
        int D[][];
        int n = matrizPesos[0].length;
        D = new int[n][n];
        traza = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = matrizPesos[i][j];
                traza[i][j] = -1;
            }
        }
        int i, j, k;
        for (i = 0; i < n; i++) {
            D[i][i] = 0;
        }
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    /*
                    if (((matPesos[y][x] + matPesos[x][c]) < matPesos[y][c])) {
                        this.matPesos[y][c] = (matPesos[y][x] + matPesos[x][c]);
                        this.matRecorrido[y][c] = matRecorrido[y][x];
                    }
                    */
                    if ((D[i][k] + D[k][j]) < D[i][j]){
                        D[i][j] = D[i][k] + D[k][j];
                        traza[i][j] = k;

                    }
                }
            }
        }
        return recuperaCamino(ini, fin, traza);
    }

    public static List<Vertice> recuperaCamino(int i, int j, int[][] traza) {
        List<Vertice> road = new ArrayList<>();
        //int peso=D[i][j];
        road.add(new Vertice(i));
        recupera(i, j, traza, road);
        road.add(new Vertice(j));
        return road;
    }

    ;
    public static void recupera(int i, int j, int[][] traza, List<Vertice> road) {
        int k = traza[i][j];
        if (k != -1) {
            recupera(i, k, traza, road);
            //road.add(new Vertice(k));
            recupera(k, j, traza, road);
        }
    }

}