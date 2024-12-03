/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao.telas_principais;

import controle.ControleClientes;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import visao.telas_cadastro.JdlCadastroCliente;
import visao.telas_cadastro.JdlEditarCliente;

/**
 *
 * @author acer
 */
public class TelaPesquisaCliente extends TelaPesquisaPadrao{
    public TelaPesquisaCliente() {
        
        // Edição da tabela
        tblConteudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tipo", "Nome", "Razao Social", "CPF", "CNPJ","Telefone","Email","Endereço"
            }
        ){boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false,false
        };
        
        @Override
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

        tblConteudo.setSurrendersFocusOnKeystroke(true);

        tblConteudo.getTableHeader().setReorderingAllowed(false);

        scrlPane.setViewportView(tblConteudo);
        
        // Edição do título da tela
        lblTitulo.setText("Pesquisa Clientes");
        
        // Edição do icone da tela
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_padrao/clientes_azul_80.png")));
        
        acaoBotoes();
        popularTabela();
        campoPesquisa();
        ordenarColuna();
        selecaoTabela();
        
    }
    
    // Cria um TableRowSorter para permitir a ordenação
    public void ordenarColuna() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblConteudo.getModel());
        tblConteudo.setRowSorter(sorter);

        // Definir comparadores para colunas numéricas
        sorter.setComparator(0, new Comparator<Object>() {  // Para a coluna "Código" (coluna 0)
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i1.compareTo(i2);  // Ordenar como números inteiros
            }
        });

        sorter.setComparator(2, new Comparator<Object>() {  // Para a coluna "CPF" (coluna 2)
            @Override
            public int compare(Object o1, Object o2) {
                // Comparar CPF como número (remover caracteres não numéricos, se necessário)
                Long l1 = Long.parseLong(o1.toString().replaceAll("[^0-9]", ""));
                Long l2 = Long.parseLong(o2.toString().replaceAll("[^0-9]", ""));
                return Long.compare(l1, l2);
            }
        });

        sorter.setComparator(5, new Comparator<Object>() {  // Para a coluna "Data Nasc" (coluna 5)
            @Override
            public int compare(Object o1, Object o2) {
                // Comparar datas (exemplo, usando a classe SimpleDateFormat)
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    return sdf.parse(o1.toString()).compareTo(sdf.parse(o2.toString()));
                } catch (ParseException ex) {
                    // Se ocorrer erro ao comparar, apenas compara lexicograficamente
                    return o1.toString().compareTo(o2.toString());
                }
            }
    });
}  
      
    
    
    public void acaoBotoes(){
        btnCadastrar.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                
               // Usando a instância da TelaPrincipal que já existe
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaCliente.this);
                principal.cadastro_cliente.setTitle("Cadastro de Cliente");
                principal.cadastro_cliente.habilitarCampos();
                principal.cadastro_cliente.limparCampos();
                principal.cadastro_cliente.setVisible(true);
                principal.cadastro_cliente.setLocation(20, 190);
                popularTabela();
                
            }
            
        });
        
        btnEditar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            // valor da linha selecionada
            int row = tblConteudo.getSelectedRow();
            
            // Vamos verificar primeiramente se tem algo selecionado na tabela
            if(row!= -1){
                
                // Pegando o id da linha selecionada
                int id = (Integer) tblConteudo.getValueAt(row, 0);
                
                
                
                // Passa os dados para a tela de cadastro
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaCliente.this);
                
                // Instanciar o Controle para fazer a busca no banco com as informações completas
                ControleClientes controle = new ControleClientes();
                controle.buscaEditar(principal.editar_cliente, id);
                
                // Mostar a tela
                principal.editar_cliente.setVisible(true);
                principal.editar_cliente.setLocation(20, 190);  // Ajuste de localização, se necessário
                
                // atualiza tabela
                popularTabela();
                
            } else {
                // Passa os dados para a tela de cadastro
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaCliente.this);
                JOptionPane.showMessageDialog(principal, "Favor selecinar um cadastro para editar");
            }
        }
    });
        
        btnExcluir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Pego a linha selecionada
            int row = tblConteudo.getSelectedRow();
            
            // Se for diferente de nenhuma linha selecionada
            if (row != -1) {
                
                // Pega o id do usuário
                int id_cliente = (Integer) tblConteudo.getValueAt(row, 0);
                
                // Confirmação de exclusão
                
                // Passa os dados para a tela de cadastro
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaCliente.this);
                
                int confirm = JOptionPane.showConfirmDialog(principal, 
                    "Tem certeza que deseja excluir este usuário?", 
                    "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
                
                // Se sim ele passa para o controlador instanciar o dao
                if (confirm == JOptionPane.YES_OPTION) {
                    // Chama o controle para excluir o usuário
                    ControleClientes controle = new ControleClientes();
                    controle.excluirCliente(principal.editar_cliente, id_cliente);
                    popularTabela();
                }
            } else {
                // Passa os dados para a tela de cadastro
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaCliente.this);
                JOptionPane.showMessageDialog(principal, "Favor selecionar um cadastro para excluir");
            }
        }
    });
        
        
              
       
    }
    
    
    @Override
    public void popularTabela() {
        try {
        ControleClientes controle = new ControleClientes();
        controle.listarClientes(tblConteudo);  // Passa a tabela para popular com clientes

        // Centralizar os itens na tabela
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto

        // Aplica o renderizador para todas as colunas
        for (int i = 0; i < tblConteudo.getColumnModel().getColumnCount(); i++) {
            tblConteudo.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }

        // Ordenar as colunas após popular a tabela
        ordenarColuna();
    } catch (RuntimeException e) {
        JOptionPane.showMessageDialog(this, e);
    }
    }
    
    
    public void campoPesquisa() {
        // Adicionando o KeyListener no JTextField
    txtpesquisa.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            // Função que pesquisa dependendo do que for digitado
            String pesquisa = txtpesquisa.getText().trim();
            String sql = "";

            // Verifica se a pesquisa contém apenas letras (pesquisa por nome)
            if (pesquisa.matches("^[a-zA-Zà-úÀ-Ú ]+$")) {
                sql = "SELECT id_cliente, tipo_cliente, nome_cliente, razao_social_cliente, cpf_cliente, cnpj_cliente, telefone_cliente, email_cliente, endereco_cliente "
                    + "FROM clientes WHERE nome_cliente LIKE '" + pesquisa + "%'";
            }
            // Verifica se a pesquisa contém apenas números (pesquisa por CPF)
            else if (pesquisa.matches("^[0-9]+$")) {
                sql = "SELECT id_cliente, tipo_cliente, nome_cliente, razao_social_cliente, cpf_cliente, cnpj_cliente, telefone_cliente, email_cliente, endereco_cliente "
                    + "FROM clientes WHERE cpf_cliente LIKE '" + pesquisa + "%'";
            }
            // Verifica se a pesquisa contém um '@' (pesquisa por email)
            else if (pesquisa.contains("@")) {
                sql = "SELECT id_cliente, tipo_cliente, nome_cliente, razao_social_cliente, cpf_cliente, cnpj_cliente, telefone_cliente, email_cliente, endereco_cliente "
                    + "FROM clientes WHERE email_cliente LIKE '%" + pesquisa + "%'";
            }

            // Instanciar Controlador
            try {
                ControleClientes controle = new ControleClientes();
                controle.listarClientes(tblConteudo, sql);  // Passa a query de pesquisa

                // Centralizar os itens na tabela
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto

                // Aplica o renderizador para todas as colunas
                for (int i = 0; i < tblConteudo.getColumnModel().getColumnCount(); i++) {
                    tblConteudo.getColumnModel().getColumn(i).setCellRenderer(centralizado);
                }

                // Ordenar as colunas após popular a tabela
                ordenarColuna();

            } catch (RuntimeException ex) {
                popularTabela();  // Se der erro, repopula a tabela
            }
        }
        });

        }
    
    
    public void selecaoTabela() {
    tblConteudo.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Verifica se é um duplo clique
            if (e.getClickCount() == 2) {
                // Verifica se a linha clicada é válida
                int row = tblConteudo.getSelectedRow();
                if (row != -1) {
                    // Captura os dados da linha selecionada
                    int codigo = (Integer) tblConteudo.getValueAt(row, 0);  // Código
                    String tipo = (String) tblConteudo.getValueAt(row, 1);   // Tipo
                    String nome = (String) tblConteudo.getValueAt(row, 2);   // Nome
                    String razaoSocial = (String) tblConteudo.getValueAt(row, 3);  // Razão Social
                    String cpf = (String) tblConteudo.getValueAt(row, 4);   // CPF
                    String cnpj = (String) tblConteudo.getValueAt(row, 5);  // CNPJ
                    String telefone = (String) tblConteudo.getValueAt(row, 6);  // Telefone
                    String email = (String) tblConteudo.getValueAt(row, 7);  // Email
                    String endereco = (String) tblConteudo.getValueAt(row, 8);  // Endereço

                    // Passa os dados para a tela de cadastro
                    TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaCliente.this);

                    // Verifica o tipo do cliente e preenche os campos adequados
                    if (tipo.equals("PF")) {  // Se for PF, exibe nome e CPF
                        principal.cadastro_cliente.txtNomeRazao.setText(nome);
                        principal.cadastro_cliente.txtCpfCnpj.setText(cpf);
                    } else if (tipo.equals("PJ")) {  // Se for PJ, exibe razão social e CNPJ
                        principal.cadastro_cliente.txtNomeRazao.setText(razaoSocial);
                        principal.cadastro_cliente.txtCpfCnpj.setText(cnpj);
                    }
                    
                    // Preenche os outros campos
                    principal.cadastro_cliente.txtEndereco.setText(endereco);  // Presumo que 'endereco' é uma variável definida em outro lugar
                    principal.cadastro_cliente.txtTelefone.setText(telefone);
                    principal.cadastro_cliente.txtEmail.setText(email);
                    principal.cadastro_cliente.cmbTipo.setSelectedItem(tipo);

                    // Torna os campos e botões desabilitados
                    principal.cadastro_cliente.desabilitarCampos();

                    // Exibe a tela de cadastro
                    principal.cadastro_cliente.setTitle("Visualiza Cadastro");
                    principal.cadastro_cliente.setVisible(true);
                    principal.cadastro_cliente.setLocation(20, 190);  // Ajuste de localização, se necessário
                }
            }
        }
        
        
    });
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
