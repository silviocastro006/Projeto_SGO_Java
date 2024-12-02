/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao.telas_principais;

import java.awt.BorderLayout;
import visao.telas_cadastro.JdlCadastroUsuario;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import visao.telas_cadastro.JdlCadastroUsuario;
import visao.telas_cadastro.JdlEditarUsuario;
/**
 *
 * @author acer
 */
public class TelaPrincipal extends javax.swing.JFrame {

    // Criação da variável para o Drawer animado
    private DrawerController drawer;
    
    // Criação das telas que serão inseridas no cardlayout
    TelaPesquisaUsuario telapesuse = new TelaPesquisaUsuario();
    TelaPesquisaCliente telapescli = new TelaPesquisaCliente();
    TelaPesquisaVisita telapesvis = new TelaPesquisaVisita();
    TelaPesquisaOrcamento telapesorc = new TelaPesquisaOrcamento();
    
    // Criação da variável para saber qual item selecionado no drawer
    private DrawerItem itemSelecionado = null;
    
    
    // Criação dos itens para o painel
    DrawerItem dashboard_item = new DrawerItem("Dashboard");
    DrawerItem usuario_item = new DrawerItem("Usuarios");
    DrawerItem cliente_item = new DrawerItem("Clientes");
    DrawerItem visita_item = new DrawerItem("Visitas");
    DrawerItem orcamento_item = new DrawerItem("Orçamentos");
    
    
    public JdlCadastroUsuario cadastro_usuario; 
    public JdlEditarUsuario editar_usuario;
    
  
    
    public TelaPrincipal() {
        
        // Configurações do menu principal
        setUndecorated(true); // Remover a barra de título
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null); // Mantém a janela centralizada
        setAlwaysOnTop(true); // (Opcional) Coloca a janela sempre no topo

        // Criação no Drawer
        criaDrawer();
        
        // Instanciar os jdialogs
        cadastro_usuario = new JdlCadastroUsuario(this, true);
        editar_usuario = new JdlEditarUsuario(this, true);
        
    }
    

    private void addMouseListenerToDrawerItem(DrawerItem item) {
    item.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
            // Restaura o estilo de todos os itens
            restoreAllItemsStyle();

            // Aplica o estilo ao item selecionado
            itemSelecionado = item;
            item.setBackground(new Color(75, 82, 111)); // Fundo alterado
            item.setOpaque(true);
            item.setForeground(Color.WHITE); // Texto branco
            updateIconOnClick(item); // Atualiza o ícone do item selecionado

            // Exibe o painel correspondente
            CardLayout layout = (CardLayout) CardPanel.getLayout();
            
           
            
            // Troca de painel no cardlayout
            if (item == usuario_item) {
                layout.show(CardPanel, "usuarios");
                drawer.hide();
            } else if (item == cliente_item){
                layout.show(CardPanel, "clientes");
                drawer.hide();
            } else if (item == visita_item){
                layout.show(CardPanel,"visitas");
                drawer.hide();
            } else if (item == orcamento_item){
                layout.show(CardPanel,"orcamentos");
                drawer.hide();
            }

            item.invalidate();
            item.repaint(); // Atualiza o componente
        }
    });
}

    // Atualiza o ícone do item quando o mouse passa por cima
    private void updateIconOnClick(DrawerItem item) {
        if (item == dashboard_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/dashboard_branco.png")));
        } else if (item == usuario_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/usuarios_branco.png")));
        } else if (item == cliente_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/clientes_branco.png")));
        } else if (item == visita_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/visitas_branco.png")));
        } else if (item == orcamento_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/orcamentos_branco.png")));
        }
    }

    // Restaura o ícone do item ao seu estado original
    private void restoreIcon(DrawerItem item) {
        if (item == dashboard_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/dashboard_azul.png")));
        } else if (item == usuario_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/usuarios_azul.png")));
        } else if (item == cliente_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/clientes_azul.png")));
        } else if (item == visita_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/visitas_azul.png")));
        } else if (item == orcamento_item) {
            item.setIcon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/orcamentos_azul.png")));
        }
    }
    
    
    // Método que recupera todos os itens como padrão
    private void restoreAllItemsStyle() {
        restoreItemStyle(dashboard_item);
        restoreItemStyle(usuario_item);
        restoreItemStyle(cliente_item);
        restoreItemStyle(visita_item);
        restoreItemStyle(orcamento_item);
    }

    // Restaura o estilo do item, se necessário
    private void restoreItemStyle(DrawerItem item) {
        
        item.setBackground(Color.WHITE);  // Altera o fundo de volta para branco
        item.setForeground(Color.black);

        // Restaura o ícone do item
        restoreIcon(item);
        item.invalidate();
        item.repaint();  
    }
    
    public void criaDrawer(){
        // Inserindo o icone para cada um
        dashboard_item.icon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/dashboard_azul.png"))).build();
        usuario_item.icon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/usuarios_azul.png"))).build();
        cliente_item.icon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/clientes_azul.png"))).build();
        visita_item.icon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/visitas_azul.png"))).build();
        orcamento_item.icon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/orcamentos_azul.png"))).build();
        
        
        // Alterando as cores do texto do drawer
        dashboard_item.setForeground(new Color(8, 0, 50));
        usuario_item.setForeground(new Color(8, 0, 50));
        cliente_item.setForeground(new Color(8, 0, 50));
        visita_item.setForeground(new Color(8, 0, 50));
        orcamento_item.setForeground(new Color(8, 0, 50));
        
        
        // Adicionando o MouseListener para cada item
        addMouseListenerToDrawerItem(dashboard_item);
        addMouseListenerToDrawerItem(usuario_item);
        addMouseListenerToDrawerItem(cliente_item);
        addMouseListenerToDrawerItem(visita_item);
        addMouseListenerToDrawerItem(orcamento_item);
        
        
        // Editando a fonte para cada item
        Font fonte_label = new Font("OpenSans-Regular", Font.PLAIN, 20);
        dashboard_item.setFont(fonte_label);
        usuario_item.setFont(fonte_label);
        cliente_item.setFont(fonte_label);
        visita_item.setFont(fonte_label);
        orcamento_item.setFont(fonte_label);
        
        
        // Criando o drawer + animação        
        drawer = Drawer.newDrawer(this)
                .header(new Header_Drawer())
                .separator(20, new Color(255,255,255))
                .addChild(dashboard_item)
                .addChild(usuario_item)
                .addChild(cliente_item)
                .addChild(visita_item)
                .addChild(orcamento_item)
                .itemHeight(70)
                .addFooter(new DrawerItem("Sair").icon(new ImageIcon(getClass().getResource("/icones/icones_pequenos/desligar.png"))).build())
                .build();

        
        // Adicionando a tela usuários no CardPanel
        CardPanel.add(telapesuse,"usuarios");
        CardPanel.add(telapescli,"clientes");
        CardPanel.add(telapesvis,"visitas");
        CardPanel.add(telapesorc,"orcamentos");
        
        CardPanel.setPreferredSize(new java.awt.Dimension(1366, 768)); // Ajuste ao tamanho desejado
        CardPanel.setSize(getWidth(), getHeight()); // Tamanho baseado no JFrame
        // Chama o método para adicionar o fundo fosco
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
        btnMenu = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        CardPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(getBackground());
        setFocusCycleRoot(false);
        setResizable(false);

        MenuSup.setBackground(Color.decode("#4b526f"));

        btnMenu.setBackground(Color.decode("#303a5f"));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/menu_30.png"))); // NOI18N
        btnMenu.setToolTipText("Abre menu");
        btnMenu.setBorder(null);
        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenu.setIconTextGap(10);
        btnMenu.setMargin(new java.awt.Insets(14, 14, 14, 14));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnFechar.setBackground(Color.decode("#495273"));
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/fechar_40.png"))); // NOI18N
        btnFechar.setToolTipText("fechar");
        btnFechar.setBorder(null);
        btnFechar.setBorderPainted(false);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnMinimizar.setBackground(Color.decode("#495273"));
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/minimizar_40.png"))); // NOI18N
        btnMinimizar.setToolTipText("minimizar");
        btnMinimizar.setBorder(null);
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuSupLayout = new javax.swing.GroupLayout(MenuSup);
        MenuSup.setLayout(MenuSupLayout);
        MenuSupLayout.setHorizontalGroup(
            MenuSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSupLayout.createSequentialGroup()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1241, Short.MAX_VALUE)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MenuSupLayout.setVerticalGroup(
            MenuSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuSupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        CardPanel.setBackground(new java.awt.Color(255, 255, 255));
        CardPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CardPanel.setFocusable(false);
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
                .addGap(0, 0, 0)
                .addComponent(CardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        if(drawer.isShow()){
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanel;
    private javax.swing.JPanel MenuSup;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMinimizar;
    // End of variables declaration//GEN-END:variables
}
