package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
public class MenuPrincipal extends MenuBase{
    Font font= new Font("SANS_SERIF",Font.PLAIN,15);
    User user;
    MenuPrincipal(User user){
        this.user=user;
    }
    @Override
    public void cargarComponentes() {
        /*
        Panel Home
        */
        PanelHome pH=  new PanelHome();
        pH.setBounds(200,0,1155,732);
        pH.setBackground(Color.green);
        pH.cargarComponentes();
        /*
        Panel mensajes
        */
        PanelInbox pI= new PanelInbox();
        pI.setBounds(200,0,1155,732);
        pI.setBackground(Color.black);
        pI.cargarComponentes();
        pI.setVisible(false);
        /*
        Panel BUscar
        */
        PanelBuscar pB= new PanelBuscar();
        pB.setBounds(200,0,1155,732);
        pB.setBackground(Color.yellow);
        pB.cargarComponentes();
        pB.setVisible(false);
        /*
        Panel Notificaciones
        */
        PanelNotifications pN= new PanelNotifications();
        pN.setBounds(200,0,1155,732);
        pN.setBackground(Color.gray);
        pN.cargarComponentes();
        pN.setVisible(false);
        /*
        Panel crear
        */
        PanelCrear pC= new PanelCrear(user);
        pC.setBounds(200,0,1155,732);
        pC.cargarComponentes();
        pC.setVisible(false);
        /*
        Panel Perfil
        */
        PanelPerfil pF= new PanelPerfil(user);
        pF.setBounds(200,0,1155,732);
        pF.cargarComponentes();
        pF.setVisible(false);
        /*
        Barra Navegacion
        */
        JPanel navegacion= new JPanel();
        navegacion.setBackground(new Color(0xFAFAFA));
        navegacion.setBounds(0,0,200,700);
        navegacion.setLayout(null);
        /*
        Botones Navegacion
        */
        //Boton Home
        JButton btnHome= new JButton("️🏠 Home");
        btnHome.setBounds(0,100,130,70);
        btnHome.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
        btnHome.setBackground(new Color(0xF7F4F0));
        btnHome.setBorderPainted(false);
        btnHome.setMargin(new Insets(0, 0, 0, 0)); 
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(e->{
            pH.setVisible(true);
            pI.setVisible(false);
            pC.setVisible(false);
            pB.setVisible(false);
            pF.setVisible(false);
            pN.setVisible(false);
        });
        //Boton mensaje
        JButton btnMsg= new JButton("💬 Inbox");
        btnMsg.setBounds(0,150,130,70);
        btnMsg.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
        btnMsg.setBackground(new Color(0xF7F4F0));
        btnMsg.setBorderPainted(false);
        btnMsg.setMargin(new Insets(0,0,0,0));
        btnMsg.setContentAreaFilled(false);
        btnMsg.addActionListener(e->{
            pH.setVisible(false);
            pI.setVisible(true);
            pC.setVisible(false);
            pB.setVisible(false);
            pF.setVisible(false);
            pN.setVisible(false);
        });
        //Boton Buscar
        JButton btnSearch= new JButton("🔎 Search");
        btnSearch.setBounds(0,200,130,70);
        btnSearch.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
        btnSearch.setBackground(new Color(0xF7F4F0));
        btnSearch.setBorderPainted(false);
        btnSearch.setMargin(new Insets(0,0,0,0));
        btnSearch.setContentAreaFilled(false);
        btnSearch.addActionListener(e->{
            pH.setVisible(false);
            pI.setVisible(false);
            pC.setVisible(false);
            pB.setVisible(true);
            pF.setVisible(false);
            pN.setVisible(false);
        });
        //Boton notificaciones
        JButton btnNotis= new JButton("❤ Notifications️");
        btnNotis.setBounds(-1,250,240,80);
        btnNotis.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
        btnNotis.setBackground(new Color(0xF7F4F0));
        btnNotis.setBorderPainted(false);
        btnNotis.setMargin(new Insets(0,0,0,0));
        btnNotis.setContentAreaFilled(false);
        btnNotis.addActionListener(e->{
            pH.setVisible(false);
            pI.setVisible(false);
            pC.setVisible(false);
            pB.setVisible(false);
            pF.setVisible(false);
            pN.setVisible(true);
        });
        //Boton Perfil
        JButton btnPerfil= new JButton("👦 Profile");
        if(user.getGenero()==Genero.FEMENINO)
            btnPerfil.setText("👧 Profile");
        btnPerfil.setBounds(0,400,130,80);
        btnPerfil.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
        btnPerfil.setBackground(new Color(0xF7F4F0));
        btnPerfil.setBorderPainted(false);
        btnPerfil.setMargin(new Insets(0,0,0,0));
        btnPerfil.setContentAreaFilled(false);
        btnPerfil.addActionListener(e->{
            pF.refresh();
            pH.setVisible(false);
            pI.setVisible(false);
            pC.setVisible(false);
            pB.setVisible(false);
            pF.setVisible(true);
            pN.setVisible(false);
        });
        //Boton create
        JButton btnCrear= new JButton("➕ Create");
        btnCrear.setBounds(-0,300,130,80);
        btnCrear.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
        btnCrear.setBackground(new Color(0xF7F4F0));
        btnCrear.setBorderPainted(false);
        btnCrear.setMargin(new Insets(0,0,0,0));
        btnCrear.setContentAreaFilled(false);
        btnCrear.addActionListener(e->{
            pH.setVisible(false);
            pI.setVisible(false);
            pC.setVisible(true);
            pB.setVisible(false);
            pF.setVisible(false);
            pN.setVisible(false);
        });
        
        /*
        Add todo a navegacion
        */
        
        navegacion.add(btnCrear);
        navegacion.add(btnPerfil);
        navegacion.add(btnNotis);
        navegacion.add(btnSearch);
        navegacion.add(btnMsg);
        navegacion.add(btnHome);
        
        
        /*
        Add todo
        */
        add(pF);
        add(pC);
        add(pN);
        add(pB);
        add(pI);
        add(pH);
        add(navegacion);
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
