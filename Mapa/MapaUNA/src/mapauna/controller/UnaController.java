package mapauna.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import mapauna.clases.Constants;
import mapauna.clases.Constants.Algoritmo;
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
    private final Vertice vertice_null = new Vertice();
    private Vertice origen = vertice_null;
    private Vertice destino = vertice_null;
    final ToggleGroup group = new ToggleGroup();
    private GrafoMatriz grafo = new GrafoMatriz(85);
    private Algoritmo algoritmo = Constants.Algoritmo.DIJKSTRA;
    private List<RadioButton> vertices;
    private List<Vertice> road;
    @FXML
    private RadioButton A80;
    @FXML
    private RadioButton A79;
    @FXML
    private RadioButton A78;
    @FXML
    private RadioButton A77;
    @FXML
    private AnchorPane dibujar_caminos;
    @FXML
    private AnchorPane dibujar_cerrado;
    @FXML
    private AnchorPane dibujar_provisional;
    @FXML
    private Pane car;
    private PathTransition transition;
    boolean update;
    Thread thread;
    @FXML
    private Group root;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        vertices = Arrays.asList(V0,V1,V2,V3,V4,V5,V6,V7,V8,V9,V10,V11,V12,V13,V14,V15,V16,V17,V18,V19,V20,V21,V22,V23,V24,V25,V26
                ,V27,V28,V29,V30,V31,V32,V33,V34,V35,V36,V37,V38,V39,V40,V41,V42,V43,V44,V45,V46,V47,V48,V49,V50,V51,V52,V53,V54,V55,
                V56,V57,V58,V59,V60,V61,V62,V63,V64,V65,V66,V67,V68,V69,V70,V71,V72,V73,V74,V75,V76,V77,V78,V79,V80,V81,V82,V84
        );
        vertices.forEach(this::associate_radio_with_group);
        group.selectedToggleProperty().addListener(this::proccess_action);
    }
    
    private void proccess_action(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle){
        if (group.getSelectedToggle() != null) {
            int VSeleccionado = Integer.valueOf( group.getSelectedToggle().getUserData().toString() );
            System.out.printf("%s%n", VSeleccionado);
            if(origen == vertice_null) origen = grafo.getVerts().get(VSeleccionado);
            else if( destino == vertice_null ){
                destino = grafo.getVerts().get(VSeleccionado);
                evaluate();
                dibujar_provisional.getChildren().removeAll(dibujar_provisional.getChildren());
                drawing_lines(road, dibujar_provisional, Constants.Clase.PROVISIONAL);
            }else {
                origen = vertice_null;
                destino = vertice_null;
            }
        }
    }
    
    private void evaluate(){
        switch(algoritmo){
            case DIJKSTRA:{
                road = Dijkstra.evaluate(grafo.getMatAd(), origen.getNumero(), destino.getNumero());
            }break;
            case FLOYD:{
                road = Floyd.evaluate(grafo.getMatAd(), origen.getNumero(), destino.getNumero());
            }break;
            default:{
                road = new ArrayList();
            }
        }
    }
    
    private void drawing_lines(List<Vertice> vertices, AnchorPane ventana, Constants.Clase clase){
        Iterator<Vertice> ite_o = vertices.iterator();
        Iterator<Vertice> ite_d = vertices.iterator();
        ite_d.next();
        while (ite_o.hasNext()) {
            if (ite_d.hasNext()) {
                ventana.getChildren().add( drawing_line(ite_o.next(), ite_d.next(), clase) );
            }else{
                break;
            }
        }
    }
    
    private void associate_radio_with_group(RadioButton v){
        v.setToggleGroup(group);
        v.setUserData( get_v_num(v.getId()) );
    }
    
    private String get_v_num(String id){
        return id.substring(1,id.length());
    }
    
    private Line drawing_line(Vertice origen, Vertice destino, Constants.Clase clase){
        Line line;
        RadioButton ROrigen = vertices.get(origen.getNumero());
        RadioButton RDestino = vertices.get(destino.getNumero());
        line = new Line(ROrigen.getLayoutX() + 7, ROrigen.getLayoutY() + 10, RDestino.getLayoutX() + 7, RDestino.getLayoutY() + 10);
        line.getStyleClass().add(clase.getName());
        return line;
    }
    
    private void run_car(){
        drawing_car();
    }
    
    private void drawing_car(){
        Iterator<Vertice> ite_o = road.iterator();
        Iterator<Vertice> ite_d = road.iterator();
        transition = new PathTransition();
        transition.setNode(car);
        Path path = new Path();
        path.getElements().add(new MoveTo(position_x(origen), position_y(origen)));
        int time = 0;
        ite_d.next();
        while (ite_o.hasNext()) {
            if (ite_d.hasNext()) time += drawing_car(ite_o.next(), ite_d.next(), path);
            else break;
        }
        path.getElements().add(new LineTo(position_x(destino), position_y(destino)));
        lbltimeCost.setText(String.valueOf(time));
        transition.setDuration(Duration.seconds(time));
        transition.setPath(path);
        transition.play();
    }
    
    private void clock(int time){
        
    }
    
    private double position_x(Vertice vertice){
        return vertices.get(vertice.getNumero()).getLayoutX();
    }
    
    private double position_y(Vertice vertice){
        return vertices.get(vertice.getNumero()).getLayoutY();
    }
    
    private int drawing_car(Vertice origen, Vertice destino, Path path){
        path.getElements().add(new LineTo(position_x(destino)+10, position_y(destino)));
        return grafo.getArco(origen, destino);
        
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
        if(destino != vertice_null){
            System.out.println( road );
            dibujar_caminos.getChildren().removeAll(dibujar_caminos.getChildren());
            drawing_lines(road, dibujar_caminos, Constants.Clase.CAMINO);
            run_car();
            reset_caminos();
        }else{
            System.out.println( "No ha seleccionado la ruta" );
        }
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
    private void onClickCerrar(ActionEvent event) {
        if(destino != vertice_null){
            update_camino(origen, destino, GrafoMatriz.INF);
            update_camino(destino, origen, GrafoMatriz.INF);
            reset_caminos();
            drawing_lines(road, dibujar_cerrado, Constants.Clase.CERRADO);
        }else{
            System.out.println( "No ha seleccionado un camino" );
        }
    }

    @FXML
    private void onClickAccidente(ActionEvent event) {
        if(destino != vertice_null){
            if(tbNoViaIzq.isSelected()){
                update_camino(destino, origen, GrafoMatriz.INF);
            }
            if(tbNoViaDer.isSelected()){
                update_camino(origen, destino, GrafoMatriz.INF);
            }
            reset_caminos();
            drawing_lines(road, dibujar_cerrado, Constants.Clase.ACCIDENTE);
        }else{
            System.out.println( "No ha seleccionado un camino" );
        }
    }
    
    private void update_camino(Vertice origen, Vertice destino, int nuevo_peso){
        int peso_actual = grafo.getArco(origen, destino);
        if (peso_actual != GrafoMatriz.INF){
            grafo.setArco(origen, destino, nuevo_peso);
            String a = (peso_actual == GrafoMatriz.INF) ? "tiempo indefinido (camino cerrado)" : String.valueOf(peso_actual) + " minutos";
            String n = (nuevo_peso == GrafoMatriz.INF) ? "tiempo indefinido (camino cerrado)" : String.valueOf(nuevo_peso) + " minutos";
            System.out.printf( "Se cambio el tiempo del camido de %s a %s %n", a, n);
        }else{
            System.out.println( "Debe seleccionar dos vertices adyacentes" );
        }
    }

    @FXML
    private void onClickVector(MouseEvent event) {
    }
    
    private void reset_caminos(){
        origen = vertice_null;
        destino = vertice_null;
        dibujar_provisional.getChildren().removeAll(dibujar_provisional.getChildren());
    }
    
}
