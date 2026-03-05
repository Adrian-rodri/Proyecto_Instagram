package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
public class PanelInbox extends MenuBase{

    @Override
    public void cargarComponentes() {
        JLabel titulo= new JLabel("Inbox");
        titulo.setBounds(0,0,100,100);
        titulo.setForeground(Color.red);
        titulo.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        add(titulo);
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
