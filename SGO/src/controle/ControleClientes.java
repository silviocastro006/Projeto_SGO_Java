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
            mcli.setTipo_cliente((String) values[0]);
            mcli.setNome_cliente((String) values[1]);
            mcli.setCpf((String) values[2]);
            mcli.setRaz_social((String) values[3]);
            mcli.setCnpj((String) values[4]);
            mcli.setTelefone_cliente((String) values[5]);
            mcli.setEmail_cliente((String) values[6]);
            mcli.setEndereco_cliente((String) values[7]);

            
        ClientesDao clientesdao = new ClientesDao();
        // Usando a instância da TelaPrincipal que já existe
        
                
        clientesdao.cadastrarCliente(
            telaCadastro,    
            mcli.getTipo_cliente(),
            mcli.getNome_cliente(),
            mcli.getCpf(),
            mcli.getRaz_social(),
            mcli.getCnpj(),
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
    
    public void editarCliente(JdlCadastroCliente telaEditar, Object... values) throws Exception{
        
         try{
        // Passo os atributos para o modelo
            mcli.setTipo_cliente((String) values[0]);
            mcli.setNome_cliente((String) values[1]);
            mcli.setCpf((String) values[2]);
            mcli.setRaz_social((String) values[3]);
            mcli.setCnpj((String) values[4]);
            mcli.setTelefone_cliente((String) values[5]);
            mcli.setEmail_cliente((String) values[6]);
            mcli.setEndereco_cliente((String) values[7]);
            mcli.setId_cliente((int) values[8]);
        
        ClientesDao clientedao = new ClientesDao();
        
        clientedao.editarCliente(
            telaEditar,
            mcli.getTipo_cliente(),
            mcli.getNome_cliente(),
            mcli.getCpf(),
            mcli.getRaz_social(),
            mcli.getCnpj(),
            mcli.getTelefone_cliente(),
            mcli.getEmail_cliente(),
            mcli.getEndereco_cliente(),
            mcli.getId_cliente()
        );
        
         } catch (IllegalArgumentException e) {
            // Captura a exceção de validação e propaga a exceção para o chamador
            throw new IllegalArgumentException("Erro de validação: " + e.getMessage(), e);

        } catch (Exception e) {
            // Caso ocorra algum outro erro e propaga a exceção para o chamador
            throw new Exception("Erro ao tentar salvar o usuário: " + e.getMessage(), e);
        }
        
    }
    
    public void excluirCliente(JdlCadastroCliente telaEditar, int id){
        
        ClientesDao dao = new ClientesDao();
        dao.excluirCliente(telaEditar, id); // Passa o id do usuário para o DAO
        
    }
    
    public void listarClientes(JTable tabela){
        // Função para popular a tabela
        
        // instanciar o DAO
        ClientesDao dao = new ClientesDao();
        List<ModeloClientes> lista_cliente = dao.carregarClientes();
        
        // manipular a tabela da view
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0); // Limpa os dados existentes

        
        
        // povoar a tabela com as informações do sql
        for (ModeloClientes cliente : lista_cliente) {
            model.addRow(new Object[]{
                cliente.getId_cliente(),
                cliente.getTipo_cliente(),
                cliente.getNome_cliente(),
                cliente.getRaz_social(),
                cliente.getCpf(),
                cliente.getCnpj(), 
                cliente.getTelefone_cliente(),
                cliente.getEmail_cliente(),
                cliente.getEndereco_cliente()
            });
        }
 
    }
    
    public void listarClientesDinamico(JTable tabela, String sql){
        // Função para carregar a tabela dinamixa
        
        // instanciar o DAO
        ClientesDao dao = new ClientesDao();
        List<ModeloClientes> lista_cliente = dao.carregarClientesDinamico(sql);
        
        // manipular a tabela da view
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0); // Limpa os dados existentes

        // povoar a tabela com as informações do sql
        for (ModeloClientes cliente : lista_cliente) {
            model.addRow(new Object[]{
                cliente.getId_cliente(),
                cliente.getTipo_cliente(),
                cliente.getNome_cliente(),
                cliente.getRaz_social(),
                cliente.getCpf(),
                cliente.getCnpj(), 
                cliente.getTelefone_cliente(),
                cliente.getEmail_cliente(),
                cliente.getEndereco_cliente()
            });
        }
        
    }
     
}