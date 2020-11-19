/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapsuna.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import mapsuna.model.Dijkstra;
import mapsuna.model.GraphicManager;
import mapsuna.model.Floyd;
import mapsuna.model.Grafo;

/**
 * FXML Controller class
 *
 * @author Jona
 */
public class WindowController implements Initializable {

    private double ejeX = 0;
    private double ejeY = 0;

    Floyd floyd = new Floyd();
    Dijkstra dijkstra = new Dijkstra();
    Grafo grafo = new Grafo();
    private GraphicManager manager;
    private Circle circulo;
    private int x;
    private int y;

    @FXML
    private RadioButton rdbDijkstra;
    @FXML
    private ToggleGroup tggAlgoritmo;
    @FXML
    private RadioButton rdbFloyd;
    @FXML
    private AnchorPane baseMap;
    @FXML
    private RadioButton A26;
    @FXML
    private RadioButton A24;
    @FXML
    private RadioButton A1;
    @FXML
    private RadioButton A2;
    @FXML
    private RadioButton A6;
    @FXML
    private RadioButton A5;
    @FXML
    private RadioButton A4;
    @FXML
    private RadioButton A3;
    @FXML
    private RadioButton A8;
    @FXML
    private RadioButton A11;
    @FXML
    private RadioButton A9;
    @FXML
    private RadioButton A10;
    @FXML
    private RadioButton A7;
    @FXML
    private RadioButton A75;
    @FXML
    private RadioButton A15;
    @FXML
    private RadioButton A27;
    @FXML
    private RadioButton A16;
    @FXML
    private RadioButton A17;
    @FXML
    private RadioButton A25;
    @FXML
    private RadioButton A29;
    @FXML
    private RadioButton A28;
    @FXML
    private RadioButton A21;
    @FXML
    private RadioButton A12;
    @FXML
    private RadioButton A13;
    @FXML
    private RadioButton A14;
    @FXML
    private RadioButton A20;
    @FXML
    private RadioButton A19;
    @FXML
    private RadioButton A18;
    @FXML
    private RadioButton A31;
    @FXML
    private RadioButton A30;
    @FXML
    private RadioButton A32;
    @FXML
    private RadioButton A33;
    @FXML
    private RadioButton A34;
    @FXML
    private RadioButton A35;
    @FXML
    private RadioButton A22;
    @FXML
    private RadioButton A23;
    @FXML
    private RadioButton A36;
    @FXML
    private RadioButton A37;
    @FXML
    private RadioButton A38;
    @FXML
    private RadioButton A39;
    @FXML
    private RadioButton A40;
    @FXML
    private RadioButton A41;
    @FXML
    private RadioButton A42;
    @FXML
    private RadioButton A43;
    @FXML
    private RadioButton A44;
    @FXML
    private RadioButton A53;
    @FXML
    private RadioButton A52;
    @FXML
    private RadioButton A51;
    @FXML
    private RadioButton A50;
    @FXML
    private RadioButton A49;
    @FXML
    private RadioButton A48;
    @FXML
    private RadioButton A58;
    @FXML
    private RadioButton A57;
    @FXML
    private RadioButton A56;
    @FXML
    private RadioButton A46;
    @FXML
    private RadioButton A47;
    @FXML
    private RadioButton A45;
    @FXML
    private RadioButton A54;
    @FXML
    private RadioButton A55;
    @FXML
    private RadioButton A64;
    @FXML
    private RadioButton A63;
    @FXML
    private RadioButton A62;
    @FXML
    private RadioButton A76;
    @FXML
    private RadioButton A72;
    @FXML
    private RadioButton A73;
    @FXML
    private RadioButton A74;
    @FXML
    private RadioButton A66;
    @FXML
    private RadioButton A59;
    @FXML
    private RadioButton A71;
    @FXML
    private RadioButton A67;
    @FXML
    private RadioButton A60;
    @FXML
    private RadioButton A61;
    @FXML
    private RadioButton A68;
    @FXML
    private RadioButton A70;
    @FXML
    private RadioButton A69;
    @FXML
    private RadioButton A80;
    @FXML
    private RadioButton A79;
    @FXML
    private RadioButton A78;
    @FXML
    private RadioButton A77;
    @FXML
    private RadioButton A65;
    @FXML
    private Label costLabel;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private Button exitButton;
    @FXML
    private HBox title;
    @FXML
    private ToggleButton leftway;
    @FXML
    private ToggleButton rightway;
    @FXML
    private Label costLabel1;
    @FXML
    private ComboBox<?> trafficCombo;
    @FXML
    private Label timeCost;
    @FXML
    private Button resetButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        inicializarValores();
        manager = new GraphicManager(circulo, rdbDijkstra, rdbFloyd, costLabel, leftway, rightway, baseMap,false, false, 1, timeCost, costLabel1);
        baseMap.getChildren().forEach(x -> {
            if (x.getClass() == RadioButton.class) {
                RadioButton ver = (RadioButton) x;
                ver.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> ver.setText(ver.getId()));
                ver.addEventFilter(MouseEvent.MOUSE_EXITED, event -> ver.setText(""));
                x.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        manager.mouseEvent(x, baseMap, 0);
                        if (manager.getTrigger()) {
                           manager.getCalcular();
                        }
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        manager.mouseEvent(x, baseMap, 1);
                    }
                });
            }
        });
        manager.iniciar(baseMap, grafo.getGrafo(), leftway, rightway);
    }
   void inicializarValores(){
       trafficCombo.setPromptText("Trafico");
        /*trafficCombo.getItems().addAll(
                "Normal",
                "Moderado",
                "Lento"
        );*/
        grafo.inicializarPesos();
        grafo.inicializarMatAux();
        circulo = new Circle();
        circulo.setCenterX(300.0f);
        circulo.setCenterY(135.0f);
        circulo.setRadius(8.0f);
        circulo.setFill(javafx.scene.paint.Color.INDIGO);
        circulo.setId("bean");
        baseMap.getChildren().add(circulo);
   }
    @FXML
    private void onActionStart(ActionEvent event) {
        manager.enable();
        System.out.println("-----------");
        ArrayList<RadioButton> radios = new ArrayList<>();
        baseMap.getChildren().forEach(item -> {
            if (item.getClass() == RadioButton.class) {
                RadioButton radio = (RadioButton) item;
                radio.setSelected(false);
            }
        });
    }

    private void limpiarRutaPrevia() {
        manager.limpiarRuta(baseMap);
        manager.setClicks(0);
        costLabel.setText("0");
        costLabel1.setText("0");
    }

    @FXML
    private void onActionStop(ActionEvent event) {
        //limpiarRutaPrevia();
        if (!manager.getUpdate()) {
            stopButton.setText("Pausar");
        } else {
            stopButton.setText("Reanudar");
        }
        manager.setUpdate();
    }

    @FXML
    private void onActionExit(ActionEvent event) {
        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onActionLeftway(ActionEvent event) {
        manager.setRecalculate(true);
        manager.setLeftFlag(true);//setear verdadero para revisar en la lista offRoad
        x = manager.toNumber(leftway, 0);
        y = manager.toNumber(leftway, 1);
        if (leftway.isSelected()) {
            if (manager.getOnline()) {
                if (!"No hay via".equals(leftway.getText())) {
                    manager.addOffRoad(x, y);
                    manager.printOffRoads();
                    manager.restoreOnline();
                }
            } else {
                leftway.setSelected(false);
            }
        } else {
            manager.removeOffRoad(x, y);
        }
    }

    @FXML
    private void onActionRightWay(ActionEvent event) {
        manager.setRecalculate(true);
        manager.setRightFlag(true);
        y = manager.toNumber(rightway, 0);
        x = manager.toNumber(rightway, 1);
        if (rightway.isSelected()) {
            if (manager.getOnline()) {
                if (!"No hay via".equals(rightway.getText())) {
                    manager.addOffRoad(y, x);
                    manager.printOffRoads();
                }
            } else {
                rightway.setSelected(false);
                Mensaje("Seleccione una linea para deshabilitar el camino");
            }
        } else {
            manager.removeOffRoad(y, x);
        }

    }

    @FXML
    private void dragWindow(MouseEvent event) {
        Stage stage = (Stage) title.getScene().getWindow();
        stage.setX(event.getScreenX() - ejeX);
        stage.setY(event.getScreenY() - ejeY);
    }

    @FXML
    private void pressWindow(MouseEvent event) {
        ejeX = event.getSceneX();
        ejeY = event.getSceneY();
    }

    private void Mensaje(String msj) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Informacion");
        alert.setContentText(msj);
        alert.showAndWait();
    }

    @FXML
    private void onActionTrafficCombo(ActionEvent event) {
        if (trafficCombo.getSelectionModel().getSelectedItem().equals("Normal")) {
            manager.setTrafico(1);
            grafo.editarMatriz(manager.getTrafico());
        } else {
            if (trafficCombo.getSelectionModel().getSelectedItem().equals("Moderado")) {
                manager.setTrafico(2);
                grafo.editarMatriz(manager.getTrafico());
            } else {
                //ES LENTO
                manager.setTrafico(3);
                grafo.editarMatriz(manager.getTrafico());
            }
        }
    }

    @FXML
    private void onActionResetButton(ActionEvent event) {
        limpiarRutaPrevia();
    }


}
