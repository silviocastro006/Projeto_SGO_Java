/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao.telas_principais;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
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
        lblTitulo.setText("Pesquisa Usuarios");
        
        // Edição do icone da tela
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icones_padrao/usuarios_azul_80.png")));
        
        acaoBotoes();
        
    }
    
    
    public void acaoBotoes(){
        btnCadastrar.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                
               // Usando a instância da TelaPrincipal que já existe
                TelaPrincipal principal = (TelaPrincipal) SwingUtilities.getWindowAncestor(TelaPesquisaUsuario.this);
                principal.cadastro_usuario.setVisible(true);
            }
            
        });
    }
}
