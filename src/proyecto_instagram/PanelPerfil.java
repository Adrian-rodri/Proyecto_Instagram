package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
public class PanelPerfil extends MenuBase {
    User user;
    GestorFollowers gestorFollower;
    GestorPublicaciones gestorPosts;
    JPanel grid=null;
    int indexPosts=0;
    JLabel lblPosts=null;
    PanelPerfil(User user){
    this.user=user;
    gestorFollower= new GestorFollowers(user);
    gestorPosts= new GestorPublicaciones(user);
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
        btnFollowers.setBounds(425,190,100,30);
        btnFollowers.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        btnFollowers.setBorderPainted(false);
        btnFollowers.setMargin(new Insets(0,0,0,0));
        btnFollowers.setContentAreaFilled(false);
        /*
        Boton following
        */
        JButton btnFollowing= new JButton(gestorFollower.getFollowing().size()+ " Following");
        btnFollowing.setBounds(515,190,100,30);
        btnFollowing.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        btnFollowing.setBorderPainted(false);
        btnFollowing.setMargin(new Insets(0,0,0,0));
        btnFollowing.setContentAreaFilled(false);
        /*
        publicaciones
        */
        //panel con scroll
        grid= new JPanel(new GridLayout(0,3,2,2));
        grid.setLayout(new GridLayout(0,3,5,5));
        grid.setBackground(new Color(0xFFFFFF));
        grid.setBorder(null);
        JScrollPane scrollPanel= new JScrollPane(grid);
        scrollPanel.setBounds(50,320,1052,412);
        scrollPanel.setBackground(new Color(0xFFFFFFF));
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setBorder(null);
        scrollPanel.setViewportBorder(null);
        scrollPanel.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPanel.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        /*
        Label posts
        */
        lblPosts= new JLabel(indexPosts+" Posts");
        lblPosts.setBounds(375,190,100,30);
        lblPosts.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        cargarPosts();
        /*
        Add todo
        */
        add(lblPosts);
        add(scrollPanel);
        add(btnFollowing);
        add(btnFollowers);
        add(btnArch);
        add(btnEdit);
        add(btnConfig);
        add(tName);
        add(tUser);
        add(foto);
    }
    public void cargarPosts(){
        indexPosts=0;
        grid.removeAll();
        ArrayList<Publicacion> lista= gestorPosts.getPublicaciones(user);
        gestorPosts.ordenarPosts(lista,lista.size());
        for(Publicacion l:lista){
            JButton btnPost= new JButton();
            ImageIcon imagen= new ImageIcon(l.getRutaImagen());
            Image imgScale= imagen.getImage().getScaledInstance(340,400, Image.SCALE_SMOOTH);
            btnPost.setIcon(new ImageIcon(imgScale));
            btnPost.setPreferredSize(new Dimension(340,400));
            btnPost.setBorderPainted(false);
            btnPost.setMargin(new Insets(0,0,0,0));
            btnPost.setContentAreaFilled(false);
            grid.add(btnPost);
            indexPosts++;
        }
        lblPosts.setText(indexPosts+" Posts");
        grid.revalidate();     
        grid.repaint();
    }

    @Override
    public void refresh() {
        cargarPosts();
    }

    
    
}
