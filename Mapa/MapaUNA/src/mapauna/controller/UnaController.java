package mapauna.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import mapauna.clases.Algoritmo_Ruta_Mas_Corta;
import mapauna.clases.Dijkstra;
import mapauna.clases.Floyd;
import mapauna.clases.GrafoMatriz;
import mapauna.clases.Vertice;

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
    @FXML
    private AnchorPane baseMap;
    @FXML
    private HBox hb_d;
    @FXML
    private RadioButton V59;
    @FXML
    private RadioButton V39;
    @FXML
    private RadioButton V1;
    @FXML
    private RadioButton V24;
    @FXML
    private RadioButton V3;
    @FXML
    private RadioButton V67;
    @FXML
    private RadioButton V28;
    @FXML
    private RadioButton V4;
    @FXML
    private RadioButton V9;
    @FXML
    private RadioButton V5;
    @FXML
    private RadioButton V23;
    @FXML
    private RadioButton V22;
    @FXML
    private RadioButton V7;
    @FXML
    private RadioButton V30;
    @FXML
    private RadioButton V38;
    @FXML
    private RadioButton V37;
    @FXML
    private RadioButton V57;
    @FXML
    private RadioButton V41;
    @FXML
    private RadioButton V36;
    @FXML
    private RadioButton V31;
    @FXML
    private RadioButton V2;
    @FXML
    private RadioButton V26;
    @FXML
    private RadioButton V21;
    @FXML
    private RadioButton V27;
    @FXML
    private RadioButton V25;
    @FXML
    private RadioButton V58;
    @FXML
    private RadioButton V68;
    @FXML
    private RadioButton V33;
    @FXML
    private RadioButton V69;
    @FXML
    private RadioButton V83;
    @FXML
    private RadioButton V66;
    @FXML
    private RadioButton V8;
    @FXML
    private RadioButton V6;
    @FXML
    private RadioButton V48;
    @FXML
    private RadioButton V74;
    @FXML
    private RadioButton V10;
    @FXML
    private RadioButton V32;
    @FXML
    private RadioButton V60;
    @FXML
    private RadioButton V70;
    @FXML
    private RadioButton V40;
    @FXML
    private RadioButton V19;
    @FXML
    private RadioButton V20;
    @FXML
    private RadioButton V34;
    @FXML
    private RadioButton V17;
    @FXML
    private RadioButton V55;
    @FXML
    private RadioButton V47;
    @FXML
    private RadioButton V65;
    @FXML
    private RadioButton V61;
    @FXML
    private RadioButton V71;
    @FXML
    private RadioButton V49;
    @FXML
    private RadioButton V77;
    @FXML
    private RadioButton V42;
    @FXML
    private RadioButton V56;
    @FXML
    private RadioButton V81;
    @FXML
    private RadioButton V75;
    @FXML
    private RadioButton V82;
    @FXML
    private RadioButton V76;
    @FXML
    private RadioButton V78;
    @FXML
    private RadioButton V45;
    @FXML
    private RadioButton V73;
    @FXML
    private RadioButton V50;
    @FXML
    private RadioButton V63;
    @FXML
    private RadioButton V43;
    @FXML
    private RadioButton V51;
    @FXML
    private RadioButton V12;
    @FXML
    private RadioButton V15;
    @FXML
    private RadioButton V84;
    @FXML
    private RadioButton V52;
    @FXML
    private RadioButton V14;
    @FXML
    private RadioButton V18;
    @FXML
    private RadioButton V46;
    @FXML
    private RadioButton V35;
    @FXML
    private RadioButton V44;
    @FXML
    private RadioButton A80;
    @FXML
    private RadioButton A79;
    @FXML
    private RadioButton A78;
    @FXML
    private RadioButton A77;
    @FXML
    private RadioButton V11;
    @FXML
    private RadioButton V54;
    @FXML
    private RadioButton V72;
    @FXML
    private RadioButton V80;
    @FXML
    private RadioButton V79;
    @FXML
    private RadioButton V13;
    @FXML
    private RadioButton V64;
    @FXML
    private RadioButton V53;
    @FXML
    private RadioButton V62;
    @FXML
    private RadioButton V29;
    @FXML
    private RadioButton V16;
    @FXML
    private RadioButton V0;
    //
    int VOrigen = -1;
    final ToggleGroup group = new ToggleGroup();
    private GrafoMatriz grafo = new GrafoMatriz(85);
    private Algoritmo_Ruta_Mas_Corta algoritmo = Algoritmo_Ruta_Mas_Corta.FLOYD;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<RadioButton> vertices = Arrays.asList(V0,V1,V2,V3,V4,V5,V6,V7,V8,V9,V10,V11,V12,V13,V14,V15,V16,V17,V18,V19,V20,V21,V22,V23
                ,V24,V25,V26,V27,V28,V29,V30,V31,V32,V33,V34,V35,V36,V37,V38,V39,V40,V41,V42,V43,V44,V45,V46,V47,V48,V50,V51,V52,V53,V54
                ,V55,V56,V57,V58,V59,V60,V61,V62,V63,V64,V65,V66,V67,V68,V69,V70,V71,V72,V73,V74,V75,V76,V77,V78,V79,V80,V81,V82,V84
        );
        vertices.forEach(this::associate_radio_with_group);
        //
        group.selectedToggleProperty().addListener(this::proccess_action);
    }
    
    private void proccess_action(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle){
        if (group.getSelectedToggle() != null) {
            int VSeleccionado = Integer.valueOf( group.getSelectedToggle().getUserData().toString() );
            System.out.printf("%s%n", VSeleccionado);
            if(VOrigen == -1) VOrigen = VSeleccionado;
            else{
               System.out.println( evaluate(VSeleccionado) );
               VOrigen = -1;
            }
        }
    }
    
    private List<Vertice> evaluate(int VSeleccionado){
        List<Vertice> result;
        switch(algoritmo){
            case DIJKSTRA:{
                result = Dijkstra.evaluate(grafo.getMatAd(), VOrigen, VSeleccionado);
            }break;
            case FLOYD:{
                result = Floyd.evaluate(grafo.getMatAd(), VOrigen, VSeleccionado);
            }break;
            default:{
                result = new ArrayList();
            }
        }
        return result;
    }
    
    private void associate_radio_with_group(RadioButton v){
        v.setToggleGroup(group);
        v.setUserData( get_v_num(v.getId()) );
    }
    
    private String get_v_num(String id){
        return id.substring(1,id.length());
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
