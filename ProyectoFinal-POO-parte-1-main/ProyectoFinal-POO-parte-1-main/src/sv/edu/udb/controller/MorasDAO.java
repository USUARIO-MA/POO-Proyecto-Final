/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.udb.controller;

/**
 *
 * @author Mercadeo 1
 */

/* import java.sql.*;
import java.util.*;
import sv.edu.udb.model.Mora;
import sv.edu.udb.controller.ConexionBD;
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import org.apache.log4j.Logger;
import sv.edu.udb.model.Mora;

public class MorasDAO {
    
    private static final Logger log = Logger.getLogger(MorasDAO.class);
    
 private Connection conn;
 private PreparedStatement stmt;
 private ResultSet rs;
 
 public MorasDAO(){
     conn = ConexionBD.getConexion();
 }   
    
 //Insert
 public boolean registrarMora(Mora m){
    String sql="INSERT INTO Moras (id_alumno, id_prestamo, monto, fecha_registro, estado) VALUES(?,?,?,?,?)";
            
            try{
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1,m.getIdAlumno());
                stmt.setInt(2,m.getIdPrestamo());
                stmt.setDouble(3,m.getMonto());
                stmt.setDate(4, new java.sql.Date(m.getFechaRegistro().getTime()));
                stmt.setString(5,m.getEstado());
                
                stmt.executeUpdate();
                log.info("Mora registrada con Exito");
                return true;
            }catch(SQLException e){
                System.out.println("Error al registar Mora: "+ e.getMessage());
                log.error("Error al registar Mora: "+e.getMessage());
                return false;
            }        
         }
    
    
 //Select all
 public List<Mora> listarMoras() {
        List<Mora> lista = new ArrayList<>();
        String sql = "SELECT * FROM Moras";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Mora m = new Mora();
                m.setIdMora(rs.getInt("id_mora"));
                m.setIdAlumno(rs.getInt("id_alumno"));
                m.setIdPrestamo(rs.getInt("id_prestamo"));
                m.setMonto(rs.getDouble("monto"));
                m.setFechaRegistro(rs.getDate("fecha_registro"));
                m.setEstado(rs.getString("estado"));

                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar moras: " + e.getMessage());
            log.error("Error al listar Moras"+e.getMessage());
        }
        
        log.info("Moras listadas con Exito");
        return lista;
    }
 
 
 
 //Mostrar por idprestamo
 public Mora obtenerMoraPorIdPrestamo(int idPrestamo) {
    String sql = "SELECT * FROM Moras WHERE id_prestamo = ?";
    
    try {
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPrestamo);
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            Mora mora = new Mora();
            mora.setIdMora(rs.getInt("id_mora"));
            mora.setIdAlumno(rs.getInt("id_alumno"));
            mora.setIdPrestamo(rs.getInt("id_prestamo"));
            mora.setMonto(rs.getDouble("monto"));
            mora.setFechaRegistro(rs.getDate("fecha_registro"));
            mora.setEstado(rs.getString("estado"));
            log.info("Mora por id Prestamo obtenida con exito");
            return mora;
        } else {
            log.info("ID prestamo no tiene mora existente");
            return null;
        }
        
    } catch (SQLException e) {
        System.out.println("Error al obtener mora por ID de préstamo: " + e.getMessage());
        log.error("Error al obtener mora por id de prestamo"+e.getMessage());
        return null;
    }
}

 
 
 public List<Mora> obtenerMorasPorIdAlumno(int idAlumno) {
    List<Mora> lista = new ArrayList<>();
    String sql = "SELECT * FROM moras WHERE id_alumno = ?";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idAlumno);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Mora m = new Mora();
            m.setIdMora(rs.getInt("id_mora"));
            m.setIdAlumno(rs.getInt("id_alumno"));
            m.setIdPrestamo(rs.getInt("id_prestamo"));
            m.setMonto(rs.getDouble("monto"));
            m.setFechaRegistro(rs.getDate("fecha_registro"));
            m.setEstado(rs.getString("estado"));
            lista.add(m);
        }
    } catch (SQLException e) {
        log.error("Error al obetern mora por id de almuno"+e.getMessage());
        System.out.println("Error al obtener moras por alumno: " + e.getMessage());
    }
   log.info("Mora obtenida por id del Alumno");
    return lista;
}

 
 
 
  // CALCULAR MORA
   public Mora calcularMora(int idPrestamo) {
    Mora mora = new Mora();
    String sql = "SELECT p.id_prestamo, p.id_alumno, p.fecha_prestamo, p.fecha_devolucion FROM Prestamos p WHERE p.id_prestamo = ?";

    try {
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPrestamo);
        rs = stmt.executeQuery();

        if (rs.next()) {
            java.sql.Date fechaPrestamo = rs.getDate("fecha_prestamo");
            java.sql.Date fechaDevolucion = rs.getDate("fecha_devolucion");
            int idAlumno = rs.getInt("id_alumno");

            if (fechaDevolucion != null) {
                System.out.println("El préstamo ya fue devuelto.");
                log.info("Prestamo ya fue devuelto");
                return null; // No hay mora si ya se devolvió
            }

            // Fecha límite = fecha_prestamo + 15 días
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaPrestamo);
            cal.add(Calendar.DAY_OF_MONTH, 15);
            java.sql.Date fechaLimite = new java.sql.Date(cal.getTimeInMillis());

            java.sql.Date hoy = new java.sql.Date(System.currentTimeMillis());

            long diferenciaMs = hoy.getTime() - fechaLimite.getTime();
            long diasRetraso = diferenciaMs / (1000 * 60 * 60 * 24);

            if (diasRetraso > 0) {
                double monto = diasRetraso * 1.50;

                System.out.println("El préstamo tiene " + diasRetraso + " días de retraso. Monto a pagar: $" + monto);

                mora.setIdPrestamo(idPrestamo);
                mora.setIdAlumno(idAlumno);
                mora.setMonto(monto);
                mora.setFechaRegistro(hoy);
                mora.setEstado("Pendiente");
              log.info("calculo de mora exitosa");
                return mora;
            } else {
                System.out.println("El préstamo aún está dentro del plazo.");
                log.info("El préstamo aún está dentro del plazo.");
                return null;
            }
        } else {
            log.info("No se encontró el préstamo.");
            System.out.println("No se encontró el préstamo.");
        }

    } catch (SQLException e) {
        log.error("Error al calcular mora: " + e.getMessage());
        System.out.println("Error al calcular mora: " + e.getMessage());
    }

    return null;
}
    
    // metodo updATE
    public boolean actualizarEstadoMora(int idMora, String nuevoEstado) {
    String sql = "UPDATE Moras SET estado = ? WHERE id_mora = ?";

    try {
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nuevoEstado);
        stmt.setInt(2, idMora);

        stmt.executeUpdate();
        log.info("Estado mora actualizado con exito");
        return true;
    } catch (SQLException e) {
        System.out.println("Error al actualizar el estado de la mora: " + e.getMessage());
        log.error("Error al actualizar el estado de la mora: "+e.getMessage());
        return false;
    }
}
    
    
}
 
 

