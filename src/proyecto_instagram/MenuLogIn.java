package proyecto_instagram;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
public class MenuLogIn extends MenuBase{
    Font font= new Font("SANS_SERIF",Font.PLAIN,15);
    MenuLogIn(){
    
    }
    public void cargarComponentes(){
        /*
        Cuadro de atras
        */
        JPanel n= new JPanel();
        n.setBounds(550,130,350,450);
        n.setVisible(true);
        n.setBackground(new Color(0xF7F4F0));
        n.setLayout( null);
        /*
        titulo
        */
        JLabel titulo=new JLabel("Instagram");
        titulo.setForeground(Color.black);
        titulo.setVisible(true);
        titulo.setBounds(75,10,300,60);
        titulo.setFont(new Font("Brush Script MT",Font.PLAIN,60));
        /*
        Login titulo
        */
        JLabel tituloLogin= new JLabel("Log into Instagram");
        tituloLogin.setForeground(Color.red);
        tituloLogin.setBounds(50,120,300,30);
        tituloLogin.setFont(font);
        tituloLogin.setVisible(false);
        /*
        Area de texto usuario
        */
        JTextField txtUsuario= new JTextField();
        txtUsuario.setBackground(new Color(0xF6F5F2));
        txtUsuario.setForeground(Color.black);
        txtUsuario.setBounds(50,120,250,50);
        txtUsuario.setFont(font);
        Border linea = BorderFactory.createLineBorder(Color.BLACK);
        Border margen = BorderFactory.createEmptyBorder(1, 10, 0, 0); 
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        /*
        Area de texto contra
        */
        JPasswordField txtContra= new JPasswordField();
        txtContra.setSize(300,40);
        txtContra.setBackground(new Color(0xF6F5F2));
        txtContra.setForeground(Color.black);
        txtContra.setBounds(50,169,250,49);
        txtContra.setFont(font);
        txtContra.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        txtContra.setEchoChar((char)0);
        /*
        Boton ver Contra
        */
        JButton btnVer=new JButton("👁️");
        btnVer.setBounds(300,169,50,50);
        /*
        Boton login
        */
        JButton btnLogin= new JButton("Log In");
        btnLogin.setBounds(50,230,250,30);
        btnLogin.setFont(font);
        btnLogin.setBackground(new Color(0x3A9AFF));
        btnLogin.setForeground(Color.white);
        /*
        Linea de separacion (O)
        */
        JLabel line= new JLabel("—————————O/U—————————");
        line.setBounds(50,290,250,30);
        /*
        Boton crear cuenta
        */
        JButton btnNewCuenta= new JButton("Registrarse en Instagram");
        btnNewCuenta.setBounds(50,320,250,30);
        btnNewCuenta.setFont(font);
        btnNewCuenta.setBackground(new Color(0xF7F4F0));
        btnNewCuenta.setForeground(new Color(0x3A9AFF));
        btnNewCuenta.setBorderPainted(false);
        
        /*
        Agregar Componentes
        */
        n.add(btnVer);
        n.add(line);
        n.add(btnNewCuenta);
        n.add(btnLogin);
        n.add(txtContra);
        n.add(titulo);
        n.add(tituloLogin);
        n.add(txtUsuario);
        add(n);
    }
    public void refresh(){}
}
