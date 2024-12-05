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
import controle.ControleUsuarios;
import java.awt.event.MouseListener;

/**
 *
 * @author acer
 */
public class JdlCadastroUsuario extends javax.swing.JDialog {
    
    String cpf;
    String telefone;
    String nome;
    String email;
    String endereco;
    String senha;
    String rsenha;
    String cargo;
    String datanasc;

    

    public JdlCadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocation(20, 200);
        mascaraCampos();
        habilitarCampos();
        this.cmbCargo.setEditable(false);
 
    }
    
    public void limparCampos(){
      txtCPF.setText("");
      txtEmail.setText("");
      txtEndereco.setText("");
      txtNome.setText("");
      txtSenha.setText("");
      txtTelefone.setText("");
      txtRSenha.setText("");
      txtDataNasc.setText("");
    } 
    
    public boolean verificarCampos(){
        
       this.cpf = txtCPF.getText().trim().replace(".","").replace("-","");
       this.telefone = txtTelefone.getText().trim().replace("(", "").replace(")","").replace("-", "").replace(" ", "");
       this.datanasc = txtDataNasc.getText().trim().replace("/","").replace("/","");
       this.nome = String.valueOf(txtNome.getText());
       this.email = String.valueOf(txtEmail.getText());
       this.endereco = String.valueOf(txtEndereco.getText());
       this.senha = String.valueOf(txtSenha.getPassword());
       this.rsenha = String.valueOf(txtRSenha.getPassword());
       this.cargo = cmbCargo.getSelectedItem().toString();
       
       if(this.cpf.isEmpty() || 
        this.telefone.isEmpty() ||
        this.datanasc.isEmpty() ||
        this.email.isEmpty() ||
        this.endereco.isEmpty() ||
        this.nome.isEmpty() ||
        this.senha.isEmpty() ||
        this.rsenha.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Favor preencher todos os dados"); 
        return false;
       }
       
       if(!this.senha.equals(this.rsenha)){
        JOptionPane.showMessageDialog(this, "Senhas devem ser iguais"); 
        return false;
       }

        return true;
       }
    
    
   public void mascaraCampos(){
        
        DefaultFormatterFactory formatoCPF = (DefaultFormatterFactory) txtCPF.getFormatterFactory();
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
        txtNome.setEditable(true);
        txtCPF.setEditable(true);
        txtDataNasc.setEditable(true);
        txtEndereco.setEditable(true);
        txtTelefone.setEditable(true);
        cmbCargo.setEditable(true);
        txtEmail.setEditable(true);
        txtSenha.setEnabled(true);
        txtRSenha.setEnabled(true);
       
       
       // Desabilita os botões, caso você tenha botões como "Salvar" ou "Editar"
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalvar.setBackground(new Color(58,109,43));
        btnCancelar.setBackground(new Color(120,32,32));
   }
   
   
   
   
   public void desabilitarCampos() {
    
    // Tira a permissão de editar os campos
    txtNome.setEditable(false);
    txtCPF.setEditable(false);
    txtDataNasc.setEditable(false);
    txtEndereco.setEditable(false);
    txtTelefone.setEditable(false);
    cmbCargo.setEditable(false);
    txtEmail.setEditable(false);
    txtSenha.setEnabled(false);
    txtRSenha.setEnabled(false);

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
        pnlCPF = new PainelRedondo();
        lblCPF = new javax.swing.JLabel();
        pnlDataNasc = new PainelRedondo();
        lblDataNasc = new javax.swing.JLabel();
        pnlEndereco = new PainelRedondo();
        lblEndereco = new javax.swing.JLabel();
        pnlTelefone = new PainelRedondo();
        lblTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        pnlEmail = new PainelRedondo();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlSenha = new PainelRedondo();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        pnlRSenha = new PainelRedondo();
        lblRSenha = new javax.swing.JLabel();
        txtRSenha = new javax.swing.JPasswordField();
        pnlCargo = new PainelRedondo();
        lblCargo = new javax.swing.JLabel();
        cmbCargo = new javax.swing.JComboBox<>();
        btnSalvar = new util.elementos.BotaoPrincipal();
        btnCancelar = new util.elementos.BotaoPrincipal();
        txtCPF = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtDataNasc = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");
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

        pnlCPF.setBackground(new java.awt.Color(48, 58, 95));
        pnlCPF.setLayout(new java.awt.BorderLayout());

        lblCPF.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblCPF.setForeground(new java.awt.Color(255, 255, 255));
        lblCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCPF.setText("CPF");
        pnlCPF.add(lblCPF, java.awt.BorderLayout.CENTER);

        pnlDataNasc.setBackground(new java.awt.Color(48, 58, 95));
        pnlDataNasc.setLayout(new java.awt.BorderLayout());

        lblDataNasc.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblDataNasc.setForeground(new java.awt.Color(255, 255, 255));
        lblDataNasc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataNasc.setText("Data Nasc.");
        pnlDataNasc.add(lblDataNasc, java.awt.BorderLayout.CENTER);

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

        txtNome.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        txtEndereco.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        pnlEmail.setBackground(new java.awt.Color(48, 58, 95));
        pnlEmail.setLayout(new java.awt.BorderLayout());

        lblEmail.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setText("Email");
        pnlEmail.add(lblEmail, java.awt.BorderLayout.CENTER);

        txtEmail.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        pnlSenha.setBackground(new java.awt.Color(48, 58, 95));
        pnlSenha.setLayout(new java.awt.BorderLayout());

        lblSenha.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSenha.setText("Senha");
        pnlSenha.add(lblSenha, java.awt.BorderLayout.CENTER);

        txtSenha.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        pnlRSenha.setBackground(new java.awt.Color(48, 58, 95));
        pnlRSenha.setLayout(new java.awt.BorderLayout());

        lblRSenha.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblRSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblRSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRSenha.setText("Repita Senha");
        pnlRSenha.add(lblRSenha, java.awt.BorderLayout.CENTER);

        txtRSenha.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtRSenha.setToolTipText("");

        pnlCargo.setBackground(new java.awt.Color(48, 58, 95));
        pnlCargo.setLayout(new java.awt.BorderLayout());

        lblCargo.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblCargo.setForeground(new java.awt.Color(255, 255, 255));
        lblCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCargo.setText("Cargo");
        pnlCargo.add(lblCargo, java.awt.BorderLayout.CENTER);

        cmbCargo.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Funcionario" }));

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
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setToolTipText("");
        txtCPF.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        try {
            txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNasc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDataNasc.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpnFundoLayout = new javax.swing.GroupLayout(jpnFundo);
        jpnFundo.setLayout(jpnFundoLayout);
        jpnFundoLayout.setHorizontalGroup(
            jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFundoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlRSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataNasc))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEndereco)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jpnFundoLayout.setVerticalGroup(
            jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFundoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(pnlCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtCPF)
                    .addComponent(pnlDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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
                ControleUsuarios contuser = new ControleUsuarios();
                
                // Tentando passar os dados
                contuser.cadastrarUsuario(
                this,
                this.nome,
                this.cpf,
		this.endereco,
                this.telefone,
                txtDataNasc.getText(),
                this.email,
                this.senha,
                this.cargo
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
            java.util.logging.Logger.getLogger(JdlCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdlCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdlCadastroUsuario dialog = new JdlCadastroUsuario(new javax.swing.JFrame(), true);
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
    private util.elementos.BotaoPrincipal btnCancelar;
    private util.elementos.BotaoPrincipal btnSalvar;
    public javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JPanel jpnFundo;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRSenha;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    public javax.swing.JPanel pnlCPF;
    public javax.swing.JPanel pnlCargo;
    public javax.swing.JPanel pnlDataNasc;
    public javax.swing.JPanel pnlEmail;
    public javax.swing.JPanel pnlEndereco;
    public javax.swing.JPanel pnlNome;
    public javax.swing.JPanel pnlRSenha;
    public javax.swing.JPanel pnlSenha;
    public javax.swing.JPanel pnlTelefone;
    public javax.swing.JFormattedTextField txtCPF;
    public javax.swing.JFormattedTextField txtDataNasc;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtEndereco;
    public javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtRSenha;
    private javax.swing.JPasswordField txtSenha;
    public javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
