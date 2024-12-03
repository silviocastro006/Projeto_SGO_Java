package modelo;

import util.funcoes.ValidarCPF;
import util.funcoes.ValidarCNPJ;

public class ModeloClientes {
    private int id_cliente;
    private String tipo_cliente; // "PF" ou "PJ"
    private String cpfCnpj;      // Armazena CPF (se PF) ou CNPJ (se PJ)
    private String nomeRazao;    // Nome (se PF) ou Razão Social (se PJ)
    private String telefone_cliente;
    private String email_cliente;
    private String endereco_cliente;

    // Getters e Setters

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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        // Valida conforme o tipo
        
        if (this.tipo_cliente == null) {
            throw new IllegalStateException("Defina o tipo do cliente antes de configurar CPF ou CNPJ.");
        }
        
        // Não faz a validação se o cpfCnpj estiver vazio ou nulo
        if (cpfCnpj == null || cpfCnpj.trim().isEmpty()) {
            this.cpfCnpj = cpfCnpj; // Permite CPF ou CNPJ vazio
            return;
        }
    
        if (this.tipo_cliente.equalsIgnoreCase("PF")) {
            if (ValidarCPF.validarCPF(cpfCnpj)) {
                this.cpfCnpj = cpfCnpj; // Define CPF
            } else {
                throw new IllegalArgumentException("CPF inválido para Pessoa Física.");
            }
        } else if (this.tipo_cliente.equalsIgnoreCase("PJ")) {
            if (ValidarCNPJ.validarCNPJ(cpfCnpj)) {
                this.cpfCnpj = cpfCnpj; // Define CNPJ
            } else {
                throw new IllegalArgumentException("CNPJ inválido para Pessoa Jurídica.");
            }
        }
    }

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        if (nomeRazao == null || nomeRazao.isEmpty()) {
            throw new IllegalArgumentException("Nome ou Razão Social não pode estar vazio.");
        }
        this.nomeRazao = nomeRazao;
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