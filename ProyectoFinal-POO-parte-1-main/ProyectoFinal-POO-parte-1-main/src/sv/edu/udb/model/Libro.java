/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.udb.model;


/**
 *
 * @author Mercadeo 1
 */
public class Libro extends Material{
    private int idLibro;
    private String genero;
    private String editorial;
    private int anioPublicacion;
    private int numeroPaginas;
    private String isbn;
    
    
 //   public Libro(){}
    
    public Libro( int idMaterial, String titulo, String autor, String ubicacion, int cantidadDisponible, String tipo, int idLibro,
                 String genero, String editorial, int anioPublicacion, int numeroPaginas, String isbn){
            
        super(idMaterial, titulo, autor, ubicacion, cantidadDisponible, tipo);
        this.idLibro = idLibro;
        this.genero = genero;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;

    }
    // getter
    public int getIdLibro(){return idLibro;}
    public String getGenero(){return genero;}
    public String getEditorial (){return editorial;}
    public int getAnioPublicacion(){return anioPublicacion;}
    public int getNumeroPaginas(){return numeroPaginas;}
    public String getIsbn(){return isbn;}
    
    // setters
    public void setIdLibro(int idLibro){this.idLibro = idLibro;}
    public void setGenero(String genero){this.genero= genero;}
    public void setEditorial(String editorial){this.editorial=editorial;}
    public void setAnioPublicacion(int anioPublicacion){this.anioPublicacion = anioPublicacion;}
    public void setNumeroPaginas(int numeroPaginas){this.numeroPaginas = numeroPaginas;}
    public void setIsbn(String isbn){this.isbn = isbn;}
}
