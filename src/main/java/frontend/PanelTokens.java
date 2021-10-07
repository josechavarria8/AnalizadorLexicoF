/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import funcionalidad.Analizador;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import elementos.*;

/**
 *
 * @author CIROSS
 */
public class PanelTokens extends javax.swing.JPanel {

    private ArrayList<Token> listaTokens;
    private ArrayList<Lexema> listaLexemas;
    Analizador al = new Analizador();
    Lexema lexema;
    
    DefaultTableModel modeloTablaToken = new DefaultTableModel();
    DefaultTableModel modeloTablaLexema = new DefaultTableModel();
    
    public PanelTokens(ArrayList<Token> listaTokens) {
        initComponents();
        inicializarTablas();
        this.listaTokens = listaTokens;
        llenarTablaTokens();
        
        this.lexema = new Lexema(this.listaTokens);
        this.listaLexemas = lexema.getListaLexemas();
        llenarTablaLexemas();
        
        jTextAreaTransiciones.append(al.getTransiciones());
    }
    
    public void llenarTablaTokens() {

        for (int i = 0; i < this.listaTokens.size(); i++) {
            modeloTablaToken.addRow(listaTokens.get(i).getArray());
        }       
    }
    
    public void llenarTablaLexemas() {

        for (int i = 0; i < this.listaLexemas.size(); i++) {
            modeloTablaLexema.addRow(listaLexemas.get(i).getArray());
        }       
    }

    public void inicializarTablas() {
        
        modeloTablaToken.addColumn("Token");
        modeloTablaToken.addColumn("Lexema");
        modeloTablaToken.addColumn("Fila");
        modeloTablaToken.addColumn("Columna");

        this.jTableTokens.setModel(modeloTablaToken);

        modeloTablaLexema.addColumn("Lexema");
        modeloTablaLexema.addColumn("Token");
        modeloTablaLexema.addColumn("Cantidad de veces");
        
        this.jTableLexemas.setModel(modeloTablaLexema);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelToken = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTokens = new javax.swing.JTable();
        jPanelLexema = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLexemas = new javax.swing.JTable();
        jPanelTransiciones = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaTransiciones = new javax.swing.JTextArea();
        jLblTitulo = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(470, 615));

        jPanelToken.setLayout(new java.awt.GridLayout(1, 0));

        jTableTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "Fila", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableTokens);

        jPanelToken.add(jScrollPane1);

        jTabbedPane1.addTab("Tokens", jPanelToken);

        jPanelLexema.setLayout(new java.awt.GridLayout(1, 0));

        jTableLexemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Token", "Cantidad de veces"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLexemas.setOpaque(false);
        jScrollPane2.setViewportView(jTableLexemas);

        jPanelLexema.add(jScrollPane2);

        jTabbedPane1.addTab("Lexemas", jPanelLexema);

        jPanelTransiciones.setLayout(new java.awt.GridLayout(1, 0));

        jTextAreaTransiciones.setEditable(false);
        jTextAreaTransiciones.setColumns(20);
        jTextAreaTransiciones.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jTextAreaTransiciones.setRows(5);
        jScrollPane3.setViewportView(jTextAreaTransiciones);

        jPanelTransiciones.add(jScrollPane3);

        jTabbedPane1.addTab("Transiciones", jPanelTransiciones);

        jLblTitulo.setFont(new java.awt.Font("Corbel Light", 1, 16)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLblTitulo.setText("Salida de Resultados");
        jLblTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanelLexema;
    private javax.swing.JPanel jPanelToken;
    private javax.swing.JPanel jPanelTransiciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableLexemas;
    private javax.swing.JTable jTableTokens;
    private javax.swing.JTextArea jTextAreaTransiciones;
    // End of variables declaration//GEN-END:variables
}
