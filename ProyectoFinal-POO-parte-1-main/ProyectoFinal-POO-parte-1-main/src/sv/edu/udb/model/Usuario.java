/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.udb.model;

/**
 *
 * @author Mercadeo 1
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String rol;

    
    public Usuario(){}
    
    public Usuario( int idUsuario ,String nombre, String apellido, String correo, String password, String rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }
//getter
    public int getID(){return idUsuario;}
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getCorreo() {return correo;}
    public String getPassword() {return password;}
    public String getRol() {return rol;}
    
    
    //setter
    public void setID( int idUsuario){this.idUsuario=idUsuario;}
    public void setNombre( String nombre ){this.nombre=nombre;}
    public void setApellido( String apellido ){this.apellido=apellido;}
    public void setCorreo( String correo ){this.correo=correo;}
    public void setPassword( String password ){this.password=password;}
    public void setRol(String rol){this.rol=rol;}
    
}

