/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.elementos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Pichau
 */
public class BotaoPrincipal extends JButton{

    private boolean mousePress;
    private boolean mouseOver;
    
    public BotaoPrincipal() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(7, 5, 7, 6));
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    mousePress=true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    mousePress=false;
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // Quando o mouse entra, muda a cor para 8, 0, 50
                mouseOver = true;
                repaint(); // Repaint the button to apply the color change
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Quando o mouse sai, volta para a cor original
                mouseOver = false;
                repaint(); // Repaint the button to revert the color
            }
            
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (mousePress) {
            g2.setColor(getBackground().darker());
        } else if (mouseOver){
             g2.setColor(new java.awt.Color(8, 0, 50));
        } else{
            g2.setColor(getBackground());
        }
       
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getHeight()));
        g2.dispose();

        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
        
    
}
