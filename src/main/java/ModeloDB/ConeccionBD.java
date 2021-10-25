/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ysaias
 */
public class ConeccionBD {
    
    // Propiedades
    private static Connection conn = null;
    
 
    // Constructor
    private ConeccionBD(){
 
        String url = "jdbc:mysql://localhost:3306/img_avatar";
        //String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String password = "root";

        try{
            //Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        }catch(SQLException e){
         System.err.println( e.getMessage() );
        
      }
    } // Fin constructor
 
    
    // Métodos
    public static Connection getConnection(){
  
        if (conn == null){
            new ConeccionBD();
        }

        return conn;
    } // Fin getConnection
    
    //Ejemplo coneccion en otras clases a la DB
    //Connection conn = ConeccionBD.getConnection();
}
