
package testes;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Fontes {
    public static void main(String[] args) {
        try {
            // Carrega a fonte Open Sans (negrito)
            Font openSansRegular = Font.createFont(Font.TRUETYPE_FONT, new File("src/util/Fontes/OpenSans-Regular.ttf"));
            openSansRegular = openSansRegular.deriveFont(Font.BOLD, 24);  // Define o tamanho e o estilo
           
            // Registra a fonte no sistema (opcional, mas útil para que ela seja reconhecida globalmente)
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(openSansRegular);
            
            // Testa aplicando a fonte em um JLabel
            JLabel label = new JLabel("Texto com Open Sans regular");
            label.setFont(openSansRegular);
            JOptionPane.showMessageDialog(null, label);
            
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}