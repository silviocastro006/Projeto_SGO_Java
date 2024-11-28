/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao;

/**
 *
 * @author acer
 */
public class TelaPesquisaCliente extends TelaPesquisaPadrao{
    public TelaPesquisaCliente() {
        
        // Edição da tabela
        tblConteudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tipo", "Nome", "Razao Social", "CPF", "CNPJ","Telefone","Email"
            }));
        
        // Edição do título da tela
        lblTitulo.setText("Pesquisa Cliente");
        
        // Edição do icone da tela
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_padrao/clientes_azul_80.png")));
        
    }
    
}
