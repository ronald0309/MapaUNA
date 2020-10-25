/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.mapsuna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import cr.ac.una.mapsuna.model.Dijkstra;
import cr.ac.una.mapsuna.model.Floyd;
import cr.ac.una.mapsuna.model.Grafo;
import cr.ac.una.mapsuna.model.GraphicManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

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
    private GraphicManager master;
    private Circle circle;
    private int x;
    private int y;

    @FXML
    private JFXRadioButton rdbDijkstra;
    @FXML
    private ToggleGroup tggAlgoritmo;
    @FXML
    private JFXRadioButton rdbFloyd;
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
    private JFXButton offroadButton;
    @FXML
    private JFXButton accidentButton;
    @FXML
    private Label costLabel;
    @FXML
    private JFXButton startButton;
    @FXML
    private JFXButton stopButton;
    @FXML
    private JFXButton exitButton;
    @FXML
    private HBox title;
    @FXML
    private JFXToggleButton leftway;
    @FXML
    private JFXToggleButton rightway;
    @FXML
    private Label costLabel1;
    @FXML
    private JFXComboBox<String> trafficCombo;
    @FXML
    private Label timeCost;
    @FXML
    private JFXButton resetButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trafficCombo.setPromptText("Trafico");
        trafficCombo.getItems().addAll(
                "Normal",
                "Moderado",
                "Lento"
        );
        grafo.inicializarPesos();
        grafo.inicializarMatAux();
        circle = new Circle();
        circle.setCenterX(300.0f);
        circle.setCenterY(135.0f);
        circle.setRadius(8.0f);
        circle.setFill(javafx.scene.paint.Color.INDIGO);
        circle.setId("bean");
        baseMap.getChildren().add(circle);
        master = new GraphicManager(circle, rdbDijkstra, rdbFloyd, costLabel, leftway, rightway, baseMap, 
                                    false, false, 1, timeCost, costLabel1);
        baseMap.getChildren().forEach(x -> {
            if (x.getClass() == RadioButton.class) {
                RadioButton r = (RadioButton) x;
                r.addEventFilter(MouseEvent.MOUSE_ENTERED, event -> r.setText(r.getId()));
                r.addEventFilter(MouseEvent.MOUSE_EXITED, event -> r.setText(""));
                x.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        master.mouseEvent(x, baseMap, 0);
                        if (master.getTrigger()) {
                           master.calcular();
                        }
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        master.mouseEvent(x, baseMap, 1);
                    }
                });
            }
        });
        master.start(baseMap, grafo.getGrafo(), leftway, rightway);
    }

    @FXML
    private void onActionStart(ActionEvent event) {
        master.enable();
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
        master.limpiarRuta(baseMap);
        master.setClicks(0);
        costLabel.setText("0");
        costLabel1.setText("0");
    }

    @FXML
    private void onActionStop(ActionEvent event) {
        //limpiarRutaPrevia();
        if (!master.getUpdate()) {
            stopButton.setText("Pausar");
        } else {
            stopButton.setText("Reanudar");
        }
        master.setUpdate();
    }

    @FXML
    private void onActionExit(ActionEvent event) {
        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onActionLeftway(ActionEvent event) {
        master.setRecalculate(true);
        master.setLeftFlag(true);//setear verdadero para revisar en la lista offRoad
        x = master.toNumber(leftway, 0);
        y = master.toNumber(leftway, 1);
        if (leftway.isSelected()) {
            if (master.getOnline()) {
                if (!"No hay via".equals(leftway.getText())) {
                    master.addOffRoad(x, y);
                    master.printOffRoads();
                    master.restoreOnline();
                }
            } else {
                leftway.setSelected(false);
                //message("Seleccione una linea para deshabilitar el camino");
            }
        } else {
            master.removeOffRoad(x, y);
        }
    }

    @FXML
    private void onActionRightWay(ActionEvent event) {
        master.setRecalculate(true);
        master.setRightFlag(true);
        y = master.toNumber(rightway, 0);
        x = master.toNumber(rightway, 1);
        if (rightway.isSelected()) {
            if (master.getOnline()) {
                if (!"No hay via".equals(rightway.getText())) {
                    master.addOffRoad(y, x);
                    master.printOffRoads();
                }
            } else {
                rightway.setSelected(false);
                message("Seleccione una linea para deshabilitar el camino");
            }
        } else {
            master.removeOffRoad(y, x);
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

    private void message(String msj) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Deshabilitar ruta");
        alert.setHeaderText("Informacion");
        alert.setContentText(msj);
        alert.showAndWait();
    }

    @FXML
    private void onMousePressedSlider(MouseEvent event) {
    }

    @FXML
    private void onActionTrafficCombo(ActionEvent event) {
        if (trafficCombo.getSelectionModel().getSelectedItem().equals("Normal")) {
            master.setTrafico(1);
            grafo.editarMatriz(master.getTrafico());
        } else {
            if (trafficCombo.getSelectionModel().getSelectedItem().equals("Moderado")) {
                master.setTrafico(2);
                grafo.editarMatriz(master.getTrafico());
            } else {
                //ES LENTO
                master.setTrafico(3);
                grafo.editarMatriz(master.getTrafico());
            }
        }
    }

    @FXML
    private void onActionResetButton(ActionEvent event) {
        limpiarRutaPrevia();
    }

}
