package proyecto_instagram;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.nio.file.*;
import java.io.File;
import java.io.IOException;
public class PanelCrear extends MenuBase{
    GestorPublicaciones gestorPosts;
    JPanel dropZone;
    JLabel lblImagen;
    String rutaSencilla;
    String ruta;
    User user;
    PanelCrear(User user){
        this.user=user;
        gestorPosts= new GestorPublicaciones(user);
    }
    @Override
    public void cargarComponentes() {
        /*
        Zona drag and drop
        */
        dropZone = new JPanel();
        dropZone.setBorder(BorderFactory.createDashedBorder(Color.black));
        dropZone.setBackground(new Color(0xFAFAFA));
        dropZone.setBounds(50, 50, 300, 300);
        dropZone.setLayout(null);
        JLabel extra= new JLabel("an Image");
        extra.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        extra.setBounds(85,70,200,200);
        lblImagen= new JLabel("Drag and Drop");
        lblImagen.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        lblImagen.setBounds(60,100,300,40);
        dropZone.add(extra);
        dropZone.add(lblImagen);
        dropZone.setTransferHandler(new TransferHandler(){
            @Override
            public boolean canImport(TransferHandler.TransferSupport support){
                return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
            }

            @Override
            public boolean importData(TransferHandler.TransferSupport support){
                try{
                    java.util.List<File> archivos=(java.util.List<File>)
                            support.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    File imagen= archivos.get(0);
                    ruta= imagen.getAbsolutePath();
                    rutaSencilla= imagen.getName();
                    ImageIcon iconOriginal= new ImageIcon(ruta);
                    Image imgRedimensionada= iconOriginal.getImage()
                    .getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon iconFinal= new ImageIcon(imgRedimensionada);
                    dropZone.remove(extra);
                    lblImagen.setBounds(0,0,300,300);
                    lblImagen.setIcon(iconFinal);
                    lblImagen.setText("");
                    dropZone.repaint();
                    dropZone.revalidate();
                    
                    return true;
                }catch(UnsupportedFlavorException | IOException e){
                    return false;
                }
            }
        });
        /*
        lbl error
        */
        JLabel error= new JLabel("");
        error.setForeground(Color.red);
        error.setBounds(50,350,300,30);
        /*
        text area textoContenido
        */
        JTextArea txtContent=new JTextArea();
        txtContent.setLineWrap(true);
        txtContent.setBounds(50,400,400,100);
        txtContent.setBackground(new Color(0xFAFAFA));
        txtContent.setBorder(BorderFactory.createDashedBorder(Color.black));
        txtContent.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        /*
        text area hashtags
        */
        JTextArea txtHashtags= new JTextArea();
        txtHashtags.setLineWrap(true);
        txtHashtags.setBounds(500,400,400,70);
        txtHashtags.setBackground(new Color(0xFAFAFA));
        txtHashtags.setBorder(BorderFactory.createDashedBorder(Color.black));
        txtHashtags.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        /*
        text area menciones
        */
        JTextArea txtMenciones= new JTextArea();
        txtMenciones.setLineWrap(true);
        txtMenciones.setBounds(50,530,400,70);
        txtMenciones.setBackground(new Color(0xFAFAFA));
        txtMenciones.setBorder(BorderFactory.createDashedBorder(Color.black));
        txtMenciones.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        /*
        Boton publicar
        */
        JButton btnPost= new JButton("Publicar");
        btnPost.setBounds(700,560,200,40);
        btnPost.setFont(new Font("SANS_SERIF",Font.BOLD,30));
        btnPost.setBackground(new Color(0x3A9AFF));
        btnPost.setForeground(Color.white);
        btnPost.setBorderPainted(false);
        btnPost.addActionListener(e->{
            error.setForeground(Color.red);
            error.setText("");
            String texto= txtContent.getText();
            if(rutaSencilla==null){
                error.setText("Agregue una imagen para continuar");
                return;
            }
            if(texto.length()>220){
                error.setText("Su texto sobre pasa los 220 caracteres: "+texto.length()+" Chars");
                return;
            }
            try{
            Path origen = Paths.get(ruta);
            Path destinoCarpeta = Paths.get("INSTA_RAIZ", user.getUserName(), "imagenes");
            Path destinoFinal = destinoCarpeta.resolve(rutaSencilla);
            Files.createDirectories(destinoCarpeta);
            Files.copy(origen, destinoFinal, StandardCopyOption.REPLACE_EXISTING);
            
            }catch(IOException ex){
                error.setText("Error al guardar la imagen: " + ex.getMessage());
                return;
            }
            String path= "INSTA_RAIZ/" + user.getUserName()+"/imagenes/"+rutaSencilla;
            String hashtags= txtHashtags.getText();
            String menciones= txtMenciones.getText();
            TipoMultimedia tipo= TipoMultimedia.FOTO;
            Publicacion newPost= new Publicacion(user.getUserName(),texto,hashtags,menciones,path,tipo);
            gestorPosts.publicar(newPost);
            error.setForeground(Color.green);
            error.setText("¡Publicación exitosa!");
            txtContent.setText("");
            txtHashtags.setText("");
            txtMenciones.setText("");
            ruta=null;
            rutaSencilla=null;
            lblImagen.setText("Drag and Drop");
            lblImagen.setIcon(null);
            lblImagen.setBounds(60,100,300,40);
            dropZone.add(extra);
            
            
        });
        /*
        Add todo
        */
        add(error);
        add(txtMenciones);
        add(btnPost);
        add(txtHashtags);
        add(txtContent);
        add(dropZone);
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
