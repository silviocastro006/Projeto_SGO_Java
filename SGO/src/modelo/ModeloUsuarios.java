/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import util.funcoes.ValidarCPF;
import util.funcoes.ValidadorData;
import util.funcoes.ValidadorEmail;
/**
 *
 * @author acer
 */
public class ModeloUsuarios {
    
    // Atributos usuários
    private int id_usuario;
    private String nome_usuario;
    private String cpf_usuario;
    private String endereco_usuario;
    private String telefone_usuario;
    private String data_usuario;
    private String email_usuario;
    private String senha_usuario;
    private String cargo_usuario;

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        if(ValidarCPF.validarCPF(cpf_usuario)){
            this.cpf_usuario = cpf_usuario;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
        
    }

    public String getEndereco_usuario() {
        return endereco_usuario;
    }

    public void setEndereco_usuario(String endereco_usuario) {
        this.endereco_usuario = endereco_usuario;
    }

    public String getTelefone_usuario() {
        return telefone_usuario;
    }

    public void setTelefone_usuario(String telefone_usuario) {
        this.telefone_usuario = telefone_usuario;
    }

    public String getData_usuario() {
        return data_usuario;
    }

    public void setData_usuario(String data_usuario) {
        if(ValidadorData.validarData(data_usuario)){
            this.data_usuario = data_usuario;
        }else{
            throw new IllegalArgumentException("Data inválida");
        }
        
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        if(ValidadorEmail.validarEmail(email_usuario)){
            this.email_usuario = email_usuario;
        }else{
            throw new IllegalArgumentException("Emai inválido");
        }
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public String getCargo_usuario() {
        return cargo_usuario;
    }

    public void setCargo_usuario(String cargo_usuario) {
        this.cargo_usuario = cargo_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
