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
    UserPublico(String nombre, Genero genero, String userName, String password, int edad,String rutaFoto,TipoCuenta tipoCuenta, long fechaCreacion, boolean estadoActivo){
        super(nombre,genero,userName,password,edad,rutaFoto,tipoCuenta,fechaCreacion,estadoActivo);
    }
    @Override
    public boolean puedeEnviarMensaje(User otro){
        return true;
        
    }
}
