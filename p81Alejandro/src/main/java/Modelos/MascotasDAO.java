/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import Alejandro.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejandro
 */
public class MascotasDAO implements IMascotas{
    
    private Connection con = null;

    public MascotasDAO() {
        con = Conexion.getInstance();
    }
    
     public List<MascotasDTO> getAll() throws SQLException {
        List<MascotasDTO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from mascotas");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                MascotasDTO p = new MascotasDTO();
                // Recogemos los datos de la persona, guardamos en un objeto
                p.setPk(res.getInt("pk"));
                p.setPk_Veterinario(res.getInt("pk_veterinario"));
                p.setChip(res.getString("chip"));
                p.setName(res.getString("nombre"));
                p.setPeso(res.getDouble("peso"));
                p.setFechaNacimiento(res.getDate("fecha_nac").toLocalDate());
                p.setTipoMascota(res.getString("tipo"));
                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }
     
    // Este método permite obtener la última id de la tabla
    // Así se pueden insertar nuevos registros sin duplicar claves
    public int getLastInsertedId() throws SQLException {
        int lastId = 0; // Valor predeterminado si no hay registros

        String query = "SELECT MAX(pk) AS pk FROM mascotas";

        PreparedStatement statement = con.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            lastId = resultSet.getInt("pk");
        }

        return lastId;
    }

    public MascotasDTO findByPk(int pk) throws SQLException {

        ResultSet res = null;
        MascotasDTO mascota = new MascotasDTO();

        String sql = "select * from mascotas where pk=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                mascota.setPk(res.getInt("pk"));
                mascota.setPk_Veterinario(res.getInt("pk_veterinario"));
                mascota.setChip(res.getString("chip"));
                mascota.setName(res.getString("nombre"));
                mascota.setPeso(res.getDouble("peso"));
                mascota.setFechaNacimiento(res.getDate("fecha_nac").toLocalDate());
                mascota.setTipoMascota(res.getString("tipo"));
                return mascota;
            }

            return null;
        }
    }

    public int insertarMascota(MascotasDTO mascota) throws SQLException {

        int numFilas = 0;
        String sql = "insert into mascotas values (?,?,?,?,?,?,?)";

        if (findByPk(mascota.getPk()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, mascota.getPk());
                prest.setInt(2, mascota.getPk_Veterinario());
                prest.setString(3, mascota.getChip());
                prest.setString(4, mascota.getName());
                prest.setDouble(5, mascota.getPeso());
                prest.setDate(6, Date.valueOf(mascota.getFechaNacimiento()));
                prest.setString(7, mascota.getTipoMascota());
                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    }

    
    public int insertarMascota(List<MascotasDTO> lista) throws SQLException {
        int numFilas = 0;

        for (MascotasDTO tmp : lista) {
            numFilas += insertarMascota(tmp);
        }

        return numFilas;
    }
    
    public int borrarMascota() throws SQLException {

        String sql = "delete from mascotas";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;

    }

    public int borrarMascota(MascotasDTO mascota) throws SQLException {
        int numFilas = 0;

        String sql = "delete from mascotas where pk = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, mascota.getPk());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    public int actualizarMascota(int pk, MascotasDTO nuevosDatos) throws SQLException {

        int numFilas = 0;
        String sql = "update mascotas set idVeterinario= ?, chip = ?, name = ?, "
                + "peso= ?, fechaNacim= ?, tipo = ?, where pk=?";

        if (findByPk(pk) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, nuevosDatos.getPk_Veterinario());
                prest.setString(2, nuevosDatos.getChip());
                prest.setString(3, nuevosDatos.getName());
                prest.setDouble(4, nuevosDatos.getPeso());
                prest.setDate(5, Date.valueOf(nuevosDatos.getFechaNacimiento()));
                prest.setString(6, nuevosDatos.getTipoMascota());
                prest.setInt(7, pk);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }
}