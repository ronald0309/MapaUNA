package mapsuna.model;

/**
 *
 * @author Jona
 */
public class Grafo {

    private static final int INF = 999;
    private int grafo[][] = new int[80][80];
    private int matAux[][] = new int[80][80];
    private final int matPeso[][] = new int[80][80];

    private final String matRecorrido[][] = new String[80][80];

    public Grafo() {
        this.grafo = new int[80][80];
        inicializarMatriz();
    }

    public int[][] getMatAux() {
        return matAux;
    }

    public void setMatAux(int[][] matAux) {
        this.matAux = matAux;
    }

    public int[][] getMatPeso() {
        return matPeso;
    }

    public void cortarPaso(int X, int Y){
        matAux[X][Y] = INF;
    }
    
    public void cortarPasoMatPeso(int fila, int col){
        matPeso[fila][col] = INF;
    }
    
    public void inicializarRecorrido() {
        int num = 1;
        for (int i = 0; i < matPeso.length; i++) {
            for (int j = 0; j < matPeso.length; j++) {
                matRecorrido[j][i] = "A" + num;
            }
            num += 1;
        }
    }

    public void inicializarMatAux() {
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 80; j++) {
                matAux[i][j] = INF;
            }
        }
        matAux[0][1] = 1;
        matAux[0][5] = 1;

        matAux[1][0] = 1;
        matAux[1][2] = 1;

        matAux[2][1] = 1;
        matAux[2][3] = 1;
        matAux[2][8] = 1;

        matAux[3][2] = 1;
        matAux[3][4] = 1;

        matAux[4][3] = 1;
        matAux[4][7] = 1;
        matAux[4][8] = 1;

        matAux[5][0] = 1;
        matAux[5][6] = 1;
        matAux[5][7] = 1;

        matAux[6][5] = 1;
        matAux[6][12] = 1;
        matAux[6][74] = 1;

        matAux[7][4] = 1;
        matAux[7][5] = 1;
        matAux[7][10] = 1;
        matAux[7][11] = 1;

        matAux[8][2] = 1;
        matAux[8][4] = 1;
        matAux[8][9] = 1;

        matAux[9][8] = 1;
        matAux[9][10] = 1;
        matAux[9][21] = 1;

        matAux[10][7] = 1;
        matAux[10][9] = 1;

        matAux[11][7] = 1;
        matAux[11][12] = 1;

        matAux[12][6] = 1;
        matAux[12][11] = 1;
        matAux[12][13] = 1;
        matAux[12][17] = 1;

        matAux[13][12] = 1;
        matAux[13][16] = 1;
        matAux[13][74] = 1;

        matAux[14][15] = 1;
        matAux[14][26] = 1;
        matAux[14][74] = 1;

        matAux[15][14] = 1;
        matAux[15][23] = 1;
        matAux[15][28] = 1;

        matAux[16][13] = 1;
        matAux[16][17] = 1;
        matAux[16][23] = 1;
        matAux[16][24] = 1;

        matAux[17][12] = 1;
        matAux[17][16] = 1;
        matAux[17][18] = 1;
        matAux[17][30] = 1;

        matAux[18][17] = 1;
        matAux[18][19] = 1;
        matAux[18][31] = 1;

        matAux[19][18] = 1;
        matAux[19][20] = 1;
        matAux[19][32] = 1;

        matAux[20][10] = 1;

        matAux[21][9] = 1;
        matAux[21][22] = 1;
        matAux[21][34] = 1;

        matAux[22][21] = 1;

        matAux[23][15] = 1;
        matAux[23][16] = 1;

        matAux[24][16] = 1;
        matAux[24][25] = 1;
        matAux[24][29] = 1;

        matAux[25][23] = 1;

        matAux[26][14] = 1;
        matAux[26][27] = 1;

        matAux[27][26] = 1;
        matAux[27][28] = 1;
        matAux[27][43] = 1;

        matAux[28][27] = 1;
        matAux[28][29] = 1;
        matAux[28][41] = 1;

        matAux[29][24] = 1;
        matAux[29][28] = 1;
        matAux[29][30] = 1;
        matAux[29][40] = 1;

        matAux[30][17] = 1;
        matAux[30][29] = 1;
        matAux[30][31] = 1;
        matAux[30][38] = 1;

        matAux[31][18] = 1;
        matAux[31][30] = 1;
        matAux[31][32] = 1;

        matAux[32][19] = 1;
        matAux[32][31] = 1;
        matAux[32][33] = 1;
        matAux[32][37] = 1;

        matAux[33][34] = 1;
        matAux[33][36] = 1;

        matAux[34][21] = 1;
        matAux[34][33] = 1;
        matAux[34][35] = 1;

        matAux[35][34] = 1;
        matAux[35][36] = 1;
        matAux[35][44] = 1;

        matAux[36][33] = 1;
        matAux[36][37] = 1;
        matAux[36][45] = 1;

        matAux[37][32] = 1;
        matAux[37][38] = 1;
        matAux[37][46] = 1;

        matAux[38][30] = 1;
        matAux[38][37] = 1;
        matAux[38][39] = 1;
        matAux[38][47] = 1;

        matAux[39][38] = 1;
        matAux[39][40] = 1;

        matAux[40][29] = 1;
        matAux[40][41] = 1;

        matAux[41][28] = 1;
        matAux[41][40] = 1;
        matAux[41][42] = 1;
        matAux[41][50] = 1;

        matAux[42][41] = 1;
        matAux[42][43] = 1;

        matAux[43][27] = 1;
        matAux[43][52] = 1;

        matAux[44][35] = 1;
        matAux[44][45] = 1;
        matAux[44][53] = 1;

        matAux[45][36] = 1;
        matAux[45][44] = 1;
        matAux[45][46] = 1;

        matAux[46][37] = 1;
        matAux[46][45] = 1;
        matAux[46][47] = 1;
        matAux[46][56] = 1;

        matAux[47][38] = 1;
        matAux[47][46] = 1;
        matAux[47][48] = 1;
        matAux[47][57] = 1;

        matAux[48][39] = 1;
        matAux[48][47] = 1;
        matAux[48][49] = 1;

        matAux[49][48] = 1;
        matAux[49][50] = 1;

//ojo con el bug
        matAux[50][41] = 1;
        matAux[50][49] = 1;
        matAux[50][51] = 1;
        matAux[50][59] = 1;

        matAux[51][42] = 1;
        matAux[51][50] = 1;
        matAux[51][52] = 1;

//ojo con posible bug A53
        matAux[52][43] = 1;
        matAux[52][51] = 1;
        matAux[52][68] = 1;

        matAux[53][44] = 1;
        matAux[53][54] = 1;
        matAux[53][61] = 1;

        matAux[54][53] = 1;
        matAux[54][55] = 1;
        matAux[54][63] = 1;

        matAux[55][45] = 1;
        matAux[55][54] = 1;
        matAux[55][56] = 1;
        matAux[55][64] = 1;

        matAux[56][46] = 1;
        matAux[56][55] = 1;
        matAux[56][57] = 1;
        matAux[56][72] = 1;

        matAux[57][47] = 1;
        matAux[57][56] = 1;
        matAux[57][70] = 1;

        matAux[58][49] = 1;
        matAux[58][59] = 1;
        matAux[58][65] = 1;

        matAux[59][50] = 1;
        matAux[59][58] = 1;
        matAux[59][60] = 1;
        matAux[59][66] = 1;

        matAux[60][51] = 1;
        matAux[60][59] = 1;
        matAux[60][67] = 1;

        matAux[61][53] = 1;
        matAux[61][62] = 1;
        matAux[61][75] = 1;

        matAux[62][61] = 1;

        matAux[63][54] = 1;

        matAux[64][55] = 1;

        matAux[65][58] = 1;
        matAux[65][66] = 1;
        matAux[65][73] = 1;

        matAux[66][59] = 1;
        matAux[66][65] = 1;
        matAux[66][67] = 1;
        matAux[66][77] = 1;

        matAux[67][60] = 1;
        matAux[67][66] = 1;
        matAux[67][69] = 1;

        matAux[68][52] = 1;
        matAux[68][69] = 1;
        matAux[68][79] = 1;

        matAux[69][67] = 1;
        matAux[69][68] = 1;
        matAux[69][78] = 1;

        matAux[70][57] = 1;

        matAux[71][72] = 1;

        matAux[72][56] = 1;
        matAux[72][71] = 1;
        matAux[72][73] = 1;

        matAux[73][65] = 1;
        matAux[73][72] = 1;
        matAux[73][76] = 1;

        matAux[74][6] = 1;
        matAux[74][13] = 1;
        matAux[74][14] = 1;

        matAux[75][61] = 1;
        matAux[75][76] = 1;

        matAux[76][73] = 1;
        matAux[76][75] = 1;
        matAux[76][77] = 1;

//ojo con posible bug
        matAux[77][66] = 1;
        matAux[77][76] = 1;
        matAux[77][78] = 1;

        matAux[78][69] = 1;
        matAux[78][77] = 1;

        matAux[79][68] = 1;
        matAux[79][78] = 1;

    }

    public void inicializarPesos() {
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 80; j++) {
                matPeso[i][j] = INF;
            }
        }
        matPeso[0][1] = 8;
        matPeso[0][5] = 14;

        matPeso[1][0] = 8;
        matPeso[1][2] = 7;

        matPeso[2][1] = 7;
        matPeso[2][3] = 9;
        matPeso[2][8] = 15;

        matPeso[3][2] = 9;
        matPeso[3][4] = 11;

        matPeso[4][3] = 11;
        matPeso[4][7] = 12;
        matPeso[4][8] = 15;

        matPeso[5][0] = 14;
        matPeso[5][6] = 5;
        matPeso[5][7] = 7;

        matPeso[6][5] = 5;
        matPeso[6][12] = 13;
        matPeso[6][74] = 15;

        matPeso[7][4] = 12;
        matPeso[7][5] = 7;
        matPeso[7][10] = 10;
        matPeso[7][11] = 9;

        matPeso[8][2] = 15;
        matPeso[8][4] = 15;
        matPeso[8][9] = 7;

        matPeso[9][8] = 7;
        matPeso[9][10] = 8;
        matPeso[9][21] = 16;

        matPeso[10][7] = 10;
        matPeso[10][9] = 8;

        matPeso[11][7] = 9;
        matPeso[11][12] = 9;

        matPeso[12][6] = 13;
        matPeso[12][11] = 9;
        matPeso[12][13] = 9;
        matPeso[12][17] = 10;

        matPeso[13][12] = 9;
        matPeso[13][16] = 8;
        matPeso[13][74] = 4;

        matPeso[14][15] = 6;
        matPeso[14][26] = 15;
        matPeso[14][74] = 10;

        matPeso[15][14] = 6;
        matPeso[15][23] = 3;
        matPeso[15][28] = 8;

        matPeso[16][13] = 8;
        matPeso[16][17] = 5;
        matPeso[16][23] = 3;
        matPeso[16][24] = 3;

        matPeso[17][12] = 10;
        matPeso[17][16] = 5;
        matPeso[17][18] = 3;
        matPeso[17][30] = 7;

        matPeso[18][17] = 3;
        matPeso[18][19] = 4;
        matPeso[18][31] = 9;

        matPeso[19][18] = 4;
        matPeso[19][20] = 2;
        matPeso[19][32] = 10;

        matPeso[20][10] = 5;

        matPeso[21][9] = 16;
        matPeso[21][22] = 2;
        matPeso[21][34] = 11;

        matPeso[22][21] = 2;

        matPeso[23][15] = 3;
        matPeso[23][16] = 3;

        matPeso[24][16] = 3;
        matPeso[24][25] = 2;
        matPeso[24][29] = 4;

        matPeso[25][23] = 3;

        matPeso[26][14] = 15;
        matPeso[26][27] = 4;

        matPeso[27][26] = 4;
        matPeso[27][28] = 14;
        matPeso[27][43] = 9;

        matPeso[28][27] = 14;
        matPeso[28][29] = 8;
        matPeso[28][41] = 9;

        matPeso[29][24] = 4;
        matPeso[29][28] = 8;
        matPeso[29][30] = 7;
        matPeso[29][40] = 10;

        matPeso[30][17] = 7;
        matPeso[30][29] = 7;
        matPeso[30][31] = 5;
        matPeso[30][38] = 9;

        matPeso[31][18] = 9;
        matPeso[31][30] = 5;
        matPeso[31][32] = 3;

        matPeso[32][19] = 10;
        matPeso[32][31] = 3;
        matPeso[32][33] = 7;
        matPeso[32][37] = 11;

        matPeso[33][34] = 8;
        matPeso[33][36] = 6;

        matPeso[34][21] = 11;
        matPeso[34][33] = 8;
        matPeso[34][35] = 6;

        matPeso[35][34] = 6;
        matPeso[35][36] = 6;
        matPeso[35][44] = 10;

        matPeso[36][33] = 6;
        matPeso[36][37] = 7;
        matPeso[36][45] = 9;

        matPeso[37][32] = 11;
        matPeso[37][38] = 9;
        matPeso[37][46] = 8;

        matPeso[38][30] = 9;
        matPeso[38][37] = 7;
        matPeso[38][39] = 5;
        matPeso[38][47] = 8;

        matPeso[39][38] = 5;
        matPeso[39][40] = 4;

        matPeso[40][29] = 10;
        matPeso[40][41] = 6;

        matPeso[41][28] = 9;
        matPeso[41][40] = 6;
        matPeso[41][42] = 9;
        matPeso[41][50] = 10;

        matPeso[42][41] = 9;
        matPeso[42][43] = 5;

        matPeso[43][27] = 9;
        matPeso[43][52] = 10;

        matPeso[44][35] = 10;
        matPeso[44][45] = 12;
        matPeso[44][53] = 8;

        matPeso[45][36] = 9;
        matPeso[45][44] = 12;
        matPeso[45][46] = 8;
        matPeso[45][55] = 11;

        matPeso[46][37] = 8;
        matPeso[46][45] = 8;
        matPeso[46][47] = 7;
        matPeso[46][56] = 9;

        matPeso[47][38] = 8;
        matPeso[47][46] = 7;
        matPeso[47][48] = 5;
        matPeso[47][57] = 10;

        matPeso[48][39] = 3;
        matPeso[48][47] = 5;
        matPeso[48][49] = 2;

        matPeso[49][48] = 2;
        matPeso[49][50] = 8;

//ojo con el bug
        matPeso[50][41] = 10;
        matPeso[50][49] = 8;
        matPeso[50][51] = 7;
        matPeso[50][59] = 9;

        matPeso[51][42] = 5;
        matPeso[51][50] = 7;
        matPeso[51][52] = 8;

//ojo con posible bug A53
        matPeso[52][43] = 10;
        matPeso[52][51] = 8;
        matPeso[52][68] = 14;

        matPeso[53][44] = 8;
        matPeso[53][54] = 7;
        matPeso[53][61] = 9;

        matPeso[54][53] = 7;
        matPeso[54][55] = 6;
        matPeso[54][63] = 4;

        matPeso[55][45] = 11;
        matPeso[55][54] = 6;
        matPeso[55][56] = 5;
        matPeso[55][64] = 5;

        matPeso[56][46] = 9;
        matPeso[56][55] = 5;
        matPeso[56][57] = 7;
        matPeso[56][72] = 12;

        matPeso[57][47] = 10;
        matPeso[57][56] = 7;
        matPeso[57][70] = 7;

        matPeso[58][49] = 4;
        matPeso[58][59] = 8;
        matPeso[58][65] = 7;

        matPeso[59][50] = 9;
        matPeso[59][58] = 8;
        matPeso[59][60] = 6;
        matPeso[59][66] = 6;

        matPeso[60][51] = 5;
        matPeso[60][59] = 6;
        matPeso[60][67] = 6;

        matPeso[61][53] = 9;
        matPeso[61][62] = 4;
        matPeso[61][75] = 13;

        matPeso[62][61] = 4;

        matPeso[63][54] = 4;

        matPeso[64][55] = 5;

        matPeso[65][58] = 7;
        matPeso[65][66] = 9;
        matPeso[65][73] = 5;

        matPeso[66][59] = 6;
        matPeso[66][65] = 9;
        matPeso[66][67] = 4;
        matPeso[66][77] = 12;

        matPeso[67][60] = 6;
        matPeso[67][66] = 4;
        matPeso[67][69] = 2;

        matPeso[68][52] = 14;
        matPeso[68][69] = 7;
        matPeso[68][79] = 10;

        matPeso[69][67] = 2;
        matPeso[69][68] = 7;
        matPeso[69][78] = 13;

        matPeso[70][57] = 7;

        matPeso[71][72] = 11;

        matPeso[72][56] = 12;
        matPeso[72][71] = 11;
        matPeso[72][73] = 14;

        matPeso[73][65] = 5;
        matPeso[73][72] = 14;
        matPeso[73][76] = 7;

        matPeso[74][6] = 15;
        matPeso[74][13] = 4;
        matPeso[74][14] = 10;

        matPeso[75][61] = 13;
        matPeso[75][76] = 20;

        matPeso[76][73] = 7;
        matPeso[76][75] = 20;
        matPeso[76][77] = 8;

//ojo con posible bug
        matPeso[77][66] = 12;
        matPeso[77][76] = 8;
        matPeso[77][78] = 9;

        matPeso[78][69] = 13;
        matPeso[78][77] = 9;
        matPeso[78][79] = 3;

        matPeso[79][68] = 10;
        matPeso[79][78] = 3;

    }

    private void inicializarMatriz() {
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 80; j++) {
                this.grafo[i][j] = 0;
            }
        }
        this.grafo[0][1] = 1;
        this.grafo[0][5] = 1;

        this.grafo[1][0] = 1;
        this.grafo[1][2] = 1;

        this.grafo[2][1] = 1;
        this.grafo[2][3] = 1;
        this.grafo[2][8] = 1;

        this.grafo[3][2] = 1;
        this.grafo[3][4] = 1;

        this.grafo[4][3] = 1;
        this.grafo[4][7] = 1;
        this.grafo[4][8] = 1;

        this.grafo[5][0] = 1;
        this.grafo[5][6] = 1;
        this.grafo[5][7] = 1;

        this.grafo[6][5] = 1;
        this.grafo[6][12] = 1;
        this.grafo[6][74] = 1;

        this.grafo[7][4] = 1;
        this.grafo[7][5] = 1;
        this.grafo[7][10] = 1;
        this.grafo[7][11] = 1;

        this.grafo[8][2] = 1;
        this.grafo[8][4] = 1;
        this.grafo[8][9] = 1;

        this.grafo[9][8] = 1;
        this.grafo[9][10] = 1;
        this.grafo[9][21] = 1;

        this.grafo[10][7] = 1;
        this.grafo[10][9] = 1;

        this.grafo[11][7] = 1;
        this.grafo[11][12] = 1;

        this.grafo[12][6] = 1;
        this.grafo[12][11] = 1;
        this.grafo[12][13] = 1;
        this.grafo[12][17] = 1;

        this.grafo[13][12] = 1;
        this.grafo[13][16] = 1;
        this.grafo[13][74] = 1;

        this.grafo[14][15] = 1;
        this.grafo[14][26] = 1;
        this.grafo[14][74] = 1;

        this.grafo[15][14] = 1;
        this.grafo[15][23] = 1;
        this.grafo[15][28] = 1;

        this.grafo[16][13] = 1;
        this.grafo[16][17] = 1;
        this.grafo[16][23] = 1;
        this.grafo[16][24] = 1;

        this.grafo[17][12] = 1;
        this.grafo[17][16] = 1;
        this.grafo[17][18] = 1;
        this.grafo[17][30] = 1;

        this.grafo[18][17] = 1;
        this.grafo[18][19] = 1;
        this.grafo[18][31] = 1;

        this.grafo[19][18] = 1;
        this.grafo[19][20] = 1;
        this.grafo[19][32] = 1;

        this.grafo[20][10] = 1;

        this.grafo[21][9] = 1;
        this.grafo[21][22] = 1;
        this.grafo[21][34] = 1;

        this.grafo[22][21] = 1;

        this.grafo[23][15] = 1;
        this.grafo[23][16] = 1;

        this.grafo[24][16] = 1;
        this.grafo[24][25] = 1;
        this.grafo[24][29] = 1;

        this.grafo[25][23] = 1;

        this.grafo[26][14] = 1;
        this.grafo[26][27] = 1;

        this.grafo[27][26] = 1;
        this.grafo[27][28] = 1;
        this.grafo[27][43] = 1;

        this.grafo[28][27] = 1;
        this.grafo[28][29] = 1;
        this.grafo[28][41] = 1;

        this.grafo[29][24] = 1;
        this.grafo[29][28] = 1;
        this.grafo[29][30] = 1;
        this.grafo[29][40] = 1;

        this.grafo[30][17] = 1;
        this.grafo[30][29] = 1;
        this.grafo[30][31] = 1;
        this.grafo[30][38] = 1;

        this.grafo[31][18] = 1;
        this.grafo[31][30] = 1;
        this.grafo[31][32] = 1;

        this.grafo[32][19] = 1;
        this.grafo[32][31] = 1;
        this.grafo[32][33] = 1;
        this.grafo[32][37] = 1;

        this.grafo[33][34] = 1;
        this.grafo[33][36] = 1;

        this.grafo[34][21] = 1;
        this.grafo[34][33] = 1;
        this.grafo[34][35] = 1;

        this.grafo[35][34] = 1;
        this.grafo[35][36] = 1;
        this.grafo[35][44] = 1;

        this.grafo[36][33] = 1;
        this.grafo[36][37] = 1;
        this.grafo[36][45] = 1;

        this.grafo[37][32] = 1;
        this.grafo[37][38] = 1;
        this.grafo[37][46] = 1;

        this.grafo[38][30] = 1;
        this.grafo[38][37] = 1;
        this.grafo[38][39] = 1;
        this.grafo[38][47] = 1;

        this.grafo[39][38] = 1;
        this.grafo[39][40] = 1;

        this.grafo[40][29] = 1;
        this.grafo[40][41] = 1;

        this.grafo[41][28] = 1;
        this.grafo[41][40] = 1;
        this.grafo[41][42] = 1;
        this.grafo[41][50] = 1;

        this.grafo[42][41] = 1;
        this.grafo[42][43] = 1;

        this.grafo[43][27] = 1;
        this.grafo[43][52] = 1;

        this.grafo[44][35] = 1;
        this.grafo[44][45] = 1;
        this.grafo[44][53] = 1;

        this.grafo[45][36] = 1;
        this.grafo[45][44] = 1;
        this.grafo[45][46] = 1;

        this.grafo[46][37] = 1;
        this.grafo[46][45] = 1;
        this.grafo[46][47] = 1;
        this.grafo[46][56] = 1;

        this.grafo[47][38] = 1;
        this.grafo[47][46] = 1;
        this.grafo[47][48] = 1;
        this.grafo[47][57] = 1;

        this.grafo[48][39] = 1;
        this.grafo[48][47] = 1;
        this.grafo[48][49] = 1;

        this.grafo[49][48] = 1;
        this.grafo[49][50] = 1;

        //ojo con el bug
        this.grafo[50][41] = 1;
        this.grafo[50][49] = 1;
        this.grafo[50][51] = 1;
        this.grafo[50][59] = 1;

        this.grafo[51][42] = 1;
        this.grafo[51][50] = 1;
        this.grafo[51][52] = 1;

        //ojo con posible bug A53
        this.grafo[52][43] = 1;
        this.grafo[52][51] = 1;
        this.grafo[52][68] = 1;

        this.grafo[53][44] = 1;
        this.grafo[53][54] = 1;
        this.grafo[53][61] = 1;

        this.grafo[54][53] = 1;
        this.grafo[54][55] = 1;
        this.grafo[54][63] = 1;

        this.grafo[55][45] = 1;
        this.grafo[55][54] = 1;
        this.grafo[55][56] = 1;
        this.grafo[55][64] = 1;

        this.grafo[56][46] = 1;
        this.grafo[56][55] = 1;
        this.grafo[56][57] = 1;
        this.grafo[56][72] = 1;

        this.grafo[57][47] = 1;
        this.grafo[57][56] = 1;
        this.grafo[57][70] = 1;

        this.grafo[58][49] = 1;
        this.grafo[58][59] = 1;
        this.grafo[58][65] = 1;

        this.grafo[59][50] = 1;
        this.grafo[59][58] = 1;
        this.grafo[59][60] = 1;
        this.grafo[59][66] = 1;

        this.grafo[60][51] = 1;
        this.grafo[60][59] = 1;
        this.grafo[60][67] = 1;

        this.grafo[61][53] = 1;
        this.grafo[61][62] = 1;
        this.grafo[61][75] = 1;

        this.grafo[62][61] = 1;

        this.grafo[63][54] = 1;

        this.grafo[64][55] = 1;

        this.grafo[65][58] = 1;
        this.grafo[65][66] = 1;
        this.grafo[65][73] = 1;

        this.grafo[66][59] = 1;
        this.grafo[66][65] = 1;
        this.grafo[66][67] = 1;
        this.grafo[66][77] = 1;

        this.grafo[67][60] = 1;
        this.grafo[67][66] = 1;
        this.grafo[67][69] = 1;

        this.grafo[68][52] = 1;
        this.grafo[68][69] = 1;
        this.grafo[68][79] = 1;

        this.grafo[69][67] = 1;
        this.grafo[69][68] = 1;
        this.grafo[69][78] = 1;

        this.grafo[70][57] = 1;

        this.grafo[71][72] = 1;

        this.grafo[72][56] = 1;
        this.grafo[72][71] = 1;
        this.grafo[72][73] = 1;

        this.grafo[73][65] = 1;
        this.grafo[73][72] = 1;
        this.grafo[73][76] = 1;

        this.grafo[74][6] = 1;
        this.grafo[74][13] = 1;
        this.grafo[74][14] = 1;

        this.grafo[75][61] = 1;
        this.grafo[75][76] = 1;

        this.grafo[76][73] = 1;
        this.grafo[76][75] = 1;
        this.grafo[76][77] = 1;

        //ojo con posible bug
        this.grafo[77][66] = 1;
        this.grafo[77][76] = 1;
        this.grafo[77][78] = 1;

        this.grafo[78][69] = 1;
        this.grafo[78][77] = 1;

        this.grafo[79][68] = 1;
        this.grafo[79][78] = 1;

    }

    public int[][] getGrafo() {
        return grafo;
    }

    public void setGrafo(int[][] grafo) {
        this.grafo = grafo;
    }
    
    public void editarMatriz(int num){
        this.inicializarPesos();
        if(num == 1){
            this.inicializarPesos();
        }else{
            if(num == 3){
                for (int i = 0; i < this.matPeso.length; i++) {
                    for (int j = 0; j < this.matPeso.length; j++) {
                        if(this.matPeso[i][j] != INF){
                            this.matPeso[i][j] = this.matPeso[i][j] * num;
                        }
                    }
                }
            }else{
                for (int i = 0; i < this.matPeso.length; i++) {
                    for (int j = 0; j < this.matPeso.length; j++) {
                        if(this.matPeso[i][j] != INF){
                            this.matPeso[i][j] = this.matPeso[i][j] * num;
                        }
                    }
                }
            }
        }
    }
}
