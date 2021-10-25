/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RenderImage;

import ImagenAvatar.Rostro;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ecomercial1
 */
public class RenderImagenListRostro extends DefaultListCellRenderer implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Rostro rostro = (Rostro) value;
        setName(String.valueOf(rostro.getId()));
        setText(rostro.getNombre());
        try {
            byte[] imagen = rostro.getImagen();
            BufferedImage bufferedImage = null;
            InputStream inputStream = new ByteArrayInputStream(imagen);
            bufferedImage = ImageIO.read(inputStream);
            ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(60, 60, 0));
            setIcon(mIcono);

        } catch (IOException e) {
            System.out.println("RenderImagenList: " + e.getMessage());
        }
        
        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }else{
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(true);
        setFont(list.getFont());
        
         return this;       
        
    }  

}
