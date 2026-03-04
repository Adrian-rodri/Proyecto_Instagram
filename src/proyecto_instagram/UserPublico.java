package proyecto_instagram;

/**
 *
 * @author adria
 */
public class UserPublico extends User {
    UserPublico(String nombre, Genero genero, String userName, String password, int edad){
        super(nombre,genero,userName,password,edad);
        setTipoCuenta(TipoCuenta.PUBLICA);
        
    }
    public boolean puedeEnviarMensaje(User otro){
        if(otro.getTipoCuenta()==TipoCuenta.PRIVADA)
            return false;
        return true;
        
    }
}
