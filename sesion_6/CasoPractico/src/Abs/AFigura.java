/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abs;

import Interface.IFigura;

/**
 *
 * @author ariel
 */
public abstract class AFigura implements IFigura {
    
    private Double area;

    protected Double getArea() {
        return area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }
    
    // Cumplir con el método definido en la interfaz.
    @Override
    public Double Area() {
        return 0.0;
    }

}
