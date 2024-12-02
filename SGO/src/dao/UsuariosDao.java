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
import modelo.ModeloUsuarios;
import visao.telas_cadastro.JdlCadastroUsuario;


/**
 *
 * @author acer
 */

public class UsuariosDao {
    
    String sql;
    PreparedStatement stm;
    
    public void cadastrarUsuario(JdlCadastroUsuario telaCadastro, Object... values){
        
        // Statemente para cadastrar usuário
        sql = "INSERT INTO usuarios ("
                + "nome_usuario,"
                + "cpf_usuario,"
                + "endereco_usuario,"
                + "telefone_usuario,"
                + "data_usuario,"
                + "email_usuario,"
                + "senha_usuario,"
                + "cargo_usuario)"
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
            
            JOptionPane.showMessageDialog(telaCadastro, "Usuário cadastrado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaCadastro, "Erro ao  cadastrar usuário "+e.getMessage());
            
        } finally{
            
            // Fechando a conexão
            Conexao.fecharConexao(conn, stm);
        }
        
    }
    
    public void excluirUsuario(){
        
    }
    
    public void editarUsuario(){
        
    }
    
    public List<ModeloUsuarios> carregarUsuarios(){
        
        // lista pública para armazenar os clientes
        List<ModeloUsuarios> lista_usuario = new ArrayList<>();
        
        // Criação de String sql para consulta
        String sql = "Select id_usuario, nome_usuario, cpf_usuario, "
                + "endereco_usuario, telefone_usuario, data_usuario, "
                + "email_usuario, cargo_usuario from usuarios;";
        
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
                    ModeloUsuarios usuario = new ModeloUsuarios();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNome_usuario(rs.getString("nome_usuario"));
                    usuario.setCpf_usuario(rs.getString("cpf_usuario"));
                    usuario.setEndereco_usuario(rs.getString("endereco_usuario"));
                    usuario.setTelefone_usuario(rs.getString("telefone_usuario"));
                    usuario.setData_usuario(rs.getString("data_usuario"));
                    usuario.setEmail_usuario(rs.getString("email_usuario"));
                    usuario.setCargo_usuario(rs.getString("cargo_usuario"));
                    
                    //adiciona valores à lista
                    lista_usuario.add(usuario);
                }
 
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao consultar usuários: " + e.getMessage(), e);
            } finally {
                 Conexao.fecharConexao(conn, stm, rs);
            }
        return lista_usuario;    
    }
    
    
    public List<ModeloUsuarios> carregarUsuarios(String sql){
        
        // lista pública para armazenar os clientes
        List<ModeloUsuarios> lista_usuario = new ArrayList<>();
        
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
                    ModeloUsuarios usuario = new ModeloUsuarios();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNome_usuario(rs.getString("nome_usuario"));
                    usuario.setCpf_usuario(rs.getString("cpf_usuario"));
                    usuario.setEndereco_usuario(rs.getString("endereco_usuario"));
                    usuario.setTelefone_usuario(rs.getString("telefone_usuario"));
                    usuario.setData_usuario(rs.getString("data_usuario"));
                    usuario.setEmail_usuario(rs.getString("email_usuario"));
                    usuario.setCargo_usuario(rs.getString("cargo_usuario"));
                    
                    //adiciona valores à lista
                    lista_usuario.add(usuario);
                }
 
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao consultar usuários: " + e.getMessage(), e);
            } finally {
                 Conexao.fecharConexao(conn, stm, rs);
            }
        return lista_usuario;    
    }
    

    
}
