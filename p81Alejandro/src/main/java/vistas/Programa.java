/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import Modelos.MascotasDAO;
import Modelos.MascotasDTO;
import Modelos.VeterinariosDAO;
import Modelos.VeterinariosDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejandro
 */
public class Programa {
    
    public static void main(String[] args) {
        
        VeterinariosDAO veterinarios = new VeterinariosDAO();
        List<VeterinariosDTO> listaVeterinario = new ArrayList<>();
        
        listaVeterinario.add(new VeterinariosDTO(1, "123123", "Alejandro", "asdasd", "5123123", LocalDate.of(1989, 2, 13), "123123@gmail.com"));
        listaVeterinario.add(new VeterinariosDTO(2,"3213", "Marcos", "asdasd", "1323123", LocalDate.of(1972,2,2), "123123@gmail.com"));
        listaVeterinario.add(new VeterinariosDTO(3,"34523", "Lucas", "asdasd", "1231223", LocalDate.of(1972,2,2), "123123@gmail.com"));
        listaVeterinario.add(new VeterinariosDTO(4,"23432", "Pedro", "asdasd", "1231123", LocalDate.of(1972,2,2), "123123@gmail.com"));
        listaVeterinario.add(new VeterinariosDTO(5,"54423", "Miguel", "asdasd", "1231s23", LocalDate.of(1972,2,2), "123123@gmail.com"));
        
        
        MascotasDAO mascotas = new MascotasDAO();
        List<MascotasDAO> listaMascota = new ArrayList<>();
        listaMascota.add(new MascotaDTO())
        String menu1 = """
                      1. Veterinarios
                      2. Mascotas
                      3. salir
                      """;
        String menu2 = """
                      1. Insertar
                      2. Consultar
                      3. Borrar
                      4. Atras
                      """;
        int opcion=0;
        boolean salir=false;
        
        
        do{
            System.out.println(menu1);
            
        switch(opcion){
            
            case 1->{
                switch(opcion){
                    case 1 ->{
                        
                    }case 2 ->{
                        
                    }case 3 ->{
                        
                    }case 4 ->{
                        
                        
                        
                    }default ->{
                        System.out.println("Salir...");
                        salir=true;
                        break;
                    }
                }
                
            } case 2 ->{
                
                
            }case 3 ->{
                System.out.println("Salir...");
                salir=true;
                break;
                
            }case 4 ->{
                
            }
            default ->{
                
                
                 salir=false;
                 break;
            }
        }
        
        
        }while(!salir);
        
        
        
        
        
        
    }
    
    
    
    
}
