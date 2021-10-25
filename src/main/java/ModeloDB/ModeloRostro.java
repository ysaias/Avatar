/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDB;


import ImagenAvatar.Cabello;
import ImagenAvatar.Rostro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ecomercial1
 */
public class ModeloRostro {
    Connection conn ;
    private String SQL_AGREGAR = "INSERT INTO rostro (nombre, imagen) VALUES (?,?)";
    
    public ModeloRostro(){}

    
    
    public void AgregarImagen(Rostro mImagen){
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
        String q = " DELETE FROM rostro WHERE id='" + id + "' " ;
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
    
    
     public ArrayList CargarRostros(){
        ArrayList listRostros = new ArrayList();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM rostro");
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                Rostro rostro = new Rostro();
                rostro.setId(res.getInt("id"));
                rostro.setNombre(res.getString("nombre"));
                rostro.setImagen(res.getBytes("imagen"));
                listRostros.add(rostro);
            }
            
        }catch (Exception e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return listRostros;
    }
     
    public Rostro CargarRostro(int id){
        Rostro rostro = new Rostro();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM rostro WHERE id='" + id + "' ") ;
            ResultSet res = pstm.executeQuery();
            while (res.next()) {  
                rostro.setId(res.getInt("id"));
                rostro.setNombre(res.getString("nombre"));
                rostro.setImagen(res.getBytes("imagen")); 
            }
            
        }catch (Exception e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return rostro;
    }

}
