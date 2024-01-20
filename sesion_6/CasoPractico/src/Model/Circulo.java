/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Abs.AFigura;

/**
 *
 * @author ariel
 */
public class Circulo extends AFigura{
    
    private Double radio;

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public Double Area() {
        super.setArea(personalizacionPI*Math.pow(getRadio(), 2));
        return super.getArea();
    }
    
        
}
