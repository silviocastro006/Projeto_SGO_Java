package util.elementos;

import javax.swing.*;
import java.awt.*;

public class PainelRedondo extends JPanel {
    private int cornerRadius;

    public PainelRedondo() {
        this(30); // Raio padrão
    }

    public PainelRedondo(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false); // Para respeitar o formato arredondado
    }

    public int getRaio() {
        return cornerRadius;
    }

    public void setRaio(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint(); // Redesenha após a alteração
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        // Suavização
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define a cor de fundo
        g2.setColor(getBackground());

        // Desenha o painel arredondado
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        g2.dispose();
    }
}
