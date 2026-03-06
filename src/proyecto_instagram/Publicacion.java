
package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.io.*;
public class Publicacion  {
    private int codigoUnico;
    private String username;
    private long fecha;
    private String textoContenido;
    private String hashtags;
    private String menciones;
    private String rutaImagen;
    private RandomAccessFile rcode;
    private TipoMultimedia tipoMultimedia;
    
    Publicacion(String username, String texto, String hashtags, String menciones, String ruta, TipoMultimedia tipoMultimedia){
        this.username=username;
        this.textoContenido=texto;
        this.hashtags=hashtags;
        this.menciones=menciones;
        this.rutaImagen=ruta;
        this.fecha=System.currentTimeMillis();
        this.codigoUnico=generarCodigo();
        this.tipoMultimedia=tipoMultimedia;
    }
    Publicacion(int code, String username, long fecha,String texto, String hashtags, String menciones, String ruta, TipoMultimedia tipoMultimedia){
        this.username=username;
        this.textoContenido=texto;
        this.hashtags=hashtags;
        this.menciones=menciones;
        this.rutaImagen=ruta;
        this.fecha=fecha;
        this.codigoUnico=code;
        this.tipoMultimedia=tipoMultimedia;
    }
    private int generarCodigo(){
        int code=0;
        try{
        rcode= new RandomAccessFile("INSTA_RAIZ/" + username+"/contador.ins","rw");
        initCode();
        rcode.seek(0);
        code=rcode.readInt();
        rcode.seek(0);
        rcode.writeInt(code+1);
        }catch(IOException e){
            System.out.println("Error"+ e.getMessage());
        }finally{
            try{
                if(rcode!=null)
                rcode.close();
            }catch (IOException e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
        return code;
    }
    private void initCode()throws IOException{
        if(rcode.length() !=0)
            return;
        rcode.writeInt(0);   
    }

    public String getUsername() {
        return username;
    }

    public long getFecha() {
        return fecha;
    }

    public String getTextoContenido() {
        return textoContenido;
    }

    public String getHashtags() {
        return hashtags;
    }

    public String getMenciones() {
        return menciones;
    }
    public String getRutaImagen(){
        return rutaImagen;
    }
    public int getCodigo(){
        return codigoUnico;
    }
    public String getTipoMultimedia(){
        return tipoMultimedia.name();
    }
    
}
