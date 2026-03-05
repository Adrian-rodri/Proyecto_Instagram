package proyecto_instagram;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
public class PanelCrear extends MenuBase{

    @Override
    public void cargarComponentes() {
        JLabel titulo= new JLabel("Menu Crear");
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
