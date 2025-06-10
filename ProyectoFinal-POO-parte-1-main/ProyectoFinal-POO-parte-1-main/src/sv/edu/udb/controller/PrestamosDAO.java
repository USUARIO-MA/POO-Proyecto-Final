/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.udb.controller;

/**
 *
 * @author Mercadeo 1
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import sv.edu.udb.model.Prestamo;

public class PrestamosDAO {
    
    private static final Logger log= Logger.getLogger(PrestamosDAO.class);
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public PrestamosDAO(){
    conn = ConexionBD.getConexion();
    }
    
    // Registar Prestamo
    public boolean registrarPrestamo(Prestamo p){
    String sql = "INSERT INTO Prestamos (id_alumno, id_material, fecha_prestamo, fecha_devolucion, estado)VALUES(?,?,?,?,?)";
    try {
    stmt = conn.prepareStatement(sql);
    stmt.setInt(1,p.getIdAlumno());
    stmt.setInt(2,p.getIdMaterial());
    stmt.setDate(3, new java.sql.Date(p.getFechaPrestamo().getTime()));
     if (p.getFechaDevolucion() != null) {
            stmt.setDate(4, new java.sql.Date(p.getFechaDevolucion().getTime()));
        } else {
            stmt.setNull(4, java.sql.Types.DATE);
        }
    stmt.setString(5, p.getEstado());
    
    stmt.executeUpdate();
    log.info("Prestamo registrado con Exito");
    return true;
    }catch(SQLException e){
    System.out.println("Error al Registrar Prestamo: "+e.getMessage());
    log.error("Error al registar Prestamo"+e.getMessage());
    return false;
        }
    
    }
    
    // Listar prestamos
    
    public List<Prestamo>ListarPrestamos(){
        List<Prestamo>lista = new ArrayList<>();
        String sql= "SELECT p.*, u.nombre AS nombre_alumno, u.apellido AS apellido_alumno, m.titulo AS nombre_material " +
                     "FROM Prestamos p " +
                     "JOIN Alumnos a ON p.id_alumno = a.id_alumno " +
                     "JOIN Usuarios u ON a.id_usuario = u.id_usuario " +
                     "JOIN Materiales m ON p.id_material = m.id_material";
        
        try{
        stmt = conn.prepareStatement(sql);
        rs= stmt.executeQuery();
        
        while (rs.next()){
        Prestamo p = new Prestamo();
        p.setIdPrestamo(rs.getInt("id_prestamo"));
        p.setIdAlumno(rs.getInt("id_alumno"));
        p.setNombreAlumno(rs.getString("nombre_alumno") + " " + rs.getString("apellido_alumno"));
        p.setIdMaterial(rs.getInt("id_material"));
        p.setNombreMaterial(rs.getString("nombre_material"));
        p.setFechaPrestamo(rs.getDate("fecha_prestamo"));
        p.setFechaDevolucion(rs.getDate("fecha_devolucion"));
        p.setEstado(rs.getString("estado"));
        
      /* String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
            p.setNombreAlumno(nombreCompleto);*/
            lista.add(p);
           }     
        }catch(SQLException e){
            log.error("Error al listar Prestamos"+e.getMessage());
          System.out.println("Error al listar los Prestamos: "+e.getMessage());  
        }
        log.info("Prestamos listados con exito");
        return lista;
    }
    
    // Buscar por IDAlumno
    public List<Prestamo> buscarPrestamosPorAlumno(int idAlumno) {
    List<Prestamo> lista = new ArrayList<>();
    String sql = "SELECT p.*, u.nombre, u.apellido, m.titulo FROM prestamos p " +
                 "JOIN alumnos a ON p.id_alumno = a.id_alumno " +
                 "JOIN usuarios u ON a.id_usuario = u.id_usuario " +
                 "JOIN materiales m ON p.id_material = m.id_material " +
                 "WHERE p.id_alumno = ?";

    try {
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idAlumno);
        rs = stmt.executeQuery();
        while (rs.next()) {
            Prestamo p = new Prestamo();
            p.setIdPrestamo(rs.getInt("id_prestamo"));
            p.setIdAlumno(rs.getInt("id_alumno"));
            p.setIdMaterial(rs.getInt("id_material"));
            p.setFechaPrestamo(rs.getDate("fecha_prestamo"));
            p.setFechaDevolucion(rs.getDate("fecha_devolucion"));
            p.setEstado(rs.getString("estado"));
            p.setNombreAlumno(rs.getString("nombre") + " " + rs.getString("apellido"));
            p.setNombreMaterial(rs.getString("titulo"));
            lista.add(p);
        }
    } catch (SQLException e) {
        log.error("error al buscar prestamo por id alumno "+e.getMessage());
        System.out.println("Error al buscar préstamos: " + e.getMessage());
    }
  log.info("Prestamo por id alumno encontrado de porfa exitosa");
    return lista;
}



    
    
    
    // modificar prestamos
    
  public boolean modificarPrestamo(Prestamo p ){
      String sql= "UPDATE prestamos SET id_alumno=?, id_material=?, fecha_prestamo=?, fecha_devolucion=?, estado=? WHERE id_prestamo=? ";
     try{
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1,p.getIdAlumno());
         stmt.setInt(2,p.getIdMaterial());
         stmt.setDate(3, new java.sql.Date(p.getFechaPrestamo().getTime()));
         stmt.setDate(4,new java.sql.Date(p.getFechaDevolucion().getTime()));
         stmt.setString(5,p.getEstado());
         stmt.setInt(6, p.getIdPrestamo());
            stmt.executeUpdate();
            log.info("Prestamo modificado con exito.");
            return true;
     }catch(SQLException e){
     System.out.println("Error al Modificar el Prestamo: "+e.getMessage());
     log.error("Error al modificar el prestamo"+e.getMessage());
     return false;
     }
  } 
  
  // Eliminar Prestamo
    
  public boolean eliminarPrestamo(int idPrestamo){
      String sql =" DELETE FROM Prestamos WHERE id_prestamo=?";
      try{
       stmt = conn.prepareStatement(sql);
       stmt.setInt(1,idPrestamo);
       stmt.executeUpdate();
       log.info("Prestamo eliminado con Exito");
       return true;
      }catch(SQLException e ){
          System.out.println("Error al Eliminar el Prestamo: "+ e.getMessage());
          log.error("Error al eliminar prestamo"+e.getMessage());
          return false;
      }
  }
    
}
