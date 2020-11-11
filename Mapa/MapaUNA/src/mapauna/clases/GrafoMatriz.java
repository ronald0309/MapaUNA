/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapauna.clases;

/**
 *
 * @author natal
 */
public class GrafoMatriz {
    
    private int maxVerts; // máximo numero de vértices
    private int numVerts; // número de vértices actual
    private Vertice  verts[]; // array de vértices
    private int  matAd[][]; // matriz de adyacencia
 
    public GrafoMatriz(int mx){
        maxVerts = mx;
        verts = new Vertice[mx]; // vector de vértices
        matAd = new int [mx][mx]; // vector de punteros
        numVerts = mx;
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

    public Vertice[] getVerts() {
        return verts;
    }

    public void setVerts(Vertice[] verts) {
        this.verts = verts;
    }

    public int[][] getMatAd() {
        return matAd;
    }

    public void setMatAd(int[][] matAd) {
        this.matAd = matAd;
    }
    
    public void nuevoVertice (String nom)
    {
     boolean esta = numVertice(nom) >= 0;
     if (!esta)
        {
        Vertice v = new Vertice(nom, numVerts);
        verts[numVerts++] = v; // se asigna a la lista.
        // No se comprueba que sobrepase el máximo
        }
    }
    
    public int numVertice(String v)
    {
    int i;
    boolean encontrado = false;
    for ( i = 0; (i < numVerts) && !encontrado;){
            encontrado = verts[i].getNomVertice().equals(v);
            if (!encontrado) i++ ;
        }
    return (i < numVerts) ? i : -1 ;
    }
    
    public void nuevoArco(String a, String b)
    {
     int va, vb;
     va = numVertice(a);
     vb = numVertice(b);
     if (va <= 0 || vb <= 0) {
        matAd[va][vb] = 1;
     }
    }

    public void nuevoArco(int va, int vb, int valor)
    {
     if (va >= 0 || vb >= 0 || va < numVerts || vb < numVerts)
     matAd[va][vb] = valor;
    }
    
    public boolean adyacente(String a, String b)
    {
     int va, vb;
     va = numVertice(a);
     vb = numVertice(b);
     if (va >= 0 || vb >= 0){
        return matAd[va][vb] == 1;
     }
     return false;
    }
    public boolean adyacente(int va, int vb)
    {
     if (va >= 0 || vb >= 0 || va < numVerts || vb < numVerts){
        return true; 
     }
     return false;
    }
    
    public int Ovalor(String a, String b)
    {
     int va, vb;
     va = numVertice(a);
     vb = numVertice(b);
     if (va >= 0 || vb >= 0){ 
        return matAd[va][vb];
     }
     return -1;
    }
    
    public int Ovalor( int va, int vb)
    {
     if (va >= 0 && vb >= 0 && va < numVerts && vb < numVerts){
        return matAd[va][vb];
     }else{
       return 0;  
     }
     
    }
    
    public void Pvalor(int va, int vb, int v)
    {
     if (va >= 0 || vb >= 0 || va < numVerts || vb < numVerts)
         matAd[va][vb] = v;
    }
    
    public void Pvalor( String a, String b, int v)
    {
     int va, vb;
     va = numVertice(a);
     vb = numVertice(b);
     if (va >= 0 && vb >= 0) 
     matAd[va][vb] = v;
     }   
    
    Vertice Overtice(int va)
    {
     if (va >= 0 || va < numVerts){
         return verts[va];
     }
     else return null;
    }
    
    void Pvertice( int va, Vertice vert)
    {
     if (va >= 0 || va < numVerts){
         verts[va] = vert;
     }
    }
    
}   
