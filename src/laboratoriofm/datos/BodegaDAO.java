/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriofm.datos;

import laboratoriofm.dominio.Bodega;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author gegmo
 */
public class BodegaDAO {

    private static final String SQL_INSERT = "INSERT INTO tbl_bodega(PK_id_bodega, nombre_articulo, autor_articulo, genero_articulo, tipo_articulo, cantidad_articulo) VALUES(?,?,?,?,?,?)";

    private static final String SQL_SELECT = "SELECT PK_id_bodega, nombre_articulo, autor_articulo, genero_articulo, tipo_articulo, cantidad_articulo FROM tbl_bodega";

    private static final String SQL_UPDATE = "UPDATE tbl_bodega SET nombre_articulo=?, autor_articulo=?, genero_articulo=?, tipo_articulo=?, cantidad_articulo=? WHERE PK_id_bodega = ?";

    public static final String SQL_QUERY = "SELECT PK_id_bodega, nombre_articulo, autor_articulo, genero_articulo, tipo_articulo, cantidad_articulo FROM tbl_bodega WHERE PK_id_bodega = ?";

    public static final String SQL_DELETE ="DELETE FROM tbl_bodega WHERE PK_id_bodega=?";

   
    public int insert(Bodega mantenimiento_bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, mantenimiento_bodega.getId_Bodega());
            stmt.setString(2, mantenimiento_bodega.getNombre_Art());
            stmt.setString(3, mantenimiento_bodega.getAutor_Art());
            stmt.setString(4, mantenimiento_bodega.getGenero());
            stmt.setString(5, mantenimiento_bodega.getTipo_Art());
            stmt.setInt(6, mantenimiento_bodega.getCantidad_Art());

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Bodega mantenimiento_bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, mantenimiento_bodega.getNombre_Art());
            stmt.setString(2, mantenimiento_bodega.getAutor_Art());
            stmt.setString(3, mantenimiento_bodega.getGenero());
            stmt.setString(4, mantenimiento_bodega.getTipo_Art());
            stmt.setInt(5, mantenimiento_bodega.getCantidad_Art());
            stmt.setInt(6, mantenimiento_bodega.getId_Bodega());

            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Bodega query(Bodega bodega) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int rows = 0;

        try {

            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, bodega.getId_Bodega());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_habitacion = rs.getInt("PK_id_bodega");
                String descripcion_hab = rs.getString("nombre_articulo");
                String precio = rs.getString("autor_articulo");
                String piso = rs.getString("genero_articulo");
                String estado_hab = rs.getString("tipo_articulo");
                int tipo_hab = rs.getInt("cantidad_articulo");

                bodega = new Bodega();
                bodega.setId_Bodega(id_habitacion);
                bodega.setNombre_Art(descripcion_hab);
                bodega.setAutor_Art(precio);
                bodega.setGenero(piso);
                bodega.setTipo_Art(estado_hab);
                bodega.setCantidad_Art(tipo_hab);
                rows++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return (bodega);
    }

    public List<Bodega> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bodega habitaciones = null;
        List<Bodega> habitacione = new ArrayList<Bodega>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_habitaciones = rs.getInt("PK_id_bodega");
                String descripcion = rs.getString("nombre_articulo");
                String precio = rs.getString("autor_articulo");
                String piso = rs.getString("genero_articulo");
                String estado = rs.getString("tipo_articulo");
                int tipo = rs.getInt("cantidad_articulo");

                habitaciones = new Bodega();
                habitaciones.setId_Bodega(id_habitaciones);
                habitaciones.setNombre_Art(descripcion);
                habitaciones.setAutor_Art(precio);
                habitaciones.setGenero(piso);
                habitaciones.setTipo_Art(estado);
                habitaciones.setCantidad_Art(tipo);

                habitacione.add(habitaciones);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return habitacione;
    }
    public int delete(Bodega bodega) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bodega.getId_Bodega());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
}


