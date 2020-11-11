/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapauna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Ronny
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Label lblCostPrevio;
    @FXML
    private Label lblCostFinal;
    @FXML
    private JFXRadioButton rdbDijkstra;
    @FXML
    private JFXRadioButton rdbFloyd;
    @FXML
    private JFXComboBox<?> trafficCombo;
    @FXML
    private JFXButton btnInciar;
    @FXML
    private JFXButton btnDetener;
    @FXML
    private JFXButton btnReiniciar;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnCerrar;
    @FXML
    private JFXButton btnAccidente;
    @FXML
    private JFXToggleButton tbNoViaIzq;
    @FXML
    private JFXToggleButton tbNoViaDer;
    @FXML
    private Label lbltimeCost;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onMousePressedSlider(MouseEvent event) {
    }

    @FXML
    private void onActionTrafficoCombo(ActionEvent event) {
    }

    @FXML
    private void onActionIniciar(ActionEvent event) {
    }

    @FXML
    private void onActionDetener(ActionEvent event) {
    }

    @FXML
    private void onActionReiniciar(ActionEvent event) {
    }

    @FXML
    private void onActionSalir(ActionEvent event) {
        Stage stage = (Stage) btnInciar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onActionViaIzquierda(ActionEvent event) {
    }

    @FXML
    private void onActionViaDerecha(ActionEvent event) {
    }
    
}
