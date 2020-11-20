package mapauna.clases;

import java.util.ArrayList;
import java.util.List;

public class GrafoMatriz {

    private int maxVerts; // máximo numero de vértices
    private int numVerts; // número de vértices actual
    private List<Vertice> verts; // array de vértices
    private int matAd[][]; // matriz de adyacencia
    public static final int INF = -1;

    public GrafoMatriz(int mx) {
        maxVerts = mx;
        verts = new ArrayList<>(); // vector de vértices
        matAd = new int[mx][mx]; // vector de punteros
        numVerts = mx;
        //Debe estar fuera de la clase
        inicializar_matriz();
        inicializar_vertices();
    }

    public int OnumeroDeVertices() {
        return numVerts;
    }

    public void PnumeroDeVertices(int numVerts) {
        this.numVerts = numVerts;
    }

    public int getMaxVerts() {
        return maxVerts;
    }

    public void setMaxVerts(int maxVerts) {
        this.maxVerts = maxVerts;
    }

    public List<Vertice> getVerts() {
        return verts;
    }

    public void setVerts(List<Vertice> verts) {
        this.verts = verts;
    }

    public int[][] getMatAd() {
        return matAd;
    }

    public void setMatAd(int[][] matAd) {
        this.matAd = matAd;
    }

    public void nuevoVertice(String nom) {
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            verts.add(new Vertice(nom, numVerts));
            // No se comprueba que sobrepase el máximo
        }
    }

    public int numVertice(String vn) {
        return verts.stream()
                .reduce(new Vertice(), (v, a) -> v.getNombre().equals(vn) ? v : a)
                .getNumero();
    }
    public void setArco(Vertice origen, Vertice destino, int peso) {
        matAd[origen.getNumero()][destino.getNumero()] = peso;
    }
    
    public int getArco(Vertice origen, Vertice destino) {
        return matAd[origen.getNumero()][destino.getNumero()];
    }

    public void nuevoArco(String a, String b) {
        int va,
         vb;
        va  = numVertice(a);
        vb = numVertice(b);
        if (va  <= 0 || vb <= 0) {
            matAd[va][vb] = 1;
        }
    }

    public void nuevoArco(int va, int vb, int valor) {
        if (va  >= 0 || vb >= 0 || va  < numVerts || vb < numVerts) {
            matAd[va][vb] = valor;
        }
    }

    public boolean adyacente(String a, String b) {
        int va,
         vb;
        va  = numVertice(a);
        vb = numVertice(b);
        if (va  >= 0 || vb >= 0) {
            return matAd[va][vb] == 1;
        }
        return false;
    }

    public boolean adyacente(int va, int vb) {
        if (va  >= 0 || vb >= 0 || va  < numVerts || vb < numVerts) {
            return true;
        }
        return false;
    }

    public int Ovalor(String a, String b) {
        int va,
         vb;
        va  = numVertice(a);
        vb = numVertice(b);
        if (va  >= 0 || vb >= 0) {
            return matAd[va][vb];
        }
        return -1;
    }

    public int Ovalor(int va, int vb) {
        if (va  >= 0 && vb >= 0 && va  < numVerts && vb < numVerts) {
            return matAd[va][vb];
        } else {
            return 0;
        }

    }

    public void Pvalor(int va, int vb, int v) {
        if (va  >= 0 || vb >= 0 || va  < numVerts || vb < numVerts) {
            matAd[va][vb] = v;
        }
    }

    public void Pvalor(String a, String b, int v) {
        int va,
         vb;
        va  = numVertice(a);
        vb = numVertice(b);
        if (va  >= 0 && vb >= 0) {
            matAd[va][vb] = v;
        }
    }

    Vertice Overtice(int va)
     {
        return verts.get(va);
    }

    void Pvertice(int va, Vertice vert) {
        verts.set(va, vert);
    }

    private void inicializar_vertices() {
        for (int i = 0; i < maxVerts; i++) {
            verts.add(new Vertice(i));
        }
    }

    private void inicializar_matriz() {
        for (int i = 0; i < maxVerts; i++) {
            for (int j = 0; j < maxVerts; j++) {
                matAd[i][j] = INF;
            }
        }
        inicializarPesos();
    }

    private void inicializarPesos() {//arreglar matriz
        matAd[0][1] = 4;
        matAd[0][24] = 6;

        matAd[1][0] = 4;
        matAd[1][25] = 1;
        matAd[1][2] = 4;

        matAd[2][1] = 4;
        matAd[2][3] = 1;
        matAd[2][26] = 3;

        matAd[3][2] = 1;
        matAd[3][28] = 1;
        matAd[3][4] = 3;

        matAd[4][3] = 3;
        matAd[4][32] = 1;
        matAd[4][5] = 2;

        matAd[5][4] = 2;
        matAd[5][6] = 1;

        matAd[6][5] = 1;
        matAd[6][48] = 2;
        matAd[6][7] = 2;

        matAd[7][6] = 2;
        matAd[7][56] = 1;
        matAd[7][8] = 1;

        matAd[8][7] = 1;
        matAd[8][67] = 3;
        matAd[8][9] = 2;

        matAd[9][8] = 2;
        matAd[9][74] = 1;
        matAd[9][10] = 4;

        matAd[10][9] = 4;
        matAd[10][11] = 12;

        matAd[11][10] = 12;
        matAd[11][12] = 2;
        matAd[11][84] = 2;

        matAd[12][11] = 2;
        matAd[12][78] = 5;
        matAd[12][13] = 2;

        matAd[13][14] = 1;
        matAd[13][80] = 4;

        matAd[14][13] = 1;
        matAd[14][15] = 4;

        matAd[15][14] = 4;
        matAd[15][80] = 2;
        matAd[15][16] = 2;

        matAd[16][15] = 2;
        matAd[16][17] = 2;

        matAd[17][16] = 2;
        matAd[17][18] = 2;

        matAd[18][17] = 2;
        matAd[18][19] = 2;

        matAd[19][18] = 2;
        matAd[19][20] = 1;
        matAd[19][47] = 4;

        matAd[20][19] = 1;
        matAd[20][21] = 5;

        matAd[21][20] = 6;
        matAd[21][22] = 2;
        matAd[21][39] = 2;

        matAd[22][21] = 2;
        matAd[22][23] = 3;

        matAd[23][22] = 3;
        matAd[23][30] = 3;
        matAd[23][24] = 2;

        matAd[24][23] = 2;
        matAd[24][27] = 2;
        matAd[24][0] = 6;

        matAd[25][1] = 1;
        matAd[25][26] = 1;

        matAd[26][25] = 1;
        matAd[26][2] = 3;
        matAd[26][27] = 2;

        matAd[27][26] = 2;
        matAd[27][28] = 2;
        matAd[27][29] = 2;
        matAd[27][24] = 2;

        matAd[28][27] = 2;
        matAd[28][3] = 1;

        matAd[29][27] = 2;
        matAd[29][30] = 2;

        matAd[30][29] = 2;
        matAd[30][36] = 2;
        matAd[30][35] = 2;

        matAd[31][28] = 2;

        matAd[32][4] = 1;

        matAd[33][31] = 1;
        matAd[33][34] = 1;

        matAd[34][35] = 1;
        matAd[34][44] = 2;

        matAd[35][34] = 1;
        matAd[35][45] = 2;

        matAd[36][22] = 1;
        matAd[36][30] = 2;

        matAd[37][36] = 2;
        matAd[37][35] = 2;

        matAd[38][37] = 1;

        matAd[39][38] = 1;
        matAd[39][47] = 2;

        matAd[40][37] = 1;
        matAd[40][41] = 1;

        matAd[41][38] = 1;

        matAd[42][5] = 2;
        matAd[42][48] = 1;

        matAd[43][42] = 2;
        matAd[43][33] = 2;

        matAd[44][36] = 2;
        matAd[44][43] = 1;

        matAd[45][44] = 1;
        matAd[45][50] = 2;

        matAd[46][45] = 2;
        matAd[46][40] = 1;
        matAd[46][52] = 2;

        matAd[47][46] = 2;
        matAd[47][53] = 2;

        matAd[48][42] = 1;
        matAd[48][49] = 2;
        matAd[48][57] = 2;

        matAd[49][43] = 2;
        matAd[49][50] = 2;

        matAd[50][49] = 1;
        matAd[50][60] = 2;

        matAd[51][52] = 1;

        matAd[52][46] = 2;
        matAd[52][53] = 2;

        matAd[53][63] = 2;
        matAd[53][54] = 2;

        matAd[54][18] = 2;

        matAd[55][65] = 1;

        matAd[56][7] = 1;
        matAd[56][66] = 1;
        matAd[56][57] = 1;

        matAd[57][56] = 1;
        matAd[57][48] = 2;
        matAd[57][58] = 1;

        matAd[58][59] = 2;
        matAd[58][57] = 1;
        matAd[58][63] = 3;

        matAd[59][49] = 2;
        matAd[59][58] = 2;
        matAd[59][60] = 2;
        matAd[59][69] = 3;

        matAd[60][59] = 2;
        matAd[60][61] = 1;
        matAd[60][70] = 3;

        matAd[61][60] = 1;
        matAd[61][51] = 2;
        matAd[61][62] = 1;

        matAd[62][63] = 3;
        matAd[62][61] = 1;

        matAd[63][62] = 3;
        matAd[63][64] = 2;
        matAd[63][72] = 2;

        matAd[64][63] = 2;
        matAd[64][65] = 1;
        matAd[64][54] = 2;

        matAd[65][55] = 1;
        matAd[65][17] = 1;

        matAd[66][56] = 1;

        matAd[67][8] = 3;
        matAd[67][75] = 2;
        matAd[67][68] = 2;

        matAd[68][58] = 3;
        matAd[68][67] = 2;
        matAd[68][76] = 2;
        matAd[68][69] = 1;

        matAd[69][59] = 3;
        matAd[69][63] = 1;
        matAd[69][70] = 2;
        matAd[69][83] = 4;

        matAd[70][60] = 3;
        matAd[70][69] = 2;
        matAd[70][81] = 3;

        matAd[71][62] = 3;
        matAd[71][72] = 3;
        matAd[71][77] = 2;

        matAd[72][73] = 2;
        matAd[72][78] = 2;

        matAd[73][64] = 2;

        matAd[74][9] = 1;

        matAd[75][67] = 2;

        matAd[76][68] = 2;

        matAd[77][71] = 2;
        matAd[77][78] = 2;
        matAd[77][84] = 2;

        matAd[78][12] = 5;
        matAd[78][77] = 2;
        matAd[78][79] = 2;

        matAd[79][78] = 2;
        matAd[79][73] = 2;

        matAd[80][79] = 1;
        matAd[80][15] = 2;

        matAd[81][70] = 3;

        matAd[82][83] = 5;

        matAd[83][82] = 5;
        matAd[83][69] = 4;
        matAd[83][84] = 5;

        matAd[84][77] = 2;
        matAd[84][11] = 2;

    }
}
