/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.ClientesDao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.ModeloClientes;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import visao.telas_cadastro.JdlCadastroCliente;
import visao.telas_cadastro.JdlEditarCliente;
import visao.telas_principais.TelaPesquisaCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author acer
 */
public class ControleClientes {
    
    ModeloClientes mcli = new ModeloClientes();
     
    
    public void cadastrarCliente(JdlCadastroCliente telaCadastro, Object... values) throws Exception{
                
        try{
        // Passo os atributos para o modelo
            mcli.setTipo_cliente((String) values[0]); // "PF" ou "PJ"
            mcli.setCpfCnpj((String) values[1]); // CPF ou CNPJ
            mcli.setNomeRazao((String) values[2]); // Nome ou Razão Social
            mcli.setTelefone_cliente((String) values[3]);
            mcli.setEmail_cliente((String) values[4]);
            mcli.setEndereco_cliente((String) values[5]);
           
        
        ClientesDao clientesdao = new ClientesDao();
        // Usando a instância da TelaPrincipal que já existe
        
        String tipocliente = mcli.getTipo_cliente();
        System.out.println(tipocliente);
        
        
        clientesdao.cadastrarCliente(
            telaCadastro,
            tipocliente,
            mcli.getTipo_cliente(),
            mcli.getNomeRazao(),
            mcli.getCpfCnpj(),
            mcli.getTelefone_cliente(),
            mcli.getEmail_cliente(),
            mcli.getEndereco_cliente()
        );
        
         } catch (IllegalArgumentException e) {
            // Captura a exceção de validação e propaga a exceção para o chamador
            throw new IllegalArgumentException("Erro de validação: " + e.getMessage(), e);

        } catch (Exception e) {
            // Caso ocorra algum outro erro e propaga a exceção para o chamador
            throw new Exception("Erro ao tentar salvar o cliente: " + e.getMessage(), e);
        }
        
    }
    
    public void editarCliente(JdlEditarCliente telaEditar, String tipoCliente, Object... values) throws Exception{

        // Chama o método do DAO para editar o cliente
        ClientesDao clientesDao = new ClientesDao();
        clientesDao.editarCliente(telaEditar, tipoCliente, values);
        
        
    }
    
    public void excluirCliente(JdlEditarCliente telaEditar, int id){
        
        ClientesDao clientesDao = new ClientesDao();
        clientesDao.excluirCliente(telaEditar, id); // Passa o ID do cliente para o DAO
    }
    
    public void listarClientes(JTable tabela){
        
        // carregar tabela padrão
        
        // instanciar o DAO
        ClientesDao clientesDao = new ClientesDao();
        List<ModeloClientes> listaClientes = clientesDao.carregarClientes();
        
        // manipular a tabela da view
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0); // Limpa os dados existentes

        
        
        // Povoar a tabela com as informações do banco
        for (ModeloClientes cliente : listaClientes) {
            model.addRow(new Object[] {
                cliente.getId_cliente(),
                cliente.getTipo_cliente(),
                cliente.getCpfCnpj(),
                cliente.getNomeRazao(),
                cliente.getTelefone_cliente(),
                cliente.getEmail_cliente(),
                cliente.getEndereco_cliente()
            });
        }
    }
    
    public void listarClientes(JTable tabela, String sql){
        
        // carregar tabela dinamica
        
        // instanciar o DAO
        ClientesDao clientesDao = new ClientesDao();
        List<ModeloClientes> listaClientes = clientesDao.carregarClientes(sql);
        
        // manipular a tabela da view
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0); // Limpa os dados existentes

        // Povoar a tabela com as informações do banco
        for (ModeloClientes cliente : listaClientes) {
            model.addRow(new Object[] {
                cliente.getId_cliente(),
                cliente.getTipo_cliente(),
                cliente.getCpfCnpj(),
                cliente.getNomeRazao(),
                cliente.getTelefone_cliente(),
                cliente.getEmail_cliente(),
                cliente.getEndereco_cliente()
            });
        }
    }
     
    public void buscaEditar(JdlEditarCliente telaEditar, int id){
        
        // Instanciar o Dao para buscar os dados no banco
        ClientesDao clientesDao = new ClientesDao();
        
        // Chamar o método de busca no DAO passando o ID
        ResultSet rs = clientesDao.buscarEditar(id);
        
        try {
        if (rs.next()) {
            // Preencher os campos da tela de edição
                telaEditar.cmbTipo.setSelectedItem(rs.getString("tipo_cliente"));
                telaEditar.txtCpfCnpj.setText(rs.getString("cpfCnpj"));
                telaEditar.txtNomeRazao.setText(rs.getString("nomeRazao"));
                telaEditar.txtTelefone.setText(rs.getString("telefone_cliente"));
                telaEditar.txtEmail.setText(rs.getString("email_cliente"));
                telaEditar.txtEndereco.setText(rs.getString("endereco_cliente"));
        }
    } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(telaEditar, "Erro ao tentar resgatar dados: "+ex);
    }
    }
}
