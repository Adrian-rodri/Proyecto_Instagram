package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
public class MenuPrincipal extends MenuBase{
    Font font= new Font("SANS_SERIF",Font.PLAIN,15);
    @Override
    public void cargarComponentes() {
        JLabel titulo= new JLabel("Probando ando");
        titulo.setBounds(10,100,100,100);
        titulo.setForeground(Color.red);
        titulo.setFont(font);
        add(titulo);
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
