/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author acer
 */
public class TesteMain extends javax.swing.JFrame {

    public DrawerController drawer;
    TestePanelPadrao teste = new TestePanelPadrao();
    
    
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
        
        CardPanel.add(teste,"usuarios");
        CardPanel.setPreferredSize(new java.awt.Dimension(1366, 768)); // Ajuste ao tamanho desejado
        CardPanel.setSize(getWidth(), getHeight()); // Tamanho baseado no JFrame
        
    }
    
    
    
    private DrawerItem itemSelecionado = null;  // Variável para controlar o item selecionado

    private void addMouseListenerToDrawerItem(DrawerItem item) {
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (item != itemSelecionado) {  // Evita que o item selecionado seja alterado ao passar o mouse
                    item.setBackground(new Color(75, 82, 111));  // Fundo alterado
                    item.setOpaque(true);
                    item.setForeground(Color.white);

                    // Troca o ícone para o estado "mouseover"
                    updateIconOnHover(item);
                    item.invalidate();
                    item.repaint();  // Atualiza o ícone
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (item != itemSelecionado) {  // Se não for o item selecionado, retorna ao normal
                    item.setBackground(Color.WHITE);  // Altera o fundo de volta para branco
                    item.setForeground(Color.black);

                    // Restaura o ícone ao estado original
                    restoreIcon(item);
                    item.invalidate();
                    item.repaint();  // Atualiza o ícone
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (itemSelecionado != null) {
                    // Restaura o estilo do item previamente clicado
                    restoreItemStyle(itemSelecionado);
                }

                // Marca o item atual como selecionado
                itemSelecionado = item;
                item.setBackground(new Color(75, 82, 111));  // Fundo alterado
                item.setOpaque(true);
                item.setForeground(Color.white);
                updateIconOnHover(item);  // Muda o ícone para o estado "clicado"
                item.invalidate();
                item.repaint();  // Atualiza o ícone
                
                CardLayout layout = (CardLayout) CardPanel.getLayout();
                if(itemSelecionado == usuario_item){
                layout.show(CardPanel, "usuarios");
                }
                       
        }
        });
    }

    // Atualiza o ícone do item quando o mouse passa por cima
    private void updateIconOnHover(DrawerItem item) {
        if (item == dashboard_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/dashboard_branco.png")));
        } else if (item == usuario_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/usuarios_branco.png")));
        } else if (item == cliente_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/clientes_branco.png")));
        } else if (item == visita_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/visitas_branco.png")));
        } else if (item == orcamento_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/orcamentos_branco.png")));
        }
    }

    // Restaura o ícone do item ao seu estado original
    private void restoreIcon(DrawerItem item) {
        if (item == dashboard_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/dashboard_azul.png")));
        } else if (item == usuario_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/usuarios_azul.png")));
        } else if (item == cliente_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/clientes_azul.png")));
        } else if (item == visita_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/visitas_azul.png")));
        } else if (item == orcamento_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/orcamentos_azul.png")));
        }
    }

    // Restaura o estilo do item, se necessário
    private void restoreItemStyle(DrawerItem item) {
        item.setBackground(Color.WHITE);  // Altera o fundo de volta para branco
        item.setForeground(Color.black);

        // Restaura o ícone do item
        restoreIcon(item);
        item.invalidate();
        item.repaint();  // Atualiza o ícone
    }

  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuSup = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        CardPanel = new javax.swing.JPanel();

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

        javax.swing.GroupLayout MenuSupLayout = new javax.swing.GroupLayout(MenuSup);
        MenuSup.setLayout(MenuSupLayout);
        MenuSupLayout.setHorizontalGroup(
            MenuSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 859, Short.MAX_VALUE)
                .addComponent(btnFechar))
        );
        MenuSupLayout.setVerticalGroup(
            MenuSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuSupLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
            .addGroup(MenuSupLayout.createSequentialGroup()
                .addComponent(btnFechar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CardPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuSup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JPanel CardPanel;
    private javax.swing.JPanel MenuSup;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
