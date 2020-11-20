package mapauna.clases;

public class Vertice{
    private String nombre;
    private int numVertice;
    
    public Vertice(String nombre, int numVertice){
        this.nombre = nombre;
        this.numVertice = numVertice;
    }
    public Vertice () { this("", -1); }
    public Vertice (int numVertice) { this("V", numVertice); }
    public Vertice(String nombre){ this(nombre, -1); }
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public Boolean igual(Vertice n){ return nombre.equals(n.nombre); }// decide entre la igualdad de nombres
    public void setNumero(int numVertice){ this.numVertice = numVertice; }
    public int getNumero(){ return numVertice; }
    @Override
    public String toString() {
        return nombre + numVertice;
    }
}
