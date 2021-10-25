package com.mycompany.avatar_final;

import ImagenAvatar.Boca;
import ImagenAvatar.Cabello;
import ImagenAvatar.Ojos;
import RenderImage.RenderImagenListOjos;
import RenderImage.RenderImagenListRostro;
import ImagenAvatar.Rostro;
import Jpanel_Imagenes.JpanelBoca;
import Jpanel_Imagenes.JpanelCabello;
import Jpanel_Imagenes.JpanelOjos;
import Jpanel_Imagenes.JpanelRostro;
import ModeloDB.ModeloAvatar;
import ModeloDB.ModeloBoca;
import ModeloDB.ModeloCabello;
import ModeloDB.ModeloOjos;
import ModeloDB.ModeloRostro;
import PatronDecorator.Avatar;
import PatronDecorator.AvatarInteface;
import PatronDecorator.Ojos_Avatar;
import RenderImage.RenderImagenListAvatar;
import RenderImage.RenderImagenListBoca;
import RenderImage.RenderImagenListCabello;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ecomercial1
 */
public class AvatarJFrame extends javax.swing.JFrame  {

    ModeloRostro modeloRostro;
    ModeloOjos modeloOjos;
    ModeloCabello modeloCabello;
    ModeloBoca modeloBoca;
    ModeloAvatar modeloAvatar;
    
    DefaultListModel modeloListRostro = new DefaultListModel();
    DefaultListModel modeloListOjos = new DefaultListModel();
    DefaultListModel modeloListCabello = new DefaultListModel();
    DefaultListModel modeloListBoca = new DefaultListModel();
    DefaultListModel modeloListAvatar = new DefaultListModel();
    
    
    String rutaImagenRostro = "";
    String rutaImagenOjos= "";
    String rutaImagenCabello = "";
    String rutaImagenBoca= "";
    
    JpanelRostro panelRostro;
    JpanelOjos panelOjo;
    JpanelCabello panelCabello;
    JpanelBoca panelBoca;
    
    Boca itemBoca;
    Rostro itemRostro;
    Cabello itemCabello;
    Ojos itemOjos;
    
    
    int cantidadListRostro = 0;
    int cantidadListOjos = 0;
    int cantidadListCabello = 0;
    int cantidadListBoca = 0;
    int cantidadListAvatar = 0;

    public AvatarJFrame() {
        initComponents();
        modeloRostro = new ModeloRostro();
        modeloOjos = new ModeloOjos();
        modeloCabello = new ModeloCabello();
        modeloBoca = new ModeloBoca();
        modeloAvatar = new ModeloAvatar();
        cargarImagenesRostro();
        cargarImagenesOjos();
        cargarImagenesCabello();
        cargarImagenesBoca();
        cargarAvatars();
    }
    
     private void cargarImagenesBoca() {
      
        ArrayList bocas;
        Boca boca;
        bocas = modeloBoca.CargarBoca();
        cantidadListBoca = bocas.size();
        if (bocas != null) {
            for (int i = 0; i < bocas.size(); i++) {
                boca = (Boca) bocas.get(i);

                modeloListBoca.addElement(boca);
            }
            jListBoca.setCellRenderer(new RenderImagenListBoca());
            jListBoca.setModel(modeloListBoca);

        }

    }
     private void cargarImagenesCabello() {
      
        ArrayList cabellos;
        Cabello cabello;
        cabellos = modeloCabello.CargarCabellos();
        cantidadListCabello = cabellos.size();
        if (cabellos != null) {
            for (int i = 0; i < cabellos.size(); i++) {
                cabello = (Cabello) cabellos.get(i);

                modeloListCabello.addElement(cabello);
            }
            jListCabello.setCellRenderer(new RenderImagenListCabello());
            jListCabello.setModel(modeloListCabello);

        }

    }
    
     private void cargarImagenesRostro() {
      
        ArrayList rostros;
        Rostro rostro;
        rostros = modeloRostro.CargarRostros();
        cantidadListRostro = rostros.size();
        if (rostros != null) {
            for (int i = 0; i < rostros.size(); i++) {
                rostro = (Rostro) rostros.get(i);

                modeloListRostro.addElement(rostro);
            }
            jListRostro.setCellRenderer(new RenderImagenListRostro());
            jListRostro.setModel(modeloListRostro);

        }

    }
     
    private void cargarImagenesOjos() {
      
        ArrayList ojos;
        Ojos ojo;
        ojos = modeloOjos.CargarOjos();
        cantidadListOjos = ojos.size();
        if (ojos != null) {
            for (int i = 0; i < ojos.size(); i++) {
                ojo = (Ojos) ojos.get(i);

                modeloListOjos.addElement(ojo);
            }
            jListOjos.setCellRenderer(new RenderImagenListOjos());
            jListOjos.setModel(modeloListOjos);

        }

    } 
    
     private void cargarAvatars() {
      
        ArrayList avatares;
        Avatar avatar;
        avatares = modeloAvatar.CargarAvatars();
        cantidadListAvatar = avatares.size();
        if (avatares != null) {
            for (int i = 0; i < avatares.size(); i++) {
                avatar = (Avatar) avatares.get(i);

                modeloListAvatar.addElement(avatar);
            }
            jListAvatar.setCellRenderer(new RenderImagenListAvatar());
            jListAvatar.setModel(modeloListAvatar);

        }

    } 
     
    private void limpiarRostro() {
        for (int i = 0; i < jListRostro.getModel().getSize(); i++) {
            modeloListRostro.remove(i);
            i -= 1;
        }
    }
    private void limpiarAvatar() {
        for (int i = 0; i < jListAvatar.getModel().getSize(); i++) {
            modeloListAvatar.remove(i);
            i -= 1;
        }
    }
    private void limpiarOjos() {
        for (int i = 0; i < jListOjos.getModel().getSize(); i++) {
            modeloListOjos.remove(i);
            i -= 1;
        }
    }
    private void limpiarCabello() {
        for (int i = 0; i < jListCabello.getModel().getSize(); i++) {
            modeloListCabello.remove(i);
            i -= 1;
        }
    }
    private void limpiarBoca() {
        for (int i = 0; i < jListBoca.getModel().getSize(); i++) {
            modeloListBoca.remove(i);
            i -= 1;
        }
    }
     
     private byte[] getImagen(String Ruta) {
        File imagen = new File(Ruta);
        try {
            byte[] icono = new byte[(int) imagen.length()];
            InputStream input = new FileInputStream(imagen);
            input.read(icono);
            return icono;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCargarRostro = new javax.swing.JButton();
        jButtonCargarOjos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelAvatar = new javax.swing.JPanel();
        jButtonGuardarRostro = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRostro = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListOjos = new javax.swing.JList();
        jButtonGuardarOjos = new javax.swing.JButton();
        jButtonGuardarCabello = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListCabello = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListBoca = new javax.swing.JList();
        jButtonGuardarBoca = new javax.swing.JButton();
        jButtonCargarCabello = new javax.swing.JButton();
        jButtonCargarBoca = new javax.swing.JButton();
        jButtonGuardarAvatar = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListAvatar = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Avatar");
        setPreferredSize(new java.awt.Dimension(1100, 950));

        jButtonCargarRostro.setText("Cargar Rostro");
        jButtonCargarRostro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarRostroActionPerformed(evt);
            }
        });

        jButtonCargarOjos.setText("Cargar Ojos");
        jButtonCargarOjos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarOjosActionPerformed(evt);
            }
        });

        panelAvatar.setBackground(new java.awt.Color(102, 255, 255));
        panelAvatar.setToolTipText("");
        panelAvatar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                panelAvatarAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        panelAvatar.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAvatar.getAccessibleContext().setAccessibleName("");
        panelAvatar.getAccessibleContext().setAccessibleDescription("");
        panelAvatar.getAccessibleContext().setAccessibleParent(null);

        jButtonGuardarRostro.setText("Guardar Rostro");
        jButtonGuardarRostro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarRostroActionPerformed(evt);
            }
        });

        jListRostro.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListRostro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListRostroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListRostro);

        jScrollPane3.setViewportView(jScrollPane1);

        jListOjos.setBackground(new java.awt.Color(102, 255, 255));
        jListOjos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListOjos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListOjosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListOjos);

        jScrollPane4.setViewportView(jScrollPane2);

        jButtonGuardarOjos.setText("Guardar Ojos");
        jButtonGuardarOjos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarOjosActionPerformed(evt);
            }
        });

        jButtonGuardarCabello.setText("Guardar Cabello");
        jButtonGuardarCabello.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarCabelloActionPerformed(evt);
            }
        });

        jListCabello.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListCabello.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListCabelloMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jListCabello);

        jScrollPane5.setViewportView(jScrollPane6);

        jListBoca.setBackground(new java.awt.Color(102, 255, 255));
        jListBoca.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListBoca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListBocaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jListBoca);

        jScrollPane7.setViewportView(jScrollPane8);

        jButtonGuardarBoca.setText("Guardar Boca");
        jButtonGuardarBoca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarBocaActionPerformed(evt);
            }
        });

        jButtonCargarCabello.setText("Cargar Cabello");
        jButtonCargarCabello.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarCabelloActionPerformed(evt);
            }
        });

        jButtonCargarBoca.setText("Cargar Boca");
        jButtonCargarBoca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarBocaActionPerformed(evt);
            }
        });

        jButtonGuardarAvatar.setText("Guardar Avatar");
        jButtonGuardarAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarAvatarActionPerformed(evt);
            }
        });

        jListAvatar.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAvatarMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jListAvatar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButtonGuardarAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCargarCabello, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonGuardarCabello, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCargarRostro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonGuardarRostro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButtonCargarBoca, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonGuardarBoca, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButtonCargarOjos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonGuardarOjos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(184, 184, 184)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(188, 188, 188)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 73, Short.MAX_VALUE)))
                        .addGap(87, 87, 87))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCargarRostro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCargarOjos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGuardarRostro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGuardarOjos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCargarCabello, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonGuardarCabello, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonGuardarAvatar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonGuardarBoca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCargarBoca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCargarRostroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarRostroActionPerformed
           if(panelRostro != null){
             panelAvatar.remove(panelRostro);
           }
            String ruta = rutaImagenSelecionada();
            rutaImagenRostro = ruta;
            panelRostro = new JpanelRostro(ruta);
            panelAvatar.add(panelRostro);
            panelAvatar.repaint();            
        
    }//GEN-LAST:event_jButtonCargarRostroActionPerformed

    private void panelAvatarAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_panelAvatarAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_panelAvatarAncestorAdded

    private void jButtonGuardarRostroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarRostroActionPerformed
            Rostro rostro = new Rostro();
            rostro.setNombre("Rostro-" + cantidadListRostro);
            rostro.setImagen(getImagen(rutaImagenRostro));
            
            modeloRostro.AgregarImagen(rostro);
            limpiarRostro();
            cargarImagenesRostro();
    }//GEN-LAST:event_jButtonGuardarRostroActionPerformed

    private void jButtonGuardarOjosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarOjosActionPerformed
            Ojos ojos = new Ojos();
            ojos.setNombre("Ojos-"+cantidadListOjos);
            ojos.setImagen(getImagen(rutaImagenOjos));
            
            modeloOjos.AgregarImagen(ojos);
            limpiarOjos();
            cargarImagenesOjos();        
    }//GEN-LAST:event_jButtonGuardarOjosActionPerformed

    private void jButtonCargarOjosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarOjosActionPerformed
            if (panelOjo != null) {
                panelAvatar.remove(panelOjo);
            }
            String ruta = rutaImagenSelecionada();
            rutaImagenOjos = ruta;
            panelOjo = new JpanelOjos(ruta);
            panelAvatar.add(panelOjo);
            panelAvatar.repaint();      
    }//GEN-LAST:event_jButtonCargarOjosActionPerformed

    private void jButtonGuardarCabelloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarCabelloActionPerformed
            Cabello cabello = new Cabello();
            cabello.setNombre("Cabello-"+cantidadListCabello);
            cabello.setImagen(getImagen(rutaImagenCabello));
            
            modeloCabello.AgregarImagenCabello(cabello);
            limpiarCabello();
            cargarImagenesCabello();  
    }//GEN-LAST:event_jButtonGuardarCabelloActionPerformed

    private void jButtonGuardarBocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarBocaActionPerformed
            Boca boca = new Boca();
            boca.setNombre("Boca-"+cantidadListBoca);
            boca.setImagen(getImagen(rutaImagenBoca));
            
            modeloBoca.AgregarImagenBoca(boca);
            limpiarBoca();
            cargarImagenesBoca();  
    }//GEN-LAST:event_jButtonGuardarBocaActionPerformed

    private void jButtonCargarCabelloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarCabelloActionPerformed
            if(panelCabello != null){
             panelAvatar.remove(panelCabello);
           }
            String ruta = rutaImagenSelecionada();
            rutaImagenCabello = ruta;
            panelCabello = new JpanelCabello(ruta);
            panelAvatar.add(panelCabello);
            panelAvatar.repaint(); 
    }//GEN-LAST:event_jButtonCargarCabelloActionPerformed

    private void jButtonCargarBocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarBocaActionPerformed
            if(panelBoca != null){
             panelAvatar.remove(panelBoca);
           }
            String ruta = rutaImagenSelecionada();
            rutaImagenBoca = ruta;
            panelBoca = new JpanelBoca(ruta);
            panelAvatar.add(panelBoca);
            panelAvatar.repaint(); 
    }//GEN-LAST:event_jButtonCargarBocaActionPerformed

    private void jListRostroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRostroMouseClicked
            if(evt.getClickCount() == 2){
                if(panelRostro != null){
                    panelAvatar.remove(panelRostro);
                }
                JList target = (JList)evt.getSource();
                target.getSelectedValue();
                int index = target.locationToIndex(evt.getPoint());
                if(index >= 0){
                itemRostro = (Rostro)target.getSelectedValue();
                   
                panelRostro = new JpanelRostro(imagenIcon(itemRostro.getImagen()));
                panelAvatar.add(panelRostro);
                panelAvatar.repaint();
            }
        }
    }//GEN-LAST:event_jListRostroMouseClicked

    private void jListOjosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListOjosMouseClicked
            if(evt.getClickCount() == 2){
                if (panelOjo != null) {
                   panelAvatar.remove(panelOjo);
                }

                JList target = (JList) evt.getSource();
                target.getSelectedValue();
                int index = target.locationToIndex(evt.getPoint());
                if (index >= 0) {
                itemOjos = (Ojos) target.getSelectedValue();

                panelOjo = new JpanelOjos(imagenIcon(itemOjos.getImagen()));
                panelAvatar.add(panelOjo);
                panelAvatar.repaint();
                }
            }
    }//GEN-LAST:event_jListOjosMouseClicked

    private void jListCabelloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListCabelloMouseClicked
            if(evt.getClickCount() == 2){
                if (panelCabello != null) {
                   panelAvatar.remove(panelCabello);
                }

                JList target = (JList) evt.getSource();
                target.getSelectedValue();
                int index = target.locationToIndex(evt.getPoint());
                if (index >= 0) {
                itemCabello = (Cabello) target.getSelectedValue();

                panelCabello = new JpanelCabello(imagenIcon(itemCabello.getImagen()));
                panelAvatar.add(panelCabello);
                panelAvatar.repaint();
                }
            }
    }//GEN-LAST:event_jListCabelloMouseClicked

    private void jListBocaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListBocaMouseClicked
            if(evt.getClickCount() == 2){
                if (panelBoca != null) {
                   panelAvatar.remove(panelBoca);
                }

                JList target = (JList) evt.getSource();
                target.getSelectedValue();
                int index = target.locationToIndex(evt.getPoint());
                if (index >= 0) {
                itemBoca = (Boca) target.getSelectedValue();

                panelBoca = new JpanelBoca(imagenIcon(itemBoca.getImagen()));
                panelAvatar.add(panelBoca);
                panelAvatar.repaint();
                }
            }
    }//GEN-LAST:event_jListBocaMouseClicked

    private void jButtonGuardarAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarAvatarActionPerformed
        guardarAvatar();
    }//GEN-LAST:event_jButtonGuardarAvatarActionPerformed

    private void jListAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAvatarMouseClicked
             if(evt.getClickCount() == 2){
                if (panelRostro != null) {
                   panelAvatar.remove(panelRostro);
                }
                if (panelOjo != null) {
                   panelAvatar.remove(panelOjo);
                }
                if (panelCabello != null) {
                   panelAvatar.remove(panelCabello);
                }
                if (panelBoca != null) {
                   panelAvatar.remove(panelBoca);
                }

                JList target = (JList) evt.getSource();
                target.getSelectedValue();
                int index = target.locationToIndex(evt.getPoint());
                if (index >= 0) {
                Avatar item = (Avatar) target.getSelectedValue();
                
                panelCabello = new JpanelCabello(imagenIcon(item.getCabello().getImagen()));
                panelOjo = new JpanelOjos(imagenIcon(item.getOjos().getImagen()));
                panelBoca = new JpanelBoca(imagenIcon(item.getBoca().getImagen()));
                panelRostro = new JpanelRostro(imagenIcon(item.getRostro().getImagen()));
                panelAvatar.add(panelCabello);
                panelAvatar.add(panelOjo);
                panelAvatar.add(panelBoca);
                panelAvatar.add(panelRostro);
                panelAvatar.repaint();
                }
            }   
    }//GEN-LAST:event_jListAvatarMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCargarBoca;
    private javax.swing.JButton jButtonCargarCabello;
    private javax.swing.JButton jButtonCargarOjos;
    private javax.swing.JButton jButtonCargarRostro;
    private javax.swing.JButton jButtonGuardarAvatar;
    private javax.swing.JButton jButtonGuardarBoca;
    private javax.swing.JButton jButtonGuardarCabello;
    private javax.swing.JButton jButtonGuardarOjos;
    private javax.swing.JButton jButtonGuardarRostro;
    private javax.swing.JList<String> jListAvatar;
    private javax.swing.JList jListBoca;
    private javax.swing.JList jListCabello;
    private javax.swing.JList jListOjos;
    private javax.swing.JList jListRostro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JPanel panelAvatar;
    // End of variables declaration//GEN-END:variables

    private String rutaImagenSelecionada() {
        String ruta = "";
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(extensionFilter);
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        return ruta;
    }

    private ImageIcon imagenIcon(byte[] im) {
          
            BufferedImage bufferedImage = null;
            InputStream inputStream = new ByteArrayInputStream(im);
                try {
                    bufferedImage = ImageIO.read(inputStream);
                } catch (IOException ex) {
                    Logger.getLogger(AvatarJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
           ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(60, 60, 0)); 
           return mIcono;
    }
    
    private void guardarAvatar(){
        
        //no se como implementar patron de diseño Decorator
//        AvatarInteface avatar = new Avatar(itemRostro);
//        AvatarInteface ojos = new Ojos_Avatar(avatar);
//        ojos.AvatarAdd(itemOjos);
        
        
        Avatar aux = new Avatar();
        aux.setOjos(itemOjos);
        aux.setRostro(itemRostro);
        aux.setCabello(itemCabello);
        aux.setBoca(itemBoca);
        
        ModeloAvatar mavatar = new ModeloAvatar();
        mavatar.AgregarAvatar(aux);
        
        limpiarAvatar();
        cargarImagenesCabello();  
        System.out.println("Avatar: "+ aux.getOjos().getNombre() +" "+ aux.getRostro().getNombre() );
    }
}
