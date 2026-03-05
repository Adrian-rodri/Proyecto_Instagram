package proyecto_instagram;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
public class PanelNotifications extends MenuBase{
    

    public void cargarComponentes() {
        JLabel titulo= new JLabel("Menu Notificaciones");
        titulo.setBounds(0,0,300,300);
        titulo.setForeground(Color.red);
        titulo.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        add(titulo);
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
