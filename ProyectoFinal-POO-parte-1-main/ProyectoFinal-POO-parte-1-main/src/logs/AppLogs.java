/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logs;

/**
 *
 * @author Mercadeo 1
 */
import org.apache.log4j.Logger;
import sv.edu.udb.controller.ConexionBD;




public class AppLogs {
 
     static final Logger log = Logger.getLogger(AppLogs.class);
    public static void main(String[] args) {
        // TODO code application logic here   
        
        ConexionBD conexionBD= new ConexionBD();
        
        
      log.info("Mensaje con Info");
      log.fatal("Mensaje con Fatal");
     
      
      
      log.warn("Mensaje con Warn");
      log.error("Mensaje con Error");
      log.debug("Mensaje con Debug");    
    } 
    
    
}
