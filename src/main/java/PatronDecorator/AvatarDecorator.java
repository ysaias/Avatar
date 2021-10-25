/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronDecorator;

import ImagenAvatar.Ojos;
import ImagenAvatar.Rostro;

/**
 *
 * @author ecomercial1
 */
public  class AvatarDecorator implements AvatarInteface{

    private AvatarInteface newAvatar ;
    private Ojos ojos;
    

    public AvatarDecorator(AvatarInteface newAvatar) {
        this.newAvatar = newAvatar;
    }

    @Override
    public void AvatarAdd(Ojos ojos) {
        this.ojos = ojos;
    }
    
    
    
    
}
