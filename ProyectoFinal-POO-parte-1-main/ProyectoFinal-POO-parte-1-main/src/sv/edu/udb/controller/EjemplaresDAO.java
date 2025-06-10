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
import sv.edu.udb.model.Material;



public class EjemplaresDAO {
    
    private static final Logger log = Logger.getLogger(EjemplaresDAO.class);
    
     public int insertarMaterial(Material material) {
        Connection conn = ConexionBD.getConexion();
        String sql = "INSERT INTO Materiales (titulo, autor, ubicacion, cantidad_disponible, tipo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, material.getTitulo());
            stmt.setString(2, material.getAutor());
            stmt.setString(3, material.getUbicacion());
            stmt.setInt(4, material.getCantidadDisponible());
            stmt.setString(5, material.getTipo());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    log.info("Nuevo Material Insertado");
                    return rs.getInt(1); // id_material generado
                }
            }

        } catch (SQLException e) {
            log.error("Error al Insertar nuevo material: "+e.getMessage(),e);
            e.printStackTrace();
        } finally {
            ConexionBD.cerrar(conn);
        }

        return -1; // Error
    }
     
     public boolean insertarLibro(int idMaterial, String genero, String editorial, int anioPublicacion, int numeroPaginas, String isbn) {
    Connection conn = ConexionBD.getConexion();
    String sql = "INSERT INTO Libros (id_material, genero, editorial, año_publicacion, numero_paginas, isbn) VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idMaterial);
        stmt.setString(2, genero);
        stmt.setString(3, editorial);
        stmt.setInt(4, anioPublicacion);
        stmt.setInt(5, numeroPaginas);
        stmt.setString(6, isbn);
        
        log.info("Libro insertado");
        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        log.error("Error al registar Libro:"+e.getMessage(),e);
        return false;
    } finally {
        ConexionBD.cerrar(conn);
    }
}
     
     
     public boolean insertarRevista(int idMaterial, int volumen, int numero, String mesPublicacion){
     Connection conn = ConexionBD.getConexion();
     String sql = "INSERT INTO Revistas(id_material, volumen, numero, mes_publicacion ) VALUES (?,?,?,?)";
     
     try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,idMaterial);
            stmt.setInt(2, volumen);
            stmt.setInt(3,numero);
            stmt.setString(4,mesPublicacion);
            log.info("Revista Insertada");
            return stmt.executeUpdate() >0;
     }catch (SQLException e){
         e.printStackTrace();
         log.error("Error al insertar revista"+e.getMessage(),e);
         return false;
     }finally {
         ConexionBD.cerrar(conn);
       }
     }
     
     
     public boolean insertarTesis (int idMaterial, String universidad , String carrera, int anioPublicacion  ){
     Connection conn = ConexionBD.getConexion();
     String sql = "INSERT INTO Tesis(id_material, universidad , carrera, año_publicacion)VALUES (?,?,?,?)";
     
     try(PreparedStatement stmt = conn.prepareStatement(sql)){
         stmt.setInt(1,idMaterial);
         stmt.setString(2,universidad);
         stmt.setString(3,carrera);
         stmt.setInt(4,anioPublicacion);
      log.info("Tesis Insertada");
         return stmt.executeUpdate() >0;
     }catch (SQLException e){
         e.printStackTrace();
         log.error("Error al insertar tesis"+e.getMessage(),e);
         return false;
     }finally{
         ConexionBD.cerrar(conn);
        }
     }
     
     public boolean insertarCD(int idMaterial, String formato, Time duracion){
         Connection conn = ConexionBD.getConexion();
         String sql = "INSERT INTO CDs (id_material, formato, duracion)VALUES(?,?,?)";
         
         try (PreparedStatement stmt = conn.prepareStatement(sql)){
             stmt.setInt(1,idMaterial);
             stmt.setString(2,formato);
             stmt.setTime(3,duracion);
              log.info("CD Insertado");
             return stmt.executeUpdate() >0;
         }catch (SQLException e ){
             e.printStackTrace();
             log.error("Error al insertar CD"+e.getMessage(),e);
             return false;
         }finally {
             ConexionBD.cerrar(conn);
         }
     
     }
     
     public boolean insertarDocumento(int idMaterial, String tipoDocumento, String fuente){
         Connection conn = ConexionBD.getConexion();
         String sql = "INSERT INTO Documentos(id_material, tipo_documento, fuente)VALUES(?,?,?)";
         
         try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1,idMaterial);
                stmt.setString(2,tipoDocumento);
                stmt.setString(3,fuente);
                    log.info("Documento Insertado");     
                return stmt.executeUpdate() >0;
         }catch(SQLException e){
             e.printStackTrace();
             log.error("Error al insertar Documento"+e.getMessage(),e);
             return false;
         }finally{
             ConexionBD.cerrar(conn);
         }
     
     }


    // LEER todos los materiales
    public List<Material> obtenerMateriales() {
        List<Material> lista = new ArrayList<>();
        Connection conn = ConexionBD.getConexion();
        String sql = "SELECT * FROM Materiales";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Material m = new Material(
                    rs.getInt("id_material"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("ubicacion"),
                    rs.getInt("cantidad_disponible"),
                    rs.getString("tipo")
                );
                lista.add(m);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error al Listar Material"+e.getMessage(),e);
        } finally {
            ConexionBD.cerrar(conn);
        }
log.info("Material Listado correctamente");
        return lista;
    }
    
    //metodo buscar por ID 
    
public Material obtenerMaterialPorID(int idMaterial) throws SQLException {
    Material material = null;
    String sql = "SELECT * FROM materiales WHERE id_material = ?";

    try (Connection conn = ConexionBD.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idMaterial);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            material = new Material();
            material.setId(rs.getInt("id_material"));
            material.setTitulo(rs.getString("titulo"));
            material.setAutor(rs.getString("autor"));
            material.setUbicacion(rs.getString("ubicacion"));
            material.setCantidadDisponible(rs.getInt("cantidad_disponible"));
            material.setTipo(rs.getString("tipo"));
        }
    }
log.info("Material listado por Id de forma correcta");
    return material;
}
    

// metodo busqueda TITULO

public List<Material> buscarMaterialesPorTitulo(String titulo) throws SQLException {
    List<Material> materiales = new ArrayList<>();

    String sql = "SELECT * FROM Materiales WHERE titulo LIKE ?";
    try (Connection conn = ConexionBD.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, "%" + titulo + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Material m = new Material();
                m.setId(rs.getInt("id_material"));
                m.setTitulo(rs.getString("titulo"));
                m.setAutor(rs.getString("autor"));
                m.setUbicacion(rs.getString("ubicacion"));
                m.setCantidadDisponible(rs.getInt("cantidad_disponible"));
                m.setTipo(rs.getString("tipo"));
                materiales.add(m);
            }
        }
    }
log.info("Material listado por Titulo de forma correcta");
    return materiales;
}



// METODO BUSQUEDA POR TIPO

    public List<Material> buscarMaterialesPorTipo(String tipo) throws SQLException {
    List<Material> materiales = new ArrayList<>();

    String sql = "SELECT * FROM Materiales WHERE tipo LIKE ?";
    try (Connection conn = ConexionBD.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, "%" + tipo + "%");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Material m = new Material();
                m.setId(rs.getInt("id_material"));
                m.setTitulo(rs.getString("titulo"));
                m.setAutor(rs.getString("autor"));
                m.setUbicacion(rs.getString("ubicacion"));
                m.setCantidadDisponible(rs.getInt("cantidad_disponible"));
                m.setTipo(rs.getString("tipo"));
                materiales.add(m);
            }
        }
    }
log.info("Material listado por Tipo de forma correcta");
    return materiales;
}




    
    

    // ACTUALIZAR material
    public boolean actualizarMaterial(Material material) {
        Connection conn = ConexionBD.getConexion();
        String sql = "UPDATE Materiales SET titulo=?, autor=?, ubicacion=?, cantidad_disponible=?, tipo=? WHERE id_material=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, material.getTitulo());
            stmt.setString(2, material.getAutor());
            stmt.setString(3, material.getUbicacion());
            stmt.setInt(4, material.getCantidadDisponible());
            stmt.setString(5, material.getTipo());
            stmt.setInt(6, material.getId());
            log.info("Material actualizado correctamente");
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error al actualizar el material"+e.getMessage(),e);
            return false;
        } finally {
            ConexionBD.cerrar(conn);
        }
    }

    // ELIMINAR material (y automáticamente lo relacionado por ON DELETE CASCADE)
    public boolean eliminarMaterial(int idMaterial) {
        Connection conn = ConexionBD.getConexion();
        String sql = "DELETE FROM Materiales WHERE id_material = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idMaterial);
            log.info("Material Eliminado correctmente");
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error al eliminar Material"+e.getMessage(),e);
            return false;
        } finally {
            ConexionBD.cerrar(conn);
        }
    }
}
