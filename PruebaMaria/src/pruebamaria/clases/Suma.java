/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebamaria.clases;

/**
 *
 * @author Ronny
 */
public class Suma {

    private Integer primerNumero;
    private Integer segundoNumero;

    public Suma() {
        this.primerNumero = 0;
        this.segundoNumero = 0;
    }

    public Suma(Integer primerNumero, Integer segundoNumero) {
        this.primerNumero = primerNumero;
        this.segundoNumero = segundoNumero;
    }

    public Integer getPrimerNumero() {
        return primerNumero;
    }

    public Integer getSegundoumero() {
        return segundoNumero;
    }

    public void setPrimerNumero(Integer primerNumero) {
        this.primerNumero = primerNumero;
    }

    public void setSegundoNumero(Integer Segundoumero) {
        this.segundoNumero = Segundoumero;
    }

    public Integer Sumar() {
        return this.primerNumero + this.segundoNumero;
    }

}
