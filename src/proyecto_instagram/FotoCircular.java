package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;

public class FotoCircular extends JPanel{
    private Image image;
    private User user;
    private String ruta;
    
    FotoCircular(String ruta, User user){
        this.setBackground(new Color(0xFFFFFF));
        this.ruta= ruta;
        this.user= user;
        if(!ruta.isEmpty())
            image= new ImageIcon(ruta).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(ruta.isEmpty()){
            // dibujar círculo gris con inicial
            g2.setColor(Color.GRAY);
            g2.fillOval(0, 0, getWidth(), getHeight());
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("SANS_SERIF", Font.BOLD, getWidth()/2));
            g2.drawString(String.valueOf(user.getNombre().charAt(0)), getWidth()/3, getHeight()/2 + 10);
        } else {
            g2.setClip(new java.awt.geom.Ellipse2D.Float(0, 0, getWidth(), getHeight()));
            g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
