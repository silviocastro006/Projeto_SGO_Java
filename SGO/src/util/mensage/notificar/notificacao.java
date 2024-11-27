/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.mensage.notificar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import static java.lang.reflect.Array.get;
import static java.nio.file.Paths.get;
import javax.swing.JPanel;
import static javax.swing.UIManager.get;
import raven.glasspanepopup.GlassPanePopup;

/**
 *
 * @author Pichau
 */
public class notificacao {

    public static class notificar extends JPanel {
        private int borderRadius = 15;
        
        public notificar(){
            setOpaque(false);
            this.setBackground(new Color(0, 0, 0, 0));    
    }
        public void setBackgroundColor(Color color){
            this.setBackground(color);
            repaint();
        }

        public void setBorderRadius(int radius){
            this.borderRadius = radius;
            repaint();
        }
        
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 =(Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(g); 
        }  
    }
    
    public static void mostrarNotificacao(String mensagem, Color corDeFundo) {
        notificar painel = new notificar();
        painel.setBackgroundColor(corDeFundo);
        
        javax.swing.JLabel label = new javax.swing.JLabel(mensagem);
        label.setForeground(Color.WHITE);
        label.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        painel.add(label);
        
        GlassPanePopup.showPopup(painel);
    }
}
