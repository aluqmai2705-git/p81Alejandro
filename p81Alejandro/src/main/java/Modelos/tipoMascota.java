/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelos;

/**
 *
 * @author alejandro
 */
public enum tipoMascota {
    
    DOGS("dogs"),
    CATS("cats"),
    OTHERS("OTHERS");
    
    private final String valor;

    private tipoMascota(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
