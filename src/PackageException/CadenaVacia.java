package PackageException;

public class CadenaVacia extends RuntimeException {
    public CadenaVacia(String message) {
        super(message);
    }

  public CadenaVacia() {
      super();
  }
}
