package PackageJSONUtiles;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class ConsolaBalneario {
    private static LineReader reader;

    static {
        try {
            Terminal terminal = TerminalBuilder.builder()
                    .system(true)
                    .build();
            reader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String leerInput(String mensaje) {
        return reader.readLine(mensaje + " ");
    }

    public static int leerEntero(String mensaje) {
        try {
            return Integer.parseInt(leerInput(mensaje));
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor ingrese un número.");
            return leerEntero(mensaje);
        }
    }
}