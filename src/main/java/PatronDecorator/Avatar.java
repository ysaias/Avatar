/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronDecorator;

import ImagenAvatar.Boca;
import ImagenAvatar.Cabello;
import ImagenAvatar.Ojos;
import ImagenAvatar.Rostro;

/**
 *
 * @author ecomercial1
 * La implementación no la uso. 
 * 
 */
public class Avatar implements AvatarInteface{
    
    private Rostro rostro;
    private Ojos ojos;
    private Cabello cabello;
    private Boca boca;
    private int id;
    
    //no lo uso
    public Avatar(Rostro rostro) {
        this.rostro = rostro;
    }

    public Avatar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    //no lo uso
  @Override
    public void AvatarAdd(Ojos ojos) {
        this.ojos = ojos;
    }

    public Rostro getRostro() {
        return rostro;
    }

    public void setRostro(Rostro rostro) {
        this.rostro = rostro;
    }

    public Ojos getOjos() {
        return ojos;
    }

    public void setOjos(Ojos ojos) {
        this.ojos = ojos;
    }

    public Cabello getCabello() {
        return cabello;
    }

    public void setCabello(Cabello cabello) {
        this.cabello = cabello;
    }

    public Boca getBoca() {
        return boca;
    }

    public void setBoca(Boca boca) {
        this.boca = boca;
    }
    
    
    
    
    
    
    
}
