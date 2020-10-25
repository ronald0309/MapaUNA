package cr.ac.una.mapsuna;
import cr.ac.una.mapsuna.model.Grafo;
import java.util.Collections;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private double ejeX = 0;
    private double ejeY = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/mapsuna/view/Window.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
//        root.setOnMousePressed((MouseEvent event) -> {
//            ejeX = event.getSceneX();
//            ejeY = event.getSceneY();
//        });
//        root.setOnMouseDragged((MouseEvent event) -> {
//            stage.setX(event.getScreenX() - ejeX);
//            stage.setY(event.getScreenY() - ejeY);
//        });

        Grafo grafo = new Grafo();
//        Dijkstra dijskstra = new Dijkstra();
//        grafo.inicializarPesos();
//        
//        dijskstra.dijkstra(grafo.getMatPeso(), 64, 28);
//        Collections.reverse(dijskstra.getLista());
//        System.out.println(dijskstra.getLista());

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}