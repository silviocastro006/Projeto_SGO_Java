/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.ModeloClientes;
import visao.telas_cadastro.JdlCadastroCliente;
import visao.telas_principais.TelaPesquisaCliente;
import visao.telas_principais.TelaPrincipal;


/**
 *
 * @author acer
 */

public class ClientesDao {
    
    String sql;
    PreparedStatement stm;
    
    public void cadastrarCliente(JdlCadastroCliente telaCadastro, String tipoCliente, Object... values) {
        
        // Statemente para cadastrar usuário
        sql = "INSERT INTO cliente ("
                + "tipo_cliente,"
                + "nome_cliente,"
                + "cpf,"
                + "raz_social,"
                + "cnpj,"
                + "telefone_cliente,"
                + "email_cliente,"
                + "endereco_cliente)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        
        Connection conn = null;
        
        try {
            // Abrindo a conexão do banco
            conn = Conexao.getConexao();
            
            
            // Criando um statement
            stm = conn.prepareStatement(sql);
            
            // Passando os valores
            stm.setString(1, (String) values[0]);
            stm.setString(2, (String) values[1]);
            stm.setString(3, (String) values[2]);
            stm.setString(4, (String) values[3]);
            stm.setString(5, (String) values[4]);
            stm.setString(6, (String) values[5]);
            stm.setString(7, (String) values[6]);
            stm.setString(8, (String) values[7]);
            
            //Executando a query
            stm.execute();
            
            // Fechando a conexão
            Conexao.fecharConexao(conn, stm);
            
            JOptionPane.showMessageDialog(telaCadastro, "Cliente cadastrado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaCadastro, "Erro ao  cadastrar cliente "+e.getMessage());
            
        } finally{
            
            // Fechando a conexão
            Conexao.fecharConexao(conn, stm);
        }
        
    }
    
    public void excluirCliente(JdlCadastroCliente telaCadastro, int id){
        
        // Prepara a query
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try  {

            // Abrindo a conexão do banco
            Connection conn = Conexao.getConexao();


                // Criando um statement
                stm = conn.prepareStatement(sql);

                stm.setInt(1, id); // Passa o ID do usuário para a consulta

                int rowsAffected = stm.executeUpdate(); // Executa a exclusão

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(telaCadastro, "Cliente Excluido com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(telaCadastro, "Erro ao excluir cliente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaCadastro, "Erro ao excluir cliente: " + e.getMessage());
        }
        
    }
    
    public void editarCliente(JdlCadastroCliente telaEditar, String tipoCliente, Object... values){
       
        // Statemente para cadastrar usuário
        sql = "UPDATE cliente SET "
                + "tipo_cliente,"
                + "nome_cliente,"
                + "cpf,"
                + "raz_social,"
                + "cnpj,"
                + "telefone_cliente,"
                + "email_cliente,"
                + "endereco_cliente)"
                + "WHERE id_usuario = ?;";
        
        Connection conn = null;
        
        try {
            // Abrindo a conexão do banco
            conn = Conexao.getConexao();
            
            
            // Criando um statement
            stm = conn.prepareStatement(sql);
            
            // Passando os valores
            stm.setString(1, (String) values[0]);
            stm.setString(2, (String) values[1]);
            stm.setString(3, (String) values[2]);
            stm.setString(4, (String) values[3]);
            stm.setString(5, (String) values[4]);
            stm.setString(6, (String) values[5]);
            stm.setString(7, (String) values[6]);
            stm.setString(8, (String) values[7]);
            stm.setInt(9, (int) values[8]);
            
            //Executando a query
            stm.execute();
            
            // Fechando a conexão
            Conexao.fecharConexao(conn, stm);
            
            JOptionPane.showMessageDialog(telaEditar, "Cliente atualizado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaEditar, "Erro ao atualizar Cliente "+e.getMessage());
            
        } finally{
            
            // Fechando a conexão
            Conexao.fecharConexao(conn, stm);
        } 
        
    }
    
    
    public List<ModeloClientes> carregarClientes(){
        // Função para popular a tabela
        
        // lista pública para armazenar os clientes
        List<ModeloClientes> lista_cliente = new ArrayList<>();
        
        // Criação de String sql para consulta
        String sql = "Select id_cliente, tipo_cliente, nome_cliente, "
                + "cpf, raz_social, cnpj, "
                + "telefone_cliente, email_cliente, endereco_cliente from cliente;";
        
        Connection conn = null;
        ResultSet rs = null;
        
        // tentar conectar no banco de dados
            try {
                // Abrindo conexão
                conn = Conexao.getConexao();
                stm = conn.prepareStatement(sql);
                
                // Buscando dados no banco
                rs = stm.executeQuery();
                
                // Criar um loop para pegar todos os valores
                while(rs.next()){
                    ModeloClientes cliente = new ModeloClientes();
                    cliente.setId_cliente(rs.getInt("id_cliente"));
                    cliente.setTipo_cliente(rs.getString("tipo_cliente"));
                    cliente.setNome_cliente(rs.getString("nome_cliente"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setRaz_social(rs.getString("raz_social"));
                    cliente.setCnpj(rs.getString("raz_social"));
                    cliente.setTelefone_cliente(rs.getString("telefone_cliente"));
                    cliente.setEmail_cliente(rs.getString("email_cliente"));
                    cliente.setEndereco_cliente(rs.getString("endereco_cliente"));
                    
                    //adiciona valores à lista
                    lista_cliente.add(cliente);
                }
  
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao consultar clientes: " + e.getMessage(), e);
            } finally {
                 Conexao.fecharConexao(conn, stm, rs);
            }
        return lista_cliente;
        
    }
    
    
    public List<ModeloClientes> carregarClientesDinamico(String sql){
        
        // Função para popular a tabela
        
        // lista pública para armazenar os clientes
        List<ModeloClientes> lista_cliente = new ArrayList<>();
        
        
        Connection conn = null;
        ResultSet rs = null;
        
        // tentar conectar no banco de dados
            try {
                // Abrindo conexão
                conn = Conexao.getConexao();
                stm = conn.prepareStatement(sql);
                
                // Buscando dados no banco
                rs = stm.executeQuery();
                
                // Criar um loop para pegar todos os valores
                while(rs.next()){
                    ModeloClientes cliente = new ModeloClientes();
                    cliente.setId_cliente(rs.getInt("id_cliente"));
                    cliente.setTipo_cliente(rs.getString("tipo_cliente"));
                    cliente.setNome_cliente(rs.getString("nome_cliente"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setRaz_social(rs.getString("raz_social"));
                    cliente.setCnpj(rs.getString("raz_social"));
                    cliente.setTelefone_cliente(rs.getString("telefone_cliente"));
                    cliente.setEmail_cliente(rs.getString("email_cliente"));
                    cliente.setEndereco_cliente(rs.getString("endereco_cliente"));
                    
                    //adiciona valores à lista
                    lista_cliente.add(cliente);
                }
  
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao consultar clientes: " + e.getMessage(), e);
            } finally {
                 Conexao.fecharConexao(conn, stm, rs);
            }
        return lista_cliente;
        
    } 
}
