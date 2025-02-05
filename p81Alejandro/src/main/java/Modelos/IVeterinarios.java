/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelos;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alejandro
 */
public interface IVeterinarios {
    // Método para obtener todos los registros de la tabla
    List<VeterinariosDTO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    VeterinariosDTO findByPk(int pk) throws SQLException;
    
    // Método para insertar un registro
    int insertarVeterinario (VeterinariosDTO veterinario) throws SQLException;
    
    // Método para insertar varios registros
    int insertarVeterinario (List<VeterinariosDTO> lista) throws SQLException;
    
    // Método para borrar una persona
    int borrarVeterinario (VeterinariosDTO veterinario) throws SQLException;
    
    // Método para borrar toda la tabla
    int borrarVeterinario() throws SQLException;
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int actualizarVeterinario (int pk, VeterinariosDTO nuevosDatos) throws SQLException;
}
