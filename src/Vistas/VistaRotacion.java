/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import Control.*;
import Modelo.*;
import Tablas.TablaRender;
import Utilidades.Utilidades;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
public class VistaRotacion extends javax.swing.JPanel {
    public DefaultTableModel modeloTblGrupos;
    public String[] EncabezadoTblGrupos;
    public DefaultTableModel modeloTblGruposHistorico;
    public String[] EncabezadoTblGruposHistorico;
    private List<Map<String, String>>  ListaRotaciones;
    private List<Map<String, String>>  ListaGruposSeleccionados;
    private ModeloRotacionLotes modeloLotes;
    private ModeloRotacionGrupos modeloGrupos;
    public List<Map<String, String>> listaFincas;
    public ControlGeneral controlgen = new ControlGeneral();
    public ControlRotacion controlRotacion = new ControlRotacion();
    public String idFinca;
    public int allFincas;
    public ModeloVentanaGeneral objetoVentana;
    
    /**
     * Creates new form VistaRotacion
     */
    public VistaRotacion() {
        initComponents();
        modeloLotes = new ModeloRotacionLotes();
        modeloGrupos = new ModeloRotacionGrupos();
        //controlPropietario = new ControlPropietarios();
        listaFincas = new ArrayList<>();
        ListaGruposSeleccionados = new ArrayList<>();
        EncabezadoTblGrupos = new String[]{
            "No","Grupo", "Bloque / Lote", "Fecha Entrada", "Estado", "Rotar"
        };
        EncabezadoTblGruposHistorico = new String[]{
            "No","Grupo", "Bloque / Lote", "Fecha Entrada", "Fecha Salida", "Estado"
        };
        idFinca = "";
        InicializarTblGrupos();
        InicializarTblGruposHistorico();
        CargarListaFincas();
        
    }
    
    public void InicializarTblGrupos() {
        tbl_Grupos.setDefaultRenderer(Object.class, new TablaRender());
        
        modeloTblGrupos = new DefaultTableModel(EncabezadoTblGrupos, 0) {
            Class[] types = new Class[]{
                java.lang.Boolean.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
            };

            public Class getColumnClass(int col) {
                return types[col];
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tbl_Grupos.setModel(modeloTblGrupos);

        tbl_Grupos.getColumnModel().getColumn(0).setPreferredWidth(15);
        tbl_Grupos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_Grupos.getColumnModel().getColumn(2).setPreferredWidth(170);
        tbl_Grupos.getColumnModel().getColumn(3).setPreferredWidth(70);
        tbl_Grupos.getColumnModel().getColumn(4).setPreferredWidth(70);
        tbl_Grupos.getColumnModel().getColumn(5).setPreferredWidth(50);
        
        tbl_Grupos.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i < modeloTblGrupos.getColumnCount(); i++) {
            tbl_Grupos.getColumnModel().getColumn(i).setResizable(false);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setFont(new Font("Tahoma", 0, 12));
            if(i > 0){
                if(i == 2 ){
                    tcr.setHorizontalAlignment(SwingConstants.RIGHT);

                }else{
                    tcr.setHorizontalAlignment(SwingConstants.CENTER);

                }
                tcr.setForeground(new Color(26, 82, 118));
                tbl_Grupos.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
            
        }
        JTableHeader header = tbl_Grupos.getTableHeader();

        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setPreferredSize(new Dimension(0, 35));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setVerticalAlignment(JLabel.CENTER);
        
    }

    public void InicializarTblGruposHistorico() {
        tbl_GruposHistorico.setDefaultRenderer(Object.class, new TablaRender());
        
        modeloTblGruposHistorico = new DefaultTableModel(EncabezadoTblGruposHistorico, 0) {
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

        tbl_GruposHistorico.setModel(modeloTblGruposHistorico);

        tbl_GruposHistorico.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl_GruposHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_GruposHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_GruposHistorico.getColumnModel().getColumn(3).setPreferredWidth(80);
        tbl_GruposHistorico.getColumnModel().getColumn(4).setPreferredWidth(80);
        tbl_GruposHistorico.getColumnModel().getColumn(5).setPreferredWidth(80);
        
        tbl_GruposHistorico.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i < modeloTblGruposHistorico.getColumnCount(); i++) {
            tbl_GruposHistorico.getColumnModel().getColumn(i).setResizable(false);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setFont(new Font("Tahoma", 0, 12));
            
            if(i == 2 ){
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
               
            }else{
                tcr.setHorizontalAlignment(SwingConstants.CENTER);
                
            }
            tcr.setForeground(new Color(26, 82, 118));
            tbl_GruposHistorico.getColumnModel().getColumn(i).setCellRenderer(tcr);
            
        }
        JTableHeader header = tbl_GruposHistorico.getTableHeader();

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Grupos = new javax.swing.JTable();
        lblTid = new javax.swing.JLabel();
        cbFinca = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_GruposHistorico = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setForeground(new java.awt.Color(59, 123, 50));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Grupos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Grupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_GruposMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Grupos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 610, 350));

        lblTid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTid.setForeground(new java.awt.Color(59, 123, 50));
        lblTid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTid.setText("Finca");
        jPanel1.add(lblTid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        cbFinca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbFinca.setForeground(new java.awt.Color(59, 123, 50));
        cbFinca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Cédula de Ciudadania", "Cédula de Extranjeria", "Tarjeta de Identidad", "Registro Civil", "Número de Identificación Tributario", "Número Unico de Identificación", "Pasaporte" }));
        cbFinca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFincaActionPerformed(evt);
            }
        });
        jPanel1.add(cbFinca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 30));

        jTabbedPane1.addTab("Grupos", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_GruposHistorico.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_GruposHistorico);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 610, -1));

        jTabbedPane1.addTab("Historico", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbFincaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFincaActionPerformed
        System.out.println("____________________________________");
        if(cbFinca.getItemCount() > 0)
            EventoComboFincas();
    }//GEN-LAST:event_cbFincaActionPerformed

    private void tbl_GruposMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_GruposMouseReleased
        int fila = tbl_Grupos.getSelectedRow();
        int cola = tbl_Grupos.getSelectedColumn();
        System.out.println("cola-->"+cola);
        if(cola == 0){
            boolean sel = (boolean) tbl_Grupos.getValueAt(fila, cola);
            tbl_Grupos.getModel().setValueAt(!sel, fila, cola);
            if(!sel){//SELECCIONADO
                ListaGruposSeleccionados.add(ListaRotaciones.get(fila));
            }else{// NO SELECCIONADO
                int ind = getIndiceLista(ListaRotaciones.get(fila).get("IDGRUPO"));
                ListaGruposSeleccionados.remove(ind);
            }
        } else if(cola == 4){// CANCELAR
            
            int ret = JOptionPane.showConfirmDialog(this, "¿Esta Seguro en Cancelar este registro "+tbl_Grupos.getValueAt(fila, 1)+"?");
            if(ret == JOptionPane.YES_OPTION){
                int resp = controlRotacion.CancelarRegistroRotacion(ListaRotaciones.get(fila));
                if(resp == Retorno.EXITO){
                    int resp2 = controlRotacion.ActivarAnteriorRegistroRotacion(ListaRotaciones.get(fila));
                    if(resp2 == Retorno.EXITO){
                        JOptionPane.showMessageDialog(this, "La operación fue realizada con exito.");
                        EventoComboFincas();
                    }
                }
                //CancelarRegistroRotacion();
                
            }
        } else if(cola == 5){ // ROTAR
            boolean sel = (boolean) tbl_Grupos.getValueAt(fila, 0);
            if(sel){
                getGruposAsociados();
                objetoVentana = new ModeloVentanaGeneral(this, new VistaRotar(), 1, ListaGruposSeleccionados);
                System.out.println("EVENTO TABLA ListaGruposSeleccionados-->"+ListaGruposSeleccionados.size());
                objetoVentana.setFila(fila);
                new VistaGeneral(objetoVentana).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Por favor seleccione esta fila para realizar la operación.");
            }
        }
        //MOstrarListaSeleccionados();
    }//GEN-LAST:event_tbl_GruposMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox cbFinca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTid;
    private javax.swing.JTable tbl_Grupos;
    private javax.swing.JTable tbl_GruposHistorico;
    // End of variables declaration//GEN-END:variables
    
    public void RetornoVistaGeneral(ModeloVentanaGeneral objeto, Object retorno) {
        
        if(objeto.getOpcion() == 1){// VISTA ROTAR
            
            EventoComboFincas();
        }
    }
    
    
    private void CargarListaFincas() {
        listaFincas = controlgen.GetComboBox("SELECT '-1' AS ID, 'Seleccionar' AS DESCRIPCION\n" +
                                                "UNION\n" +
                                                "SELECT `id` AS ID, `descripcion` AS DESCRIPCION\n" +
                                                "FROM `fincas`\n"+
                                                "UNION \n"+
                                                "SELECT 'ALL' AS ID, 'TODOS' AS DESCRIPCION");
         
        Utilidades.LlenarComboBox(cbFinca, listaFincas, "DESCRIPCION");
        cbFinca.setSelectedIndex(1);
        EventoComboFincas();
    }
    public void EventoComboFincas(){
        
        ListaGruposSeleccionados = new ArrayList<>();
        if(cbFinca.getSelectedIndex() >= 0){
            idFinca = listaFincas.get(cbFinca.getSelectedIndex()).get("ID");
            if(idFinca.equals("ALL")){   
                allFincas = 1; 
            }else{
                allFincas = 0;
            }
            if(Integer.parseInt(idFinca)>0){
                ListaRotaciones = controlRotacion.ObtenerRotacion(""+idFinca);
                Utilidades.LimpiarTabla(tbl_Grupos);
                for(int i =0; i < ListaRotaciones.size(); i++){
                    Utilidades.agregarFilaTabla(
                            modeloTblGrupos, 
                            new Object[]{
                                false,//tbl_Grupos.getRowCount()+1,
                                ListaRotaciones.get(i).get("GRUPO"),
                                (allFincas == 1?ListaRotaciones.get(i).get("FINCA")+" / ":"") + 
                                ListaRotaciones.get(i).get("BLOQUE") + " / " + ListaRotaciones.get(i).get("LOTE"),
                                ListaRotaciones.get(i).get("FECHA_IN"), 
                                ListaRotaciones.get(i).get("ESTADO"), 
                                "Rotar" 
                            } 
                        );
                }
            }

        }else{
            Utilidades.LimpiarTabla(tbl_Grupos);
        }
    }

    private int getIndiceLista(String Dato) {
        for(int i = 0; i < ListaGruposSeleccionados.size(); i++){
            if(ListaGruposSeleccionados.get(i).get("IDGRUPO").equals(Dato)){
                return i;
            }
        }
        return -1;
    }

    private void MOstrarListaSeleccionados() {
        for(int i = 0; i < ListaGruposSeleccionados.size(); i++){
            System.out.println("i-->"+i);
            for (Map.Entry<String, String> entry : ListaGruposSeleccionados.get(i).entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println("key: "+key);
                System.out.println("value: "+value);
            }
            System.out.println("*****************END i*********************");
        }
    }

    private void getGruposAsociados() {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        System.out.println("******************getGruposAsociados*****************"+ListaGruposSeleccionados.size());
        boolean encontro = false;
        for(int j = 0; j < ListaRotaciones.size(); j++){
            for(int i = 0; i < ListaGruposSeleccionados.size(); i++){
                if(ListaGruposSeleccionados.get(i).get("IDGRUPO").equals(ListaRotaciones.get(j).get("IDGRUPO")) && 
                   ListaGruposSeleccionados.get(i).get("IDLOTE").equals(ListaRotaciones.get(j).get("IDLOTE"))){
                   encontro = true;
                   break;
                }
            }
            if(!encontro){
                indices.add(j);
            }
        }
        System.out.println("indices--->"+indices.size());
        for(int i = 0 ; i < indices.size(); i++){
            ListaGruposSeleccionados.add(ListaRotaciones.get(indices.get(i)));
        }
        System.out.println("ListaGruposSeleccionados.size()--->"+ListaGruposSeleccionados.size());
        System.out.println("****************END getGruposAsociados****************");
    }
    
    
}
