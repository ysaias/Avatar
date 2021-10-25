/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDB;

import ImagenAvatar.Ojos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ecomercial1
 */
public class ModeloOjos {
    
    Connection conn ;
    private String SQL_AGREGAR = "INSERT INTO ojos (nombre, imagen) VALUES (?,?)";
    
    public ModeloOjos(){}

    public void AgregarImagen(Ojos mImagen){
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

  
    public boolean EliminarProducto( String id )
    {
         boolean res=false;
        //se arma la consulta
        String q = " DELETE FROM ojos WHERE id='" + id + "' " ;
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
    
    
     public ArrayList CargarOjos(){
        ArrayList listOjos = new ArrayList();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM ojos");
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                Ojos ojos = new Ojos();
                ojos.setId(res.getInt("id"));
                ojos.setNombre(res.getString("nombre"));
                ojos.setImagen(res.getBytes("imagen"));
                listOjos.add(ojos);
            }
            
        }catch (Exception e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return listOjos;
    }

     public Ojos CargarOjos(int id){
        Ojos ojos = new Ojos();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM ojos WHERE id='" + id + "' ") ;
            ResultSet res = pstm.executeQuery();
            while (res.next()) {  
                ojos.setId(res.getInt("id"));
                ojos.setNombre(res.getString("nombre"));
                ojos.setImagen(res.getBytes("imagen")); 
            }
            
        }catch (Exception e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return ojos;
    }
}

