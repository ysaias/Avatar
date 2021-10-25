/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpanel_Imagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ecomercial1
 */
public class JpanelOjos  extends javax.swing.JPanel {
    
    Image imagen;

    public JpanelOjos(String ruta) {
        
        imagen = new ImageIcon(ruta).getImage();
        this.setSize(400, 400); //se selecciona el tamaño del panel
        
    }
    public JpanelOjos(ImageIcon imaIcon) {
        
        imagen = imaIcon.getImage();
        this.setSize(400, 400); //se selecciona el tamaño del panel
        
    }

//Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
        Dimension height = getSize();

//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        ImageIcon Img = new ImageIcon(imagen);

//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
    }

}
