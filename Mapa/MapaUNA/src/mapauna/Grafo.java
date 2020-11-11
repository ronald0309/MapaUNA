/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapauna;

/**
 *
 * @author Ronny
 */
public class Grafo {

    public static final int INF = 999999;

    private int matPeso[][] = new int[85][85];

    public Grafo() {
        for (int i = 0; i < 85; i++) {
            for (int j = 0; j < 85; j++) {
                matPeso[i][j] = INF;
            }
        }
        inicializarPesos();

    }

    private void inicializarPesos() {
        matPeso[1][2] = 4;
        matPeso[1][25] = 6;

        matPeso[2][1] = 4;
        matPeso[2][26] = 1;
        matPeso[2][3] = 4;

        matPeso[3][2] = 4;
        matPeso[3][4] = 1;
        matPeso[3][27] = 3;

        matPeso[4][3] = 1;
        matPeso[4][29] = 1;
        matPeso[4][5] = 3;

        matPeso[5][4] = 3;
        matPeso[5][33] = 1;
        matPeso[5][6] = 2;

        matPeso[6][5] = 2;
        matPeso[6][7] = 1;

        matPeso[7][6] = 1;
        matPeso[7][49] = 2;
        matPeso[7][8] = 2;

        matPeso[8][7] = 2;
        matPeso[8][57] = 1;
        matPeso[8][9] = 1;

        matPeso[9][8] = 1;
        matPeso[9][68] = 3;
        matPeso[9][10] = 2;

        matPeso[10][9] = 2;
        matPeso[10][75] = 1;
        matPeso[10][11] = 4;

        matPeso[11][10] = 4;
        matPeso[11][12] = 12;

        matPeso[12][11] = 12;
        matPeso[12][13] = 2;
        matPeso[12][85] = 2;

        matPeso[13][12] = 2;
        matPeso[13][79] = 5;
        matPeso[13][14] = 2;

        matPeso[14][15] = 1;
        matPeso[14][81] = 4;

        matPeso[15][14] = 1;
        matPeso[15][16] = 4;

        matPeso[16][15] = 4;
        matPeso[16][81] = 2;
        matPeso[16][17] = 2;

        matPeso[17][16] = 2;
        matPeso[17][18] = 2;

        matPeso[18][17] = 2;
        matPeso[18][19] = 2;

        matPeso[19][18] = 2;
        matPeso[19][20] = 2;

        matPeso[20][19] = 2;
        matPeso[20][21] = 1;
        matPeso[20][48] = 4;

        matPeso[21][20] = 1;
        matPeso[21][22] = 5;

        matPeso[22][21] = 6;
        matPeso[22][23] = 2;
        matPeso[22][40] = 2;

        matPeso[23][22] = 2;
        matPeso[23][24] = 3;

        matPeso[24][23] = 3;
        matPeso[24][31] = 3;
        matPeso[24][25] = 2;

        matPeso[25][24] = 2;
        matPeso[25][28] = 2;
        matPeso[25][1] = 6;

        matPeso[26][2] = 1;
        matPeso[26][27] = 1;

        matPeso[27][26] = 1;
        matPeso[27][3] = 3;
        matPeso[27][28] = 2;

        matPeso[28][27] = 2;
        matPeso[28][29] = 2;
        matPeso[28][30] = 2;
        matPeso[28][25] = 2;

        matPeso[29][28] = 2;
        matPeso[29][4] = 1;

        matPeso[30][28] = 2;
        matPeso[30][31] = 2;

        matPeso[31][30] = 2;
        matPeso[31][37] = 2;
        matPeso[31][36] = 2;

        matPeso[32][29] = 2;

        matPeso[33][5] = 1;

        matPeso[34][32] = 1;
        matPeso[34][35] = 1;

        matPeso[35][36] = 1;
        matPeso[35][45] = 2;

        matPeso[36][35] = 1;
        matPeso[36][46] = 2;

        matPeso[37][23] = 1;
        matPeso[37][31] = 2;

        matPeso[38][37] = 2;
        matPeso[38][36] = 2;

        matPeso[39][38] = 1;

        matPeso[40][39] = 1;
        matPeso[40][48] = 2;

        matPeso[41][38] = 1;
        matPeso[41][42] = 1;

        matPeso[42][39] = 1;

        matPeso[43][6] = 2;
        matPeso[43][49] = 1;

        matPeso[44][43] = 2;
        matPeso[44][34] = 2;

        matPeso[45][35] = 2;
        matPeso[45][44] = 1;

        matPeso[46][45] = 1;
        matPeso[46][51] = 2;

        matPeso[47][46] = 2;
        matPeso[47][41] = 1;
        matPeso[47][53] = 2;

        matPeso[48][47] = 2;
        matPeso[48][54] = 2;

        matPeso[49][43] = 1;
        matPeso[49][50] = 2;
        matPeso[49][58] = 2;

        matPeso[50][44] = 2;
        matPeso[50][51] = 2;

        matPeso[51][50] = 1;
        matPeso[51][61] = 2;

        matPeso[52][53] = 1;

        matPeso[53][47] = 2;
        matPeso[53][54] = 2;

        matPeso[54][64] = 2;
        matPeso[54][55] = 2;

        matPeso[55][19] = 2;

        matPeso[56][66] = 1;

        matPeso[57][8] = 1;
        matPeso[57][67] = 1;
        matPeso[57][58] = 1;

        matPeso[58][57] = 1;
        matPeso[58][49] = 2;
        matPeso[58][59] = 1;

        matPeso[59][60] = 2;
        matPeso[59][58] = 1;
        matPeso[59][64] = 3;

        matPeso[60][50] = 2;
        matPeso[60][59] = 2;
        matPeso[60][61] = 2;
        matPeso[60][70] = 3;

        matPeso[61][60] = 2;
        matPeso[61][62] = 1;
        matPeso[61][71] = 3;

        matPeso[62][61] = 1;
        matPeso[62][52] = 2;
        matPeso[62][63] = 1;

        matPeso[63][64] = 3;
        matPeso[63][62] = 1;

        matPeso[64][63] = 3;
        matPeso[64][65] = 2;
        matPeso[64][73] = 2;

        matPeso[65][64] = 2;
        matPeso[65][66] = 1;
        matPeso[65][55] = 2;

        matPeso[66][56] = 1;
        matPeso[66][18] = 1;

        matPeso[67][57] = 1;

        matPeso[68][9] = 3;
        matPeso[68][76] = 2;
        matPeso[68][69] = 2;

        matPeso[69][59] = 3;
        matPeso[69][68] = 2;
        matPeso[69][77] = 2;
        matPeso[69][70] = 1;

        matPeso[70][60] = 3;
        matPeso[70][64] = 1;
        matPeso[70][71] = 2;
        matPeso[70][84] = 4;

        matPeso[71][61] = 3;
        matPeso[71][70] = 2;
        matPeso[71][82] = 3;

        matPeso[72][63] = 3;
        matPeso[72][73] = 3;
        matPeso[72][78] = 2;

        matPeso[73][74] = 2;
        matPeso[73][79] = 2;

        matPeso[74][65] = 2;

        matPeso[75][10] = 1;

        matPeso[76][68] = 2;

        matPeso[77][69] = 2;

        matPeso[78][72] = 2;
        matPeso[78][79] = 2;
        matPeso[78][85] = 2;

        matPeso[79][13] = 5;
        matPeso[79][78] = 2;
        matPeso[79][80] = 2;

        matPeso[80][79] = 2;
        matPeso[80][74] = 2;

        matPeso[81][80] = 1;
        matPeso[81][16] = 2;

        matPeso[82][71] = 3;

        matPeso[83][84] = 5;

        matPeso[84][83] = 5;
        matPeso[84][70] = 4;
        matPeso[84][85] = 5;

        matPeso[85][78] = 2;
        matPeso[85][12] = 2;

    }
}
