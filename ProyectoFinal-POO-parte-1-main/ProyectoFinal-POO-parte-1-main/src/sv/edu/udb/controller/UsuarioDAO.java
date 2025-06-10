/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.udb.controller;

/**
 *
 * @author Mercadeo 1
 */
import sv.edu.udb.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


public class UsuarioDAO {
    
    private static final Logger log = Logger.getLogger(UsuarioDAO.class); 

    // Validar credenciales para login
    public Usuario validarUsuario(String correo, String password) {
        Connection conn = ConexionBD.getConexion();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                log.info("Se validado el usuario correctamente. ");
                return new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contraseña"),
                    rs.getString("tipo_usuario")
                );
            }
        } catch (SQLException ex) {
            log.error("Error al validar Usuario: "+ex.getMessage(),ex);
            ex.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }
        return null;
    }

    // Insertar nuevo usuario
    public boolean insertarUsuario(Usuario usuario) {
        Connection conn = ConexionBD.getConexion();
        String sql = "INSERT INTO Usuarios(nombre, apellido, correo, contraseña, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getRol());
            
            int rowsInserted = stmt.executeUpdate();
            log.info("Usuario insertado de forma exitosa");
            return rowsInserted > 0;
        } catch (SQLException ex) {
            log.error("Error al insertar usuario: "+ex.getMessage(),ex);
            ex.printStackTrace();
            return false;
        } finally {
            ConexionBD.cerrar(conn);
        }
    }

    // Listar todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        Connection conn = ConexionBD.getConexion();
        String sql = "SELECT * FROM Usuarios";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contraseña"),
                    rs.getString("tipo_usuario")
                );
                lista.add(u);
            }
            log.info("Exito al listar todos los Ususarios");
        } catch (SQLException ex) {
            log.error("Error al tratar de Listar los usuario:"+ex.getMessage(),ex);
            ex.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }
        return lista;
    }

    // Actualizar usuario
    public boolean actualizarUsuario(Usuario usuario) {
        Connection conn = ConexionBD.getConexion();
        String sql = "UPDATE Usuarios SET nombre=?, apellido=?, correo=?, contraseña=?, tipo_usuario=? WHERE id_usuario=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getRol());
            stmt.setInt(6, usuario.getID());
            
             int filasActualizadas = stmt.executeUpdate();
             log.info("Actualizacion de Usuario exitosa");
            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("Error al Actualizar Usuario "+ex.getMessage(),ex);
            return false;
        } finally {
            ConexionBD.cerrar(conn);
        }
    }

    // Eliminar usuario
    public boolean eliminarUsuario(int id) {
        Connection conn = ConexionBD.getConexion();
        String sql = "DELETE FROM Usuarios WHERE id_usuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            log.info("Usuario Eliminado");
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("Error al eliminar usuario");
            return false;
        } finally {
            ConexionBD.cerrar(conn);
        }
    }

    // Restablecer contraseña (opcional)
    public boolean restablecerContrasena(int id, String nuevaContrasena) {
        Connection conn = ConexionBD.getConexion();
        String sql = "UPDATE Usuarios SET contraseña = ? WHERE id_usuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevaContrasena);
            stmt.setInt(2, id);
            log.info("Contraseña Restablecida");
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("Error al restablecer contraseña"+ex.getMessage(),ex);
            return false;
        } finally {
            ConexionBD.cerrar(conn);
        }
    }
}