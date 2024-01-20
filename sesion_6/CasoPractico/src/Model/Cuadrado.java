/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Abs.AFigura;
import static Interface.IFigura.personalizacionPI;

/**
 *
 * @author ariel
 */
public class Cuadrado extends AFigura{
    private Double base;

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }
    
    @Override
    public Double Area() {
        super.setArea(getBase()*getBase());
        return super.getArea();
    }
}
