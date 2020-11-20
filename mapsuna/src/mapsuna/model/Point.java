
package mapsuna.model;
import javafx.scene.Node;

public class Point {
    private int x;
    private int y;
    private String id;
    
    public Point() {
        x = -1;
        y = -1;
        id = "-1";
    }
    
    public void actualizar(Node n) {
        x = (int) ((n.getLayoutX()) + 7) ;
        y = (int) ((n.getLayoutY()) + 9);
        id = n.getId();
    }
    
    public void actualizar(int xPosition, int yPosition) {
        this.x = xPosition;
        this.y = yPosition;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getId() {
        return id;
    }

    
}
