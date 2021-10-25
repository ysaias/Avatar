/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RenderImage;


import PatronDecorator.Avatar;
import com.mycompany.avatar_final.AvatarJFrame;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ecomercial1
 */
public class RenderImagenListAvatar extends DefaultListCellRenderer implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Avatar avatar = (Avatar) value;
        setText(String.valueOf(avatar.getId()));
        setIcon(imagenIcon(avatar.getRostro().getImagen()) );
        
//        setIcon(imagenIcon(avatar.getCabello().getImagen()));
//        setIcon(imagenIcon(avatar.getBoca().getImagen()));
        
        
        setEnabled(true);
        setFont(list.getFont());
        
         return this;       
        
    } 
    
     private ImageIcon imagenIcon(byte[] im) {
          
            BufferedImage bufferedImage = null;
            InputStream inputStream = new ByteArrayInputStream(im);
                try {
                    bufferedImage = ImageIO.read(inputStream);
                } catch (IOException ex) {
                    Logger.getLogger(ex.getMessage());
                }
           ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(60, 60, 0)); 
           return mIcono;
    }

}
