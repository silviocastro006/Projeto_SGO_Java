/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao.telas_principais;

/**
 *
 * @author acer
 */
public class TelaPesquisaVisita extends TelaPesquisaPadrao{
    public TelaPesquisaVisita() {
        
        // Edição da tabela
        tblConteudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Status", "Data", "Hora", "Endereço", "Cliente","Telefone"
            }));
        
        // Edição do título da tela
        lblTitulo.setText("Pesquisa Visitas");
        
        // Edição do icone da tela
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_padrao/visitas_azul_80.png")));
        
    }
}
