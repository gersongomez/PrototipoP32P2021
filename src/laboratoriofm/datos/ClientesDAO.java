/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriofm.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import laboratoriofm.dominio.Clientes;

/**
 *
 * @author leone
 */
public class ClientesDAO {
    private static final String SQL_INSERT = "insert into tbl_clientes values(?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT PK_numero_tarjeta, dpi_cliente, nombre_cliente, apellido_cliente, email_cliente, telefono_cliente FROM tbl_clientes";
    private static final String SQL_DELETE = "delete from tbl_clientes where PK_numero_tarjeta = ?";  
    private static final String SQL_UPDATE = "UPDATE tbl_clientes SET dpi_cliente=?, nombre_cliente=?, apellido_cliente=?, email_cliente, telefono_cliente WHERE PK_numero_tarjeta=?";
    private static final String SQL_QUERY = "SELECT PK_dpi, nombre_renap, apellido_renap, nacionalidad_renap, estado_renap FROM tbl_renap WHERE PK_dpi = ?";
    
    
public List<Clientes> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes clientes = null;
        List<Clientes> cliente = new ArrayList<Clientes>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("PK_numero_tarjeta");
                String dpi = rs.getString("dpi_cliente");
                String nombre = rs.getString("nombre_cliente");
                String apellido = rs.getString("apellido_cliente");
                String email = rs.getString("email_cliente");
                String telefono = rs.getString("telefono_cliente");
                
                clientes = new Clientes();
                clientes.setId(id);
                clientes.setDpi(dpi);
                clientes.setNombre(nombre);
                clientes.setApellido(apellido);
                clientes.setEmail(email);
                clientes.setTelefono(telefono);
                
                
                cliente.add(clientes);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return cliente;
    }
    public int insert(Clientes clientes){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, clientes.getId());
            stmt.setString(2, clientes.getDpi());
            stmt.setString(3, clientes.getNombre());
            stmt.setString(4, clientes.getApellido());
            stmt.setString(5, clientes.getEmail());
            stmt.setString(6, clientes.getTelefono());
//            System.out.println("ejecutando query:" + SQL_INSERT);
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
    public int update(Clientes clientes){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
//            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, clientes.getDpi());
            stmt.setString(2, clientes.getNombre());
            stmt.setString(3, clientes.getApellido());
            stmt.setString(4, clientes.getEmail());
            stmt.setString(5, clientes.getTelefono());
            stmt.setString(6, clientes.getId());
            
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
    public int delete(Clientes clientes){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, clientes.getId());
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
    public Clientes query(Clientes clientes) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, clientes.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String dpi = rs.getString("PK_dpi");
                String nombre = rs.getString("nombre_renap");
                String apellido = rs.getString("apellido_renap");
                
                clientes = new Clientes();
                clientes.setDpi(dpi);
                clientes.setNombre(nombre);
                clientes.setApellido(apellido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }
    }