/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDB;

import ImagenAvatar.Boca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ecomercial1
 */
public class ModeloBoca {
    Connection conn ;
    private String SQL_AGREGAR = "INSERT INTO boca (nombre, imagen) VALUES (?,?)";
    
    public ModeloBoca(){}

    public void AgregarImagenBoca(Boca mImagen){
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
        String q = " DELETE FROM boca WHERE id='" + id + "' " ;
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
    
    
     public ArrayList CargarBoca(){
        ArrayList listBoca = new ArrayList();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM boca");
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                Boca boca = new Boca();
                boca.setId(res.getInt("id"));
                boca.setNombre(res.getString("nombre"));
                boca.setImagen(res.getBytes("imagen"));
                listBoca.add(boca);
            }
            
        }catch (SQLException e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return listBoca;
    }
     
     public Boca Cargarboca(int id){
        Boca boca = new Boca();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM boca WHERE id='" + id + "' ") ;
            ResultSet res = pstm.executeQuery();
            while (res.next()) {  
                boca.setId(res.getInt("id"));
                boca.setNombre(res.getString("nombre"));
                boca.setImagen(res.getBytes("imagen")); 
            }
            
        }catch (Exception e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return boca;
    }

}

