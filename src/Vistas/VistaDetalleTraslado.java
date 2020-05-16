/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import Control.ControlAnimales;
import Modelo.ModeloVentanaGeneral;
import Tablas.TablaRender;
import Utilidades.Utilidades;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author MERRY
 */
public class VistaDetalleTraslado extends javax.swing.JPanel {
    String id_Animal = "";
    String numero_Animal = "";
    private ControlAnimales controlAnimales = new ControlAnimales();
    private List<Map<String, String>> ListaDatos;
    public DefaultTableModel modeloTblTraslado;
    public String[] EncabezadoTblTraslado;
    private int ancho;
    private int alto;
    /**
     * Creates new form VistaDetalleGrupos
     */
    public VistaDetalleTraslado() {
        initComponents();
        setSize(781 ,522);
    }
    
    public VistaDetalleTraslado(ModeloVentanaGeneral modeloVentanaGeneral) {
        initComponents();
        setSize(781 ,522);
        id_Animal = ""+modeloVentanaGeneral.getModeloDatos();
        ListaDatos = new ArrayList<>();
        EncabezadoTblTraslado = new String[]{
            "No",
             "Grupo", 
             "<html><p style=\"text-align:center;\">Fecha</p><p style=\"text-align:center;\">Traslado</p></html>", 
             "Motivo", 
             "Estado"
        };
        InicializarTblAnimales();
        GetDatosTrasladoAnimal();   
    }

    public void InicializarTblAnimales() {
        tbl_Traslados.setDefaultRenderer(Object.class, new TablaRender());
        
        modeloTblTraslado = new DefaultTableModel(EncabezadoTblTraslado, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int col) {
                return types[col];
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tbl_Traslados.setModel(modeloTblTraslado);

        tbl_Traslados.getColumnModel().getColumn(0).setPreferredWidth(25);
        tbl_Traslados.getColumnModel().getColumn(1).setPreferredWidth(70);
        tbl_Traslados.getColumnModel().getColumn(2).setPreferredWidth(70);
        tbl_Traslados.getColumnModel().getColumn(3).setPreferredWidth(70);
        tbl_Traslados.getColumnModel().getColumn(4).setPreferredWidth(70);
        tbl_Traslados.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i < modeloTblTraslado.getColumnCount(); i++) {
            tbl_Traslados.getColumnModel().getColumn(i).setResizable(false);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setFont(new Font("Tahoma", 0, 12));
            if(i > 0){
//                if(i == 2 ){
//                    tcr.setHorizontalAlignment(SwingConstants.RIGHT);
//
//                }else{
                    tcr.setHorizontalAlignment(SwingConstants.CENTER);

//                }
                tcr.setForeground(new Color(26, 82, 118));
                tbl_Traslados.getColumnModel().getColumn(i).setCellRenderer(tcr);
            }
            
        }
        JTableHeader header = tbl_Traslados.getTableHeader();

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
        tbl_Traslados = new javax.swing.JTable();
        lblNumeroAnimal = new javax.swing.JLabel();
        lblTid1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 123, 50)));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Traslados.setForeground(new java.awt.Color(59, 123, 50));
        tbl_Traslados.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Traslados.setSelectionBackground(new java.awt.Color(59, 123, 50));
        jScrollPane1.setViewportView(tbl_Traslados);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 740, 430));

        lblNumeroAnimal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumeroAnimal.setForeground(new java.awt.Color(59, 123, 50));
        lblNumeroAnimal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNumeroAnimal.setText("Animal Número: ");
        add(lblNumeroAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 150, -1));

        lblTid1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTid1.setForeground(new java.awt.Color(59, 123, 50));
        lblTid1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTid1.setText("Historico Traslado");
        add(lblTid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        ancho = this.getWidth();
        alto = this.getHeight();
    }//GEN-LAST:event_formComponentResized


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumeroAnimal;
    private javax.swing.JLabel lblTid1;
    private javax.swing.JTable tbl_Traslados;
    // End of variables declaration//GEN-END:variables

    private void GetDatosTrasladoAnimal() {
        ListaDatos = controlAnimales.GetDatosTraslado(id_Animal); 
        
        numero_Animal = ListaDatos.get(0).get("NUMERO_ANIMAL");
        LlenarTabla();
    }

    private void LlenarTabla() {
        Utilidades.LimpiarTabla(tbl_Traslados);
//        SELECT anim.`numero` AS NUMERO_ANIMAL, grup.`descripcion` AS GRUPO,
//DATE_FORMAT(traslado.`fecha_traslado`, '%d/%m/%Y') AS FECHA_TRASLADO,
//traslado.motivo AS MOTIVO, traslado.estado AS ESTADO
        for(int i =0; i < ListaDatos.size(); i++){ 
            Utilidades.agregarFilaTabla( 
                    modeloTblTraslado,  
                    new Object[]{
                        (i+1),//tbl_Grupos.getRowCount()+1,
                        ListaDatos.get(i).get("GRUPO"),
                        ListaDatos.get(i).get("FECHA_TRASLADO"),
                        ListaDatos.get(i).get("MOTIVO"), 
                        ListaDatos.get(i).get("ESTADO")
                    } 
                );
        }
    }
    
    
}