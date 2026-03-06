package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.io.*;
import java.util.ArrayList;
public class GestorPublicaciones implements Publicable{
    /*
        1. writeInt(code)
        2. writeUTF(username)
        3. writeLong(fecha)
        4. writeUTF(textoContenido)
        5. writeUTF(hashtags)
        6. writeUTF(menciones)
        7. writeUTF(rutaImagen)
        8. writeUTF(tipoCuenta);
    */
    User actual;
    RandomAccessFile post=null;
    GestorPublicaciones(User user){
        this.actual=user;
    }
    @Override
    public void publicar(Publicacion publicacion){
    try{
        post= new RandomAccessFile("INSTA_RAIZ/" + actual.getUserName()+"/insta.ins","rw");
        post.seek(post.length());
        post.writeInt(publicacion.getCodigo());
        post.writeUTF(publicacion.getUsername());
        post.writeLong(publicacion.getFecha());
        post.writeUTF(publicacion.getTextoContenido());
        post.writeUTF(publicacion.getHashtags());
        post.writeUTF(publicacion.getMenciones());
        post.writeUTF(publicacion.getRutaImagen());
        post.writeUTF(publicacion.getTipoMultimedia());
    }catch(IOException e){
        System.out.println("Error: "+ e.getMessage());
    }finally{
        try{
            if(post!=null)
                post.close();
        }catch(IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    }
    @Override
    public void eliminarPublicacion(Publicacion publicacion){
        ArrayList<Publicacion> arrayPubli= new ArrayList<>();
        int index=-1;
        try{
            post= new RandomAccessFile("INSTA_RAIZ/" + actual.getUserName()+"/insta.ins","rw");
            post.seek(0);
            int i=0;
            while(post.getFilePointer()<post.length()){
                int code= post.readInt();
                String user= post.readUTF();
                long fecha= post.readLong();
                String texto= post.readUTF();
                String hashtags= post.readUTF();
                String menciones= post.readUTF();
                String ruta= post.readUTF();
                TipoMultimedia tipo= TipoMultimedia.valueOf(post.readUTF());
                Publicacion nuevaPubli= new Publicacion(code,user,fecha,texto,hashtags,menciones,ruta,tipo);
                arrayPubli.add(nuevaPubli);
                if(code==publicacion.getCodigo())
                    index=i;
                i++;
            }
            if(index==-1)
                return;
            arrayPubli.remove(index);
            post.setLength(0);
            for(Publicacion p: arrayPubli){
                post.writeInt(p.getCodigo());
                post.writeUTF(p.getUsername());
                post.writeLong(p.getFecha());
                post.writeUTF(p.getTextoContenido());
                post.writeUTF(p.getHashtags());
                post.writeUTF(p.getMenciones());
                post.writeUTF(p.getRutaImagen());
                post.writeUTF(p.getTipoMultimedia());
            }
            
        }catch(IOException e){
            System.out.println("Error: "+ e.getMessage());
        }finally{
            try{
                if(post!=null)
                    post.close();
            }catch(IOException e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }
    public ArrayList<Publicacion> getPublicaciones(User actual){
        ArrayList<Publicacion> arrayPubli= new ArrayList<>();
        try{
            post= new RandomAccessFile("INSTA_RAIZ/" + actual.getUserName()+"/insta.ins","r");
            post.seek(0);
            while(post.getFilePointer()<post.length()){
                int code= post.readInt();
                String user= post.readUTF();
                long fecha= post.readLong();
                String texto= post.readUTF();
                String hashtags= post.readUTF();
                String menciones= post.readUTF();
                String ruta= post.readUTF();
                TipoMultimedia tipo= TipoMultimedia.valueOf(post.readUTF());
                Publicacion nuevaPubli= new Publicacion(code,user,fecha,texto,hashtags,menciones,ruta,tipo);
                arrayPubli.add(nuevaPubli);
            }
        }catch(IOException e){
            System.out.println("Error: "+ e.getMessage());
        }finally{
            try{
                if(post!=null)
                post.close();
            }catch(IOException e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
        return arrayPubli;
    }
    public ArrayList<Publicacion> getFeed(){
        ArrayList<Publicacion> feed=getPublicaciones(actual);
        
        GestorUsuarios gestorU= new GestorUsuarios();
        GestorFollowers gestorF= new GestorFollowers(actual);
        
        ArrayList<String> following= gestorF.getFollowing();
        
        for(String username: following){
            User u= gestorU.buscarUser(username);
            if(u != null && u.isEstadoActivo()){
                feed.addAll(getPublicaciones(u));
            }
    }
        ordenarPosts(feed, feed.size());
        return feed;
    }
    public void ordenarPosts(ArrayList<Publicacion> lista, int n){
    if(n<= 1)
        return;
    ordenarPosts(lista, n - 1);
    
    Publicacion ultimo= lista.get(n - 1);
    int j=n - 2;
    while(j>=0&&lista.get(j).getFecha() < ultimo.getFecha()){
        lista.set(j+1,lista.get(j));
        j--;
    }
    lista.set(j + 1, ultimo);
    }

    
        
    
}
