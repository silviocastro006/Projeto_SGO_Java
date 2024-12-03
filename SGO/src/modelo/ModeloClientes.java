package modelo;

import util.funcoes.ValidarCPF;
import util.funcoes.ValidarCNPJ;

public class ModeloClientes {
    
    int id_cliente;
    String tipo_cliente;
    String nome_cliente;
    String cpf;
    String raz_social;
    String cnpj;
    String telefone_cliente;
    String email_cliente;
    String endereco_cliente;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(ValidarCPF.validarCPF(cpf)){
            this.cpf = cpf;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        } 
    }

    public String getRaz_social() {
        return raz_social;
    }

    public void setRaz_social(String raz_social) {
        this.raz_social = raz_social;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if(ValidarCPF.validarCPF(cnpj)){
            this.cnpj = cnpj;
        }else{
            throw new IllegalArgumentException("CNPJ inválido");
        }
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getEndereco_cliente() {
        return endereco_cliente;
    }

    public void setEndereco_cliente(String endereco_cliente) {
        this.endereco_cliente = endereco_cliente;
    }
}