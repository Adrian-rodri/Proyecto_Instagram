package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.util.Calendar;
import java.time.LocalDate;
public abstract class User {
    private String nombre;
    private Genero genero;
    private String userName;
    private String password;
    private String fechaCreacion;
    private int edad;
    private boolean estadoActivo;
    private String rutaFoto;
    private TipoCuenta tipoCuenta;
    
    User(String nombre, Genero genero, String userName, String password, int edad){
        this.nombre=nombre;
        this.genero=genero;
        this.userName=userName;
        this.password=password;
        this.fechaCreacion=LocalDate.now().toString();
        this.edad=edad;
        this.estadoActivo=true;
        this.rutaFoto=null;
        this.tipoCuenta=TipoCuenta.PUBLICA;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }
    public abstract boolean puedeEnviarMensaje(User otro);
}
