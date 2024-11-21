/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author acer
 */
public class TesteMain extends javax.swing.JFrame {

    public DrawerController drawer;
    
    
    // Criação dos itens para o painel
    DrawerItem dashboard_item = new DrawerItem("Dashboard");
    DrawerItem usuario_item = new DrawerItem("Usuários");
    DrawerItem cliente_item = new DrawerItem("Clientes");
    DrawerItem visita_item = new DrawerItem("Visitas");
    DrawerItem orcamento_item = new DrawerItem("Orçamentos");
    
    
    public TesteMain() {
        setUndecorated(true); // Remover a barra de título
        initComponents();
        btnFechar.setBackground(new Color(255, 255, 255, 0));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null); // Mantém a janela centralizada
        setAlwaysOnTop(true); // (Opcional) Coloca a janela sempre no topo

        // Inserindo o icone para cada um
        dashboard_item.icon(new ImageIcon(getClass().getResource("/icones/dashboard_azul.png"))).build();
        usuario_item.icon(new ImageIcon(getClass().getResource("/icones/usuarios_azul.png"))).build();
        cliente_item.icon(new ImageIcon(getClass().getResource("/icones/clientes_azul.png"))).build();
        visita_item.icon(new ImageIcon(getClass().getResource("/icones/visitas_azul.png"))).build();
        orcamento_item.icon(new ImageIcon(getClass().getResource("/icones/orcamentos_azul.png"))).build();
        
        
        // Adicionando o MouseListener para cada item
        addMouseListenerToDrawerItem(dashboard_item);
        addMouseListenerToDrawerItem(usuario_item);
        addMouseListenerToDrawerItem(cliente_item);
        addMouseListenerToDrawerItem(visita_item);
        addMouseListenerToDrawerItem(orcamento_item);
        
        
        // Editando a fonte para cada item
        
        Font fonte_label = new Font("openSans-Regular", Font.PLAIN, 20);
        dashboard_item.setFont(fonte_label);
        usuario_item.setFont(fonte_label);
        cliente_item.setFont(fonte_label);
        visita_item.setFont(fonte_label);
        orcamento_item.setFont(fonte_label);
        
        
                
        drawer = Drawer.newDrawer(this)
                .header(new Header())
                .separator(20, new Color(255,255,255))
                .addChild(dashboard_item)
                .addChild(usuario_item)
                .addChild(cliente_item)
                .addChild(visita_item)
                .addChild(orcamento_item)
                .itemHeight(70)
                .addFooter(new DrawerItem("Sair").icon(new ImageIcon(getClass().getResource("/icones/desligar.png"))).build())
                .build();
        
        
        
    }
    
    
        private void addMouseListenerToDrawerItem(DrawerItem item) {
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Aqui você pode definir o comportamento do item ao passar o mouse
                    item.setBackground(Color.decode("#4b526f"));
                    item.setOpaque(true); // Garante que o fundo será visível
                    item.setBorderPainted(false); // Opcional: remover a borda do botão, caso queira  // Altera o fundo para cyan
                    item.setForeground(Color.white);
                    // Verifica qual item foi ativado e troca o ícone
                    if(item.getText().equals("Dashboard")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/dashboard_branco.png")));  // Atualiza o ícone
                    } else if(item.getText().equals("Usuários")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/usuarios_branco.png")));  // Atualiza o ícone
                    } else if(item.getText().equals("Clientes")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/clientes_branco.png")));  // Atualiza o ícone
                    } else if(item.getText().equals("Visitas")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/visitas_branco.png")));  // Atualiza o ícone
                    } else if(item.getText().equals("Orçamentos")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/orcamentos_branco.png")));  // Atualiza o ícone
                    }
                }
                        
                
                @Override
                public void mouseExited(MouseEvent e) {
                    // Volta para a cor original quando o mouse sai
                    item.setBackground(Color.WHITE); // Altera o fundo de volta para branco  
                    item.setForeground(Color.black);
                    // Verifica qual item foi ativado e troca o ícone
                    if(item.getText().equals("Dashboard")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/dashboard_azul.png")));  // Atualiza o ícone
                    } else if(item.getText().equals("Usuários")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/usuarios_azul.png")));  // Atualiza o ícone
                    } else if(item.getText().equals("Clientes")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/clientes_azul.png")));  // Atualiza o ícone
                    } else if(item.getText().equals("Visitas")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/visitas_azul.png")));  // Atualiza o ícone
                    } else if(item.getText().equals("Orçamentos")){
                        item.setIcon(new ImageIcon(getClass().getResource("/icones/orcamentos_azul.png")));  // Atualiza o ícone
                    }
                }
                
                
        });

    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        jButton1.setText("|||");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar_ico.png"))); // NOI18N
        btnFechar.setBorder(null);
        btnFechar.setBorderPainted(false);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFechar.setFocusPainted(false);
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 689, Short.MAX_VALUE)
                .addComponent(btnFechar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnFechar))
                .addGap(0, 443, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(drawer.isShow()){
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnFecharActionPerformed

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
            java.util.logging.Logger.getLogger(TesteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesteMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
