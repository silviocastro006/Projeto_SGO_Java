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
    Boolean deletado;

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
        // se o campo já tiver sido criado e tem um traço
        
        if(nome_cliente.equals("-")){
            this.nome_cliente = "-";
            return;
        }
        
        if (nome_cliente.length() == 0) {
            this.nome_cliente = "-";
            return;
        }
        
        this.nome_cliente = nome_cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        
        // se o campo já tiver sido criado e tem um traço
        if(cpf.equals("-")){
            this.cpf = "-";
            return;
        }
        
        // Se o CPF for vazio ou nulo, define como null
        if (cpf == null || cpf.equals("") || cpf.contains(" ")) {
            this.cpf = "-";
            return;  // Não valida se o CPF é nulo ou vazio
        }
                
        if (ValidarCPF.validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido o erro é no model");
        }
    }

    public String getRaz_social() {
        return raz_social;
    }

    public void setRaz_social(String raz_social) {
        // se o campo já tiver sido criado e tem um traço
        if(raz_social.equals("-")){
            this.raz_social = "-";
            return;
        }
        
        if (raz_social == null || raz_social.equals("")) {
            this.raz_social = "-";
            return;  // Não valida se o CNPJ é nulo ou vazio
        }
        this.raz_social = raz_social;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        // se o campo já tiver sido criado e tem um traço
        
        if(cnpj.equals("-")){
            this.cnpj = "-";
            return;
        }
        
        // Se o CNPJ for vazio ou nulo, define como null
        if (cnpj == null || cnpj.equals("") || cnpj.contains(" ")) {
            this.cnpj = "-";
            return;  // Não valida se o CNPJ é nulo ou vazio
        }

        // Se for um CNPJ válido, define o valor
        if (ValidarCNPJ.validarCNPJ(cnpj)) {  // Corrigido para usar o Validador de CNPJ
            this.cnpj = cnpj;
        } else {
            throw new IllegalArgumentException("CNPJ inválido o erro é no model");
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

    public Boolean getDeletado() {
        return deletado;
    }

    public void setDeletado(Boolean deletado) {
        this.deletado = deletado;
    }
    
    
}