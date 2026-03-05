package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.awt.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;
public class MenuRegistro extends MenuBase{
    Font font= new Font("SANS_SERIF",Font.PLAIN,15);
    GestorUsuarios gestorUser= new GestorUsuarios();
    @Override
    public void cargarComponentes() {
        /*
        Titulo
        */
        JLabel titulo=new JLabel("Instagram");
        titulo.setForeground(Color.black);
        titulo.setVisible(true);
        titulo.setBounds(75,10,300,60);
        titulo.setFont(new Font("Brush Script MT",Font.PLAIN,60));
        /*
        Texto error
        */
        JLabel error = new JLabel();
        error.setForeground(Color.red);
        error.setFont(new Font("SANS_SERIF",Font.PLAIN,10));
        error.setBounds(50,100,500,20);
        /*
        Text field de nombre
        */
        
        TextFieldTextoFantasma txtName= new  TextFieldTextoFantasma("Nombre Completo");
        txtName.setBounds(50,120,250,40);
        Border linea = BorderFactory.createLineBorder(Color.BLACK);
        txtName.setBorder(linea);
        txtName.setFont(font);
        
        /*
        Text field de username
        */
        
        TextFieldTextoFantasma txtUser= new  TextFieldTextoFantasma("User unico");
        txtUser.setBounds(50,208,250,40);
        txtUser.setBorder(linea);
        txtUser.setFont(font);
        /*
        Elegir genero
        */
        String[] opcionesGenero= {"Genero","MASCULINO","FEMENINO"};
        JComboBox<String> combGenero= new JComboBox<>(opcionesGenero);
        combGenero.setBounds(50,164,250,40);
        combGenero.setBorder(linea);
        combGenero.setFont(font);
        /*
        Tect field contrasena
        */
        TextFieldTextoFantasma txtContra= new TextFieldTextoFantasma("Contraseña");
        txtContra.setBounds(50,252, 250,40);
        txtContra.setBorder(linea);
        txtContra.setFont(font);
        /*
        Text field confirmar contrasena
        */
        TextFieldTextoFantasma txtConfirm= new TextFieldTextoFantasma("Confirmar Contraseña");
        txtConfirm.setBounds(50,296, 250,40);
        txtConfirm.setBorder(linea);
        txtConfirm.setFont(font);
        /*
        Spiner Fecha de nacimiento
        */
        SpinnerDateModel model=new SpinnerDateModel();
        JSpinner spinnerFecha= new JSpinner(model);
        JSpinner.DateEditor editor= new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
        spinnerFecha.setEditor(editor);
        spinnerFecha.setBounds(50, 340, 250, 40);
        spinnerFecha.setBorder(linea);
        spinnerFecha.setFont(font);
        /*
        Boton guardar usuario
        */
        JButton btnSave= new JButton("Sign Up");
        btnSave.setBounds(55, 384, 240, 30);
        btnSave.setBackground(new Color(0x3A9AFF));
        btnSave.setFont(new Font("SANS_SERIF",Font.BOLD,18));
        btnSave.setForeground(Color.white);
        btnSave.setBorderPainted(false);
        btnSave.addActionListener(e->{
            error.setText("");
            String name= txtName.getText();
            if(name.isEmpty()){
                error.setText("Ingrese su Nombre Completo");
                return;
                        }
            if(combGenero.getSelectedIndex()==0){
                error.setText("Seleccione su Genero");
                return;
            }
            Genero genero= Genero.valueOf(combGenero.getSelectedItem().toString());
            String username=txtUser.getText();
            if(username.isEmpty() || gestorUser.existeUser(username)){
                error.setText("Usuario Invalido");
                return;  
            }
            Date fechaNacimiento=(Date) spinnerFecha.getValue();
            long diferencia= System.currentTimeMillis() - fechaNacimiento.getTime();
            int edad= (int)(diferencia / (1000L * 60 * 60 * 24 * 365));
            if(edad <16){
                error.setText("Debe ser mayor de 16 para usar Instagram");
                return;
            }
            String contra= txtContra.getText();
            if(contra.isEmpty() || contra.length()<8){
                error.setText("Ingrese una Contraseña con 8 o mas caracteres");
                return;
            }
            if(!contra.equals(txtConfirm.getText())){
                error.setText("La contraseña no coincide");
                return;
            }
            UserPublico user= new UserPublico(name,genero,username,contra,edad);
            gestorUser.registrarUser(user);
            this.setVisible(false);
            Container parent=this.getParent();
            parent.removeAll();
            
            MenuLogIn menu= new MenuLogIn();
            menu.setLayout(null);
            menu.setBounds(0,0,parent.getWidth(), parent.getHeight());
            menu.cargarComponentes();
            
            parent.add(menu);
            parent.revalidate();
            parent.repaint();
        
        });
        
        /*
        Boton login
        */
        JButton btnLogin= new JButton("Ya tienes una Cuenta, Log In");
        btnLogin.setBounds(55, 420, 240,30);
        btnLogin.setFont(new Font("SANS_SERIF",Font.PLAIN,13));
        btnLogin.setBackground(new Color(0xF7F4F0));
        btnLogin.setForeground(new Color(0x3A9AFF));
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(e->{
            this.setVisible(false);
            Container parent=this.getParent();
            parent.removeAll();
            
            MenuLogIn menu= new MenuLogIn();
            menu.setLayout(null);
            menu.setBounds(0,0,parent.getWidth(), parent.getHeight());
            menu.cargarComponentes();
            
            parent.add(menu);
            parent.revalidate();
            parent.repaint();
        
        });
        add(error);
        add(btnLogin);
        add(txtConfirm);
        add(btnSave);
        add(spinnerFecha);
        add(txtContra);
        add(combGenero);
        add(txtUser);
        add(txtName);
        add(titulo);
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
