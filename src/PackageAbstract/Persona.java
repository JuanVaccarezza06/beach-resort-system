package PackageAbstract;

public abstract class Persona extends Modelo {

    private String nombreCompleto;
    private String numeroTelefono;
    private String DNI;
    private String email;
    private String origen;

    public Persona(String nombreCompleto, String numeroTelefono, String email, String DNI, String origen) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.DNI = DNI;
        this.origen = origen;
    }

    public Persona() {
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        return
                "ID='" + super.getId() + '\'' +
                        "nombreCompleto='" + nombreCompleto + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                        ", DNI='" + DNI + '\'' +
                ", email='" + email + '\'' +
                ", origen='" + origen + '\'';
    }


}
