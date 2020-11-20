/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapsuna;

import java.util.Collections;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mapsuna.model.Dijkstra;
import mapsuna.model.Grafo;

/**
 *
 * @author Ronny
 */
public class Mapsuna extends Application {
    private double ejeX = 0;
    private double ejeY = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/mapsuna/view/Window.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image("/mapsuna/resources/logo.png"));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);

        Grafo grafo = new Grafo();

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
