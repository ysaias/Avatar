/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDB;

import ImagenAvatar.Cabello;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ecomercial1
 */
public class ModeloCabello {
    Connection conn ;
    private String SQL_AGREGAR = "INSERT INTO cabello (nombre, imagen) VALUES (?,?)";
    
    public ModeloCabello(){}

    public void AgregarImagenCabello(Cabello mImagen){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConeccionBD.getConnection().prepareStatement(SQL_AGREGAR);
            preparedStatement.setString(1, mImagen.getNombre());
            preparedStatement.setBytes(2, mImagen.getImagen());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             System.err.println( ex.getMessage() );
        
            
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                 System.err.println( ex.getMessage() );
        
            }
        }
    }

  
    public boolean EliminarCabello( String id )
    {
         boolean res=false;
        //se arma la consulta
        String q = " DELETE FROM cabello WHERE id='" + id + "' " ;
        //se ejecuta la consulta
         try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return res;
    }

    /** Metodo privado para validar datos */
    private boolean valida_datos(String id, String nombre , String imagen)
    {
        if( id.equals(" - ") )
            return false;
        else if( nombre.length() > 0 && imagen.length()>0 )
        {
            return true;
        }
        else return false;
    }
    
    
     public ArrayList CargarCabellos(){
        ArrayList listCabello = new ArrayList();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM cabello");
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                Cabello cabello = new Cabello();
                cabello.setId(res.getInt("id"));
                cabello.setNombre(res.getString("nombre"));
                cabello.setImagen(res.getBytes("imagen"));
                listCabello.add(cabello);
            }
            
        }catch (SQLException e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return listCabello;
    }

     public Cabello CargarCabello(int id){
        Cabello cabello = new Cabello();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM cabello WHERE id='" + id + "' ") ;
            ResultSet res = pstm.executeQuery();
            while (res.next()) {  
                cabello.setId(res.getInt("id"));
                cabello.setNombre(res.getString("nombre"));
                cabello.setImagen(res.getBytes("imagen")); 
            }
            
        }catch (Exception e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return cabello;
    }
}

