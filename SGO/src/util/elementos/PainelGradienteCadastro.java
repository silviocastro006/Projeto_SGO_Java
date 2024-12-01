package util.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import javax.swing.JPanel;

public class PainelGradienteCadastro extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast para Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Definir os pontos de cores
        float[] fractions = {0.0f, 0.1f, 1.0f};  // Posições das cores no gradiente
        Color[] colors = {Color.decode("#ffffff"), Color.decode("#ffffff"), Color.decode("#ededed")};  // Cores do gradiente

        // Criar o gradiente de 3 cores da esquerda para a direita
        LinearGradientPaint gradient = new LinearGradientPaint(0, 0, getWidth(), 0, fractions, colors);

        // Definir o gradiente como a pintura
        g2d.setPaint(gradient);

        // Preencher o painel com o gradiente
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
