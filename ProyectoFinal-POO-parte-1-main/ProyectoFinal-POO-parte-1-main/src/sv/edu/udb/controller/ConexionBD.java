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
 import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class ConexionBD {
    private static final Logger log = Logger.getLogger(ConexionBD.class);

    private static final String URL = "jdbc:mysql://localhost:3306/colegiodb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConexion() {
        try {
            log.info("Conexion a la base de datos establecida correctamente");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Error al conectar con la base de datos: " + ex.getMessage());
            log.error("Error al conectar con la base de datos"+ex.getMessage(),ex);
            return null;
        }
    }

    public static void cerrar(Connection conn) {
        try {
            log.info("Conexion cerrada correctamente");
            if (conn != null && !conn.isClosed()) conn.close();
        } catch (SQLException ex) {
            System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            log.error("Error al cerrar la conexion"+ex.getMessage(),ex);
        }
    }

    public static void cerrar(PreparedStatement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) stmt.close();
        } catch (SQLException ex) {
            System.err.println("Error al cerrar PreparedStatement: " + ex.getMessage());
        }
    }

    public static void cerrar(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) rs.close();
        } catch (SQLException ex) {
            System.err.println("Error al cerrar ResultSet: " + ex.getMessage());
        }
    }
}
