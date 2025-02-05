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
public interface IMascotas {
    // Método para obtener todos los registros de la tabla
    List<MascotasDTO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    MascotasDTO findByPk(int pk) throws SQLException;
    
    // Método para insertar un registro
    int insertarMascota (MascotasDTO mascota) throws SQLException;
    
    // Método para insertar varios registros
    int insertarMascota (List<MascotasDTO> lista) throws SQLException;
    
    // Método para borrar una persona
    int borrarMascota (MascotasDTO mascota) throws SQLException;
    
    // Método para borrar toda la tabla
    int borrarMascota() throws SQLException;
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int actualizarMascota (int pk, MascotasDTO nuevosDatos) throws SQLException;
}
