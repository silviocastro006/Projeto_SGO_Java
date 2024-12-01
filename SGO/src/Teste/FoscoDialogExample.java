package Teste;

import javax.swing.*;
import java.awt.*;

public class FoscoDialogExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exemplo de Fundo Fosco");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            JButton showDialogButton = new JButton("Mostrar JDialog");
            showDialogButton.addActionListener(e -> showFoscoDialog(frame));

            frame.add(showDialogButton, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    private static void showFoscoDialog(JFrame parent) {
        // Painel para criar o efeito de fundo fosco
        JPanel glassPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(0, 0, 0, 100)); // Cor preta com transparência (alpha)
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        glassPane.setOpaque(false);

        // Adiciona o efeito no JFrame principal
        parent.setGlassPane(glassPane);
        glassPane.setVisible(true);

        // Cria o JDialog
        JDialog dialog = new JDialog(parent, "JDialog com fundo fosco", true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(parent);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> {
            dialog.dispose();
            glassPane.setVisible(false); // Remove o efeito após o fechamento
        });

        dialog.setLayout(new BorderLayout());
        dialog.add(new JLabel("Conteúdo do JDialog", SwingConstants.CENTER), BorderLayout.CENTER);
        dialog.add(closeButton, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}
