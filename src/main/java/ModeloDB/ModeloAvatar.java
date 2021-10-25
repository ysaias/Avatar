/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDB;

import PatronDecorator.Avatar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ecomercial1
 */
public class ModeloAvatar {
    Connection conn ;
    
    private String SQL_AGREGAR = "INSERT INTO avatar (rostro, ojos, cabello, boca) VALUES (?,?,?,?)";
    
    public ModeloAvatar(){}

    
    
    public void AgregarAvatar(Avatar avatar){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConeccionBD.getConnection().prepareStatement(SQL_AGREGAR);
            preparedStatement.setInt(1, avatar.getRostro().getId());
            preparedStatement.setInt(2, avatar.getOjos().getId());
            preparedStatement.setInt(3, avatar.getCabello().getId());
            preparedStatement.setInt(4, avatar.getCabello().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             System.err.println("AgregarAvatar: "+ ex.getMessage() );
        
            
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
        String q = " DELETE FROM avatar WHERE id='" + id + "' " ;
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

  
    
     public ArrayList CargarAvatars(){
        ArrayList listAvatar = new ArrayList();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM avatar");
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                ModeloRostro mrostro = new ModeloRostro();
                ModeloOjos mojos = new ModeloOjos();
                ModeloCabello mcabello = new ModeloCabello();
                ModeloBoca mboca = new ModeloBoca();
                
                
                Avatar avatar = new Avatar();
                avatar.setId(res.getInt("id"));
                avatar.setRostro(mrostro.CargarRostro(res.getInt("rostro")));
                avatar.setOjos(mojos.CargarOjos(res.getInt("ojos")));
                avatar.setCabello(mcabello.CargarCabello(res.getInt("cabello")));
                avatar.setBoca(mboca.Cargarboca(res.getInt("boca")));
                
                listAvatar.add(avatar);
            }
            
        }catch (Exception e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return listAvatar;
    }

}

