/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visao.notificacoes.notificar;

import util.elementos.PainelGradienteNotificar;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JDialog;
import visao.notificacoes.AcaodeDialogo;
/**
 *
 * @cleber Pichau
 */
public final class NotificaErro extends javax.swing.JDialog {

    public NotificaErro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarPainel(); //configurar apos inicializar
        centralizar();
        
        //Alteração de texto:
        AcaodeDialogo.alterarMensagem(txtAvisoErro, "ERRO: Campo obrigatorio não preenchido!");
    }
    
    public void configurarPainel(){ 
        //Configurar o painel:
        ((PainelGradienteNotificar)jpnPrincipalErro).setTipoNotificacao("erro");
                
        //DEIXAR QUE FIQUE OPACO.
        jpnBotaoErro.setOpaque(false);
        jpnBotaoErro.setBackground(new java.awt.Color(0,0,0,0));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnPrincipalErro = new util.elementos.PainelGradienteNotificar();
        jLabel1 = new javax.swing.JLabel();
        txtAvisoErro = new javax.swing.JTextPane();
        jpnBotaoErro = new javax.swing.JPanel();
        btnOkErro = new util.elementos.BotaoPrincipal();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/fechar_ico.png"))); // NOI18N

        txtAvisoErro.setEditable(false);
        txtAvisoErro.setBackground(new java.awt.Color(255, 255, 255));
        txtAvisoErro.setBorder(null);
        txtAvisoErro.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        txtAvisoErro.setForeground(new java.awt.Color(51, 51, 51));
        txtAvisoErro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAvisoErro.setDoubleBuffered(true);
        txtAvisoErro.setDragEnabled(true);
        txtAvisoErro.setFocusTraversalPolicyProvider(true);
        txtAvisoErro.setFocusable(false);
        txtAvisoErro.setInheritsPopupMenu(true);
        txtAvisoErro.setRequestFocusEnabled(false);

        jpnBotaoErro.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jpnBotaoErroAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnOkErro.setBackground(new java.awt.Color(204, 204, 204));
        btnOkErro.setText("OK");
        btnOkErro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkErroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnBotaoErroLayout = new javax.swing.GroupLayout(jpnBotaoErro);
        jpnBotaoErro.setLayout(jpnBotaoErroLayout);
        jpnBotaoErroLayout.setHorizontalGroup(
            jpnBotaoErroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBotaoErroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOkErro, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jpnBotaoErroLayout.setVerticalGroup(
            jpnBotaoErroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBotaoErroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOkErro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnPrincipalErroLayout = new javax.swing.GroupLayout(jpnPrincipalErro);
        jpnPrincipalErro.setLayout(jpnPrincipalErroLayout);
        jpnPrincipalErroLayout.setHorizontalGroup(
            jpnPrincipalErroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPrincipalErroLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtAvisoErro, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnPrincipalErroLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jpnBotaoErro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnPrincipalErroLayout.setVerticalGroup(
            jpnPrincipalErroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPrincipalErroLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jpnPrincipalErroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPrincipalErroLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addComponent(txtAvisoErro))
                .addGap(18, 18, 18)
                .addComponent(jpnBotaoErro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jpnPrincipalErro, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkErroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkErroActionPerformed
        dispose();
    }//GEN-LAST:event_btnOkErroActionPerformed

    private void jpnBotaoErroAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jpnBotaoErroAncestorAdded
    }//GEN-LAST:event_jpnBotaoErroAncestorAdded

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
            java.util.logging.Logger.getLogger(NotificaErro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificaErro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificaErro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificaErro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotificaErro dialog = new NotificaErro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.elementos.BotaoPrincipal btnOkErro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpnBotaoErro;
    private javax.swing.JPanel jpnPrincipalErro;
    private javax.swing.JTextPane txtAvisoErro;
    // End of variables declaration//GEN-END:variables
     
    private void centralizar(){
        //Configurar o texto:
        
        //DEIXAR QUE FIQUE OPACO.
        txtAvisoErro.setOpaque(false);
        txtAvisoErro.setBackground(new java.awt.Color(0,0,0,0));
        
        //METODO PARA FAZER A CENTRALIZAÇÃO DAS LENTRAS MANUALMENTE
        StyledDocument doc = txtAvisoErro.getStyledDocument();
        SimpleAttributeSet centro = new SimpleAttributeSet();
        
        StyleConstants.setAlignment(centro, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), centro, false);
        
    }
    
}

