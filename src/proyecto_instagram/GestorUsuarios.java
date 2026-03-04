package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.io.*;
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
        users = new RandomAccessFile("INSTA_RAIZ/users.ins", "rw");
        users.seek(users.length());
        users.writeUTF(actual.getNombre());
        users.writeUTF(actual.getGenero().toString());
        users.writeUTF(actual.getUserName());
        users.writeUTF(actual.getPassword());
        users.writeUTF(actual.getRutaFoto());
        users.writeUTF(actual.getTipoCuenta().toString());
        users.writeLong(actual.getFechaCreacion());
        users.writeInt(actual.getEdad());
        users.writeBoolean(actual.isEstadoActivo());
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
        if(usuario !=null && usuario.isEstadoActivo() && usuario.getPassword().equals(password))
            return usuario;
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
        
    }
}
