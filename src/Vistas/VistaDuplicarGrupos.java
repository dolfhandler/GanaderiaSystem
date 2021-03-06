/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Control.ControlGeneral;
import Control.ControlGrupos;
import Control.Retorno;
import Modelo.ModeloGrupos;
import Modelo.ModeloVentanaGeneral;
import static Utilidades.Consultas.consultas;
import Utilidades.Utilidades;
import Utilidades.datosUsuario;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author DOLFHANDLER
 */
public class VistaDuplicarGrupos extends javax.swing.JPanel {

    private ModeloVentanaGeneral modeloVentanaGeneral;
    private List<Map<String, String>> fincasOrigen;
    private List<Map<String, String>> fincasDestino;
    private List<Map<String, String>> tipoAnimalOrigen;
    private List<Map<String, String>> tipoAnimalDestino;
    private ControlGeneral controlGral;
    private ControlGrupos control;
    private ModeloGrupos modelo;

    public VistaDuplicarGrupos() {
        initComponents();
        setSize(689, 304);
        controlGral = new ControlGeneral();
        control = new ControlGrupos();
        modelo = new ModeloGrupos();
        cargarComboFincasDestino();
        cargarComboFincasOrigen();
    }

    VistaDuplicarGrupos(ModeloVentanaGeneral modeloVentanaGeneral) {
        initComponents();
        setSize(689, 304);
        this.modeloVentanaGeneral = modeloVentanaGeneral;
        controlGral = new ControlGeneral();
        control = new ControlGrupos();
        modelo = new ModeloGrupos();
        cargarComboFincasDestino();
        cargarComboFincasOrigen();

    }

    private void cargarComboFincasOrigen() {
        String consulta = consultas.get("CARGAR_COMBO_FINCAS");
        fincasOrigen = controlGral.GetComboBox(consulta);

        Utilidades.LlenarComboBox(cbFincaOrigen, fincasOrigen, "descripcion");

        VistaGrupos vg = (VistaGrupos) (modeloVentanaGeneral != null ? modeloVentanaGeneral.getPanelPadre() : new VistaGrupos());
        String idFincaOrigen = vg.cbFinca.getSelectedItem().toString();
        if (!idFincaOrigen.isEmpty()) {
            cbFincaOrigen.setSelectedItem(idFincaOrigen);
            seleccionarFincaOrigen();
        }
    }

    private void cargarComboFincasDestino() {
        String consulta = consultas.get("CARGAR_COMBO_FINCAS");
        fincasDestino = controlGral.GetComboBox(consulta);

        Utilidades.LlenarComboBox(cbFincaDestino, fincasDestino, "descripcion");
    }

    private void cargarComboTipoAnimales() {
        String consulta = consultas.get("CARGAR_COMBO_TIPO_ANIMALES") + txtCodigoFincaOrigen.getText();
        tipoAnimalOrigen = controlGral.GetComboBox(consulta);

        Utilidades.LlenarComboBox(cbTipoAnimalOrigen, tipoAnimalOrigen, "descripcion");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigoFincaOrigen = new javax.swing.JLabel();
        txtCodigoFincaDestino = new javax.swing.JLabel();
        txtCodigoTipoAnimalOrigen = new javax.swing.JLabel();
        panelOrigen = new javax.swing.JPanel();
        lbltitle8 = new javax.swing.JLabel();
        cbFincaOrigen = new javax.swing.JComboBox();
        lbltitle4 = new javax.swing.JLabel();
        cbTipoAnimalOrigen = new javax.swing.JComboBox();
        panelOrigen1 = new javax.swing.JPanel();
        lbltitle9 = new javax.swing.JLabel();
        cbFincaDestino = new javax.swing.JComboBox();
        btnRegistroSiguiente = new javax.swing.JButton();
        lbltitle10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelOrigen.setBackground(new java.awt.Color(255, 255, 255));
        panelOrigen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Datos de origen ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 0))); // NOI18N
        panelOrigen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltitle8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltitle8.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle8.setText("Fincas");
        panelOrigen.add(lbltitle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        cbFincaOrigen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbFincaOrigen.setForeground(new java.awt.Color(59, 123, 50));
        cbFincaOrigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        cbFincaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFincaOrigenActionPerformed(evt);
            }
        });
        panelOrigen.add(cbFincaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 270, 30));

        lbltitle4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltitle4.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle4.setText("Tipo de animales");
        panelOrigen.add(lbltitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));

        cbTipoAnimalOrigen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbTipoAnimalOrigen.setForeground(new java.awt.Color(59, 123, 50));
        cbTipoAnimalOrigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        cbTipoAnimalOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoAnimalOrigenActionPerformed(evt);
            }
        });
        panelOrigen.add(cbTipoAnimalOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 270, 30));

        add(panelOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 310, 160));

        panelOrigen1.setBackground(new java.awt.Color(255, 255, 255));
        panelOrigen1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Datos de destino ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 0))); // NOI18N
        panelOrigen1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltitle9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltitle9.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle9.setText("Fincas");
        panelOrigen1.add(lbltitle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        cbFincaDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbFincaDestino.setForeground(new java.awt.Color(59, 123, 50));
        cbFincaDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        cbFincaDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFincaDestinoActionPerformed(evt);
            }
        });
        panelOrigen1.add(cbFincaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 270, 30));

        add(panelOrigen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 310, 160));

        btnRegistroSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/copiar.png"))); // NOI18N
        btnRegistroSiguiente.setToolTipText("Copiar grupos de animales");
        btnRegistroSiguiente.setBorderPainted(false);
        btnRegistroSiguiente.setContentAreaFilled(false);
        btnRegistroSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroSiguiente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/copiar_over.png"))); // NOI18N
        btnRegistroSiguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/copiar_over.png"))); // NOI18N
        btnRegistroSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroSiguienteActionPerformed(evt);
            }
        });
        add(btnRegistroSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 30, 30));

        lbltitle10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbltitle10.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle10.setText("<html>\n<p align='justify'>\nLos <b>grupos de animales</b> de la finca y el tipo de animal especificados en los datos de origen,\n<br> \nserán copiados a la finca especificada en los Datos de destino una vez haga clic en el botón copiar\n</p>\n</html>");
        add(lbltitle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 640, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void cbFincaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFincaOrigenActionPerformed
        seleccionarFincaOrigen();
    }//GEN-LAST:event_cbFincaOrigenActionPerformed

    private void cbFincaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFincaDestinoActionPerformed
        int indice = cbFincaDestino.getSelectedIndex();
        if (indice > 0) {
            String idFinca = fincasDestino.get(indice).get("id");
            txtCodigoFincaDestino.setText(idFinca);
        }
    }//GEN-LAST:event_cbFincaDestinoActionPerformed

    private void cbTipoAnimalOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoAnimalOrigenActionPerformed
        seleccionarTipoAnimal();
    }//GEN-LAST:event_cbTipoAnimalOrigenActionPerformed

    private void btnRegistroSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroSiguienteActionPerformed
        Duplicar();
    }//GEN-LAST:event_btnRegistroSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistroSiguiente;
    public javax.swing.JComboBox cbFincaDestino;
    public javax.swing.JComboBox cbFincaOrigen;
    public javax.swing.JComboBox cbTipoAnimalOrigen;
    private javax.swing.JLabel lbltitle10;
    private javax.swing.JLabel lbltitle4;
    private javax.swing.JLabel lbltitle8;
    private javax.swing.JLabel lbltitle9;
    private javax.swing.JPanel panelOrigen;
    private javax.swing.JPanel panelOrigen1;
    private javax.swing.JLabel txtCodigoFincaDestino;
    private javax.swing.JLabel txtCodigoFincaOrigen;
    private javax.swing.JLabel txtCodigoTipoAnimalOrigen;
    // End of variables declaration//GEN-END:variables

    private void Duplicar() {
        //<editor-fold defaultstate="collapsed" desc="VALIDACIONES">
        if (cbFincaOrigen.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar la finca de origen.");
            cbFincaOrigen.requestFocusInWindow();
            return;
        }
        if (cbTipoAnimalOrigen.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de animal del origen.");
            cbTipoAnimalOrigen.requestFocusInWindow();
            return;
        }
        if (cbFincaDestino.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar la finca de destino.");
            cbFincaDestino.requestFocusInWindow();
            return;
        }
//</editor-fold>
        modelo.setIdFincaOrigen(txtCodigoFincaOrigen.getText());
        modelo.setIdTipoAnimalOrigen(txtCodigoTipoAnimalOrigen.getText());
        modelo.setDescTipoAnimalOrigen(cbTipoAnimalOrigen.getSelectedItem().toString());
        modelo.setIdFincaDestino(txtCodigoFincaDestino.getText());
        modelo.setDescFincaDestino(cbFincaDestino.getSelectedItem().toString());
        modelo.setIdUsuario(datosUsuario.datos.get(0).get("ID_USUARIO"));

        int retorno = Retorno.DEFECTO;

        retorno = control.Duplicar(modelo);

        String mensaje = "";
        switch (retorno) {
            case Retorno.EXITO:
                mensaje = "Grupos copiado satisfactoriamente.";
                ((VistaGeneral) modeloVentanaGeneral.getFrameVentana()).dispose();
                break;
            case Retorno.ERROR:
                mensaje = "Ocurrio un error tratando de copiar los grupos a otra finca.";
                break;
            case Retorno.EXCEPCION_SQL:
                mensaje = "Ocurrio un error en la base de datos\nOperación no realizada.";
                break;
            case Retorno.CLASE_NO_ENCONTRADA:
                mensaje = "Ocurrio un error con el conector de la base de datos\nOperación no realizada.";
                break;
        }

        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void seleccionarFincaOrigen() {
        int indice = cbFincaOrigen.getSelectedIndex();
        if (indice > 0) {
            String idFinca = fincasOrigen.get(indice).get("id");
            String descFinca = fincasOrigen.get(indice).get("descripcion");
            txtCodigoFincaOrigen.setText(idFinca);

            cargarComboTipoAnimales();

            for (int i = 0; i < cbFincaDestino.getItemCount(); i++) {
                if (descFinca.equals(cbFincaDestino.getItemAt(i))) {
                    cbFincaDestino.removeItemAt(i);
                    fincasDestino.remove(indice);
                    i--;
                }
            }
        }
    }

    private void seleccionarTipoAnimal() {
        int indice = cbTipoAnimalOrigen.getSelectedIndex();
        if (indice > 0) {
            String idTipoAnimal = tipoAnimalOrigen.get(indice).get("id");
            txtCodigoTipoAnimalOrigen.setText(idTipoAnimal);
        }
    }
}
