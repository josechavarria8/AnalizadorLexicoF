
package Frontend;

import javax.swing.JTextArea;

/**
 *
 * @author blue
 */
public class resultadoBusqueda extends javax.swing.JPanel {

    
    public resultadoBusqueda() {
        
        initComponents();       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBusqueda = new javax.swing.JTextArea();

        setOpaque(false);

        jLblTitulo.setFont(new java.awt.Font("Corbel Light", 1, 16)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(20, 10, 10));
        jLblTitulo.setText("Búsqueda");
        jLblTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTextAreaBusqueda.setColumns(20);
        jTextAreaBusqueda.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAreaBusqueda.setRows(5);
        jTextAreaBusqueda.setOpaque(false);
        jScrollPane1.setViewportView(jTextAreaBusqueda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                        .addGap(101, 101, 101))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public JTextArea getjTextAreaBusqueda() {
        return jTextAreaBusqueda;
    }

    public void setjTextAreaBusqueda(JTextArea jTextAreaBusqueda) {
        this.jTextAreaBusqueda = jTextAreaBusqueda;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaBusqueda;
    // End of variables declaration//GEN-END:variables

}
