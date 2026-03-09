package PackageException;

public class ServicioOcupado extends RuntimeException {
    public ServicioOcupado(String message) {
        super(message);
    }
  public ServicioOcupado() {
    super();
  }

}
