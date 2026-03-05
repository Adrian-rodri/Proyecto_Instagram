package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
public class PanelPerfil extends MenuBase {
    User user;
    GestorFollowers gestorFollower;
    PanelPerfil(User user){
    this.user=user;
    gestorFollower= new GestorFollowers(user);
    }
    @Override
    public void cargarComponentes() {
        String ruta="";
        /*
        Foto
        */
        FotoCircular foto= new FotoCircular(ruta,user);
        foto.setBounds(200, 100, 150,150);
        /*
        Boton ocnfiguraciom
        */
        JButton btnConfig= new JButton("⚙️");
        btnConfig.setFont(new Font("Sans_seriff", Font.BOLD, 24));
        btnConfig.setBounds(510,108,80,80);
        btnConfig.setBorderPainted(false);
        btnConfig.setMargin(new Insets(0,0,0,0));
        btnConfig.setContentAreaFilled(false);
        /*
        Tiulo username
        */
        JLabel tUser= new JLabel(user.getUserName());
        tUser.setBounds(375,130,150,30);
        tUser.setFont(new Font("SANS_SERIF",Font.BOLD,30));
        
        /*
        Titulo nombre
        */
        JLabel tName= new JLabel(user.getNombre());
        tName.setBounds(375,160,300,30);
        tName.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        /*
        Boton editar perfil
        */
        JButton btnEdit= new JButton("Edit Profile");
        btnEdit.setBounds(200,270,300,30);
        btnEdit.setBorderPainted(false);
        btnEdit.setBackground(new Color(0xe6e6e6));
        /*
        Btn archivados
        */
        JButton btnArch= new JButton("View Archive");
        btnArch.setBounds(530,270,300,30);
        btnArch.setBorderPainted(false);
        btnArch.setBackground(new Color(0xe6e6e6));
        /*
        Boton Followers
        */
        JButton btnFollowers= new JButton(gestorFollower.getFollowers().size()+ " Followers");
        btnFollowers.setBounds(360,190,100,30);
        btnFollowers.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        btnFollowers.setBorderPainted(false);
        btnFollowers.setMargin(new Insets(0,0,0,0));
        btnFollowers.setContentAreaFilled(false);
        /*
        Boton following
        */
        JButton btnFollowing= new JButton(gestorFollower.getFollowing().size()+ " Following");
        btnFollowing.setBounds(450,190,100,30);
        btnFollowing.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        btnFollowing.setBorderPainted(false);
        btnFollowing.setMargin(new Insets(0,0,0,0));
        btnFollowing.setContentAreaFilled(false);
        /*
        Add todo
        */
        add(btnFollowing);
        add(btnFollowers);
        add(btnArch);
        add(btnEdit);
        add(btnConfig);
        add(tName);
        add(tUser);
        add(foto);
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
