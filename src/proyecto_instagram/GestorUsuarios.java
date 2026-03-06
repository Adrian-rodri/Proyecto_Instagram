package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.io.*;
import java.util.ArrayList;
public class GestorUsuarios {
    /*
    1. writeUTF(nombre)
    2. writeUTF(genero.toString())
    3. writeUTF(userName)
    4. writeUTF(password)
    5. writeUTF(rutaFoto)
    6. writeUTF(tipoCuenta.toString())
    7. writeLong(fechaCreacion)
    8. writeInt(edad)
    9. writeBoolean(estadoActivo)
    */
    RandomAccessFile users=null;
    public void registrarUser(User actual){
        try{
            new File("INSTA_RAIZ").mkdirs();
            new File("INSTA_RAIZ/users.ins").createNewFile();
            users = new RandomAccessFile("INSTA_RAIZ/users.ins", "rw");
            users.seek(users.length());
            writeUser(actual);
            crearFolderConFiles(actual);
        }catch(IOException e){
            System.err.println("Error: "+ e.getMessage());
        }finally{
        try{
            users.close();
        }catch(IOException e){
            System.err.println("Error: "+ e.getMessage());
        }
        }
    }
    public User login(String username, String password){
        User usuario= buscarUser(username);
        if(usuario !=null && usuario.isEstadoActivo() && usuario.getPassword().equals(password)){
            try {
                crearFolderConFiles(usuario);
                return usuario;
            } catch (IOException ex) {
                System.getLogger(GestorUsuarios.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        return null;
    }
    public User buscarUser(String username){
        try{
        users= new RandomAccessFile("INSTA_RAIZ/users.ins","r");
        users.seek(0);
        while(users.getFilePointer()<users.length()){
            String nombre= users.readUTF(); 
            Genero genero= Genero.valueOf(users.readUTF());
            String user= users.readUTF();
            String password= users.readUTF();
            String rutaFoto= users.readUTF();
            TipoCuenta tipoCuenta= TipoCuenta.valueOf(users.readUTF());
            long fecha= users.readLong();
            int edad= users.readInt();
            boolean estadoActivo=users.readBoolean();
            if(user.equals(username)){
                if(tipoCuenta==TipoCuenta.PRIVADA){
                    UserPrivado usuario= new UserPrivado(nombre,genero,username,password,edad,rutaFoto,tipoCuenta,fecha,estadoActivo);
                    return usuario;
                }else{
                    UserPublico usuario= new UserPublico(nombre,genero,username,password,edad,rutaFoto,tipoCuenta,fecha,estadoActivo);
                    return usuario;
                }
            }
        }
        }catch(IOException e){
            System.err.println("Error: "+e.getMessage());
        }finally{
            try{
                users.close();
            }catch(IOException e){
                System.out.println("Error: "+ e.getMessage());
            }
        }
        return null;
    }
    public boolean existeUser(String username){
        try{
            File file= new File("INSTA_RAIZ/users.ins");
            file.createNewFile();
            users = new RandomAccessFile("INSTA_RAIZ/users.ins", "r");
            users.seek(0);
            while(users.getFilePointer()<users.length()){
                users.readUTF(); //nombre
                users.readUTF(); //genero
                String userActual=users.readUTF(); //username
                if(userActual.equals(username))
                    return true;
                users.readUTF(); //password
                users.readUTF(); //rutafoto
                users.readUTF(); //tipo cuenta
                users.skipBytes(13);
            }
            return false;
        }catch(IOException e){
            System.err.println("Error: "+ e.getMessage());
        }finally{
            try{
                if(users!=null)
                    users.close();
            }catch (IOException e){
                System.err.println("Error: "+ e.getMessage());
            }
        }
            return false;
    }
    public void actualizarUser(User user){
        try {
            ArrayList<User> arrayUser= new ArrayList<>();
            users= new RandomAccessFile("INSTA_RAIZ/users.ins","rw");
            users.seek(0);
            while(users.getFilePointer()<users.length()){
                String name= users.readUTF();
                Genero genero= Genero.valueOf(users.readUTF());
                String username= users.readUTF();
                String contra= users.readUTF();
                String path= users.readUTF();
                TipoCuenta tipo= TipoCuenta.valueOf(users.readUTF());
                long fecha= users.readLong();
                int edad= users.readInt();
                boolean estado= users.readBoolean();
                if(tipo==TipoCuenta.PUBLICA){
                    UserPublico usuario= new UserPublico(name, genero,username,contra,edad,path,tipo,fecha,estado);
                    arrayUser.add(usuario);
                }else{
                    UserPrivado usuario=new UserPrivado(name, genero,username,contra,edad,path,tipo,fecha,estado);
                    arrayUser.add(usuario);
                }
            }
            
            int index=-1;
            for(int i=0;i<arrayUser.size();i++){
                if(arrayUser.get(i).getUserName().equals(user.getUserName())){
                    index=i;
                }
            }
            if(index != -1){
                arrayUser.set(index, user);
            }
            users.setLength(0);
            for(User u:arrayUser){
                writeUser(u);
                
            }
        } catch (IOException e) {
            System.err.println("Error: "+ e.getMessage());
        }finally{
            try{
            if(users!=null)
                users.close();
            }catch(IOException e){
                System.err.println("Error: "+ e.getMessage());
            }
        }
    }
    private void writeUser(User user)throws IOException{
        users.writeUTF(user.getNombre());
        users.writeUTF(user.getGenero().toString());
        users.writeUTF(user.getUserName());
        users.writeUTF(user.getPassword());
        users.writeUTF(user.getRutaFoto());
        users.writeUTF(user.getTipoCuenta().toString());
        users.writeLong(user.getFechaCreacion());
        users.writeInt(user.getEdad());
        users.writeBoolean(user.isEstadoActivo());
    }
    private void crearFolderConFiles(User actual)throws IOException{
        File carpeta = new File("INSTA_RAIZ/" + actual.getUserName()+"/imagenes");
        carpeta.mkdirs();
        carpeta= new File("INSTA_RAIZ/" + actual.getUserName()+"/folders_personales");
        carpeta.mkdir();
        carpeta= new File("INSTA_RAIZ/" + actual.getUserName()+"/stickers_personales");
        carpeta.mkdir();
        File file= new File("INSTA_RAIZ/" + actual.getUserName()+"/followers.ins");
        file.createNewFile();
        file= new File("INSTA_RAIZ/" + actual.getUserName()+"/following.ins");
        file.createNewFile();
        file= new File("INSTA_RAIZ/" + actual.getUserName()+"/inbox.ins");
        file.createNewFile();
        file= new File("INSTA_RAIZ/" + actual.getUserName()+"/insta.ins");
        file.createNewFile();
        file= new File("INSTA_RAIZ/" + actual.getUserName()+"/stickers.ins");
        file.createNewFile();
        file= new File("INSTA_RAIZ/" + actual.getUserName()+"/contador.ins");
        file.createNewFile();
    }
}
