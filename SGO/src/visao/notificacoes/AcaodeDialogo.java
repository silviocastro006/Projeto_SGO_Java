/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao.notificacoes;


import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @cleber
 */
public class AcaodeDialogo {
    
    //Método estatico para alterar a mensagem
    public static void alterarMensagem (JTextPane txtPane, String novaMensagem){
        if (txtPane != null) {
            try { 
                StyledDocument doc = txtPane.getStyledDocument();
                doc.remove(0, doc.getLength());
                doc.insertString(0, novaMensagem, null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O JTextPane é nulo. ");
        }
    
    }
}