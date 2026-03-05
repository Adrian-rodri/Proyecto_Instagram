package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
public class PanelHome extends MenuBase{

    @Override
    public void cargarComponentes() {
       JLabel titulo= new JLabel("Menu principal");
       titulo.setForeground(Color.red);
       titulo.setFont(new Font("SANS_SERIF",Font.PLAIN,45));
       titulo.setBounds(0,0,100,100);
       add(titulo);
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
