package proyecto_instagram;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
public class Gui extends JFrame {
    Color bgr= Color.WHITE;
    Font font= new Font("SANS_SERIF",Font.PLAIN,16);
    JPanel navegacion= new JPanel(new FlowLayout());
    MenuLogIn menuLogin= new MenuLogIn();
    
    Gui(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setSize(1366,768);
    this.setResizable(false);
    
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.getContentPane().setBackground(bgr);
    
    //Componentes
    
    
    navegacion.setBackground(bgr);
    menuLogin.setBounds(0,0,1366,768);
    //Add
    menuLogin.cargarComponentes();
    add(menuLogin);
    add(navegacion);
    
    
    
    
    
    
    
    
    
    
    this.setVisible(true);
}
}
