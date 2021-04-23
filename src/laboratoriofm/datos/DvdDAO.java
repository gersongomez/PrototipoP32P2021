/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriofm.datos;


import laboratoriofm.dominio.Dvd;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class DvdDAO {

    //Buscar en la BD
    private static final String SQL_SELECT = "SELECT PK_id_dvd, nombre_dvd, autor_dvd, genero_dvd, existencias_dvd FROM tbl_dvd";
    //Insertar en la BD
    private static final String SQL_INSERT = "INSERT INTO tbl_dvd(PK_id_dvd, nombre_dvd, autor_dvd, genero_dvd, existencias_dvd) VALUES(?, ?, ?, ?, ?)";
    //Modificar la BD
    private static final String SQL_UPDATE = "UPDATE tbl_dvd SET nombre_dvd=?, autor_dvd=?, genero_dvd=?, existencias_dvd=? WHERE PK_id_dvd = ?";
    //Eliminar de la BD
    private static final String SQL_DELETE = "DELETE FROM tbl_dvd WHERE PK_id_dvd=?";
    //Buscar 2 en la BD
    public static final String SQL_QUERY = "SELECT PK_id_dvd, nombre_dvd, autor_dvd, genero_dvd, existencias_dvd FROM tbl_dvd WHERE PK_id_dvd = ?";

    public List<Dvd> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Dvd ama_De_Llave = null;
        List<Dvd> ama_De_Llaves = new ArrayList<Dvd>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_dvd = rs.getInt("PK_id_dvd");
                String nombre_dvd = rs.getString("nombre_dvd");
                String autor_dvd = rs.getString("autor_dvd");
                String genero_dvd = rs.getString("genero_dvd");
                int existencias_dvd = rs.getInt("existencias_dvd");
                
                ama_De_Llave = new Dvd();
                ama_De_Llave.setId_Dvd(id_dvd);
                ama_De_Llave.setNombre_Dvd(nombre_dvd);
                ama_De_Llave.setAutor_Dvd(autor_dvd);
                ama_De_Llave.setGenero_Dvd(genero_dvd);
                ama_De_Llave.setExistencias_Dvd(existencias_dvd);

                ama_De_Llaves.add(ama_De_Llave);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ama_De_Llaves;
    }

    public int insert(Dvd ama_De_Llaves) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, ama_De_Llaves.getId_Dvd());
            stmt.setString(2, ama_De_Llaves.getNombre_Dvd());
            stmt.setString(3, ama_De_Llaves.getAutor_Dvd());
            stmt.setString(4, ama_De_Llaves.getGenero_Dvd());
            stmt.setInt(5, ama_De_Llaves.getExistencias_Dvd());

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

    public int update(Dvd ama_De_Llaves) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, ama_De_Llaves.getNombre_Dvd());
            stmt.setString(2, ama_De_Llaves.getAutor_Dvd());
            stmt.setString(3, ama_De_Llaves.getGenero_Dvd());
            stmt.setInt(4, ama_De_Llaves.getExistencias_Dvd());
            stmt.setInt(5, ama_De_Llaves.getId_Dvd());
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

    public int delete(Dvd ama_De_Llaves) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, ama_De_Llaves.getId_Dvd());
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
//    //    public List<Persona> query(Persona persona) { // Si se utiliza un ArrayList
//
    public Dvd query(Dvd ama_De_Llaves) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //List<Ama_De_Llaves> ama_De_Llave = new ArrayList<Ama_De_Llaves>();
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, ama_De_Llaves.getId_Dvd());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_dvd = rs.getInt("PK_id_dvd");
                String nombre_dvd = rs.getString("nombre_dvd");
                String autor_dvd = rs.getString("autor_dvd");
                String genero_dvd = rs.getString("genero_dvd");
                int existtencias_dvd = rs.getInt("existencias_dvd");

                ama_De_Llaves = new Dvd();
                ama_De_Llaves.setId_Dvd(id_dvd);
                ama_De_Llaves.setNombre_Dvd(nombre_dvd);
                ama_De_Llaves.setAutor_Dvd(autor_dvd);
                ama_De_Llaves.setGenero_Dvd(genero_dvd);
                ama_De_Llaves.setExistencias_Dvd(existtencias_dvd);
                rows++;
            }
            //System.out.println("Registros buscado:" + aplicacion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ama_De_Llaves;

    }


}
