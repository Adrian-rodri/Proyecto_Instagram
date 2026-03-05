package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
public class PanelBuscar extends MenuBase{

    @Override
    public void cargarComponentes() {
        JLabel titulo= new JLabel("Buscar");
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
