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
    
    @Override
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
                p.setPk(res.getInt("idMascota"));
                p.setIdVeterinario(res.getInt("idVeterinario"));
                p.setChip(res.getString("chip"));
                p.setName(res.getString("name"));
                p.setPeso(res.getDouble("peso"));
                p.setFechaNacimiento(res.getDate("fechaNacim").toLocalDate());
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

        String query = "SELECT MAX(idMascota) AS idMascota FROM mascotas";

        PreparedStatement statement = con.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            lastId = resultSet.getInt("idMascota");
        }

        return lastId;
    }

    @Override
    public MascotasDTO findByPk(int idMascota) throws SQLException {

        ResultSet res = null;
        MascotasDTO mascota = new MascotasDTO();

        String sql = "select * from mascotas where idMascota=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, idMascota);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                mascota.setPk(res.getInt("idMascota"));
                mascota.setIdVeterinario(res.getInt("idVeterinario"));
                mascota.setChip(res.getString("chip"));
                mascota.setName(res.getString("name"));
                mascota.setPeso(res.getDouble("peso"));
                mascota.setFechaNacimiento(res.getDate("fechaNacim").toLocalDate());
                mascota.setTipoMascota(res.getString("tipo"));
                return mascota;
            }

            return null;
        }
    }

    @Override
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
                prest.setInt(2, mascota.getIdVeterinario());
                if( mascota.getIdVeterinario()==0){
                    prest.setNull(2, java.sql.Types.INTEGER);
                }
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

    
    @Override
    public int insertarMascota(List<MascotasDTO> lista) throws SQLException {
        int numFilas = 0;

        for (MascotasDTO tmp : lista) {
            numFilas += insertarMascota(tmp);
        }

        return numFilas;
    }
    
    @Override
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

    @Override
    public int borrarMascota(MascotasDTO mascota) throws SQLException {
        int numFilas = 0;

        String sql = "delete from mascotas where idMascota = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, mascota.getPk());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }
    
    @Override
    public int borrarMascota(int idMascota) throws SQLException {
        int numFilas = 0;

        String sql = "delete from mascotas where idMascota = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, idMascota);
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int actualizarMascota(int idMascota, MascotasDTO nuevosDatos) throws SQLException {

        int numFilas = 0;
        String sql = "update mascotas set idVeterinario= ?, chip = ?, name = ?, "
                + "peso= ?, fechaNacim= ?, tipo = ? where idMascota=?";

        if (findByPk(idMascota) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, nuevosDatos.getIdVeterinario());
                prest.setString(2, nuevosDatos.getChip());
                prest.setString(3, nuevosDatos.getName());
                prest.setDouble(4, nuevosDatos.getPeso());
                prest.setDate(5, Date.valueOf(nuevosDatos.getFechaNacimiento()));
                prest.setString(6, nuevosDatos.getTipoMascota());
                prest.setInt(7, idMascota);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }
}