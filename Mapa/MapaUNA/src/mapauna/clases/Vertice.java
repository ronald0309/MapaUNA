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
    public String getNomVertice(){ return nombre; }
    public void setNomVertice(String nombre){ this.nombre = nombre; }
    public Boolean igual(Vertice n){ return nombre.equals(n.nombre); }// decide entre la igualdad de nombres
    public void setNumVertice(int numVertice){ this.numVertice = numVertice; }
    public int getNumVertice(){ return numVertice; }
    @Override
    public String toString() {
        return "Vertice{" + "nombre=" + nombre + ", numVertice=" + numVertice + '}';
    }
}
