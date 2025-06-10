/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.udb.model;

import java.util.Date;

/**
 *
 * @author Mercadeo 1
 */
public class Prestamo {
    private int idPrestamo;
    private int idAlumno;
    private String nombreAlumno;
    private String nombreMaterial;
    private int idMaterial;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;
   
    
    // constructor vacio
    public Prestamo(){}
    
    // sin idPrestamo para poder registar 
    public Prestamo(int idAlumno, String nombreAlumno, int idMaterial, Date fechaPrestamo, Date fechaDevolucion, String estado){
        this.idAlumno = idAlumno;
        this.nombreAlumno=nombreAlumno;
        this.idMaterial = idMaterial;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion=fechaDevolucion;
        this.estado= estado;
    }
    
    // constructor completo
    public Prestamo (int idPrestamo, int idAlumno, int idMaterial, Date fechaPrestamo, Date fechaDevolucion, String estado){
        this.idPrestamo = idPrestamo;
        this.idAlumno = idAlumno;
        this.idMaterial = idMaterial;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion=fechaDevolucion;
        this.estado= estado;
    }
    
    
   
    // getters 
    public int getIdPrestamo(){return idPrestamo;}
    public int getIdAlumno(){return idAlumno;}
    public String getNombreAlumno(){return nombreAlumno;}
    public String getNombreMaterial(){return nombreMaterial;}
    public int getIdMaterial(){return idMaterial;}
    public Date getFechaPrestamo(){return fechaPrestamo;}
    public Date getFechaDevolucion(){return fechaDevolucion;}
    public String getEstado(){return estado;}
    
    
    // setter
    public void setIdPrestamo(int idPrestamo){this.idPrestamo = idPrestamo;}
    public void setIdAlumno(int idAlumno){this.idAlumno = idAlumno; }
    public void setNombreAlumno(String nombreAlumno){this.nombreAlumno=nombreAlumno;}
    public void setNombreMaterial(String nombreMaterial){this.nombreMaterial = nombreMaterial;}
    public void setIdMaterial(int idMaterial){this.idMaterial=idMaterial;}
    public void setFechaPrestamo(Date fechaPrestamo){this.fechaPrestamo= fechaPrestamo;}
    public void setFechaDevolucion(Date fechaDevolucion){this.fechaDevolucion = fechaDevolucion;}
    public void setEstado(String estado){this.estado = estado;}
    
}
