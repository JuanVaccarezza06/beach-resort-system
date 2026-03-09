package PackageException;

public class DatoNulo extends Exception{
    public DatoNulo() {
        super("El dato recibido por parametro es NULO");
    }

    public DatoNulo(String message) {
        super(message);
    }
}
