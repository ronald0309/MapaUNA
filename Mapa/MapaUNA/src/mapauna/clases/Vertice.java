package mapauna.clases;

public class Vertice {
    private String nombre;
    private int numVertice;
    
    public Vertice () {}
    public Vertice(String nombre){ 
        this.nombre = nombre;
        numVertice = -1;
    }
    public Vertice(String nombre, int numVertice){ 
        this.nombre = nombre;
        this.numVertice = numVertice;
    }
    public String getNomVertice(){ return nombre; }
    public void setNomVertice(String nombre){ this.nombre = nombre; }
    public Boolean igual(Vertice n){ return nombre == n.nombre; }// decide entre la igualdad de nombres
    public void setNumVertice(int n){ this.numVertice = numVertice; }
    public int getNumVertice(){ return numVertice; }
    
}
