/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao.telas_principais;

import controle.ControleUsuarios;
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
import visao.telas_cadastro.JdlCadastroUsuario;
import visao.telas_cadastro.JdlEditarUsuario;

/**
 *
 * @author acer
 */
public class TelaPesquisaUsuario extends TelaPesquisaPadrao{
    
    public TelaPesquisaUsuario() {
        
        // Edição da tabela
        tblConteudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "CPF", "Endereço", "Telefone", "Data Nasc","Email","Cargo"
            }
        )   {boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        lblTitulo.setText("Pesquisa Usuarios");
        
        // Edição do icone da tela
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_padrao/usuarios_azul_80.png")));
        
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
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaUsuario.this);
                principal.cadastro_usuario.setTitle("Cadastro de Usuário");
                principal.cadastro_usuario.habilitarCampos();
                principal.cadastro_usuario.cmbCargo.setEnabled(true);
                principal.cadastro_usuario.cmbCargo.setEditable(false);
                principal.cadastro_usuario.limparCampos();
                principal.cadastro_usuario.setVisible(true);
                principal.cadastro_usuario.setLocation(20, 190);
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
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaUsuario.this);
                
                // Instanciar o Controle para fazer a busca no banco com as informações completas
                ControleUsuarios controle = new ControleUsuarios();
                controle.buscaEditar(principal.editar_usuario, id);
                
                // Mostar a tela
                principal.editar_usuario.setVisible(true);
                principal.editar_usuario.setLocation(20, 190);  // Ajuste de localização, se necessário
                
                // atualiza tabela
                popularTabela();
                
            } else {
                // Passa os dados para a tela de cadastro
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaUsuario.this);
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
                int id_usuario = (Integer) tblConteudo.getValueAt(row, 0);
                
                // Confirmação de exclusão
                
                // Passa os dados para a tela de cadastro
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaUsuario.this);
                
                int confirm = JOptionPane.showConfirmDialog(principal, 
                    "Tem certeza que deseja excluir este usuário?", 
                    "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
                
                // Se sim ele passa para o controlador instanciar o dao
                if (confirm == JOptionPane.YES_OPTION) {
                    // Chama o controle para excluir o usuário
                    ControleUsuarios controle = new ControleUsuarios();
                    controle.excluirUsuario(principal.editar_usuario, id_usuario);
                    popularTabela();
                }
            } else {
                // Passa os dados para a tela de cadastro
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaUsuario.this);
                JOptionPane.showMessageDialog(principal, "Favor selecionar um cadastro para excluir");
            }
        }
    });
        
        
              
       
    }
    
    
    @Override
    public void popularTabela() {
        try{
        ControleUsuarios controle = new ControleUsuarios();
        controle.listarUsuarios(tblConteudo);
        
        // Centralizar os itens na tabela
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto

        // Aplica o renderizador para todas as colunas
        for (int i = 0; i < tblConteudo.getColumnModel().getColumnCount(); i++) {
            tblConteudo.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        }
        
        ordenarColuna();
    } catch(RuntimeException e){
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
                    sql = "SELECT id_usuario, nome_usuario, cpf_usuario, "
                + "endereco_usuario, telefone_usuario, data_usuario, "
                + "email_usuario, cargo_usuario FROM usuarios WHERE nome_usuario LIKE '" + pesquisa + "%'";
                }
                // Verifica se a pesquisa contém apenas números (pesquisa por CPF)
                else if (pesquisa.matches("^[0-9]+$")) {
                    sql = "SELECT id_usuario, nome_usuario, cpf_usuario, "
                + "endereco_usuario, telefone_usuario, data_usuario, "
                + "email_usuario, cargo_usuario FROM usuarios WHERE cpf_usuario LIKE'" + pesquisa + "%'";
                }
                // Verifica se a pesquisa contém um '@' (pesquisa por email)
                else if (pesquisa.contains("@")) {
                    sql = "SELECT id_usuario, nome_usuario, cpf_usuario, "
                + "endereco_usuario, telefone_usuario, data_usuario, "
                + "email_usuario, cargo_usuario FROM usuarios WHERE email_usuario LIKE'%" + pesquisa + "%'";
                }

                // Instanciar Controlador
                try{
                    ControleUsuarios controle = new ControleUsuarios();
                    controle.listarUsuarios(tblConteudo, sql);

                    // Centralizar os itens na tabela
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto

                    // Aplica o renderizador para todas as colunas
                    for (int i = 0; i < tblConteudo.getColumnModel().getColumnCount(); i++) {
                        tblConteudo.getColumnModel().getColumn(i).setCellRenderer(centralizado);
                        
                    
                }
                    ordenarColuna();
        
                } catch(RuntimeException ex){
                    popularTabela();
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
                    int codigo = (Integer) tblConteudo.getValueAt(row, 0);  // Exemplo de captura do "Codigo"
                    String nome = (String) tblConteudo.getValueAt(row, 1);  // Exemplo de captura do "Nome"
                    String cpf = (String) tblConteudo.getValueAt(row, 2);   // Exemplo de captura do "CPF"
                    String endereco = (String) tblConteudo.getValueAt(row, 3);  // Exemplo de captura do "Endereço"
                    String telefone = (String) tblConteudo.getValueAt(row, 4);  // Exemplo de captura do "Telefone"
                    String dataNasc = (String) tblConteudo.getValueAt(row, 5);  // Exemplo de captura da "Data Nasc"
                    String email = (String) tblConteudo.getValueAt(row, 6);  // Exemplo de captura do "Email"
                    String cargo = (String) tblConteudo.getValueAt(row, 7);  // Exemplo de captura do "Cargo"

                    // Passa os dados para a tela de cadastro
                    TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaUsuario.this);

                    // Preenche os campos de cadastro com os dados da tabela
                    principal.cadastro_usuario.txtNome.setText(nome);
                    principal.cadastro_usuario.txtCPF.setText(cpf);
                    principal.cadastro_usuario.txtEndereco.setText(endereco);
                    principal.cadastro_usuario.txtTelefone.setText(telefone);
                    principal.cadastro_usuario.txtDataNasc.setText(dataNasc);
                    principal.cadastro_usuario.txtEmail.setText(email);
                    principal.cadastro_usuario.cmbCargo.setSelectedItem(cargo);

                    // Torna os campos e botões desabilitados
                    principal.cadastro_usuario.desabilitarCampos();

                    // Exibe a tela de cadastro
                    principal.cadastro_usuario.setTitle("Visualiza Cadastro");
                    principal.cadastro_usuario.cmbCargo.setEnabled(false);
                    principal.cadastro_usuario.setVisible(true);
                    principal.cadastro_usuario.setLocation(20, 190);  // Ajuste de localização, se necessário
                }
            }
        }
        
        
    });
    }
 
}
    

    
