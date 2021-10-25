/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImagenAvatar;

/**
 *
 * @author ecomercial1
 */
public class Rostro {
  private int id;
    private String nombre;
    private byte [] imagen;

    public Rostro() {
    }

    public Rostro(int id, String nombre, byte[] imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
       
}

