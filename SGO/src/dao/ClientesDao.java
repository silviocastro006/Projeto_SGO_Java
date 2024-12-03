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
import visao.telas_cadastro.JdlEditarCliente;
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
        // Define a query dependendo do tipo de cliente
        String sql = "";

        if (tipoCliente.equals("PF")) {
            // Cadastro de Pessoa Física (PF)
            sql = "INSERT INTO cliente (tipo_cliente, nome_cliente, cpf, endereco_cliente, telefone_cliente, email_cliente) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";
        } else if (tipoCliente.equals("PJ")) {
            // Cadastro de Pessoa Jurídica (PJ)
            sql = "INSERT INTO cliente (tipo_cliente, raz_social, cnpj, endereco_cliente, telefone_cliente, email_cliente) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        } else {
            JOptionPane.showMessageDialog(telaCadastro, "Erro ao definir a sql e tipo de cliente para cadastrar.");
            return;
        }
        
        Connection conn = null;
        
        try {
            // Abrindo a conexão do banco
            conn = Conexao.getConexao();
            
            
            // Criando um statement
            stm = conn.prepareStatement(sql);
            
            // Passando os valores para a query
        if (tipoCliente.equals("PF")) {
            // Para PF
            stm.setString(1, "PF");  // Definindo o tipo como PF
            stm.setString(2, (String) values[0]);  // Nome
            stm.setString(3, (String) values[1]);  // CPF
            stm.setString(4, (String) values[2]);  // Endereço
            stm.setString(5, (String) values[3]);  // Telefone
            stm.setString(6, (String) values[4]);  // Email
        } else {
            // Para PJ
            stm.setString(1, "PJ");  // Definindo o tipo como PJ
            stm.setString(2, (String) values[0]);  // Nome
            stm.setString(3, (String) values[1]);  // Razão Social
            stm.setString(4, (String) values[2]);  // CNPJ
            stm.setString(5, (String) values[3]);  // Endereço
            stm.setString(6, (String) values[4]);  // Telefone
            stm.setString(7, (String) values[5]);  // Email
        }
            
            //Executando a query
            stm.execute();
            
            // Fechando a conexão
            Conexao.fecharConexao(conn, stm);
            
            JOptionPane.showMessageDialog(telaCadastro, "Cliente cadastrado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaCadastro, "Erro ao cadastrar cliente "+e.getMessage());
            
        } finally{
            
            // Fechando a conexão
            Conexao.fecharConexao(conn, stm);
        }
        
    }
    
    public void excluirCliente(JdlEditarCliente telaEditar, int id){
        
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
                JOptionPane.showMessageDialog(telaEditar, "Cliente Excluido com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(telaEditar, "Erro ao excluir cliente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaEditar, "Erro ao excluir cliente: " + e.getMessage());
        }
    }
    
    public void editarCliente(JdlEditarCliente telaEditar, String tipoCliente, Object... values){
        // SQL para atualizar os dados do cliente
       String sql = "";

       // Definindo a query com base no tipo de cliente
       if (tipoCliente.equals("PF")) {
           // SQL para edição de Pessoa Física (PF)
           sql = "UPDATE cliente SET "
                   + "nome_cliente = ?, "
                   + "cpf = ?, "
                   + "endereco_cliente = ?, "
                   + "telefone_cliente = ?, "
                   + "email_cliente = ?, "
                   + "senha_cliente = ? "
                   + "WHERE id_cliente = ?";
       } else if (tipoCliente.equals("PJ")) {
           // SQL para edição de Pessoa Jurídica (PJ)
           sql = "UPDATE cliente SET "
                   + "nome_cliente = ?, "
                   + "raz_social = ?, "
                   + "cnpj = ?, "
                   + "endereco_cliente = ?, "
                   + "telefone_cliente = ?, "
                   + "email_cliente = ?, "
                   + "senha_cliente = ? "
                   + "WHERE id_cliente = ?";
       } else {
           JOptionPane.showMessageDialog(telaEditar, "Erro ao tentar definir a sql e tipo de cliente para atualizar.");
           return;
       }

       Connection conn = null;

       try {
           // Abrindo a conexão do banco
           conn = Conexao.getConexao();

           // Criando um statement
           stm = conn.prepareStatement(sql);

           // Passando os valores para a query dependendo do tipo de cliente
           if (tipoCliente.equals("PF")) {
               // Para PF
               stm.setString(1, (String) values[0]);  // Nome
               stm.setString(2, (String) values[1]);  // CPF
               stm.setString(3, (String) values[2]);  // Endereço
               stm.setString(4, (String) values[3]);  // Telefone
               stm.setString(5, (String) values[4]);  // Email
               stm.setString(6, (String) values[5]);  // Senha
               stm.setInt(7, (int) values[6]);        // ID
           } else {
               // Para PJ
               stm.setString(1, (String) values[0]);  // Nome
               stm.setString(2, (String) values[1]);  // Razão Social
               stm.setString(3, (String) values[2]);  // CNPJ
               stm.setString(4, (String) values[3]);  // Endereço
               stm.setString(5, (String) values[4]);  // Telefone
               stm.setString(6, (String) values[5]);  // Email
               stm.setString(7, (String) values[6]);  // Senha
               stm.setInt(8, (int) values[7]);        // ID
           }

           // Executando a query
           stm.execute();

           // Fechando a conexão
           Conexao.fecharConexao(conn, stm);

           JOptionPane.showMessageDialog(telaEditar, "Cliente atualizado com sucesso");

       } catch (SQLException e) {
           JOptionPane.showMessageDialog(telaEditar, "Erro ao atualizar cliente: " + e.getMessage());
       } finally {
           // Fechando a conexão
           Conexao.fecharConexao(conn, stm);
       }
        
    }
    
    
    public List<ModeloClientes> carregarClientes(){
        
        // função para carregar a tabela 
        
        // lista pública para arar os clientes
        List<ModeloClientes> lista_cliente = new ArrayList<>();
        
        // Criação de String sql para consulta
        String sql = "Select id_cliente, tipo_cliente, nome_cliente, "
                + "raz_social, cpf, cnpj, "
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
                while (rs.next()) {
                    ModeloClientes cliente = new ModeloClientes();
                    cliente.setId_cliente(rs.getInt("id_cliente"));
                    cliente.setTipo_cliente(rs.getString("tipo_cliente"));

                    // Verifica o tipo do cliente e define nomeRazao e cpfCnpj
                    if ("PF".equalsIgnoreCase(cliente.getTipo_cliente())) {
                        cliente.setNomeRazao(rs.getString("nome_cliente")); // Nome para PF
                        cliente.setCpfCnpj(rs.getString("cpf")); // CPF para PF
                    } else if ("PJ".equalsIgnoreCase(cliente.getTipo_cliente())) {
                        cliente.setNomeRazao(rs.getString("raz_social")); // Razão Social para PJ
                        cliente.setCpfCnpj(rs.getString("cnpj")); // CNPJ para PJ
                    }

                    cliente.setTelefone_cliente(rs.getString("telefone_cliente"));
                    cliente.setEmail_cliente(rs.getString("email_cliente"));
                    cliente.setEndereco_cliente(rs.getString("endereco_cliente"));

                    // Adiciona valores à lista
                    lista_cliente.add(cliente);
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao consultar clientes: " + e.getMessage(), e);
            } finally {
                Conexao.fecharConexao(conn, stm, rs);
            }

            return lista_cliente;    
        }
    
    
    public List<ModeloClientes> carregarClientes(String sql){
        
        // função para carregar a tabela dinamixa
        
        // lista pública para armazenar os clientes
        List<ModeloClientes> lista_cliente  = new ArrayList<>();
        
        Connection conn = null;
        ResultSet rs = null;
        
        // tentar conectar no banco de dados
            try {
                // Abrindo conexão
                conn = Conexao.getConexao();
                stm = conn.prepareStatement(sql);
                
                // Buscando dados no banco
                rs = stm.executeQuery();
                
                while(rs.next()){
                    ModeloClientes mcli = new ModeloClientes();

                    // Mapeando os dados para o modelo
                    mcli.setId_cliente(rs.getInt("id_cliente"));
                    mcli.setTipo_cliente(rs.getString("tipo_cliente"));

                    // Se o cliente for PF (Pessoa Física), pega o CPF, caso contrário, pega o CNPJ
                    if ("PF".equalsIgnoreCase(mcli.getTipo_cliente())) {
                        mcli.setCpfCnpj(rs.getString("cpf_cliente"));  // Armazena CPF
                        mcli.setNomeRazao(rs.getString("nome_cliente")); // Armazena Nome
                    } else if ("PJ".equalsIgnoreCase(mcli.getTipo_cliente())) {
                        mcli.setCpfCnpj(rs.getString("cnpj_cliente"));  // Armazena CNPJ
                        mcli.setNomeRazao(rs.getString("razao_social_cliente")); // Armazena Razão Social
                    }

                    mcli.setTelefone_cliente(rs.getString("telefone_cliente"));
                    mcli.setEmail_cliente(rs.getString("email_cliente"));
                    mcli.setEndereco_cliente(rs.getString("endereco_cliente"));

                    // Adiciona o cliente à lista
                    lista_cliente.add(mcli);
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao consultar clientes: " + e.getMessage(), e);
            } finally {
                // Fechar a conexão
                Conexao.fecharConexao(conn, stm, rs);
            }

            return lista_cliente;
        }
    
    public ResultSet buscarEditar(int id){
        
        // Preparar a consulta SQL
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        ResultSet rs = null;
        
         try {
        // Conectar ao banco e preparar a consulta
        Connection conn = Conexao.getConexao();  // Método para obter conexão com o banco
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);  // Substitui o "?" pelo ID
        
        // Passa os dados para a tela de cadastro
        rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }    
}
