/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriofm.datos;

import laboratoriofm.dominio.VideoJuegos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leelu
 */
public class VideoJuegosDAO {
        private static final String SQL_INSERT = "insert into tbl_videojuego values(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_videojuego SET nombre_videojuego=?, autor_videojuego=?, genero_videojuego=?, existencias_videojuego=? WHERE PK_id_videojuego=?";
    private static final String SQL_SELECT = "SELECT PK_id_videojuego, nombre_videojuego, autor_videojuego, genero_videojuego, existencias_videojuego FROM tbl_videojuego";
    private static final String SQL_QUERY = "SELECT PK_id_videojuego, nombre_videojuego, autor_videojuego, genero_videojuego, existencias_videojuego FROM tbl_videojuego WHERE PK_id_videojuego = ?";
    
    public int insert(VideoJuegos huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, huespedes.getCodigo());
            stmt.setString(2, huespedes.getNombre());
            stmt.setString(3, huespedes.getAutor());
            stmt.setString(4, huespedes.getGenero());
            stmt.setString(5, huespedes.getExistencia());
           

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    public int update(VideoJuegos huespedes){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(8, huespedes.getCodigo());
            stmt.setString(1, huespedes.getNombre());
            stmt.setString(3, huespedes.getAutor());
            stmt.setString(4, huespedes.getGenero());
            stmt.setString(5, huespedes.getExistencia());

            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    public List<VideoJuegos> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VideoJuegos huespedes = null;
        List<VideoJuegos> metodo = new ArrayList<VideoJuegos>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String codigo = rs.getString("PK_id_videojuego");
                String nombre = rs.getString("nombre_videojuego");
                String apellido = rs.getString("autor_videojuego");
                String nacionalidad = rs.getString("genero_videojuego");
                String direccion = rs.getString("existencias_videojuego");
                
                
                huespedes = new VideoJuegos();
                huespedes.setCodigo(codigo);
                huespedes.setNombre(nombre);
                huespedes.setAutor(apellido);
                huespedes.setGenero(nacionalidad);
                huespedes.setExistencia(direccion);
                
                
                metodo.add(huespedes);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return metodo;
    }
    public VideoJuegos query(VideoJuegos huespedes) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, huespedes.getCodigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("PK_id_videojuego");
                String nombre = rs.getString("nombre_videojuego");
                String apellido = rs.getString("autor_videojuego");
                String nacionalidad = rs.getString("genero_videojuego");
                String direccion = rs.getString("existencias_videojuego");
                
                
                huespedes = new VideoJuegos();
                huespedes.setCodigo(codigo);
                huespedes.setNombre(nombre);
                huespedes.setAutor(apellido);
                huespedes.setGenero(nacionalidad);
                huespedes.setExistencia(direccion);
                System.out.println(huespedes.getNombre());
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return huespedes;
    }
}
