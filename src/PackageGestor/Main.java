package PackageGestor;

public class Main {
    public static void main(String[] args) {

        //BIENVENIDA1
        SistemaBalneario balnearioVYC = new SistemaBalneario("VYC");

        System.out.println("\n"
                + "......................................................\n"
                + "......................................................\n"
                + "         " + balnearioVYC.Bienvenida() + "      "
                + "\n                " + "Balneario " + balnearioVYC.getNombreBalneario() + "      "
                + "\n             Vaccarezza Cecchini     "
                + "\n......................................................"
                + "\n......................................................");


        //INICIO DEL FLUJO DEL PROGRAMA

         balnearioVYC.mostrarMenu();

    }
}