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
public class Mora {
    
    private int idMora;
    private int idAlumno;
    private int idPrestamo;
    private double monto;
    private Date fechaRegistro;
    private String estado;
    
    
    public Mora(){}
    
    
    public Mora(int idAlumno, int idPrestamo,double monto,Date fechaRegistro , String estado){
        this.idAlumno=idAlumno;
        this.idPrestamo = idPrestamo;
        this.monto= monto;
        this.fechaRegistro=fechaRegistro;
        this.estado = estado;
    }

    
    public Mora(int idMora, int idAlumno, int idPrestamo,double monto,Date fechaRegistro , String estado){
        this.idMora=idMora;
        this.idAlumno=idAlumno;
        this.idPrestamo = idPrestamo;
        this.monto= monto;
        this.fechaRegistro=fechaRegistro;
        this.estado = estado;
    }
    
    
    //getters
    public int getIdMora(){return idMora;}
    public int getIdAlumno(){return idAlumno;}
    public int getIdPrestamo(){return idPrestamo;}
    public double getMonto(){return monto;}
    public Date getFechaRegistro(){return fechaRegistro;}
    public String getEstado(){return estado;}
    
    //Stters
    
    public void setIdMora(int idMora){this.idMora = idMora;}
    public void setIdAlumno(int idAlumno){this.idAlumno = idAlumno;}
    public void setIdPrestamo(int idPrestamo){this.idPrestamo = idPrestamo;}
    public void setMonto(double monto){this.monto=monto;}
    public void setFechaRegistro(Date fechaRegistro){this.fechaRegistro = fechaRegistro;}
    public void setEstado(String estado){this.estado=estado;}
}
