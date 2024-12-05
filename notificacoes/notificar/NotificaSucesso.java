/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visao.notificacoes.notificar;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import util.elementos.PainelGradienteNotificar;
import visao.notificacoes.AcaodeDialogo;

/**
 *
 * @author Pichau
 */
public final class NotificaSucesso extends javax.swing.JDialog {

    /**
     * Creates new form NotificaFecharSistema
     * @param parent
     * @param modal
     */
    public NotificaSucesso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
        centralizar();
        configurarPainel();
        
        //Alteração de texto:
        AcaodeDialogo.alterarMensagem(txtNotificaSucesso, "Ação realizada com sucesso!");
    }

    public void configurarPainel(){
        //Configurar o painel:
        ((PainelGradienteNotificar)jpnPrincipalSucesso).setTipoNotificacao("sucesso");
        
        //deixar fundo do botao opaco
        jpnBotaoSucesso.setOpaque(false);
        jpnBotaoSucesso.setBackground(new java.awt.Color(0,0,0,0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnPrincipalSucesso = new util.elementos.PainelGradienteNotificar();
        txtNotificaSucesso = new javax.swing.JTextPane();
        jpnBotaoSucesso = new javax.swing.JPanel();
        btnOkSucesso = new util.elementos.BotaoPrincipal();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpnPrincipalSucesso.setBackground(new java.awt.Color(204, 204, 204));

        txtNotificaSucesso.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        txtNotificaSucesso.setDoubleBuffered(true);
        txtNotificaSucesso.setDragEnabled(true);
        txtNotificaSucesso.setFocusTraversalPolicyProvider(true);
        txtNotificaSucesso.setFocusable(false);
        txtNotificaSucesso.setInheritsPopupMenu(true);
        txtNotificaSucesso.setRequestFocusEnabled(false);

        jpnBotaoSucesso.setBackground(new java.awt.Color(153, 153, 153));

        btnOkSucesso.setBackground(new java.awt.Color(204, 204, 204));
        btnOkSucesso.setText("OK");
        btnOkSucesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkSucessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnBotaoSucessoLayout = new javax.swing.GroupLayout(jpnBotaoSucesso);
        jpnBotaoSucesso.setLayout(jpnBotaoSucessoLayout);
        jpnBotaoSucessoLayout.setHorizontalGroup(
            jpnBotaoSucessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBotaoSucessoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOkSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnBotaoSucessoLayout.setVerticalGroup(
            jpnBotaoSucessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBotaoSucessoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOkSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/fechar_ico.png"))); // NOI18N

        javax.swing.GroupLayout jpnPrincipalSucessoLayout = new javax.swing.GroupLayout(jpnPrincipalSucesso);
        jpnPrincipalSucesso.setLayout(jpnPrincipalSucessoLayout);
        jpnPrincipalSucessoLayout.setHorizontalGroup(
            jpnPrincipalSucessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPrincipalSucessoLayout.createSequentialGroup()
                .addGroup(jpnPrincipalSucessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPrincipalSucessoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNotificaSucesso, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                    .addGroup(jpnPrincipalSucessoLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jpnBotaoSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnPrincipalSucessoLayout.setVerticalGroup(
            jpnPrincipalSucessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPrincipalSucessoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpnPrincipalSucessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNotificaSucesso, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jpnBotaoSucesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jpnPrincipalSucesso, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkSucessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkSucessoActionPerformed
        dispose();
    }//GEN-LAST:event_btnOkSucessoActionPerformed

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
            java.util.logging.Logger.getLogger(NotificaSucesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificaSucesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificaSucesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificaSucesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotificaSucesso dialog = new NotificaSucesso(new javax.swing.JFrame(), true);
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
    private util.elementos.BotaoPrincipal btnOkSucesso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpnBotaoSucesso;
    private javax.swing.JPanel jpnPrincipalSucesso;
    private javax.swing.JTextPane txtNotificaSucesso;
    // End of variables declaration//GEN-END:variables

        private void centralizar(){
        //configurar:
        
        txtNotificaSucesso.setOpaque(false);
        txtNotificaSucesso.setBackground(new java.awt.Color(0,0,0,0));
        
        //metodo apra fazer a centralização das letras manualmente
        StyledDocument doc = txtNotificaSucesso.getStyledDocument();
        SimpleAttributeSet centro = new SimpleAttributeSet();
        
       StyleConstants.setAlignment(centro, StyleConstants.ALIGN_CENTER);
       doc.setParagraphAttributes(0, doc.getLength(), centro, false);     
    }

}
