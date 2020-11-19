package mapauna.clases;

public class Grafo {

    public static final int INF = 999999;
    public static final int MAX = 85;

    private final int matPeso[][] = new int[MAX][MAX];

    public Grafo() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                matPeso[i][j] = INF;
            }
        }
        inicializarPesos();
    }

    private void inicializarPesos() {//arreglar matriz
        matPeso[0][1] = 4;
        matPeso[0][24] = 6;

        matPeso[1][0] = 4;
        matPeso[1][25] = 1;
        matPeso[1][2] = 4;

        matPeso[2][1] = 4;
        matPeso[2][3] = 1;
        matPeso[2][26] = 3;

        matPeso[3][2] = 1;
        matPeso[3][28] = 1;
        matPeso[3][4] = 3;

        matPeso[4][3] = 3;
        matPeso[4][32] = 1;
        matPeso[4][5] = 2;

        matPeso[5][4] = 2;
        matPeso[5][6] = 1;

        matPeso[6][5] = 1;
        matPeso[6][48] = 2;
        matPeso[6][7] = 2;

        matPeso[7][6] = 2;
        matPeso[7][56] = 1;
        matPeso[7][8] = 1;

        matPeso[8][7] = 1;
        matPeso[8][67] = 3;
        matPeso[8][9] = 2;

        matPeso[9][8] = 2;
        matPeso[9][74] = 1;
        matPeso[9][10] = 4;

        matPeso[10][9] = 4;
        matPeso[10][11] = 12;

        matPeso[11][10] = 12;
        matPeso[11][12] = 2;
        matPeso[11][84] = 2;

        matPeso[12][11] = 2;
        matPeso[12][78] = 5;
        matPeso[12][13] = 2;

        matPeso[13][14] = 1;
        matPeso[13][80] = 4;

        matPeso[14][13] = 1;
        matPeso[14][15] = 4;

        matPeso[15][14] = 4;
        matPeso[15][80] = 2;
        matPeso[15][16] = 2;

        matPeso[16][15] = 2;
        matPeso[16][17] = 2;

        matPeso[17][16] = 2;
        matPeso[17][18] = 2;

        matPeso[18][17] = 2;
        matPeso[18][19] = 2;

        matPeso[19][18] = 2;
        matPeso[19][20] = 1;
        matPeso[19][47] = 4;

        matPeso[20][19] = 1;
        matPeso[20][21] = 5;

        matPeso[21][20] = 6;
        matPeso[21][22] = 2;
        matPeso[21][39] = 2;

        matPeso[22][21] = 2;
        matPeso[22][23] = 3;

        matPeso[23][22] = 3;
        matPeso[23][30] = 3;
        matPeso[23][24] = 2;

        matPeso[24][23] = 2;
        matPeso[24][27] = 2;
        matPeso[24][0] = 6;

        matPeso[25][1] = 1;
        matPeso[25][26] = 1;

        matPeso[26][25] = 1;
        matPeso[26][2] = 3;
        matPeso[26][27] = 2;

        matPeso[27][26] = 2;
        matPeso[27][28] = 2;
        matPeso[27][29] = 2;
        matPeso[27][24] = 2;

        matPeso[28][27] = 2;
        matPeso[28][3] = 1;

        matPeso[29][27] = 2;
        matPeso[29][30] = 2;

        matPeso[30][29] = 2;
        matPeso[30][36] = 2;
        matPeso[30][35] = 2;

        matPeso[31][28] = 2;

        matPeso[32][4] = 1;

        matPeso[33][31] = 1;
        matPeso[33][34] = 1;

        matPeso[34][35] = 1;
        matPeso[34][44] = 2;

        matPeso[35][34] = 1;
        matPeso[35][45] = 2;

        matPeso[36][22] = 1;
        matPeso[36][30] = 2;

        matPeso[37][36] = 2;
        matPeso[37][35] = 2;

        matPeso[38][37] = 1;

        matPeso[39][38] = 1;
        matPeso[39][47] = 2;

        matPeso[40][37] = 1;
        matPeso[40][41] = 1;

        matPeso[41][38] = 1;

        matPeso[42][5] = 2;
        matPeso[42][48] = 1;

        matPeso[43][42] = 2;
        matPeso[43][33] = 2;

        matPeso[44][36] = 2;
        matPeso[44][43] = 1;

        matPeso[45][44] = 1;
        matPeso[45][50] = 2;

        matPeso[46][45] = 2;
        matPeso[46][40] = 1;
        matPeso[46][52] = 2;

        matPeso[47][46] = 2;
        matPeso[47][53] = 2;

        matPeso[48][42] = 1;
        matPeso[48][49] = 2;
        matPeso[48][57] = 2;

        matPeso[49][43] = 2;
        matPeso[49][50] = 2;

        matPeso[50][49] = 1;
        matPeso[50][60] = 2;

        matPeso[51][52] = 1;

        matPeso[52][46] = 2;
        matPeso[52][53] = 2;

        matPeso[53][63] = 2;
        matPeso[53][54] = 2;

        matPeso[54][18] = 2;

        matPeso[55][65] = 1;

        matPeso[56][7] = 1;
        matPeso[56][66] = 1;
        matPeso[56][57] = 1;

        matPeso[57][56] = 1;
        matPeso[57][48] = 2;
        matPeso[57][58] = 1;

        matPeso[58][59] = 2;
        matPeso[58][57] = 1;
        matPeso[58][63] = 3;

        matPeso[59][49] = 2;
        matPeso[59][58] = 2;
        matPeso[59][60] = 2;
        matPeso[59][69] = 3;

        matPeso[60][59] = 2;
        matPeso[60][61] = 1;
        matPeso[60][70] = 3;

        matPeso[61][60] = 1;
        matPeso[61][51] = 2;
        matPeso[61][62] = 1;

        matPeso[62][63] = 3;
        matPeso[62][61] = 1;

        matPeso[63][62] = 3;
        matPeso[63][64] = 2;
        matPeso[63][72] = 2;

        matPeso[64][63] = 2;
        matPeso[64][65] = 1;
        matPeso[64][54] = 2;

        matPeso[65][55] = 1;
        matPeso[65][17] = 1;

        matPeso[66][56] = 1;

        matPeso[67][8] = 3;
        matPeso[67][75] = 2;
        matPeso[67][68] = 2;

        matPeso[68][58] = 3;
        matPeso[68][67] = 2;
        matPeso[68][76] = 2;
        matPeso[68][69] = 1;

        matPeso[69][59] = 3;
        matPeso[69][63] = 1;
        matPeso[69][70] = 2;
        matPeso[69][83] = 4;

        matPeso[70][60] = 3;
        matPeso[70][69] = 2;
        matPeso[70][81] = 3;

        matPeso[71][62] = 3;
        matPeso[71][72] = 3;
        matPeso[71][77] = 2;

        matPeso[72][73] = 2;
        matPeso[72][78] = 2;

        matPeso[73][64] = 2;

        matPeso[74][9] = 1;

        matPeso[75][67] = 2;

        matPeso[76][68] = 2;

        matPeso[77][71] = 2;
        matPeso[77][78] = 2;
        matPeso[77][84] = 2;

        matPeso[78][12] = 5;
        matPeso[78][77] = 2;
        matPeso[78][79] = 2;

        matPeso[79][78] = 2;
        matPeso[79][73] = 2;

        matPeso[80][79] = 1;
        matPeso[80][15] = 2;

        matPeso[81][70] = 3;

        matPeso[82][83] = 5;

        matPeso[83][82] = 5;
        matPeso[83][69] = 4;
        matPeso[83][84] = 5;

        matPeso[84][77] = 2;
        matPeso[84][11] = 2;

    }
    
    public int[][] getMatrizPesos(){
        return matPeso;
    }
}
