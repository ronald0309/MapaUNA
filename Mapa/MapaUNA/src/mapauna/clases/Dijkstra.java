package mapauna.clases;
import java.util.ArrayList;
import java.util.List;

public class Dijkstra{
    public static final int NO_PARENT = -1;
    
    public static List<Vertice> evaluate(int[][] matrizPesos,int iniVertice, int finalVertice){
        int nVertices = matrizPesos[0].length;
        int[] DistanciasMasCortas = new int[nVertices];
        boolean[] revisados = new boolean[nVertices];
        
        for (int VerticeIndice = 0; VerticeIndice < nVertices; VerticeIndice++){
            DistanciasMasCortas[VerticeIndice] = Integer.MAX_VALUE;
            revisados[VerticeIndice] = false;
        }
        DistanciasMasCortas[iniVertice] = 0;
        int[] padres = new int[nVertices];
        padres[iniVertice] = NO_PARENT;
        for (int i = 1; i < nVertices; i++){
            int verticeCercano = -1;
            int DistanciaMasCorta = Integer.MAX_VALUE;
            for (int VerticeIndice = 0;VerticeIndice < nVertices; VerticeIndice++){
                if (!revisados[VerticeIndice] && DistanciasMasCortas[VerticeIndice] < DistanciaMasCorta){
                    verticeCercano = VerticeIndice;
                    DistanciaMasCorta = DistanciasMasCortas[VerticeIndice];
                }
            }
            revisados[verticeCercano] = true;
            for (int VerticeIndice = 0;VerticeIndice < nVertices;VerticeIndice++){
                int PesoArista = matrizPesos[verticeCercano][VerticeIndice];
                
                if (PesoArista > 0 && ((DistanciaMasCorta + PesoArista) <  DistanciasMasCortas[VerticeIndice])){
                    padres[VerticeIndice] = verticeCercano;
                    DistanciasMasCortas[VerticeIndice] = DistanciaMasCorta + PesoArista;
                }
            }
        }
        return solution(iniVertice, DistanciasMasCortas, padres, finalVertice);
    }
    public static List<Vertice> solution(int iniVertice,int[] distances,int[] padres, int finalVertice){
        List<Vertice> road = new ArrayList<>();
        int peso = -1;
        int nVertices = distances.length;
        for (int VerticeIndice = 0;VerticeIndice < nVertices; VerticeIndice++){
            if (VerticeIndice != iniVertice){
                if(VerticeIndice == finalVertice) peso = distances[VerticeIndice];
                path(VerticeIndice,VerticeIndice, padres,finalVertice, road);
            }
        }
        return road;
    }
    public static void path(int verticeInicial,int VerticeIndice,int[] padres, int finalVertice, List<Vertice> road){
        if( verticeInicial == NO_PARENT ) return;
        path(padres[verticeInicial],VerticeIndice, padres, finalVertice, road);
        if( VerticeIndice == finalVertice ) road.add(new Vertice(verticeInicial));
    }
    
}