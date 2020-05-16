/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alerta;

import Utilidades.Utilidades;
import javax.swing.ImageIcon;

/**
 *
 * @author DOLFHANDLER
 */
public class VentanaAlerta extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAlerta
     */
    public VentanaAlerta() {
        initComponents();
        setLocationRelativeTo(null);
        panelSi.setVisible(false);
        btnSi.setVisible(false);
        panelNo.setVisible(false);
        btnNo.setVisible(false);
        panelAceptar.setVisible(false);
        btnAceptar.setVisible(false);
        Mensaje.bloquear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCerrar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        imagenAlerta = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JLabel();
        panelAceptar = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        panelNo = new javax.swing.JPanel();
        btnNo = new javax.swing.JButton();
        panelSi = new javax.swing.JPanel();
        btnSi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(157, 189, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCerrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCerrar.setForeground(new java.awt.Color(59, 123, 50));
        txtCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCerrar.setText("x");
        txtCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCerrarMousePressed(evt);
            }
        });
        jPanel1.add(txtCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 20, -1));

        jPanel2.setBackground(new java.awt.Color(132, 173, 127));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alerta/Iconos/alerta.png"))); // NOI18N
        jPanel2.add(imagenAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 62, 100, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 230));

        txtTitulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(59, 123, 50));
        txtTitulo.setText("título de la ventana");
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 230, 40));

        txtMensaje.setForeground(new java.awt.Color(59, 123, 50));
        txtMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMensaje.setText("adasdadasdasdadsadad");
        jPanel1.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 250, 100));

        panelAceptar.setBackground(new java.awt.Color(59, 123, 50));
        panelAceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 123, 50)));
        panelAceptar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setMargin(new java.awt.Insets(1, 10, 1, 10));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelAceptar.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel1.add(panelAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 90, 30));

        panelNo.setBackground(new java.awt.Color(59, 123, 50));
        panelNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 123, 50)));
        panelNo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNo.setForeground(new java.awt.Color(255, 255, 255));
        btnNo.setText("No");
        btnNo.setBorderPainted(false);
        btnNo.setContentAreaFilled(false);
        btnNo.setFocusPainted(false);
        btnNo.setMargin(new java.awt.Insets(1, 10, 1, 10));
        btnNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNoMouseExited(evt);
            }
        });
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        panelNo.add(btnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 45, 30));

        jPanel1.add(panelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 190, 45, 30));

        panelSi.setBackground(new java.awt.Color(59, 123, 50));
        panelSi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 123, 50)));
        panelSi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSi.setForeground(new java.awt.Color(255, 255, 255));
        btnSi.setText("Si");
        btnSi.setBorderPainted(false);
        btnSi.setContentAreaFilled(false);
        btnSi.setFocusPainted(false);
        btnSi.setMargin(new java.awt.Insets(1, 10, 1, 10));
        btnSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSiMouseExited(evt);
            }
        });
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });
        panelSi.add(btnSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 45, 30));

        jPanel1.add(panelSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 45, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCerrarMousePressed
        dispose();
    }//GEN-LAST:event_txtCerrarMousePressed

    private void btnNoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNoMouseEntered
        Utilidades.establecerColorDeFondo(panelNo, true);
    }//GEN-LAST:event_btnNoMouseEntered

    private void btnNoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNoMouseExited
        Utilidades.establecerColorDeFondo(panelNo, false);
    }//GEN-LAST:event_btnNoMouseExited

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        Mensaje.respuesta = Confirmacion.NO;
    }//GEN-LAST:event_btnNoActionPerformed

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        Utilidades.establecerColorDeFondo(panelAceptar, true);
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        Utilidades.establecerColorDeFondo(panelAceptar, false);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Mensaje.respuesta = Confirmacion.NO;
        Mensaje.desbloquear();
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiMouseEntered
        Utilidades.establecerColorDeFondo(panelSi, true);
    }//GEN-LAST:event_btnSiMouseEntered

    private void btnSiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiMouseExited
        Utilidades.establecerColorDeFondo(panelSi, false);
    }//GEN-LAST:event_btnSiMouseExited

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        Mensaje.respuesta = Confirmacion.SI;
    }//GEN-LAST:event_btnSiActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Mensaje.bloquear();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(VentanaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAlerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAlerta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnNo;
    public javax.swing.JButton btnSi;
    private javax.swing.JLabel imagenAlerta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel panelAceptar;
    public javax.swing.JPanel panelNo;
    public javax.swing.JPanel panelSi;
    public javax.swing.JLabel txtCerrar;
    public javax.swing.JLabel txtMensaje;
    public javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables

    void cargarIcono(String url) {
        ImageIcon icono = new ImageIcon(getClass().getResource(url));
        imagenAlerta.setIcon(icono);
    }

}