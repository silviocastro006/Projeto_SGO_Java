package util.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import javax.swing.JPanel;

public class PainelGradienteNotificar extends JPanel {
    //Pode ser "erro", "normal" e "sucesso".
    private String tipoNotificacao = "normal";
    
    public void setTipoNotificacao(String tipo) {
        this.tipoNotificacao = tipo;
        repaint(); //Redesenhar o painel quando mudar seu tipo.
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast para Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Definir os pontos de cores
        float[] fractions = {0.0f, 0.1f, 1.0f};  // Posições das cores no gradiente
        Color[] colors; // Cores do gradiente
         
        //Faz a leitura da variavel para efetuar a troca das cores dentro de casa especificação
            colors = switch (tipoNotificacao) {
            case "erro" -> new Color[]{Color.decode("#ffffff"), Color.decode("#ffffff"), Color.decode("#ead3d4")};
            case "sucesso" -> new Color[]{Color.decode("#ffffff"), Color.decode("#ffffff"), Color.decode("#b0caa8")};
            default -> new Color[]{Color.decode("#ffffff"),Color.decode("#ffffff"),Color.decode("#ededed")};
        };
        // Criar o gradiente de 3 cores da esquerda para a direita
        LinearGradientPaint gradient = new LinearGradientPaint(0, 0, getWidth(), 0, fractions, colors);

        // Definir o gradiente como a pintura
        g2d.setPaint(gradient);

        // Preencher o painel com o gradiente
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
