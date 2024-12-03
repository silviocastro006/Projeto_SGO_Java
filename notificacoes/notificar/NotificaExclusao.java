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
public final class NotificaExclusao extends javax.swing.JDialog {

    /**
     * Creates new form NotificaFecharSistema
     * @param parent
     * @param modal
     */
    
    public NotificaExclusao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centralizar();
        configurarPainel();
        
        //Alteração de texto:
        AcaodeDialogo.alterarMensagem(txtAvisarExclusao, "Você realmente deseja excluir esses dados?");
    }

    public void configurarPainel(){
        //Configurar o painel:
        ((PainelGradienteNotificar)jpnPrincipalExclusao).setTipoNotificacao("erro");
        
        //deixar fundo do botao opaco
        jpnBotaoExclusao.setOpaque(false);
        jpnBotaoExclusao.setBackground(new java.awt.Color(0,0,0,0));
    }
    
    private boolean confirmado = false;
    public boolean isConfirmado(){
        return confirmado;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpnPrincipalExclusao = new util.elementos.PainelGradienteNotificar();
        txtAvisarExclusao = new javax.swing.JTextPane();
        jpnBotaoExclusao = new javax.swing.JPanel();
        btnSimExclusao = new util.elementos.BotaoPrincipal();
        btnNaoExclusao = new util.elementos.BotaoPrincipal();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        txtAvisarExclusao.setEditable(false);
        txtAvisarExclusao.setBackground(new java.awt.Color(255, 255, 255));
        txtAvisarExclusao.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        txtAvisarExclusao.setDoubleBuffered(true);
        txtAvisarExclusao.setDragEnabled(true);
        txtAvisarExclusao.setFocusTraversalPolicyProvider(true);
        txtAvisarExclusao.setFocusable(false);
        txtAvisarExclusao.setInheritsPopupMenu(true);
        txtAvisarExclusao.setRequestFocusEnabled(false);

        btnSimExclusao.setBackground(new java.awt.Color(0, 153, 0));
        btnSimExclusao.setText("SIM");
        btnSimExclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimExclusaoActionPerformed(evt);
            }
        });

        btnNaoExclusao.setBackground(new java.awt.Color(204, 0, 0));
        btnNaoExclusao.setText("NÃO");
        btnNaoExclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoExclusaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnBotaoExclusaoLayout = new javax.swing.GroupLayout(jpnBotaoExclusao);
        jpnBotaoExclusao.setLayout(jpnBotaoExclusaoLayout);
        jpnBotaoExclusaoLayout.setHorizontalGroup(
            jpnBotaoExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBotaoExclusaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNaoExclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnSimExclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnBotaoExclusaoLayout.setVerticalGroup(
            jpnBotaoExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBotaoExclusaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnBotaoExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimExclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNaoExclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/fechar_ico.png"))); // NOI18N

        javax.swing.GroupLayout jpnPrincipalExclusaoLayout = new javax.swing.GroupLayout(jpnPrincipalExclusao);
        jpnPrincipalExclusao.setLayout(jpnPrincipalExclusaoLayout);
        jpnPrincipalExclusaoLayout.setHorizontalGroup(
            jpnPrincipalExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPrincipalExclusaoLayout.createSequentialGroup()
                .addGroup(jpnPrincipalExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPrincipalExclusaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtAvisarExclusao, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                    .addGroup(jpnPrincipalExclusaoLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jpnBotaoExclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnPrincipalExclusaoLayout.setVerticalGroup(
            jpnPrincipalExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPrincipalExclusaoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jpnPrincipalExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtAvisarExclusao, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jpnBotaoExclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jpnPrincipalExclusao, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnSimExclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimExclusaoActionPerformed
        confirmado = true;
        //Apenas confirma, não tem uma ação realmente programada.
        System.out.println("Dados excluidos com sucesso!");
        
        dispose();
    }//GEN-LAST:event_btnSimExclusaoActionPerformed

    private void btnNaoExclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoExclusaoActionPerformed
    dispose();

    }//GEN-LAST:event_btnNaoExclusaoActionPerformed

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
            java.util.logging.Logger.getLogger(NotificaExclusao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificaExclusao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificaExclusao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificaExclusao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotificaExclusao dialog = new NotificaExclusao(new javax.swing.JFrame(), true);
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
    private util.elementos.BotaoPrincipal btnNaoExclusao;
    private util.elementos.BotaoPrincipal btnSimExclusao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpnBotaoExclusao;
    private javax.swing.JPanel jpnPrincipalExclusao;
    private javax.swing.JTextPane txtAvisarExclusao;
    // End of variables declaration//GEN-END:variables

    private void centralizar(){
        //configurar:
        
        txtAvisarExclusao.setOpaque(false);
        txtAvisarExclusao.setBackground(new java.awt.Color(0,0,0,0));
        
        //metodo apra fazer a centralização das letras manualmente
        StyledDocument doc = txtAvisarExclusao.getStyledDocument();
        SimpleAttributeSet centro = new SimpleAttributeSet();
        
       StyleConstants.setAlignment(centro, StyleConstants.ALIGN_CENTER);
       doc.setParagraphAttributes(0, doc.getLength(), centro, false);     
    }

}
