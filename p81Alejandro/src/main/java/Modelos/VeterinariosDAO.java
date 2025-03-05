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
public class VeterinariosDAO implements IVeterinarios{
    
    private Connection con = null;

    public VeterinariosDAO() {
        con = Conexion.getInstance();
    }
     public List<VeterinariosDTO> getAll() throws SQLException {
        List<VeterinariosDTO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from veterinarios");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                VeterinariosDTO p = new VeterinariosDTO();
                // Recogemos los datos de la persona, guardamos en un objeto
                p.setIdVeterinario(res.getInt("idVeterinario"));
                p.setNif(res.getString("nif"));
                p.setName(res.getString("name"));
                p.setAddress(res.getString("address"));
                p.setPhoneNumber(res.getString("phoneNumber"));
                p.setEmail(res.getString("email"));
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

        String query = "SELECT MAX(idVeterinario) AS idVeterinario FROM veterinarios";

        PreparedStatement statement = con.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            lastId = resultSet.getInt("idVeterinario");
        }

        return lastId;
    }

    public VeterinariosDTO findByPk(int idVeterinario) throws SQLException {

        ResultSet res = null;
        VeterinariosDTO persona = new VeterinariosDTO();

        String sql = "select * from veterinarios where idVeterinario=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, idVeterinario);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                persona.setIdVeterinario(res.getInt("idVeterinario"));
                persona.setName(res.getString("name"));
                persona.setNif(res.getString("nif"));
                persona.setAddress(res.getString("address"));
                persona.setPhoneNumber(res.getString("phoneNumber"));
                persona.setEmail(res.getString("email"));
                return persona;
            }

            return null;
        }
    }

    @Override
    public int insertarVeterinario(VeterinariosDTO veterinario) throws SQLException {

        int numFilas = 0;
        String sql = "insert into veterinarios values (?,?,?,?,?,?)";

        if (findByPk(veterinario.getIdVeterinario()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, veterinario.getIdVeterinario());
                prest.setString(2, veterinario.getNif());
                prest.setString(3, veterinario.getName());
                prest.setString(4, veterinario.getAddress());
                prest.setString(5, veterinario.getPhoneNumber());
                prest.setString(6, veterinario.getEmail());
                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

    
    @Override
    public int insertarVeterinario(List<VeterinariosDTO> lista) throws SQLException {
        int numFilas = 0;

        for (VeterinariosDTO tmp : lista) {
            numFilas += insertarVeterinario(tmp);
        }

        return numFilas;
    }
    
    @Override
    public int borrarVeterinario() throws SQLException {

        String sql = "delete from veterinarios";

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

    @Override
    public int borrarVeterinario(VeterinariosDTO veterinario) throws SQLException {
        int numFilas = 0;

        String sql = "delete from veterinarios where idVeterinario = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, veterinario.getIdVeterinario());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }
    
    @Override
    public int borrarVeterinario(int idVeterinario) throws SQLException {
        int numFilas = 0;

        String sql = "delete from veterinarios where idVeterinario = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, idVeterinario);
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int actualizarVeterinario(int idVeterinario, VeterinariosDTO nuevosDatos) throws SQLException {

        int numFilas = 0;
        String sql = "update veterinarios set nif= ?, name = ?, address = ?, "
                + "phoneNumber= ?, email = ? where idVeterinario=?";

        if (findByPk(idVeterinario) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1, nuevosDatos.getNif());
                prest.setString(2, nuevosDatos.getName());
                prest.setString(3, nuevosDatos.getAddress());
                prest.setString(4, nuevosDatos.getPhoneNumber());
                prest.setString(5, nuevosDatos.getEmail());
                prest.setInt(6, idVeterinario);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }
}
    
