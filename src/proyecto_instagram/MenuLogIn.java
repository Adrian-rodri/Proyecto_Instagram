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
    boolean oculta=true;
    MenuRegistro register;
    GestorUsuarios gestorUsuarios= new GestorUsuarios();
    MenuLogIn(){
    
    }
    @Override
    public void cargarComponentes(){
        /*
        Cuadro de atras
        */
        JPanel n= new JPanel();
        n.setBounds(550,130,350,450);
        n.setVisible(true);
        n.setBackground(new Color(0xFAFAFA));
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
        TextFieldTextoFantasma txtUsuario= new TextFieldTextoFantasma("Usuario");
        txtUsuario.setBackground(new Color(0xFAFAFA));
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
        txtContra.setBackground(new Color(0xFAFAFA));
        txtContra.setForeground(Color.black);
        txtContra.setBounds(50,169,250,49);
        txtContra.setFont(font);
        txtContra.setBorder(BorderFactory.createCompoundBorder(linea, margen));
        /*
        label de error
        */
        JLabel error= new JLabel("");
        error.setForeground(Color.red);
        error.setFont(new Font("SANS_SERIF",Font.PLAIN,10));
        error.setBounds(50, 105,500 , 10);
        /*
        Boton ver Contra
        */
        JButton btnVer=new JButton("👁️");
        btnVer.setBounds(285,169,50,50);
        btnVer.setBorderPainted(false);
        btnVer.setMargin(new Insets(0,0,0,0));
        btnVer.setContentAreaFilled(false);
        btnVer.addActionListener(e->{
            oculta=oculta?false:true;
        if(oculta){
            txtContra.setEchoChar('\u2022');
            btnVer.setText("👁");
  
        }else{
            txtContra.setEchoChar((char)0);
            btnVer.setText("︶");
     
        }
        
        
        });
        /*
        Boton login
        */
        JButton btnLogin= new JButton("Log In");
        btnLogin.setBounds(50,230,250,30);
        btnLogin.setFont(new Font("SANS_SERIF",Font.BOLD,18));
        btnLogin.setBackground(new Color(0x3A9AFF));
        btnLogin.setForeground(Color.white);
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(e->{
            String usuario= txtUsuario.getText();
            error.setText("");
            if(usuario.isEmpty() || !gestorUsuarios.existeUser(usuario)){
                error.setText("El usuario no existe");
                return;
            }
            String contra= new String(txtContra.getPassword());
            User user=gestorUsuarios.login(usuario, contra);
            if(contra.isEmpty()||user==null){
                error.setText("Contraseña Incorrecta");
                return;
            }
            this.setVisible(false);
            Container parent= this.getParent();
            parent.removeAll();
            MenuPrincipal mp= new MenuPrincipal(user);
            mp.setBounds(0,0,1366,768);
            mp.cargarComponentes();
            mp.setVisible(true);
            parent.add(mp);
            parent.revalidate();
            parent.repaint();
        });
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
        btnNewCuenta.setMargin(new Insets(0,0,0,0));
        btnNewCuenta.setContentAreaFilled(false);
        btnNewCuenta.addActionListener(e->{
            this.remove(n);
            register= new MenuRegistro();
            register.setLayout(null);
            register.setBounds(550,130,350,450);
            register.cargarComponentes();
            register.setBackground(new Color(0xFAFAFA));
            register.setVisible(true);
            add(register);
            this.repaint();
            this.revalidate();
        
        });
        /*
        Agregar Componentes
        */
        n.add(error);
        n.add(btnVer);
        n.add(line);
        n.add(btnNewCuenta);
        n.add(btnLogin);
        n.add(txtContra);
        n.add(titulo);
        n.add(txtUsuario);
        n.add(tituloLogin);
        SwingUtilities.invokeLater(() -> {
            n.setFocusable(true);
            n.requestFocusInWindow();
        });

        
        add(n);
    }
    public void refresh(){}
}
