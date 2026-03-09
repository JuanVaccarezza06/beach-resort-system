package PackageJSONUtiles;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtiles {

    public static void writeInFile(JSONArray a, String nombreArchivo){

        try {
            FileWriter file = new FileWriter(nombreArchivo);
            file.write(a.toString(4));
            file.close();
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static String levantarArchivo(String nombreArchivo){
        String contenido;

        try {
            contenido = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contenido;
    }

    public static JSONArray guardarArchivoEnJSONArray(String nombreArchivo){
        JSONArray array;
        try {
            array = new JSONArray(levantarArchivo(nombreArchivo));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return array;
    }
}
