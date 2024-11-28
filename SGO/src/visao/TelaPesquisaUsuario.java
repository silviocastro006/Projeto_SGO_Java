/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao;

import raven.glasspanepopup.GlassPanePopup;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author acer
 */
public class TelaPesquisaUsuario extends TelaPesquisaPadrao{

    public TelaPesquisaUsuario() {
  
        
        
        // Edição da tabela
        tblConteudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "CPF", "Endereço", "Telefone", "Data Nasc","Email","Cargo"
            }));
        
        // Edição do título da tela
        lblTitulo.setText("Pesquisa Usuário");
        
        // Edição do icone da tela
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_padrao/usuarios_azul_80.png")));
        
        
        // configurar as ações dos botões
        AcoesBotoes();
    }
    
    // Adicionar MouseAdapter aos botões
     private void AcoesBotoes() {
        btnCadastrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /*/ Abrir nova tela
                // Criar uma nova instância do JFrame para a tela de cadastro
                TelaEntreGlass telaentreglass = new TelaEntreGlass();
                telaentreglass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                telaentreglass.setLocationRelativeTo(null); // Centraliza a tela
                
                // Torna a janela visível acima da janela principal
                telaentreglass.setAlwaysOnTop(true);  // Garante que a tela de cadastro fique em cima
                telaentreglass.setVisible(true);  // Exibe a tela*/

                // Exibir o popup com a janela de cadastro
                
                
                // Verifica se o Drawer está visível e esconde o Drawer antes de mostrar o GlassPanePopup
                if (TelaPrincipal.drawer.isShow()) {
                    TelaPrincipal.drawer.hide();
                }

                // Exibe o GlassPanePopup
                GlassPanePopup.showPopup(new JanelaCadastroCliente());
            }
        });
        
        /*btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Abrir nova tela
                abrirNovaTela();
            }
        });
        
        btnExcluir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Abrir nova tela
                abrirNovaTela();
            }
        });*/
     }
   
     
     
}
