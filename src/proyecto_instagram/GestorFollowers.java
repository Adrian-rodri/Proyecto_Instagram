package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.util.ArrayList;
import java.io.*;
public class GestorFollowers {
    RandomAccessFile following=null;
    RandomAccessFile followers=null;
    RandomAccessFile raf = null;
    public void seguir(User actual, User otro){
        try{
            following= new RandomAccessFile("INSTA_RAIZ/"+actual.getUserName()+"/following.ins","rw");
            followers= new RandomAccessFile("INSTA_RAIZ/"+otro.getUserName()+"/followers.ins","rw");
            while(following.getFilePointer()< following.length()){
                String username= following.readUTF();
                if(username.equals(otro.getUserName()))
                    return;
            }
            following.seek(following.length());
            following.writeUTF(otro.getUserName());
            
            followers.seek(followers.length());
            followers.writeUTF(actual.getUserName());
        }catch (IOException e){
            System.err.println("Error: "+ e.getMessage());
        }finally{
            try{
                if(following!= null)
                    following.close();
                if(followers != null)
                    followers.close();
            }catch (IOException e){
                System.err.println("Error: "+ e.getMessage());
            }
        }
    }
    public void dejarDeSeguir(User actual,User otro){
        try{
            following= new RandomAccessFile("INSTA_RAIZ/"+actual.getUserName()+"/following.ins","rw");
            followers= new RandomAccessFile("INSTA_RAIZ/"+otro.getUserName()+"/followers.ins","rw");
            following.seek(0);
            followers.seek(0);
            ArrayList<String> arrayFollowing= new ArrayList<>();
            ArrayList<String> arrayFollowers= new ArrayList<>();
            String userFollowing="";
            String userFollowers="";
            while(following.getFilePointer()<following.length()){
                String user=following.readUTF();
                arrayFollowing.add(user);
                if(user.equals(otro.getUserName()))
                    userFollowing=user;
                    
            }
            while(followers.getFilePointer()<followers.length()){
                String user=followers.readUTF();
                arrayFollowers.add(user);
                if(user.equals(actual.getUserName()))
                    userFollowers=user;
            }
            if(!userFollowing.equals("")){
                arrayFollowing.remove(userFollowing);
                arrayFollowers.remove(userFollowers);
            }
            following.setLength(0);
            followers.setLength(0);
            for(String user:arrayFollowing){
                following.writeUTF(user);
            }
            for(String user:arrayFollowers){
                followers.writeUTF(user);
            }
            
            
        }catch(IOException e){
            System.err.println("Error: "+ e.getMessage());
        }finally{
            try{
                if(following!= null)
                    following.close();
                if(followers != null)
                    followers.close();
            }catch (IOException e){
                System.err.println("Error: "+ e.getMessage());
            }
        }
    }
    public boolean SeSiguenMutuamente(User actual, User otro){
        String rutaActual="INSTA_RAIZ/"+actual.getUserName()+"/following.ins";
        String rutaOtro="INSTA_RAIZ/"+otro.getUserName()+"/following.ins";
        return existeEn(rutaActual,otro.getUserName()) && existeEn(rutaOtro,actual.getUserName());
    }
    private boolean existeEn(String ruta,String username){
        try{
        raf= new RandomAccessFile(ruta,"r");
        while(raf.getFilePointer()<raf.length()){
            String user= raf.readUTF();
            if(user.equals(username))
                return true;
        }
        raf.close();
        }catch(IOException e){
            System.err.println("Error"+e.getMessage());
        }finally{
            try{
            if(raf!=null)
            raf.close();
            }catch(IOException e){
                System.err.println("Error: "+ e.getMessage());
            }
        
        }
        return false;
    }
    public ArrayList<String> getFollowers(User actual){
        ArrayList<String> arrayFollowers= new ArrayList<>();
    
        try{
        raf= new RandomAccessFile("INSTA_RAIZ/"+actual.getUserName()+"/followers.ins","r");
        while(raf.getFilePointer()<raf.length()){
            arrayFollowers.add(raf.readUTF());
        }
        }catch(IOException e){
            System.err.println("Error: "+ e.getMessage());
        }finally{
            try{
            if(raf!=null)
            raf.close();
            }catch(IOException e){
                System.err.println("Error: "+ e.getMessage());
            }
        
        }
        
        return arrayFollowers;
    }
    public ArrayList<String> getFollowing(User actual){
        ArrayList<String> arrayFollowing= new ArrayList<>();
    
        try{
        raf= new RandomAccessFile("INSTA_RAIZ/"+actual.getUserName()+"/following.ins","r");
        while(raf.getFilePointer()<raf.length()){
            arrayFollowing.add(raf.readUTF());
        }
        }catch(IOException e){
            System.err.println("Error: "+ e.getMessage());
        }finally{
            try{
            if(raf!=null)
            raf.close();
            }catch(IOException e){
                System.err.println("Error: "+ e.getMessage());
            }
        
        }
        
        return arrayFollowing;
    }
    
}
