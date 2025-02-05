/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alejandro;

/**
 *
 * @author alejandro
 */
import java.sql.Connection;
import Modelos.MascotasDAO;
import Modelos.MascotasDTO;
import Modelos.VeterinariosDAO;
import Modelos.VeterinariosDTO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prueba {

    public static void main(String[] args) {
        
        Connection con = Conexion.getInstance();
        
        VeterinariosDAO veterinario = new VeterinariosDAO();
        
        
        
    }
    
}