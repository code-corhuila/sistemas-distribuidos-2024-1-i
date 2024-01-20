/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Abs.AFigura;
import Model.CapturarDato;
import Model.Circulo;
import Model.Cuadrado;

/**
 *
 * @author ariel
 */
public class Ejecutar {
    public static void main(String[] args) {
        CapturarDato capturar = new CapturarDato();
        
        Circulo circulo = new Circulo();
        circulo.setRadio(capturar.capturar("Digite el radio del circulo: "));
        System.out.println(circulo.Area());
        
        Cuadrado cuadrado = new Cuadrado();
        cuadrado.setBase(capturar.capturar("Digite la altura del cuadrado: "));
        System.out.println(cuadrado.Area());
    }
}
