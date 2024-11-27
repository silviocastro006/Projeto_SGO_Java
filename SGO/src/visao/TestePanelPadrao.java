/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import javax.swing.table.DefaultTableCellRenderer;

public class TestePanelPadrao extends javax.swing.JPanel {

    /**
     * Creates new form TestePanelPadrao
     * 
     */
    public TestePanelPadrao(){
        
        // Configurações iniciais da tela
        initComponents();
        setPreferredSize(new java.awt.Dimension(1366, 768)); // Ajuste para o tamanho desejado
        setSize(getWidth(), getHeight());
        
        //Configurando a aparência da tabela
        
        tblConteudo.getTableHeader().setBackground(Color.decode("#303a5f"));
        tblConteudo.getTableHeader().setForeground(Color.black);
        tblConteudo.getTableHeader().setFont(new Font("OpenSans-Regular", Font.PLAIN, 16));
        
        
        // Centralizando texto na tabela
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblConteudo.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast para Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Definir os pontos de cores
        float[] fractions = {0.0f, 0.1f, 1.0f};  // Posições das cores no gradiente
        Color[] colors = {Color.decode("#ffffff"), Color.decode("#ffffff"), Color.decode("#eff4ff")};  // Cores do gradiente

        // Criar o gradiente de 3 cores da esquerda para a direita
        LinearGradientPaint gradient = new LinearGradientPaint(0, 0, getWidth(), 0, fractions, colors);

        // Definir o gradiente como a pintura
        g2d.setPaint(gradient);

        // Preencher o painel com o gradiente
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnlPesquisa = new javax.swing.JPanel();
        txtpesquisa = new javax.swing.JTextField();
        lblLupa = new javax.swing.JLabel();
        scrlPane = new util.elementos.ScrollPaneWin11();
        tblConteudo = new javax.swing.JTable();
        pnlBotoes = new javax.swing.JPanel();
        btnCadastrar = new util.sample.message.Button();
        btnEditar = new util.sample.message.Button();
        btnExcluir = new util.sample.message.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setRequestFocusEnabled(false);

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_padrao/usuarios_azul_80.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Open Sans", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(48, 58, 95));
        lblTitulo.setText("PESQUISA USUARIOS");

        pnlPesquisa.setBackground(new java.awt.Color(255, 255, 255));
        pnlPesquisa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));

        txtpesquisa.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        txtpesquisa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtpesquisa.setToolTipText("Digite o nome do usuário");
        txtpesquisa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtpesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtpesquisa.setMargin(new java.awt.Insets(2, 20, 2, 6));
        txtpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisaActionPerformed(evt);
            }
        });

        lblLupa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/lupa_24.png"))); // NOI18N

        javax.swing.GroupLayout pnlPesquisaLayout = new javax.swing.GroupLayout(pnlPesquisa);
        pnlPesquisa.setLayout(pnlPesquisaLayout);
        pnlPesquisaLayout.setHorizontalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPesquisaLayout.createSequentialGroup()
                .addComponent(lblLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPesquisaLayout.setVerticalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        scrlPane.setBackground(new java.awt.Color(255, 255, 255));

        tblConteudo.setAutoCreateRowSorter(true);
        tblConteudo.setBackground(new java.awt.Color(249, 249, 249));
        tblConteudo.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        tblConteudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "CPF", "Endereço", "Telefone", "Data Nascimento", "Email", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblConteudo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblConteudo.setFocusable(false);
        tblConteudo.setGridColor(new java.awt.Color(210, 210, 210));
        tblConteudo.setRowHeight(30);
        tblConteudo.setSelectionBackground(new java.awt.Color(207, 211, 225));
        tblConteudo.setShowGrid(true);
        tblConteudo.getTableHeader().setReorderingAllowed(false);
        scrlPane.setViewportView(tblConteudo);
        if (tblConteudo.getColumnModel().getColumnCount() > 0) {
            tblConteudo.getColumnModel().getColumn(0).setHeaderValue("Codigo");
            tblConteudo.getColumnModel().getColumn(1).setHeaderValue("Nome");
            tblConteudo.getColumnModel().getColumn(2).setHeaderValue("CPF");
            tblConteudo.getColumnModel().getColumn(3).setHeaderValue("Endereço");
            tblConteudo.getColumnModel().getColumn(4).setHeaderValue("Telefone");
            tblConteudo.getColumnModel().getColumn(5).setHeaderValue("Data Nascimento");
            tblConteudo.getColumnModel().getColumn(6).setHeaderValue("Email");
            tblConteudo.getColumnModel().getColumn(7).setHeaderValue("Cargo");
        }

        pnlBotoes.setOpaque(false);

        btnCadastrar.setBackground(new java.awt.Color(58, 109, 43));
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/add_32.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseEntered(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(40, 103, 112));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/editar_32.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N

        btnExcluir.setBackground(new java.awt.Color(120, 32, 32));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/lixo_32.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitulo)
                        .addGap(65, 65, 65)
                        .addComponent(pnlPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pnlPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(scrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesquisaActionPerformed

    private void btnCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseEntered
    }//GEN-LAST:event_btnCadastrarMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.sample.message.Button btnCadastrar;
    private util.sample.message.Button btnEditar;
    private util.sample.message.Button btnExcluir;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblLupa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlPesquisa;
    private javax.swing.JScrollPane scrlPane;
    private javax.swing.JTable tblConteudo;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables
}
