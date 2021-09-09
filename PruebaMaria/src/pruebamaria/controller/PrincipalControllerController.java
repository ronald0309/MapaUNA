/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebamaria.controller;

import pruebamaria.clases.Suma;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Scanner;

/**
 *
 * @author Ronny
 */
public class PrincipalControllerController implements Initializable {
    
    
    private Integer sumador=0;
    private Boolean bandera= false;
    @FXML
    private Button btnAceptar;
    @FXML
    private Label lblMostrar;
    private Suma suma= new Suma();
    @FXML
    private TextField txtNumero2;
    @FXML
    private TextField txtNumero1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
//        if(txtNumero1.getLength()>0 && txtNumero2.getLength()>0){
//            suma.setPrimerNumero(Integer.valueOf(txtNumero1.getText()));
//            suma.setSegundoNumero(Integer.valueOf(txtNumero2.getText()));
//            lblMostrar.setText(String.valueOf(suma.Sumar()));
//        }else{
            
            Integer fac=1;
            Integer n= Integer.valueOf(txtNumero1.getText());
            for(int i=1;i<=n;i++){
                fac=fac*i;
            }
            lblMostrar.setText(String.valueOf(fac));
            
        //}
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblMostrar.setText("Hello World!");
    }    
    
}
