/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.UsuariosDao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.ModeloUsuarios;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import visao.telas_cadastro.JdlCadastroUsuario;
import visao.telas_principais.TelaPesquisaUsuario;

/**
 *
 * @author acer
 */
public class ControleUsuarios {
    
    ModeloUsuarios muser = new ModeloUsuarios();
     
    
    public void cadastrarUsuario(JdlCadastroUsuario telaCadastro, Object... values) throws Exception{
                
        try{
        // Passo os atributos para o modelo
        muser.setNome_usuario((String) values[0]);
        muser.setCpf_usuario((String) values[1]);
        muser.setEndereco_usuario((String) values[2]);
        muser.setTelefone_usuario((String) values[3]);
        muser.setData_usuario((String) values[4]);
        muser.setEmail_usuario((String) values[5]);
        muser.setSenha_usuario((String) values[6]);
        muser.setCargo_usuario((String) values[7]);
        
        UsuariosDao userdao = new UsuariosDao();
        // Usando a instância da TelaPrincipal que já existe
        
        userdao.cadastrarUsuario(
            telaCadastro,
            muser.getNome_usuario(),
            muser.getCpf_usuario(),
            muser.getEndereco_usuario(),
            muser.getTelefone_usuario(),
            muser.getData_usuario(),
            muser.getEmail_usuario(),
            muser.getSenha_usuario(),
            muser.getCargo_usuario()
        );
        
         } catch (IllegalArgumentException e) {
            // Captura a exceção de validação e propaga a exceção para o chamador
            throw new IllegalArgumentException("Erro de validação: " + e.getMessage(), e);

        } catch (Exception e) {
            // Caso ocorra algum outro erro e propaga a exceção para o chamador
            throw new Exception("Erro ao tentar salvar o usuário: " + e.getMessage(), e);
        }
        
    }
    
    public void editarUsuario(){
        
    }
    
    public void excluirUsuario(){
        
    }
    
    public void listarUsuarios(JTable tabela){
        
        // instanciar o DAO
        UsuariosDao dao = new UsuariosDao();
        List<ModeloUsuarios> lista_usuario = dao.carregarUsuarios();
        
        // manipular a tabela da view
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0); // Limpa os dados existentes

        
        
        // povoar a tabela com as informações do sql
        for (ModeloUsuarios usuario : lista_usuario) {
            model.addRow(new Object[]{
                usuario.getId_usuario(),
                usuario.getNome_usuario(),
                usuario.getCpf_usuario(),
                usuario.getEndereco_usuario(),
                usuario.getTelefone_usuario(),
                usuario.getData_usuario(), 
                usuario.getEmail_usuario(),
                usuario.getCargo_usuario()
            });
        }
    }
    
    public void listarUsuarios(JTable tabela, String sql){
        
        // instanciar o DAO
        UsuariosDao dao = new UsuariosDao();
        List<ModeloUsuarios> lista_usuario = dao.carregarUsuarios(sql);
        
        // manipular a tabela da view
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0); // Limpa os dados existentes

        // povoar a tabela com as informações do sql
        for (ModeloUsuarios usuario : lista_usuario) {
            model.addRow(new Object[]{
                usuario.getId_usuario(),
                usuario.getNome_usuario(),
                usuario.getCpf_usuario(),
                usuario.getEndereco_usuario(),
                usuario.getTelefone_usuario(),
                usuario.getData_usuario(), 
                usuario.getEmail_usuario(),
                usuario.getCargo_usuario()
            });
        }
    }
}
