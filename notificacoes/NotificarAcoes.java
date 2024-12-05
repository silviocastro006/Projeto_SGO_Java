/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao.notificacoes;

import visao.notificacoes.notificar.*;
/**
 *
 * @author Pichau
 */

public class NotificarAcoes extends javax.swing.JFrame {

    /**
     * Creates new form NotificarAcoes
     */
    public NotificarAcoes() {
        initComponents();
        Abrirnotificar();
    }
    
    //Cria uma lista com os dialogs para os puxar.
    private void Abrirnotificar(){
        
        btnErro.addActionListener(e -> {
           NotificaErro erroDialogo = new NotificaErro(this, true);
           erroDialogo.setVisible(true);
        });

        btnSucesso.addActionListener(e -> {
           NotificaSucesso sucessoDialogo = new NotificaSucesso(this, true);
           sucessoDialogo.setVisible(true);
        });

        btnErro.addActionListener(e -> {
           NotificaExclusao exclusaoDialogo = new NotificaExclusao(this, true);
           exclusaoDialogo.setVisible(true);
           
           //Espera o dialogo ser fechado e verifica
           if (!exclusaoDialogo.isVisible()){
               if (exclusaoDialogo.isConfirmado()) {
                   //mostrar sucesso para confirmar.
                   NotificaSucesso sucessoDialogo = new NotificaSucesso(this, true);
                   sucessoDialogo.setVisible(true);
                   
               } else {
                   System.out.println("Exclusão cancelada.");
               }
           }
        });
        
        btnFechar.addActionListener(e -> {
           NotificaFecharSistema fecharDialogo = new NotificaFecharSistema(this, true);
           fecharDialogo.setVisible(true);
           
           
        });


    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnErro = new javax.swing.JButton();
        btnSucesso = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnErro.setText("erro");

        btnSucesso.setText("sucesso");

        btnFechar.setText("fechar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFechar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSucesso)
                        .addComponent(btnErro)))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnErro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSucesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NotificarAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificarAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificarAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificarAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotificarAcoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnErro;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSucesso;
    // End of variables declaration//GEN-END:variables
}
