package PackageException;

public class ServicioDesocupado extends RuntimeException {
    public ServicioDesocupado(String message) {
        super(message);
    }

    public ServicioDesocupado() {
    }
}
