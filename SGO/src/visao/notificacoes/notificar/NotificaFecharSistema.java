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
public final class NotificaFecharSistema extends javax.swing.JDialog {

    /**
     * Creates new form NotificaFecharSistema
     * @param parent
     * @param modal
     */
    public NotificaFecharSistema(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarPainel(); //configurar apos inicializar
        centralizar();
        
        //Alteração de texto:
        AcaodeDialogo.alterarMensagem(txtAvisoFSistema, "Você deve preencher para completar a tabela!");
    }
    
    public void configurarPainel(){
        //Configurar o painel:
        ((PainelGradienteNotificar)jpnPrincipalFSistema).setTipoNotificacao("");
        
        //deixar o  fundo do botao opaco.
        jpnBotaoFSistema.setOpaque(false);
        jpnBotaoFSistema.setBackground(new java.awt.Color(0,0,0,0));
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnPrincipalFSistema = new util.elementos.PainelGradienteNotificar();
        txtAvisoFSistema = new javax.swing.JTextPane();
        jpnBotaoFSistema = new javax.swing.JPanel();
        btnNaoFSistema = new util.elementos.BotaoPrincipal();
        tbnSimFSistema = new util.elementos.BotaoPrincipal();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtAvisoFSistema.setEditable(false);
        txtAvisoFSistema.setBackground(new java.awt.Color(255, 255, 255));
        txtAvisoFSistema.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        txtAvisoFSistema.setDoubleBuffered(true);
        txtAvisoFSistema.setDragEnabled(true);
        txtAvisoFSistema.setFocusTraversalPolicyProvider(true);
        txtAvisoFSistema.setFocusable(false);
        txtAvisoFSistema.setInheritsPopupMenu(true);
        txtAvisoFSistema.setRequestFocusEnabled(false);

        btnNaoFSistema.setBackground(new java.awt.Color(204, 0, 0));
        btnNaoFSistema.setText("NÃO");
        btnNaoFSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoFSistemaActionPerformed(evt);
            }
        });

        tbnSimFSistema.setBackground(new java.awt.Color(0, 153, 0));
        tbnSimFSistema.setText("SIM");
        tbnSimFSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSimFSistemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnBotaoFSistemaLayout = new javax.swing.GroupLayout(jpnBotaoFSistema);
        jpnBotaoFSistema.setLayout(jpnBotaoFSistemaLayout);
        jpnBotaoFSistemaLayout.setHorizontalGroup(
            jpnBotaoFSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBotaoFSistemaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNaoFSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(tbnSimFSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnBotaoFSistemaLayout.setVerticalGroup(
            jpnBotaoFSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBotaoFSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnBotaoFSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnSimFSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNaoFSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/fechar_ico.png"))); // NOI18N

        javax.swing.GroupLayout jpnPrincipalFSistemaLayout = new javax.swing.GroupLayout(jpnPrincipalFSistema);
        jpnPrincipalFSistema.setLayout(jpnPrincipalFSistemaLayout);
        jpnPrincipalFSistemaLayout.setHorizontalGroup(
            jpnPrincipalFSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPrincipalFSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtAvisoFSistema)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPrincipalFSistemaLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jpnBotaoFSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jpnPrincipalFSistemaLayout.setVerticalGroup(
            jpnPrincipalFSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPrincipalFSistemaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jpnPrincipalFSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtAvisoFSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jpnBotaoFSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jpnPrincipalFSistema, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNaoFSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoFSistemaActionPerformed

        dispose();
    }//GEN-LAST:event_btnNaoFSistemaActionPerformed

    private void tbnSimFSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSimFSistemaActionPerformed
        
        this.dispose();
        NotificaSucesso sucessoDialogo = new NotificaSucesso((java.awt.Frame)this.getParent(), true);
        sucessoDialogo.setVisible(true);
    }//GEN-LAST:event_tbnSimFSistemaActionPerformed

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
            java.util.logging.Logger.getLogger(NotificaFecharSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificaFecharSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificaFecharSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificaFecharSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            NotificaFecharSistema dialog = new NotificaFecharSistema(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.elementos.BotaoPrincipal btnNaoFSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpnBotaoFSistema;
    private javax.swing.JPanel jpnPrincipalFSistema;
    private util.elementos.BotaoPrincipal tbnSimFSistema;
    private javax.swing.JTextPane txtAvisoFSistema;
    // End of variables declaration//GEN-END:variables

   private void centralizar(){
       //Configurar o texto:
       
       //Deixar que fique opaco.
       txtAvisoFSistema.setOpaque(false);
       txtAvisoFSistema.setBackground(new java.awt.Color(0,0,0,0));
       
       //Metodo para fazer a centralização das letras manualmente.
       StyledDocument doc = txtAvisoFSistema.getStyledDocument();
       SimpleAttributeSet centro = new SimpleAttributeSet();
       
       StyleConstants.setAlignment(centro, StyleConstants.ALIGN_CENTER);
       doc.setParagraphAttributes(0, doc.getLength(), centro, false);
   }

}
