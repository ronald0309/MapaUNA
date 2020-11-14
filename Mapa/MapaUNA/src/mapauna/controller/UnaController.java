/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapauna.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ronny
 */
public class UnaController implements Initializable {

    @FXML
    private RadioButton tbNoViaIzq;
    @FXML
    private RadioButton tbNoViaDer;
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnAccidente;
    @FXML
    private RadioButton rdbDijkstra;
    @FXML
    private RadioButton rdbFloyd;
    @FXML
    private ComboBox<?> trafficCombo;
    @FXML
    private Label lblCostPrevio;
    @FXML
    private Label lblCostFinal;
    @FXML
    private Label lbltimeCost;
    @FXML
    private Button btnInciar;
    @FXML
    private Button btnDetener;
    @FXML
    private Button btnReiniciar;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onActionViaIzquierda(ActionEvent event) {
    }

    @FXML
    private void onActionViaDerecha(ActionEvent event) {
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
    
}
