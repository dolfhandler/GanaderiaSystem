package pruebas;


import AjustarControles.tiposDeAjuste;
import AjustarControles.AjustarControles;
import AjustarControles.Ajustar;
import AjustarControles.ControlDeUsuario;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DOLFHANDLER
 */
public class ventanauno extends javax.swing.JFrame {

    private AjustarControles controles;
    private int band = 0;
    private clasePrueba prb;

    public ventanauno() {
        initComponents();

        iniciarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelSecundario = new javax.swing.JPanel();
        btnPrueba = new javax.swing.JButton();
        lblPrueba = new javax.swing.JLabel();
        lblPrueba1 = new javax.swing.JLabel();
        btnPrueba1 = new javax.swing.JButton();
        panelIconos = new javax.swing.JPanel();
        lblprueba1 = new javax.swing.JLabel();
        lblprueba2 = new javax.swing.JLabel();
        panelContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 340));

        panelSecundario.setBackground(new java.awt.Color(255, 255, 255));
        panelSecundario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrueba.setText("jButton1");
        panelSecundario.add(btnPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 86, -1, -1));

        lblPrueba.setText("jLabel1");
        panelSecundario.add(lblPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 90, -1, -1));

        lblPrueba1.setText("jLabel1");
        panelSecundario.add(lblPrueba1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 56, -1, -1));

        btnPrueba1.setText("jButton1");
        btnPrueba1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrueba1ActionPerformed(evt);
            }
        });
        panelSecundario.add(btnPrueba1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 52, -1, -1));

        getContentPane().add(panelSecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 250, 120));

        panelIconos.setBackground(new java.awt.Color(255, 255, 255));

        lblprueba1.setText("jLabel1");
        lblprueba1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblprueba1MousePressed(evt);
            }
        });

        lblprueba2.setText("jLabel2");

        javax.swing.GroupLayout panelIconosLayout = new javax.swing.GroupLayout(panelIconos);
        panelIconos.setLayout(panelIconosLayout);
        panelIconosLayout.setHorizontalGroup(
            panelIconosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIconosLayout.createSequentialGroup()
                .addContainerGap(312, Short.MAX_VALUE)
                .addComponent(lblprueba2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblprueba1)
                .addContainerGap())
        );
        panelIconosLayout.setVerticalGroup(
            panelIconosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIconosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIconosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprueba1)
                    .addComponent(lblprueba2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelIconos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        getContentPane().add(panelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 700, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        iniciarComponentes();
        repaint();
    }//GEN-LAST:event_formComponentResized

    private void lblprueba1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblprueba1MousePressed
        if (evt.getClickCount() == 1) {
            if (band == 0) {
                band = 1;
                panelPrincipal.setBounds(panelPrincipal.getX(), panelPrincipal.getY(), 80, panelPrincipal.getHeight());
                panelSecundario.setBounds(panelPrincipal.getX() + panelPrincipal.getWidth(), panelSecundario.getY(), panelSecundario.getWidth(), panelSecundario.getHeight());
            } else {
                band = 0;
                panelPrincipal.setBounds(panelPrincipal.getX(), panelPrincipal.getY(), 210, panelPrincipal.getHeight());
                panelSecundario.setBounds(panelPrincipal.getX() + panelPrincipal.getWidth(), panelSecundario.getY(), panelSecundario.getWidth(), panelSecundario.getHeight());
            }
            iniciarComponentes();
        }
    }//GEN-LAST:event_lblprueba1MousePressed

    private void btnPrueba1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrueba1ActionPerformed
//        metodoquecompartenlasvistas();
    }//GEN-LAST:event_btnPrueba1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanauno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanauno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanauno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanauno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanauno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrueba;
    private javax.swing.JButton btnPrueba1;
    private javax.swing.JLabel lblPrueba;
    private javax.swing.JLabel lblPrueba1;
    private javax.swing.JLabel lblprueba1;
    private javax.swing.JLabel lblprueba2;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelIconos;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSecundario;
    // End of variables declaration//GEN-END:variables

    private void iniciarComponentes() {
        controles = new AjustarControles();
        ControlDeUsuario controlUsuario = new ControlDeUsuario(panelContenedor);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.DERECHA);
        controlUsuario.addAjuste(Ajustar.ABAJO);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_DIMENSION;
        controles.agregarControl(controlUsuario);

        controlUsuario = new ControlDeUsuario(panelSecundario);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.DERECHA);
        controlUsuario.addAjuste(Ajustar.ABAJO);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_DIMENSION;
        controles.agregarControl(controlUsuario);

        controlUsuario = new ControlDeUsuario(panelPrincipal);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.ABAJO);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_DIMENSION;
        controles.agregarControl(controlUsuario);

        controlUsuario = new ControlDeUsuario(panelIconos);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.DERECHA);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_DIMENSION;
        controles.agregarControl(controlUsuario);

        controlUsuario = new ControlDeUsuario(btnPrueba);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.ABAJO);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_POSICION;
        controles.agregarControl(controlUsuario);

        controlUsuario = new ControlDeUsuario(lblPrueba);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.ABAJO);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_POSICION;
        controles.agregarControl(controlUsuario);

        controlUsuario = new ControlDeUsuario(btnPrueba1);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.ABAJO);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_POSICION;
        controles.agregarControl(controlUsuario);

        controlUsuario = new ControlDeUsuario(lblPrueba1);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.ABAJO);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_POSICION;
        controles.agregarControl(controlUsuario);

        controlUsuario = new ControlDeUsuario(lblprueba1);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.DERECHA);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_POSICION;
        controles.agregarControl(controlUsuario);

        controlUsuario = new ControlDeUsuario(lblprueba2);
        controlUsuario.ajustable = true;
        controlUsuario.addAjuste(Ajustar.DERECHA);
        controlUsuario.tipoAjuste = tiposDeAjuste.POR_POSICION;
        controles.agregarControl(controlUsuario);

        controles.ajustarControlesPorDimension();
        controles.ajustarControlesPorPosicion();
//        repaint();
    }
    
}