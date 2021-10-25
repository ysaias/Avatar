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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ysaias
 */
public class Modelo{
    
    Connection conn ;
    private String SQL_AGREGAR = "INSERT INTO imagen (titulo, imagen) VALUES (?,?)";
    
    public Modelo(){}

    /** Obtiene registros de la tabla PRODUCTO y los devuelve en un DefaultTableModel*/
    public DefaultTableModel getTablaProducto()
    {
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"id","titulo","imgen"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      try{
         PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement( "SELECT count(*) as total FROM imagen");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][5];
      try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM imagen");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "id" );
                data[i][1] = res.getString( "titulo" );
                data[i][2] = res.getString( "imagen" );
            i++;
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }

    /** Registra un nuevo producto */
    public boolean NuevaImagen(String id, String titulo , String imagen)
    {
        if( valida_datos(id, titulo, imagen) )
        {
            
            //Se arma la consulta
            String q=" INSERT INTO imagen ( id , nombre , imagen ) "
                    + "VALUES ( '" + id + "','" + titulo + "', '" + imagen + " ) ";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
        else
         return false;
    }
    
    public void AgregarImagen(Cabello mImagen){
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

    /** Elimina un registro dado su ID -> Llave primaria */
    public boolean EliminarProducto( String id )
    {
         boolean res=false;
        //se arma la consulta
        String q = " DELETE FROM imagen WHERE id='" + id + "' " ;
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
    private boolean valida_datos(String id, String titulo , String imagen)
    {
        if( id.equals(" - ") )
            return false;
        else if( titulo.length() > 0 && imagen.length()>0 )
        {
            return true;
        }
        else return false;
    }
    
    
     public ArrayList CargarImagenes(){
        ArrayList Imagenes = new ArrayList();
        try {
            PreparedStatement pstm = ConeccionBD.getConnection().prepareStatement("SELECT * FROM imagen");
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                Cabello mImagen = new Cabello();
                mImagen.setId(res.getInt("id"));
                mImagen.setNombre(res.getString("titulo"));
                mImagen.setImagen(res.getBytes("imagen"));
                Imagenes.add(mImagen);
            }
            
        }catch (Exception e){
             System.err.println( e.getMessage() );
        
            return null;
        }
        return Imagenes;
    }

     
     
     
     
}
