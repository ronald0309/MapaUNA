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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ronny
 */
public class UnaController implements Initializable {

    @FXML
    private VBox titulo;
    @FXML
    private RadioButton tbNoViaIzq;
    @FXML
    private RadioButton tbNoViaDer;
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnAccidente;
    @FXML
    private AnchorPane contMap;
    @FXML
    private RadioButton V0;
    @FXML
    private RadioButton V1;
    @FXML
    private RadioButton V2;
    @FXML
    private RadioButton V3;
    @FXML
    private RadioButton V4;
    @FXML
    private RadioButton V5;
    @FXML
    private RadioButton V6;
    @FXML
    private RadioButton V7;
    @FXML
    private RadioButton V8;
    @FXML
    private RadioButton V9;
    @FXML
    private RadioButton V10;
    @FXML
    private RadioButton V11;
    @FXML
    private RadioButton V12;
    @FXML
    private RadioButton V13;
    @FXML
    private RadioButton V14;
    @FXML
    private RadioButton V15;
    @FXML
    private RadioButton V16;
    @FXML
    private RadioButton V17;
    @FXML
    private RadioButton V18;
    @FXML
    private RadioButton V19;
    @FXML
    private RadioButton V20;
    @FXML
    private RadioButton V21;
    @FXML
    private RadioButton V22;
    @FXML
    private RadioButton V23;
    @FXML
    private RadioButton V24;
    @FXML
    private RadioButton V25;
    @FXML
    private RadioButton V26;
    @FXML
    private RadioButton V27;
    @FXML
    private RadioButton V28;
    @FXML
    private RadioButton V29;
    @FXML
    private RadioButton V30;
    @FXML
    private RadioButton V31;
    @FXML
    private RadioButton V32;
    @FXML
    private RadioButton V33;
    @FXML
    private RadioButton V34;
    @FXML
    private RadioButton V35;
    @FXML
    private RadioButton V36;
    @FXML
    private RadioButton V37;
    @FXML
    private RadioButton V38;
    @FXML
    private RadioButton V39;
    @FXML
    private RadioButton V40;
    @FXML
    private RadioButton V41;
    @FXML
    private RadioButton V42;
    @FXML
    private RadioButton V43;
    @FXML
    private RadioButton V44;
    @FXML
    private RadioButton V45;
    @FXML
    private RadioButton V46;
    @FXML
    private RadioButton V47;
    @FXML
    private RadioButton V48;
    @FXML
    private RadioButton V49;
    @FXML
    private RadioButton V50;
    @FXML
    private RadioButton V51;
    @FXML
    private RadioButton V52;
    @FXML
    private RadioButton V53;
    @FXML
    private RadioButton V54;
    @FXML
    private RadioButton V55;
    @FXML
    private RadioButton V56;
    @FXML
    private RadioButton V57;
    @FXML
    private RadioButton V58;
    @FXML
    private RadioButton V59;
    @FXML
    private RadioButton V60;
    @FXML
    private RadioButton V61;
    @FXML
    private RadioButton V62;
    @FXML
    private RadioButton V63;
    @FXML
    private RadioButton V64;
    @FXML
    private RadioButton V65;
    @FXML
    private RadioButton V66;
    @FXML
    private RadioButton V67;
    @FXML
    private RadioButton V68;
    @FXML
    private RadioButton V69;
    @FXML
    private RadioButton V70;
    @FXML
    private RadioButton V71;
    @FXML
    private RadioButton V72;
    @FXML
    private RadioButton V73;
    @FXML
    private RadioButton V74;
    @FXML
    private RadioButton V75;
    @FXML
    private RadioButton V76;
    @FXML
    private RadioButton V77;
    @FXML
    private RadioButton V78;
    @FXML
    private RadioButton V79;
    @FXML
    private RadioButton V80;
    @FXML
    private RadioButton V81;
    @FXML
    private RadioButton V82;
    @FXML
    private RadioButton V83;
    @FXML
    private RadioButton V84;
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
    private double ejeX = 0;
    private double ejeY = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onActionSalir(ActionEvent event) {
        Stage stage = (Stage) btnInciar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void MousePressedTitulo(MouseEvent event) {

    }

    @FXML
    private void dragWindow(MouseEvent event) {
        
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

}
