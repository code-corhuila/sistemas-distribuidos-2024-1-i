/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class CapturarDato {

    public Double capturar(String mensaje) {
        Double numero = 0.0;
        Scanner scanner = new Scanner(System.in);

        
        do {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(scanner.nextLine());
                if(numero<=0.0){
                    System.out.println("Dato debe ser positivo.");
                }
            } catch (Exception e) {
                System.out.println("Dato no válido");
            }
        } while (numero<=0.0);

        return numero;
    }
}
