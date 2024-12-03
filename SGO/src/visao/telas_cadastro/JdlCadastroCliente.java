/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visao.telas_cadastro;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import util.elementos.PainelRedondo;
import util.elementos.PainelGradienteCadastro;
import controle.ControleClientes;
import java.awt.event.MouseListener;

/**
 *
 * @author acer
 */
public class JdlCadastroCliente extends javax.swing.JDialog {
    
    String cpf_cpnj;
    String telefone;
    String nome;
    String email;
    String endereco;
    String tipo;

    

    public JdlCadastroCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocation(20, 200);
        mascaraCampos();
        habilitarCampos();
        configurarListenerCmbTipo(); // Adiciona o listener ao combo box
 
    }
    
    private void configurarListenerCmbTipo() {
    cmbTipo.addActionListener(e -> {
        String tipoSelecionado = cmbTipo.getSelectedItem().toString();
        if (tipoSelecionado.equals("PF")) {
            alterarMascaraCPFouCNPJ("###.###.###-##"); // Máscara para CPF
            CPF_CNPJ.setText("CPF"); // Atualiza o label
            this.lblNome.setText("Nome");
        } else if (tipoSelecionado.equals("PJ")) {
            alterarMascaraCPFouCNPJ("##.###.###/####-##"); // Máscara para CNPJ
            CPF_CNPJ.setText("CNPJ"); // Atualiza o label
            this.lblNome.setText("Raz Social");
        }
    });
    }
    
    private void alterarMascaraCPFouCNPJ(String mascara) {
    try {
        txtCpfCnpj.setFormatterFactory(
            new DefaultFormatterFactory(new MaskFormatter(mascara))
        );
    } catch (java.text.ParseException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao aplicar a máscara: " + ex.getMessage());
    }
    }       
    
    
    public void limparCampos(){
      txtCpfCnpj.setText("");
      txtEmail.setText("");
      txtEndereco.setText("");
      txtNomeRazao.setText("");
      txtTelefone.setText("");
    } 
    
    public boolean verificarCampos(){
        
       // Remover formatações e capturar valores
        this.cpf_cpnj = txtCpfCnpj.getText().trim().replace(".", "").replace("-", "").replace("/", "");
        this.telefone = txtTelefone.getText().trim().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        this.nome = txtNomeRazao.getText().trim();
        this.email = txtEmail.getText().trim();
        this.endereco = txtEndereco.getText().trim();
        this.tipo = cmbTipo.getSelectedItem().toString();
       
        // Verificar campos obrigatórios
        if (this.cpf_cpnj.isEmpty() ||
            this.telefone.isEmpty() ||
            this.email.isEmpty() ||
            this.endereco.isEmpty() ||
            this.nome.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Favor preencher todos os dados.");
        return false;
        }

        return true;
       }
    
    
   public void mascaraCampos(){
        
        DefaultFormatterFactory formatoCPF = (DefaultFormatterFactory) txtCpfCnpj.getFormatterFactory();
        DefaultFormatterFactory formatoTelefone = (DefaultFormatterFactory) txtTelefone.getFormatterFactory();
        DefaultFormatterFactory formatoData = (DefaultFormatterFactory) txtTelefone.getFormatterFactory();
        
        MaskFormatter mascaraCPF = (MaskFormatter) formatoCPF.getDefaultFormatter();
        MaskFormatter mascaraTelefone = (MaskFormatter) formatoTelefone.getDefaultFormatter();
        MaskFormatter mascaraData = (MaskFormatter) formatoData.getDefaultFormatter();
        
        mascaraCPF.setAllowsInvalid(false);
        mascaraTelefone.setAllowsInvalid(false);
        mascaraData.setAllowsInvalid(false);
        
        
        mascaraCPF.setValueContainsLiteralCharacters(false);
        mascaraTelefone.setValueContainsLiteralCharacters(false);
        mascaraData.setValueContainsLiteralCharacters(false);

   }
   
   
   public void habilitarCampos(){
       
       // Permite edição dos campos
        txtNomeRazao.setEditable(true);
        txtCpfCnpj.setEditable(true);
        txtEndereco.setEditable(true);
        txtTelefone.setEditable(true);
        cmbTipo.setEditable(true);
        txtEmail.setEditable(true);
       
       
       // Desabilita os botões, caso você tenha botões como "Salvar" ou "Editar"
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalvar.setBackground(new Color(58,109,43));
        btnCancelar.setBackground(new Color(120,32,32));
   }
   
   
   
   
   public void desabilitarCampos() {
    
    // Tira a permissão de editar os campos
    txtNomeRazao.setEditable(false);
    txtCpfCnpj.setEditable(false);
    txtEndereco.setEditable(false);
    txtTelefone.setEditable(false);
    cmbTipo.setEditable(false);
    txtEmail.setEditable(false);

    // Desabilita os botões, caso você tenha botões como "Salvar" ou "Editar"
    btnSalvar.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnSalvar.setBackground(Color.lightGray);
    btnCancelar.setBackground(Color.lightGray);
    
    
}
   
   
   
    
               
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnFundo = new util.elementos.PainelGradienteCadastro();
        pnlNome = new PainelRedondo();
        lblNome = new javax.swing.JLabel();
        pnlCPF_CNPJ = new PainelRedondo();
        CPF_CNPJ = new javax.swing.JLabel();
        pnlEndereco = new PainelRedondo();
        lblEndereco = new javax.swing.JLabel();
        pnlTelefone = new PainelRedondo();
        lblTelefone = new javax.swing.JLabel();
        txtNomeRazao = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        pnlEmail = new PainelRedondo();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlTipo = new PainelRedondo();
        lblTipo = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        btnSalvar = new util.elementos.BotaoPrincipal();
        btnCancelar = new util.elementos.BotaoPrincipal();
        txtCpfCnpj = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cliente");
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jpnFundo.setBackground(new java.awt.Color(255, 255, 255));

        pnlNome.setBackground(new java.awt.Color(48, 58, 95));
        pnlNome.setLayout(new java.awt.BorderLayout());

        lblNome.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setText("Nome");
        pnlNome.add(lblNome, java.awt.BorderLayout.CENTER);

        pnlCPF_CNPJ.setBackground(new java.awt.Color(48, 58, 95));
        pnlCPF_CNPJ.setLayout(new java.awt.BorderLayout());

        CPF_CNPJ.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        CPF_CNPJ.setForeground(new java.awt.Color(255, 255, 255));
        CPF_CNPJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CPF_CNPJ.setText("CPF");
        pnlCPF_CNPJ.add(CPF_CNPJ, java.awt.BorderLayout.CENTER);

        pnlEndereco.setBackground(new java.awt.Color(48, 58, 95));
        pnlEndereco.setLayout(new java.awt.BorderLayout());

        lblEndereco.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        lblEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndereco.setText("Endereço");
        pnlEndereco.add(lblEndereco, java.awt.BorderLayout.CENTER);

        pnlTelefone.setBackground(new java.awt.Color(48, 58, 95));
        pnlTelefone.setLayout(new java.awt.BorderLayout());

        lblTelefone.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefone.setText("Telefone");
        pnlTelefone.add(lblTelefone, java.awt.BorderLayout.CENTER);

        txtNomeRazao.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        txtEndereco.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        pnlEmail.setBackground(new java.awt.Color(48, 58, 95));
        pnlEmail.setLayout(new java.awt.BorderLayout());

        lblEmail.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setText("Email");
        pnlEmail.add(lblEmail, java.awt.BorderLayout.CENTER);

        txtEmail.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        pnlTipo.setBackground(new java.awt.Color(48, 58, 95));
        pnlTipo.setLayout(new java.awt.BorderLayout());

        lblTipo.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("Tipo");
        pnlTipo.add(lblTipo, java.awt.BorderLayout.CENTER);

        cmbTipo.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PF", "PJ" }));

        btnSalvar.setBackground(new java.awt.Color(58, 109, 43));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/salvar_32.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(120, 32, 32));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_pequenos/cancelar_32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        try {
            txtCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfCnpj.setToolTipText("");
        txtCpfCnpj.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpnFundoLayout = new javax.swing.GroupLayout(jpnFundo);
        jpnFundo.setLayout(jpnFundoLayout);
        jpnFundoLayout.setHorizontalGroup(
            jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFundoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeRazao))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail)))
                .addGap(48, 48, 48))
        );
        jpnFundoLayout.setVerticalGroup(
            jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFundoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlCPF_CNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomeRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if(verificarCampos()){
            try{
                
                // instancia do controlador
                ControleClientes contcli = new ControleClientes();
                
                // Tentando passar os dados
                contcli.cadastrarCliente(this,
                this.tipo,
                this.cpf_cpnj,
                this.nome,
                this.telefone,
                this.email,
                this.endereco
                );
                
                limparCampos();
                
            } catch (IllegalArgumentException e) {
            // Exibe a mensagem de erro gerada pela validação do modelo (por exemplo, CPF inválido)
            JOptionPane.showMessageDialog(this, e.getMessage());
            
            } catch (Exception e) {
            // Exibe uma mensagem genérica em caso de outros erros
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
            
            }
        }
        
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(JdlCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdlCadastroCliente dialog = new JdlCadastroCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel CPF_CNPJ;
    private util.elementos.BotaoPrincipal btnCancelar;
    private util.elementos.BotaoPrincipal btnSalvar;
    public javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JPanel jpnFundo;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTipo;
    public javax.swing.JPanel pnlCPF_CNPJ;
    public javax.swing.JPanel pnlEmail;
    public javax.swing.JPanel pnlEndereco;
    public javax.swing.JPanel pnlNome;
    public javax.swing.JPanel pnlTelefone;
    public javax.swing.JPanel pnlTipo;
    public javax.swing.JFormattedTextField txtCpfCnpj;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtEndereco;
    public javax.swing.JTextField txtNomeRazao;
    public javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
