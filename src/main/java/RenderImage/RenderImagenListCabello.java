package RenderImage;

import ImagenAvatar.Cabello;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Somos programadores
 */
public class RenderImagenListCabello extends DefaultListCellRenderer implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Cabello cabello = (Cabello) value;
        setText(cabello.getNombre());
        try {
            byte[] imagen = cabello.getImagen();
            BufferedImage bufferedImage = null;
            InputStream inputStream = new ByteArrayInputStream(imagen);
            bufferedImage = ImageIO.read(inputStream);
            ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(60, 60, 0));
            setIcon(mIcono);

        } catch (IOException e) {
            System.out.println("RenderImagenListOjos: " + e.getMessage());
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
