package proyecto_instagram;

/**
 *
 * @author adria
 */
import java.util.Calendar;
import java.time.LocalDate;
import java.util.Date;
public abstract class User {
    private String nombre;
    private Genero genero;
    private String userName;
    private String password;
    private long fechaCreacion;
    private Date fecha;
    private int edad;
    private boolean estadoActivo;
    private String rutaFoto;
    private TipoCuenta tipoCuenta;
    
    User(String nombre, Genero genero, String userName, String password, int edad){
        this.nombre=nombre;
        this.genero=genero;
        this.userName=userName;
        this.password=password;
        this.fechaCreacion=System.currentTimeMillis();
        fecha= new Date(fechaCreacion);
        this.edad=edad;
        this.estadoActivo=true;
        this.rutaFoto="";
        this.tipoCuenta=TipoCuenta.PUBLICA;
    }
    User(String nombre, Genero genero, String userName, String password, int edad,String rutaFoto,TipoCuenta tipoCuenta, long fechaCreacion, boolean estadoActivo){
        this.nombre=nombre;
        this.genero=genero;
        this.userName=userName;
        this.password=password;
        this.fechaCreacion=fechaCreacion;
        fecha= new Date(fechaCreacion);
        this.edad=edad;
        this.estadoActivo=estadoActivo;
        this.rutaFoto=rutaFoto;
        this.tipoCuenta=tipoCuenta;
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

    public Long getFechaCreacion() {
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
