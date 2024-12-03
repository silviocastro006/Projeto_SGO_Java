/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao.notificacoes.notificar;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Aluno
 */
public class notificacao extends JDialog{
    
    //Faz a leitura dos dados sem a necessidade de uma STRING solta.
    public enum  tipodeDialogo{
        CADASTRO, VERIFICACAO, CONFIRMACAO 
    }
    
    //Construtor Primario!
    public notificacao (JFrame owner, String titulo, tipodeDialogo tipagem, String mensagem) {
        super(owner, titulo, true); //Associar, Titulo e Modal
        iniciarDialogo(tipagem, mensagem); //Tipo de Dialogo e a mensgaem escr
    }
    
    //Iniciar o JDialog com base no tipo de notificação escolhida
    private void iniciarDialogo(tipodeDialogo tipagem, String mensagem){
        setLayout(new BorderLayout());
        JPanel mainPainel = new JPanel(); 
        mainPainel.setLayout(new BoxLayout(mainPainel, BoxLayout.Y_AXIS));
        
        //Mensagem personalizada
        JLabel mensagemLabel = new JLabel(mensagem, SwingConstants.CENTER);
        mensagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPainel.add(mensagemLabel);
        
        switch (tipagem) {
            case CADASTRO -> addConfirmarButtons(mainPainel);
            case VERIFICACAO -> addErrorButtons(mainPainel);
            case CONFIRMACAO -> addFecharButtons(mainPainel);
        }
        add(mainPainel, BorderLayout.CENTER);
        
        //Ajustar tamanho e exibição
        setPreferredSize(new Dimension(400, 200)); //Ajuste do Tamanho
        pack();
        setLocationRelativeTo(getOwner());
    }
    
    //Botoes de confirmação para o cadastro.
    private void addConfirmarButtons(JPanel painel) {
        JPanel botaoPainel = new JPanel(new FlowLayout());
        JButton simBotao = new JButton("Sim");
        JButton naoBotao = new JButton("Não");
        
        simBotao.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Ação confirmada!");
            dispose(); //Fecha por confirmação
        });
        
        naoBotao.addActionListener(e -> dispose());
        
        botaoPainel.add(simBotao);
        botaoPainel.add(naoBotao);
        painel.add(botaoPainel);
    }
    
    //Botâo de confirmação da Verificação
    private void addErrorButtons(JPanel painel) {
        JButton okBotao = new JButton("OK");
        okBotao.addActionListener(e -> dispose());
        painel.add(okBotao);
    }
    
    //Botâo de confirmação da COnfirmação
    private void addFecharButtons(JPanel painel) {
        JButton fecharBotao = new JButton("Fechar");
        fecharBotao.addActionListener(e -> dispose());
        painel.add(fecharBotao);
    }
    
}
