/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao;

/**
 *
 * @author acer
 */
public class TelaPesquisaOrcamento extends TelaPesquisaPadrao{

    public TelaPesquisaOrcamento() {
        
        // Edição da tabela
        tblConteudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Status", "Prazo Conclusão", "Endereço", "Cliente", "Telefone"
            }));
        
        // Edição do título da tela
        lblTitulo.setText("Pesquisa Orçamento");
        
        // Edição do icone da tela
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_padrao/orcamentos_azul_80.png")));
        
    }
    
        
        
        
    }
