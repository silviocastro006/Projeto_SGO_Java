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
   
   public int id;
   String tipo;
   String nome;
   String cpf;
   String razsocial;
   String cnpj;
   String telefone;
   String email;
   String endereco;
   public boolean modoEdicao = false;  // Controle do modo de edição

    

    public JdlCadastroCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocation(20, 200);
        mascaraCampos();
        desabilitarPJ();
        setTitle("Cadastro de Cliente");
    }      
    
    
   public void limparCampos(){
      txtNome.setText("");
      txtCPF.setText("");
      txtRazSocial.setText("");
      txtCNPJ.setText("");
      txtTelefone.setText("");
      txtEmail.setText("");
      txtEndereco.setText("");
    } 
   
   
   public boolean verificarCampos(){
        
        // Remover formatações e capturar valores
        this.tipo = cmbTipo.getSelectedItem().toString();
        this.nome = txtNome.getText().trim();
        this.cpf = txtCPF.getText().trim().replace(".", "").replace("-", "");
        this.razsocial = txtRazSocial.getText().trim();
        this.cnpj = txtCNPJ.getText().trim().replace(".", "").replace("-", "").replace("/", "");
        this.telefone = txtTelefone.getText().trim().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        this.email = txtEmail.getText().trim();
        this.endereco = txtEndereco.getText().trim();
        
       
        // Verificar campos obrigatórios
        if(this.tipo.equals("PF") && (
            this.cpf.equals("") ||
            this.nome.equals("") ||
            this.telefone.equals("") ||
            this.email.equals("") ||
            this.endereco.equals("")))
        {
            JOptionPane.showMessageDialog(this, "Favor preencher todos os dados de Pessoa Física.");
            return false;
        }
        
        if(this.tipo.equals("PJ") && (
            this.cnpj.equals("") ||
            this.razsocial.equals("") ||
            this.telefone.equals("") ||
            this.email.equals("") ||
            this.endereco.equals("")))
        {
            JOptionPane.showMessageDialog(this, "Favor preencher todos os dados de Pessoa Jurídica.");
            return false;
        }

        return true;
    }
    
    
   public void mascaraCampos(){
        
        DefaultFormatterFactory formatoCPF = (DefaultFormatterFactory) txtCPF.getFormatterFactory();
        DefaultFormatterFactory formatoCNPJ = (DefaultFormatterFactory) txtCNPJ.getFormatterFactory();
        DefaultFormatterFactory formatoTelefone = (DefaultFormatterFactory) txtTelefone.getFormatterFactory();
        
        MaskFormatter mascaraCPF = (MaskFormatter) formatoCPF.getDefaultFormatter();
        MaskFormatter mascaraCNPJ = (MaskFormatter) formatoCNPJ.getDefaultFormatter();
        MaskFormatter mascaraTelefone = (MaskFormatter) formatoTelefone.getDefaultFormatter();
        
        mascaraCPF.setAllowsInvalid(false);
        mascaraCNPJ.setAllowsInvalid(false);
        mascaraTelefone.setAllowsInvalid(false);

        mascaraCPF.setValueContainsLiteralCharacters(false);
        mascaraCNPJ.setValueContainsLiteralCharacters(false);
        mascaraTelefone.setValueContainsLiteralCharacters(false);

   }
   
   
   public void habilitarCamposTotal(){
       
       // devolve as cores originais
       pnlTipo.setBackground(new Color(48,58,95));
       pnlNome.setBackground(new Color(48,58,95));
       pnlCPF.setBackground(new Color(48,58,95));
       pnlRazSocial.setBackground(new Color(48,58,95));
       pnlCNPJ.setBackground(new Color(48,58,95));
       pnlTelefone.setBackground(new Color(48,58,95));
       pnlEmail.setBackground(new Color(48,58,95));
       pnlEndereco.setBackground(new Color(48,58,95));

       
       // habilita os campos
       cmbTipo.setEnabled(true);
       txtNome.setEnabled(true);
       txtCPF.setEnabled(true);
       txtRazSocial.setEnabled(true);
       txtCNPJ.setEnabled(true);
       txtTelefone.setEnabled(true);
       txtEmail.setEnabled(true);
       txtEndereco.setEnabled(true);


        // habilita os campos para edição
       txtNome.setEditable(true);
       txtCPF.setEditable(true);
       txtRazSocial.setEditable(true);
       txtCNPJ.setEditable(true);
       txtTelefone.setEditable(true);
       txtEmail.setEditable(true);
       txtEndereco.setEditable(true);
       

       // Habilitar os botões de salvar e cancelar
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalvar.setBackground(new Color(58,109,43));
        btnCancelar.setBackground(new Color(120,32,32));
   }
   
   
   public void desabilitarCamposTotal() {
    
    // devolve as cores originais
       pnlTipo.setBackground(Color.LIGHT_GRAY);
       pnlNome.setBackground(Color.LIGHT_GRAY);
       pnlCPF.setBackground(Color.LIGHT_GRAY);
       pnlRazSocial.setBackground(Color.LIGHT_GRAY);
       pnlCNPJ.setBackground(Color.LIGHT_GRAY);
       pnlTelefone.setBackground(Color.LIGHT_GRAY);
       pnlEmail.setBackground(Color.LIGHT_GRAY);
       pnlEndereco.setBackground(Color.LIGHT_GRAY);

       
       // habilita os campos para edição
       cmbTipo.setEditable(false);
       txtNome.setEditable(false);
       txtCPF.setEditable(false);
       txtRazSocial.setEditable(false);
       txtCNPJ.setEditable(false);
       txtTelefone.setEditable(false);
       txtEmail.setEditable(false);
       txtEndereco.setEditable(false);
       

       // Habilitar os botões de salvar e cancelar
        btnSalvar.setEnabled(false);
        btnSalvar.setBackground(Color.LIGHT_GRAY);
}
   
   
   public void desabilitarPF(){
        pnlNome.setBackground(Color.LIGHT_GRAY);
        pnlCPF.setBackground(Color.LIGHT_GRAY);
        txtNome.setEnabled(false);
        txtCPF.setEnabled(false);
   }
   
   
   public void desabilitarPJ(){
        pnlRazSocial.setBackground(Color.LIGHT_GRAY);
        pnlCNPJ.setBackground(Color.LIGHT_GRAY);
        txtRazSocial.setEnabled(false);
        txtCNPJ.setEnabled(false);
   }
   
   
   public void cadastrarCliente(){
       if(verificarCampos()){
            try{
                
                // instancia do controlador
                ControleClientes contcli = new ControleClientes();
                
                // Tentando passar os dados      
                contcli.cadastrarCliente(
                this,
                this.tipo,
                this.nome,
		this.cpf,
                this.razsocial,
                this.cnpj,
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
   }
   
   
   public void editarCliente(){
       if(verificarCampos()){
            try{
                
                // instancia do controlador
                ControleClientes contcli = new ControleClientes();
                
                // Tentando passar os dados
                contcli.editarCliente(
                this,
                this.tipo,
                this.nome,
		this.cpf,
                this.razsocial,
                this.cnpj,
                this.telefone,
                this.email,
                this.endereco,
                this.id
                );
                
                limparCampos();
                
            }catch (IllegalArgumentException e) {
            // Exibe a mensagem de erro gerada pela validação do modelo (por exemplo, CPF inválido)
            JOptionPane.showMessageDialog(this, e.getMessage());
            
            } catch (Exception e) {
            // Exibe uma mensagem genérica em caso de outros erros
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
            }
        }
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
        pnlEndereco = new PainelRedondo();
        lblEndereco = new javax.swing.JLabel();
        pnlTelefone = new PainelRedondo();
        lblTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        pnlEmail = new PainelRedondo();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlTipo = new PainelRedondo();
        lblTipo = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        btnSalvar = new util.elementos.BotaoPrincipal();
        btnCancelar = new util.elementos.BotaoPrincipal();
        txtCNPJ = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        pnlCNPJ = new PainelRedondo();
        lblCNPJ = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        pnlRazSocial = new PainelRedondo();
        lblRazSocial = new javax.swing.JLabel();
        txtRazSocial = new javax.swing.JTextField();

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

        pnlCPF.setBackground(new java.awt.Color(48, 58, 95));
        pnlCPF.setLayout(new java.awt.BorderLayout());

        lblCPF.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblCPF.setForeground(new java.awt.Color(255, 255, 255));
        lblCPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCPF.setText("CPF");
        pnlCPF.add(lblCPF, java.awt.BorderLayout.CENTER);

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

        pnlTipo.setBackground(new java.awt.Color(48, 58, 95));
        pnlTipo.setLayout(new java.awt.BorderLayout());

        lblTipo.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("Tipo");
        pnlTipo.add(lblTipo, java.awt.BorderLayout.CENTER);

        cmbTipo.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PF", "PJ" }));
        cmbTipo.setFocusable(false);
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

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
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCNPJ.setToolTipText("");
        txtCNPJ.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        pnlCNPJ.setBackground(new java.awt.Color(48, 58, 95));
        pnlCNPJ.setLayout(new java.awt.BorderLayout());

        lblCNPJ.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblCNPJ.setForeground(new java.awt.Color(255, 255, 255));
        lblCNPJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCNPJ.setText("CNPJ");
        pnlCNPJ.add(lblCNPJ, java.awt.BorderLayout.CENTER);

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setToolTipText("");
        txtCPF.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        pnlRazSocial.setBackground(new java.awt.Color(48, 58, 95));
        pnlRazSocial.setLayout(new java.awt.BorderLayout());

        lblRazSocial.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        lblRazSocial.setForeground(new java.awt.Color(255, 255, 255));
        lblRazSocial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRazSocial.setText("Razão Social");
        pnlRazSocial.add(lblRazSocial, java.awt.BorderLayout.CENTER);

        txtRazSocial.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpnFundoLayout = new javax.swing.GroupLayout(jpnFundo);
        jpnFundo.setLayout(jpnFundoLayout);
        jpnFundoLayout.setHorizontalGroup(
            jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFundoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEndereco))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(pnlTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnFundoLayout.createSequentialGroup()
                        .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFundoLayout.createSequentialGroup()
                                .addComponent(pnlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefone))
                            .addGroup(jpnFundoLayout.createSequentialGroup()
                                .addComponent(pnlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnFundoLayout.createSequentialGroup()
                                .addComponent(pnlRazSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtRazSocial)))
                        .addGap(18, 18, 18)
                        .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnFundoLayout.createSequentialGroup()
                                .addComponent(pnlCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnFundoLayout.createSequentialGroup()
                                .addComponent(pnlCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnFundoLayout.createSequentialGroup()
                                .addComponent(pnlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jpnFundoLayout.setVerticalGroup(
            jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFundoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlRazSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRazSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(54, 54, 54)
                .addGroup(jpnFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
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
        
         if (modoEdicao) {
            editarCliente();  // Se estiver no modo de edição, atualiza o cliente
        } else {
            cadastrarCliente();  // Caso contrário, realiza o cadastro
        }   
                                  
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed

        if(cmbTipo.getSelectedItem().equals("PF")){
            limparCampos();
            habilitarCamposTotal();
            desabilitarPJ();
            
        } else{
            limparCampos();
            habilitarCamposTotal();
            desabilitarPF();
        }
    }//GEN-LAST:event_cmbTipoActionPerformed

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
    public util.elementos.BotaoPrincipal btnCancelar;
    public util.elementos.BotaoPrincipal btnSalvar;
    public javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JPanel jpnFundo;
    private javax.swing.JLabel lblCNPJ;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRazSocial;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTipo;
    public javax.swing.JPanel pnlCNPJ;
    public javax.swing.JPanel pnlCPF;
    public javax.swing.JPanel pnlEmail;
    public javax.swing.JPanel pnlEndereco;
    public javax.swing.JPanel pnlNome;
    public javax.swing.JPanel pnlRazSocial;
    public javax.swing.JPanel pnlTelefone;
    public javax.swing.JPanel pnlTipo;
    public javax.swing.JFormattedTextField txtCNPJ;
    public javax.swing.JFormattedTextField txtCPF;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtEndereco;
    public javax.swing.JTextField txtNome;
    public javax.swing.JTextField txtRazSocial;
    public javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
