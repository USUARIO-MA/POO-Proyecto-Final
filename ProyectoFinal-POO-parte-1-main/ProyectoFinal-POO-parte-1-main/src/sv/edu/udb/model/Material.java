/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.udb.model;

/**
 *
 * @author Mercadeo 1
 */
public class Material {
    
    private int idMaterial;
    private String titulo;
    private String autor;
    private String ubicacion;
    private int cantidadDisponible;
    private String tipo; //libros , revistas etc
    
    
    public Material (int idMaterial, String titulo, String autor, String ubicacion, int cantidadDisponible, String tipo ){
    
    this.idMaterial = idMaterial;
    this.titulo = titulo;
    this.autor = autor;
    this.ubicacion = ubicacion;
    this.cantidadDisponible = cantidadDisponible;
    this.tipo = tipo;
    
    }
    public Material() {
    // Constructor vacío
}
    public Material (String titulo , String autor, String ubicacion,int cantidadDisponible, String tipo){
        this(-1,titulo,autor,ubicacion,cantidadDisponible, tipo);
    }
    
    //getters y setters
    public int getId(){return idMaterial;}
    public String getTitulo(){return titulo;}
    public String getAutor(){return autor;}
    public String getUbicacion(){return ubicacion;}
    public int getCantidadDisponible(){return cantidadDisponible;}
    public String getTipo(){return tipo;}
    
    
    public void setId(int idMaterial){this.idMaterial =idMaterial;}
    public void setTitulo(String titulo){this.titulo = titulo;}
    public void setAutor(String autor){this.autor = autor;}
    public void setUbicacion(String ubicacion){this.ubicacion = ubicacion;}
    public void setCantidadDisponible(int cantidadDisponible){this.cantidadDisponible = cantidadDisponible;}
    public void setTipo(String tipo){this.tipo = tipo;}
    
    
}
