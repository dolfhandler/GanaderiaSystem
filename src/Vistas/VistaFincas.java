/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import Busqueda.VistaBusqueda;
import Control.*;
import Modelo.ModeloBloques;
import Modelo.ModeloFincas;
import Modelo.ModeloGestorBusqueda;
import Modelo.ModeloLotes;
import Modelo.ModeloPropietarios;
import Modelo.ModeloVentanaGeneral;
import Tablas.TablaRender;
import static Utilidades.Consultas.consultas;
import Utilidades.Estado;
import Utilidades.Expresiones;
import Utilidades.Utilidades;
import Utilidades.datosUsuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author MERRY
 */
public class VistaFincas extends javax.swing.JPanel {
    public int banBQDPropietarios;
    public int banBQD;
    ModeloGestorBusqueda objetoBusqueda;
    ModeloVentanaGeneral objetoVentana;
    public int id_Finca;
    public String estadog="";
    private ModeloFincas  modelo;
    private ModeloPropietarios  modeloPropietarios;
    private ControlFincas controlFinca;
    private ControlBloques controlBloque;
    private ControLotes controlLote;
    private ModeloBloques  modeloBloques;
    private ModeloLotes  modeloLotes;
    private ArrayList<ModeloBloques>  ListamodeloBloques;
    private ArrayList<ModeloLotes>  ListamodeloLotes;
    public DefaultTableModel modeloTblBloques;
    public DefaultTableModel modeloTblLotes;
    public String[] EncabezadoTblBloques; 
    public String[] EncabezadoTblLotes; 
    private ControlGeneral controlGral;
    private List<Map<String, String>> Tipo_moneda;
    
    /**
     * Creates new form VistaFincas
     */
    public VistaFincas() {
        initComponents();
        banBQDPropietarios = 0;
        banBQD = 0;
        lblIdPropietario.setVisible(false);
        modelo = new ModeloFincas();
        controlFinca = new ControlFincas();
        controlBloque = new ControlBloques();
        controlLote = new ControLotes();
        ListamodeloBloques = new ArrayList<>();
        ListamodeloLotes = new ArrayList<>();
        EncabezadoTblBloques = new String[]{
            "No", "Número", "Área Total", "Modificar", "Eliminar"
        };
        EncabezadoTblLotes = new String[]{
            "No","Bloque", "Número", "Área Total", "Modificar", "Eliminar"
        };
        Tipo_moneda = new ArrayList<>();
        controlGral = new ControlGeneral();
        jTabbedPane1.removeTabAt(2);
        jTabbedPane1.removeTabAt(1);
        btnAgregarPropietario.setVisible(false);
        cargarComboMoneda();
        InicializarTblBloques();
        InicializarTblLotes();
        FincasEstadoFomulario(0);
    }

    public void InicializarTblBloques() {
        tbl_Bloques.setDefaultRenderer(Object.class, new TablaRender());
        
        modeloTblBloques = new DefaultTableModel(EncabezadoTblBloques, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class
            };

            public Class getColumnClass(int col) {
                return types[col];
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tbl_Bloques.setModel(modeloTblBloques);

        tbl_Bloques.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl_Bloques.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_Bloques.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_Bloques.getColumnModel().getColumn(3).setPreferredWidth(80);
        tbl_Bloques.getColumnModel().getColumn(4).setPreferredWidth(80);
        
        tbl_Bloques.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i < modeloTblBloques.getColumnCount(); i++) {
            tbl_Bloques.getColumnModel().getColumn(i).setResizable(false);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setFont(new Font("Tahoma", 0, 12));
            
            if(i == 2 ){
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
               
            }else{
                tcr.setHorizontalAlignment(SwingConstants.CENTER);
                
            }
            tcr.setForeground(new Color(26, 82, 118));
            tbl_Bloques.getColumnModel().getColumn(i).setCellRenderer(tcr);
            
        }
        JTableHeader header = tbl_Bloques.getTableHeader();

        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setPreferredSize(new Dimension(0, 35));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setVerticalAlignment(JLabel.CENTER);
        
    }
    
    public void InicializarTblLotes() {
        tbl_Lotes.setDefaultRenderer(Object.class, new TablaRender());
        
        modeloTblLotes = new DefaultTableModel(EncabezadoTblLotes, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
            };

            public Class getColumnClass(int col) {
                return types[col];
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tbl_Lotes.setModel(modeloTblLotes);

        tbl_Lotes.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl_Lotes.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_Lotes.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_Lotes.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl_Lotes.getColumnModel().getColumn(4).setPreferredWidth(80);
        tbl_Lotes.getColumnModel().getColumn(5).setPreferredWidth(80);
        
        tbl_Lotes.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i < modeloTblLotes.getColumnCount(); i++) {
            tbl_Lotes.getColumnModel().getColumn(i).setResizable(false);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setFont(new Font("Tahoma", 0, 12));
            
            if(i == 3 ){
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
               
            }else{
                tcr.setHorizontalAlignment(SwingConstants.CENTER);
                
            }
            tcr.setForeground(new Color(26, 82, 118));
            tbl_Lotes.getColumnModel().getColumn(i).setCellRenderer(tcr);
            
        }
        JTableHeader header = tbl_Lotes.getTableHeader();

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        lbltitle1 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lbltitle2 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtAreaT = new javax.swing.JTextField();
        lbltitle3 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        txtPropietarios = new javax.swing.JTextField();
        lbltitle4 = new javax.swing.JLabel();
        lblBsqPropietarios = new javax.swing.JLabel();
        btnAgregarPropietario = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnDescartar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblIdPropietario = new javax.swing.JLabel();
        lbltitle5 = new javax.swing.JLabel();
        cbTipoMoneda = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarBloque = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Bloques = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Lotes = new javax.swing.JTable();
        btnAgregarLote = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(59, 123, 50));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(59, 123, 50));
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblId.setText("FINCAS");
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 100, 20));

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(59, 123, 50));
        txtDescripcion.setBorder(null);
        txtDescripcion.setCaretColor(new java.awt.Color(59, 123, 50));
        txtDescripcion.setFocusCycleRoot(true);
        txtDescripcion.setSelectionColor(new java.awt.Color(59, 123, 50));
        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 560, 30));

        jSeparator6.setBackground(new java.awt.Color(59, 123, 50));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 560, 10));

        lbltitle1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltitle1.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle1.setText("Descripcion");
        jPanel1.add(lbltitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 20));

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(59, 123, 50));
        txtDireccion.setBorder(null);
        txtDireccion.setCaretColor(new java.awt.Color(59, 123, 50));
        txtDireccion.setFocusCycleRoot(true);
        txtDireccion.setSelectionColor(new java.awt.Color(59, 123, 50));
        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 560, 30));

        lbltitle2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltitle2.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle2.setText("Direccion");
        jPanel1.add(lbltitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, 20));

        jSeparator7.setBackground(new java.awt.Color(59, 123, 50));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 560, 10));

        txtAreaT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAreaT.setForeground(new java.awt.Color(59, 123, 50));
        txtAreaT.setBorder(null);
        txtAreaT.setCaretColor(new java.awt.Color(59, 123, 50));
        txtAreaT.setFocusCycleRoot(true);
        txtAreaT.setSelectionColor(new java.awt.Color(59, 123, 50));
        txtAreaT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAreaTFocusLost(evt);
            }
        });
        txtAreaT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAreaTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaTKeyReleased(evt);
            }
        });
        jPanel1.add(txtAreaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 140, 30));

        lbltitle3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltitle3.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle3.setText("Tipo Moneda");
        jPanel1.add(lbltitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 100, 20));

        jSeparator8.setBackground(new java.awt.Color(59, 123, 50));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 140, 10));

        jSeparator9.setBackground(new java.awt.Color(59, 123, 50));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 520, 10));

        txtPropietarios.setEditable(false);
        txtPropietarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPropietarios.setForeground(new java.awt.Color(59, 123, 50));
        txtPropietarios.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPropietarios.setBorder(null);
        txtPropietarios.setCaretColor(new java.awt.Color(59, 123, 50));
        txtPropietarios.setSelectionColor(new java.awt.Color(59, 123, 50));
        jPanel1.add(txtPropietarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 520, 30));

        lbltitle4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltitle4.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle4.setText("Propietario");
        jPanel1.add(lbltitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 110, -1));

        lblBsqPropietarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/lupa_1.png"))); // NOI18N
        lblBsqPropietarios.setToolTipText("Consultar Arrendatario");
        lblBsqPropietarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBsqPropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBsqPropietariosMouseClicked(evt);
            }
        });
        jPanel1.add(lblBsqPropietarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 30, 30));

        btnAgregarPropietario.setBackground(new java.awt.Color(0, 0, 204));
        btnAgregarPropietario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/add.png"))); // NOI18N
        btnAgregarPropietario.setToolTipText("Agregar Arrendatario");
        btnAgregarPropietario.setBorder(null);
        btnAgregarPropietario.setBorderPainted(false);
        btnAgregarPropietario.setContentAreaFilled(false);
        btnAgregarPropietario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPropietarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 30, 30));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setMargin(new java.awt.Insets(2, 10, 2, 8));
        btnEliminar.setName("btnEliminar"); // NOI18N
        btnEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/eliminar_over.png"))); // NOI18N
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/eliminar_over.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 64, 64));

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/consultar.png"))); // NOI18N
        btnConsultar.setToolTipText("Consutar");
        btnConsultar.setBorderPainted(false);
        btnConsultar.setContentAreaFilled(false);
        btnConsultar.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnConsultar.setName("btnConsultar"); // NOI18N
        btnConsultar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/consultar_over.png"))); // NOI18N
        btnConsultar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/consultar_over.png"))); // NOI18N
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 64, 64));

        btnDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/descartar.png"))); // NOI18N
        btnDescartar.setToolTipText("Descartar");
        btnDescartar.setBorderPainted(false);
        btnDescartar.setContentAreaFilled(false);
        btnDescartar.setMargin(new java.awt.Insets(2, 10, 2, 8));
        btnDescartar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/descartar_over.png"))); // NOI18N
        btnDescartar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/descartar_over.png"))); // NOI18N
        btnDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescartarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 64, 64));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/modificar.png"))); // NOI18N
        btnModificar.setToolTipText("Modificar");
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.setMargin(new java.awt.Insets(2, 14, 2, 5));
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/modificar_over.png"))); // NOI18N
        btnModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/modificar_over.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 64, 64));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setMargin(new java.awt.Insets(2, 10, 2, 8));
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/guardar_over.png"))); // NOI18N
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/guardar_over.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 64, 64));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(59, 123, 50));
        jLabel13.setText("HA");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, 30));
        jPanel1.add(lblIdPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        lbltitle5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltitle5.setForeground(new java.awt.Color(59, 123, 50));
        lbltitle5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle5.setText("Area Total");
        jPanel1.add(lbltitle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 100, 20));

        cbTipoMoneda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbTipoMoneda.setForeground(new java.awt.Color(59, 123, 50));
        cbTipoMoneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Peso(Colombiano)", "Dolar Estadounidense", "Euro", "Yen", "Libra Esterlina" }));
        cbTipoMoneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoMonedaActionPerformed(evt);
            }
        });
        jPanel1.add(cbTipoMoneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 210, 30));

        jTabbedPane1.addTab("Fincas", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarBloque.setBackground(new java.awt.Color(0, 0, 204));
        btnAgregarBloque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/add.png"))); // NOI18N
        btnAgregarBloque.setToolTipText("Agregar Arrendatario");
        btnAgregarBloque.setBorder(null);
        btnAgregarBloque.setBorderPainted(false);
        btnAgregarBloque.setContentAreaFilled(false);
        btnAgregarBloque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarBloque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBloqueActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarBloque, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 30, 30));

        tbl_Bloques.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Bloques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_BloquesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Bloques);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 570, 350));

        jTabbedPane1.addTab("Bloques", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Lotes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Lotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_LotesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Lotes);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 570, 350));

        btnAgregarLote.setBackground(new java.awt.Color(0, 0, 204));
        btnAgregarLote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/add.png"))); // NOI18N
        btnAgregarLote.setToolTipText("Agregar Arrendatario");
        btnAgregarLote.setBorder(null);
        btnAgregarLote.setBorderPainted(false);
        btnAgregarLote.setContentAreaFilled(false);
        btnAgregarLote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLoteActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregarLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 30, 30));

        jTabbedPane1.addTab("Lotes", jPanel3);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        
    }//GEN-LAST:event_txtDescripcionFocusLost

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionFocusLost

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtAreaTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAreaTFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaTFocusLost

    private void txtAreaTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaTKeyPressed

    private void txtAreaTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaTKeyReleased
        String areat = txtAreaT.getText();
        String valorsin = areat.indexOf(".") > -1 ? areat.replace(".", "") : areat;
        String dato = Expresiones.procesarSoloNumP(valorsin);
        dato = Utilidades.MascaraMonedaConDecimales(dato);
        txtAreaT.setText(dato);
    }//GEN-LAST:event_txtAreaTKeyReleased

    private void lblBsqPropietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBsqPropietariosMouseClicked
        if(banBQDPropietarios == 0){
            banBQDPropietarios = 1;
            //new ventanaBusquedaPaciente(1, "IDENTIFICACION:-:NOMBRE", estadoch, this);
            if(lblBsqPropietarios.isEnabled()){
                objetoBusqueda = new ModeloGestorBusqueda(this, "BQD_PROP", 1);
                LimpiarPropietarios();
                new VistaBusqueda(objetoBusqueda);
            }
        }
    }//GEN-LAST:event_lblBsqPropietariosMouseClicked

    private void btnAgregarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPropietarioActionPerformed
        //new VistaContratos(this).setVisible(true);
        btnAgregarPropietario.setEnabled(false);
        objetoVentana = new ModeloVentanaGeneral(this, new VistaPropietarios(), 2);
        
        LimpiarPropietarios();
        new VistaGeneral(objetoVentana).setVisible(true);
    }//GEN-LAST:event_btnAgregarPropietarioActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescartarActionPerformed
        FincasEstadoFomulario(0);
    }//GEN-LAST:event_btnDescartarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Modificar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarBloqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBloqueActionPerformed
        btnAgregarBloque.setEnabled(false);
        
        modeloBloques = new ModeloBloques();
        modeloBloques.setId_finca(""+id_Finca);
        modeloBloques.setId("0");
        
        objetoVentana = new ModeloVentanaGeneral(this, new VistaBloques(), 1,modeloBloques);
        objetoVentana.setFila(-1);
        
        new VistaGeneral(objetoVentana).setVisible(true);
    }//GEN-LAST:event_btnAgregarBloqueActionPerformed

    private void tbl_BloquesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BloquesMouseReleased
        int fila = tbl_Bloques.getSelectedRow();
        int cola = tbl_Bloques.getSelectedColumn();
        if(cola == 3){// ACTUALIZAR
            
            modeloBloques = ListamodeloBloques.get(fila);
            
            objetoVentana = new ModeloVentanaGeneral(this, new VistaBloques(), 1,modeloBloques);
            objetoVentana.setFila(fila);

            new VistaGeneral(objetoVentana).setVisible(true);
            
        }else if(cola == 4){ //ELIMINAR
            int resp = JOptionPane.showConfirmDialog(this, "¿Esta Seguro de Eliminar esta Fila?");
            if(resp == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(this, "HAz EL MEtodo ");
            }
        }
        
    }//GEN-LAST:event_tbl_BloquesMouseReleased

    private void tbl_LotesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_LotesMouseReleased
        int fila = tbl_Lotes.getSelectedRow();
        int cola = tbl_Lotes.getSelectedColumn();
        if(cola == 4){// ACTUALIZAR
            
            modeloLotes = ListamodeloLotes.get(fila);
            modeloLotes.setId_finca(""+id_Finca);
            
            objetoVentana = new ModeloVentanaGeneral(this, new VistaLotes(), 3,modeloLotes);
            objetoVentana.setFila(fila);

            new VistaGeneral(objetoVentana).setVisible(true);
            
        }else if(cola == 5){ //ELIMINAR
            int resp = JOptionPane.showConfirmDialog(this, "¿Esta Seguro de Eliminar esta Fila?");
            if(resp == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(this, "HAz EL MEtodo ");
            }
        }
    }//GEN-LAST:event_tbl_LotesMouseReleased

    private void btnAgregarLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLoteActionPerformed
        btnAgregarLote.setEnabled(false);
        
        modeloLotes = new ModeloLotes();
        System.out.println("id_Finca-->"+id_Finca);
        System.out.println("modelo.getId()-->"+modelo.getId());
        modeloLotes.setId_finca(""+id_Finca);
        modeloLotes.setId("0");
        
        objetoVentana = new ModeloVentanaGeneral(this, new VistaLotes(), 3,modeloLotes);
        objetoVentana.setFila(-1);
        
        new VistaGeneral(objetoVentana).setVisible(true);
    }//GEN-LAST:event_btnAgregarLoteActionPerformed

    private void cbTipoMonedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoMonedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoMonedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarBloque;
    public javax.swing.JButton btnAgregarLote;
    public javax.swing.JButton btnAgregarPropietario;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnDescartar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    public javax.swing.JComboBox cbTipoMoneda;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBsqPropietarios;
    public javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdPropietario;
    public javax.swing.JLabel lbltitle1;
    public javax.swing.JLabel lbltitle2;
    public javax.swing.JLabel lbltitle3;
    private javax.swing.JLabel lbltitle4;
    public javax.swing.JLabel lbltitle5;
    private javax.swing.JTable tbl_Bloques;
    private javax.swing.JTable tbl_Lotes;
    public javax.swing.JTextField txtAreaT;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtPropietarios;
    // End of variables declaration//GEN-END:variables

    
    //<editor-fold defaultstate="collapsed" desc="Metodos CRUD">
    public void Guardar(){
        
        //<editor-fold defaultstate="collapsed" desc="validaciones">
        if(txtDescripcion.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Por Favor Ingrese la Descripción.");
            return;
        }
        if(txtDireccion.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Por Favor Ingrese la Dirección.");
            return;
        }
        if(txtAreaT.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Por Favor Ingrese el Área Total de la Finca.");
            return;
        }
        if(lblIdPropietario.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Por Favor relacione un propietario a la Finca, para realizar la operación.");
            return;
        }
        if(cbTipoMoneda.getSelectedIndex() <= 0){
            JOptionPane.showMessageDialog(this, "Por Favor seleccione un tipo de moneda, para realizar la operación.");
            return;
        }
//</editor-fold>
        
        modelo.setId(""+id_Finca);
        modelo.setDescripcion(txtDescripcion.getText().trim());
        modelo.setDireccion(txtDireccion.getText().trim());
        modelo.setAreat(txtAreaT.getText().trim().replace(".", "").replace(",", "."));
        modelo.setId_propietario(lblIdPropietario.getText());
        modelo.setFecha("NOW()");
        modelo.setIdUsuario(datosUsuario.datos.get(0).get("ID_USUARIO"));
        modelo.setIdTipoMoneda(Tipo_moneda.get(cbTipoMoneda.getSelectedIndex()).get("ID"));
        int ret = -1;
        if(id_Finca==0){//INSERT
            ret = controlFinca.Guardar(modelo);
        }else{
            ret = controlFinca.Actualizar(modelo);
        }
        
        String mensaje = "";
        switch (ret) {
            case Retorno.EXITO:
                mensaje = "Registro " + (id_Finca == Estado.GUARDAR ? "guardado" : "actualizado") + " satisfactoriamente.";
                break;
            case Retorno.ERROR:
                mensaje = "El registro no pudo ser " + (id_Finca == Estado.GUARDAR ? "guardado" : "actualizado") + ".";
                break;
            case Retorno.EXCEPCION_SQL:
                mensaje = "Ocurrio un error en la base de datos\nOperación no realizada.";
                break;
            case Retorno.CLASE_NO_ENCONTRADA:
                mensaje = "Ocurrio un error con el conector de la base de datos\nOperación no realizada.";
                break;
        }
        JOptionPane.showMessageDialog(this, mensaje);
        FincasEstadoFomulario(0);
    }
    public void Modificar(){
        FincasEstadoFomulario(2);
    }
    public void Consultar(){
        if(banBQD == 0){
            banBQD = 1;
            //new ventanaBusquedaPaciente(1, "IDENTIFICACION:-:NOMBRE", estadoch, this);
            objetoBusqueda = new ModeloGestorBusqueda(this, "BQD_FNCS", 0);
            new VistaBusqueda(objetoBusqueda);
        }
    }
    public void Eliminar(){
        int resp = JOptionPane.showConfirmDialog(this, "¿Esta Seguro de Eliminar este Registro?");
        if(resp == JOptionPane.YES_OPTION){
            int ret = -1;
            ret = controlFinca.Eliminar(modelo);
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodo Busqueda Retorno">
    public void RetornoBusqueda(ModeloGestorBusqueda objeto, Map<String, String> retorno) {
        
        if(objeto.getOpcion() == 0){// DEFAULT VISTA__VENTANA__
            id_Finca = Integer.parseInt(retorno.get("ID"));
            System.out.println("modelo---"+modelo.getId());
            
            modelo = (ModeloFincas)((ArrayList<ModeloFincas>) controlFinca.ObtenerDatosKey(""+id_Finca)).get(0);
            
            txtDescripcion.setText(""+modelo.getDescripcion());
            txtDireccion.setText(""+modelo.getDireccion());
            txtAreaT.setText(""+modelo.getAreat());
            lblIdPropietario.setText(""+modelo.getId_propietario());
            txtPropietarios.setText(""+modelo.getPropietario()); 
            cbTipoMoneda.setSelectedIndex(Integer.parseInt(modelo.getIdTipoMoneda()));
            
//            ListamodeloBloques = (ArrayList<ModeloBloques>) controlFinca.ObtenerBloquesxFinca(""+id_Finca);
//            ListamodeloLotes = (ArrayList<ModeloLotes>) controlFinca.ObtenerLotesxFinca(""+id_Finca);
//            
//            for(int i =0; i < ListamodeloBloques.size(); i++){
//                agregarFilaTabla(modeloTblBloques, 
//                        new Object[]{
//                            tbl_Bloques.getRowCount()+1,
//                            ListamodeloBloques.get(i).getNumero(),
//                            Utilidades.MascaraMonedaConDecimales(ListamodeloBloques.get(i).getArea()),
//                            "Modificar",
//                            "Eliminar"
//                        });
//            }
//            for(int i =0; i < ListamodeloLotes.size(); i++){
//                agregarFilaTabla(modeloTblLotes, 
//                        new Object[]{
//                            tbl_Lotes.getRowCount()+1,
//                            "Bloque "+ListamodeloLotes.get(i).getId_bloque(),
//                            ListamodeloLotes.get(i).getNumero(),
//                            Utilidades.MascaraMonedaConDecimales(ListamodeloLotes.get(i).getArea()),
//                            "Modificar",
//                            "Eliminar"
//                        });
//            }
            
        }else if(objeto.getOpcion() == 1){// PROPIETARIOS
            lblIdPropietario.setText(""+retorno.get("ID"));
            txtPropietarios.setText(""+retorno.get("PROPIETARIO"));
        }
    }
    //</editor-fold>
    
    public void RetornoVistaGeneral(ModeloVentanaGeneral objeto, Object retorno) {
        
        if(objeto.getOpcion() == 1){// VISTA BLOQUES
            modeloBloques = (ModeloBloques) retorno;
            if(objeto.getFila() > -1){//ESTA EN TABLA ACTUALIZAR
                ListamodeloBloques.set(objeto.getFila(), modeloBloques);
                tbl_Bloques.setValueAt(modeloBloques.getNumero(), objeto.getFila(), 1);
                tbl_Bloques.setValueAt(modeloBloques.getArea(), objeto.getFila(), 2);
//                Lista_Seleccionados.get(listadoOficinas.get(fila)[0])[3] = area;
                
                
            }else{  
                ListamodeloBloques.add(modeloBloques);
                agregarFilaTabla(modeloTblBloques,
                        new Object[]{
                            tbl_Bloques.getRowCount()+1,
                            modeloBloques.getNumero(),
                            Utilidades.MascaraMonedaConDecimales(modeloBloques.getArea()),
                            "Modificar",
                            "Eliminar"
                        });
            }
            
        }else if(objeto.getOpcion() == 2){// VISTA PROPIETARIOS
            modeloPropietarios = (ModeloPropietarios) retorno;
            
            lblIdPropietario.setText(""+modeloPropietarios.getId());
            txtPropietarios.setText(""+modeloPropietarios.getPrimer_nombre()+
                                    (modeloPropietarios.getSegundo_nombre().equals("")?"":" "+modeloPropietarios.getSegundo_nombre())+
                                    " "+modeloPropietarios.getPrimer_apellido()+
                                    (modeloPropietarios.getSegundo_apellido().equals("")?"":" "+modeloPropietarios.getSegundo_apellido()));
            
        }else if(objeto.getOpcion() == 3){// VISTA LOTES
            modeloLotes = (ModeloLotes) retorno;
            //No, BLOQUE, NUMERO, AREA, MOD, ELI
            if(objeto.getFila() > -1){//ESTA EN TABLA ACTUALIZAR
                ListamodeloLotes.set(objeto.getFila(), modeloLotes);
                tbl_Lotes.setValueAt("Bloque "+modeloLotes.getId_bloque(), objeto.getFila(), 1);
                tbl_Lotes.setValueAt(modeloLotes.getNumero(), objeto.getFila(), 2);
                tbl_Lotes.setValueAt(modeloLotes.getArea(), objeto.getFila(), 3);
                
                
            }else{  
                ListamodeloLotes.add(modeloLotes);
                agregarFilaTabla(modeloTblLotes,
                        new Object[]{
                            tbl_Lotes.getRowCount()+1,
                            "Bloque "+modeloLotes.getId_bloque(),
                            modeloLotes.getNumero(),
                            Utilidades.MascaraMonedaConDecimales(modeloLotes.getArea()),
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
    
    public void FincasEstadoFomulario(int opc){
        FincasEstadoBotones(opc);
        switch (opc) {
            case 0: {//DESCARTAR
                txtDescripcion.setText("");
                txtDireccion.setText("");
                txtAreaT.setText("");
                id_Finca = 0;
                banBQDPropietarios = 0;
                banBQD = 0;
                estadog = "0";
                lblIdPropietario.setText("");
                txtPropietarios.setText("");
                txtDescripcion.requestFocusInWindow();
                modelo = new ModeloFincas();
                cbTipoMoneda.setSelectedIndex(0);
                txtDescripcion.setEnabled(true);
                txtDireccion.setEnabled(true);
                txtAreaT.setEnabled(true);
                
                break;
            }
            case 1: {//NUEVO
                
                break;
            }
            case 2: {//MODIFICAR
                txtDescripcion.setEnabled(true);
                txtDireccion.setEnabled(true);
                txtAreaT.setEnabled(true);
                lblBsqPropietarios.setEnabled(true);
                btnAgregarPropietario.setEnabled(true);
                
                break;
            }
            case 3: {//CONSULTADO
                txtDescripcion.setEnabled(false);
                txtDireccion.setEnabled(false);
                txtAreaT.setEnabled(false);
                lblBsqPropietarios.setEnabled(false);
                btnAgregarPropietario.setEnabled(false);
                break;
            }
        } 
    }
    
    private void cargarComboMoneda() {
        System.out.println("********cargarComboMoneda*******");
        Tipo_moneda = controlGral.GetComboBox("SELECT '-1' AS ID, 'Seleccionar' AS DESCRIPCION\n"+
                                                "UNION\n" +
                                                "SELECT id AS ID, CONCAT(descripcion, ' (', iniciales,')') AS DESCRIPCION\n" +
                                                "FROM `tipo_moneda`\n" +
                                                "WHERE estado = 'Activo'\n" +
                                                "ORDER BY id ASC");
        System.out.println("tipo moneda-->"+Tipo_moneda.size());
        Utilidades.LlenarComboBox(cbTipoMoneda, Tipo_moneda, "DESCRIPCION");
        cbTipoMoneda.setSelectedIndex(1);
    }

    public void FincasEstadoBotones(int opc) { 
        switch (opc) {
            case 0: {//DESCARTAR         
                btnGuardar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnDescartar.setEnabled(true);
                btnEliminar.setEnabled(false);
                btnConsultar.setEnabled(true);
                break;
            }
            case 1: {//NUEVO
                btnGuardar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnDescartar.setEnabled(true);
                btnEliminar.setEnabled(false);
                btnConsultar.setEnabled(false);
                break;
            }
            case 2: {//MODIFICAR
                btnGuardar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnDescartar.setEnabled(true);
                btnEliminar.setEnabled(false);
                btnConsultar.setEnabled(false);
                break;
            }
            case 3: {//CONSULTADO
                btnGuardar.setEnabled(false);
                btnModificar.setEnabled(true);
                btnDescartar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnConsultar.setEnabled(false);
                break;
            }
        }
    }

    private void agregarFilaTabla(DefaultTableModel modelotbl, Object[] fila) {
        modelotbl.addRow(fila);
    }
}
