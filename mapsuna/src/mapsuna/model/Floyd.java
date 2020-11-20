package mapsuna.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class Floyd {

    private String[][] matRecorrido = new String[80][80];
    private int[][] matPesos = new int[80][80];
    private List<String> ruta;
    private LocalDateTime ini;
    private LocalDateTime result;
    private long iniTime;
    private long resultTime;
    

    public Floyd() {
    }

    public int obtenerCostoPrevio(String origen, String destino){
        int result;
        int fila = Integer.valueOf(origen.replaceAll("\\D+", ""));
        int col = Integer.valueOf(destino.replaceAll("\\D+", ""));
        result = matPesos[fila-1][col-1];
        return result;
    }
    
    public void floyd() {
        iniTime = System.nanoTime();
        ini = LocalDateTime.now();
        matRecorridoDefault();//inicializar la matriz de recorridos
        for (int x = 0; x < matPesos.length; x++) {
            for (int y = 0; y < matPesos.length; y++) {
                for (int c = 0; c < matPesos.length; c++) {
                    if (((matPesos[y][x] + matPesos[x][c]) < matPesos[y][c])) {
                        this.matPesos[y][c] = (matPesos[y][x] + matPesos[x][c]);
                        this.matRecorrido[y][c] = matRecorrido[y][x];
                    }
                }
            }
        }
        resultTime =  System.nanoTime() - iniTime;
        
    }

    public List<String> obtenerRuta(String origen, String destino) {
        List<String> path = new ArrayList<>();
        path.add(origen);
        int fila = Integer.valueOf(origen.replaceAll("\\D+", ""));
        int col = Integer.valueOf(destino.replaceAll("\\D+", ""));
        boolean finalizado = false;
        while (!finalizado) {
            String busqueda = matRecorrido[fila - 1][col - 1];
            path.add(busqueda);
            fila = Integer.valueOf(busqueda.replaceAll("\\D+", ""));
            if (busqueda.equals(destino)) {
                finalizado = true;
            }
        }
        return path;
    }

    private void matRecorridoDefault() {
        int num = 1;
        for (int i = 0; i < matPesos.length; i++) {
            for (int j = 0; j < matPesos.length; j++) {
                matRecorrido[j][i] = "A" + num;
            }
            num += 1;
        }
    }

    public String[][] getMatRecorrido() {
        return matRecorrido;
    }

    public void setMatRecorrido(String[][] matRecorrido) {
        this.matRecorrido = matRecorrido;
    }

    public int[][] getMatPesos() {
        return matPesos;
    }

    public void setMatPesos(int[][] matPesos) {
        this.matPesos = matPesos;
    }

    public Floyd(List<String> ruta) {
        this.ruta = ruta;
    }

    public long getResultTime() {
        return resultTime;
    }

    public void setResultTime(long resultTime) {
        this.resultTime = resultTime;
    }
    
    

}
