/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Busqueda.VistaBusqueda;
import Control.ControlPropietarios;
import Imagenes.TipoCodificacion;
import Modelo.*;
import Tablas.TablaRender;
import Utilidades.OpcionesHierro;
import Utilidades.UtilidadesImagenes;
import java.awt.*;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author MERRY
 */
public class VistaAllHierros extends javax.swing.JPanel {

    public int banBQDPropietarios = 0;
    public DefaultTableModel modeloTblHierro;
    public String[] EncabezadoTblHierro;
    private ModeloHierros modeloHierro;
    private ControlPropietarios controlPropietario;
    private ArrayList<ModeloHierros> ListamodeloHierros;
    ModeloVentanaGeneral objetoVentana;
    ModeloGestorBusqueda objetoBusqueda;

    /**
     * Creates new form VistaAllHierros
     */
    public VistaAllHierros() {
        initComponents();
        lblIdPropietario.setVisible(false);
        EncabezadoTblHierro = new String[]{
            "No", "Descripción", "Imagen", "Estado", "Ver", "Modificar", "Eliminar"
        };
        controlPropietario = new ControlPropietarios();
        InicializarTblHierros();
    }

    public void InicializarTblHierros() {
        tbl_Hierro.setDefaultRenderer(Object.class, new TablaRender());

        modeloTblHierro = new DefaultTableModel(EncabezadoTblHierro, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int col) {
                return types[col];
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tbl_Hierro.setModel(modeloTblHierro);

        tbl_Hierro.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl_Hierro.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_Hierro.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_Hierro.getColumnModel().getColumn(3).setPreferredWidth(80);
        tbl_Hierro.getColumnModel().getColumn(4).setPreferredWidth(80);
        tbl_Hierro.getColumnModel().getColumn(5).setPreferredWidth(80);
        tbl_Hierro.getColumnModel().getColumn(6).setPreferredWidth(80);

        tbl_Hierro.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i < modeloTblHierro.getColumnCount(); i++) {
            tbl_Hierro.getColumnModel().getColumn(i).setResizable(false);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setFont(new Font("Tahoma", 0, 12));

            if (i == 2) {
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);

            } else {
                tcr.setHorizontalAlignment(SwingConstants.CENTER);

            }
            tcr.setForeground(new Color(26, 82, 118));
            tbl_Hierro.getColumnModel().getColumn(i).setCellRenderer(tcr);

        }
        JTableHeader header = tbl_Hierro.getTableHeader();

        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setPreferredSize(new Dimension(0, 35));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setVerticalAlignment(JLabel.CENTER);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Hierro = new javax.swing.JTable();
        btnAgregarHierro = new javax.swing.JButton();
        lbltitle4 = new javax.swing.JLabel();
        txtPropietarios = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        lblBsqPropietarios = new javax.swing.JLabel();
        lblIdPropietario = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Hierro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Hierro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_HierroMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Hierro);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 360));

        btnAgregarHierro.setBackground(new java.awt.Color(0, 0, 204));
        btnAgregarHierro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/add.png"))); // NOI18N
        btnAgregarHierro.setToolTipText("Agregar Hierro");
        btnAgregarHierro.setBorder(null);
        btnAgregarHierro.setBorderPainted(false);
        btnAgregarHierro.setContentAreaFilled(false);
        btnAgregarHierro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarHierro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHierroActionPerformed(evt);
            }
        });
        add(btnAgregarHierro, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 30, 30));

        lbltitle4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltitle4.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle4.setText("Propietario");
        add(lbltitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, -1));

        txtPropietarios.setEditable(false);
        txtPropietarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPropietarios.setForeground(new java.awt.Color(59, 123, 50));
        txtPropietarios.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPropietarios.setBorder(null);
        txtPropietarios.setCaretColor(new java.awt.Color(59, 123, 50));
        txtPropietarios.setSelectionColor(new java.awt.Color(59, 123, 50));
        add(txtPropietarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 480, 30));

        jSeparator9.setBackground(new java.awt.Color(59, 123, 50));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 480, 10));

        lblBsqPropietarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/lupa_1.png"))); // NOI18N
        lblBsqPropietarios.setToolTipText("Consultar Arrendatario");
        lblBsqPropietarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBsqPropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBsqPropietariosMouseClicked(evt);
            }
        });
        add(lblBsqPropietarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 30, 30));
        add(lblIdPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_HierroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HierroMouseReleased
        int fila = tbl_Hierro.getSelectedRow();
        int cola = tbl_Hierro.getSelectedColumn();
        if (cola == OpcionesHierro.ACTUALIZAR) {// ACTUALIZAR
            modeloHierro = new ModeloHierros();
            modeloHierro = ListamodeloHierros.get(fila);

            objetoVentana = new ModeloVentanaGeneral(this, new VistaHierros(), 1, modeloHierro);
            objetoVentana.setFila(fila);

            new VistaGeneral(objetoVentana).setVisible(true);

        } else if (cola == OpcionesHierro.ELIMINAR) { //ELIMINAR
            int resp = JOptionPane.showConfirmDialog(this, "¿Esta Seguro de Eliminar esta Fila?");
            if (resp == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "HAz EL MEtodo ");
            }
        } else if (cola == OpcionesHierro.VER_IMAGEN) { //VER IMAGEN
            modeloHierro = new ModeloHierros();
            modeloHierro = ListamodeloHierros.get(fila);
            mostrarImagen(modeloHierro);
        }
    }//GEN-LAST:event_tbl_HierroMouseReleased

    private void btnAgregarHierroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHierroActionPerformed

        if (lblIdPropietario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Por Favor Consulte a un Propietario.");
            return;
        }
        btnAgregarHierro.setEnabled(false);
        modeloHierro = new ModeloHierros();
        modeloHierro.setId_propietario("" + lblIdPropietario.getText());
        modeloHierro.setId("0");

        objetoVentana = new ModeloVentanaGeneral(this, new VistaHierros(), 1, modeloHierro);
        objetoVentana.setFila(-1);

        new VistaGeneral(objetoVentana).setVisible(true);
    }//GEN-LAST:event_btnAgregarHierroActionPerformed

    private void lblBsqPropietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBsqPropietariosMouseClicked
        if (banBQDPropietarios == 0) {
            banBQDPropietarios = 1;
            //new ventanaBusquedaPaciente(1, "IDENTIFICACION:-:NOMBRE", estadoch, this);
            if (lblBsqPropietarios.isEnabled()) {
                objetoBusqueda = new ModeloGestorBusqueda(this, "BQD_PROP", 1);
                LimpiarPropietarios();
                new VistaBusqueda(objetoBusqueda);
            }
        }
    }//GEN-LAST:event_lblBsqPropietariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarHierro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblBsqPropietarios;
    private javax.swing.JLabel lblIdPropietario;
    private javax.swing.JLabel lbltitle4;
    private javax.swing.JTable tbl_Hierro;
    public javax.swing.JTextField txtPropietarios;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc="Metodo Busqueda Retorno">
    public void RetornoBusqueda(ModeloGestorBusqueda objeto, Map<String, String> retorno) {

        if (objeto.getOpcion() == 0) {// DEFAULT VISTA__VENTANA__

        } else if (objeto.getOpcion() == 1) {// PROPIETARIOS
            banBQDPropietarios = 0;
            lblIdPropietario.setText("" + retorno.get("ID"));
            txtPropietarios.setText("" + retorno.get("PROPIETARIO"));
            ListamodeloHierros = (ArrayList<ModeloHierros>) controlPropietario.ObtenerHierrosxPropietario("" + lblIdPropietario.getText());

            if(ListamodeloHierros.size()>0){
                for (int i = 0; i < ListamodeloHierros.size(); i++) {
                    agregarFilaTabla(modeloTblHierro,
                            new Object[]{
                                tbl_Hierro.getRowCount() + 1,
                                ListamodeloHierros.get(i).getDescripcion(),
                                ListamodeloHierros.get(i).getNombre_imagen(),
                                ListamodeloHierros.get(i).getEstado(),
                                "Ver",
                                "Modificar",
                                "Eliminar"
                    });
                }
            }
        }
    }
    //</editor-fold>

    public void RetornoVistaGeneral(ModeloVentanaGeneral objeto, Object retorno) {

        if (objeto.getOpcion() == 1) {// VISTA HIERRO
            modeloHierro = (ModeloHierros) retorno;

            //"No","Descripción", "Imagen", "Estado", "Ver", "Modificar", "Eliminar"
            if (objeto.getFila() > -1) {//ESTA EN TABLA ACTUALIZAR
                ListamodeloHierros.set(objeto.getFila(), modeloHierro);
                tbl_Hierro.setValueAt(modeloHierro.getDescripcion(), objeto.getFila(), 1);
                tbl_Hierro.setValueAt(modeloHierro.getNombre_imagen(), objeto.getFila(), 2);
                tbl_Hierro.setValueAt(modeloHierro.getEstado(), objeto.getFila(), 3);

            } else {
                ListamodeloHierros.add(modeloHierro);
                agregarFilaTabla(modeloTblHierro,
                        new Object[]{
                            tbl_Hierro.getRowCount() + 1,
                            modeloHierro.getDescripcion(),
                            modeloHierro.getNombre_imagen(),
                            modeloHierro.getEstado(),
                            "Ver",
                            "Modificar",
                            "Eliminar"
                        });
            }

        }
    }

    private void LimpiarPropietarios() {
        lblIdPropietario.setText("");
        txtPropietarios.setText("");
    }

    private void agregarFilaTabla(DefaultTableModel modelotbl, Object[] fila) {
        modelotbl.addRow(fila);
    }

    private void mostrarImagen(ModeloHierros modelo) {
        String nombreImagen = "imagen_" + (int) Math.floor(Math.random() * 1000000 + 1) + ".jpg";
        String urlDescarga = System.getProperty("java.io.tmpdir") + "\\" + nombreImagen;//obtengo la ruta del directorio temporal del sistema
        UtilidadesImagenes.imagenesTemporales.add(urlDescarga);

        byte[] bytes = Imagenes.UtilidadesImagenes.getBytes(modelo.getImagen(), TipoCodificacion.IMAGEN_BASE64);
        if (Imagenes.UtilidadesImagenes.descargarImagen(
                urlDescarga,
                bytes
        )) {
            try {
                Desktop.getDesktop().open(new File(urlDescarga));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ocurrio un problema abriendo la imagen, intentelo nuevamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un problema abriendo la imagen, intentelo nuevamente.");
        }
    }
}
