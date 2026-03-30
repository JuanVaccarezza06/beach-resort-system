package PackageGenerico;

import PackageAbstract.Modelo;
import PackageException.CadenaVacia;
import PackageException.DatoNulo;
import PackageModelos.*;
import PackagePersonal.AsistenciaPasillo;
import PackagePersonal.Puesto;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.*;

public class Almacenamiento<T extends Modelo> {

    Set<T> lista;

    public Almacenamiento() {
        this.lista = new LinkedHashSet<>();
    }

    public void agregarObjeto(T o) throws DatoNulo {
        if (o != null) {
            lista.add(o);
        } else {
            throw new DatoNulo();
        }
    }

    public void eliminarObjeto(T o) throws DatoNulo {
        if (o != null) {
            lista.remove(o);
        } else {
            throw new DatoNulo();
        }
    }

    public void eliminarObjetoPorId(String ID) throws CadenaVacia {
        if (ID != null) {
            lista.removeIf(o -> o.getId().equals(ID));
        } else {
            throw new CadenaVacia();
        }
    }

    public T buscarObjeto(String ID) throws CadenaVacia {
        if (!ID.isEmpty()) {
            for (T t : lista) {
                if (t.getId().equals(ID)) {
                    return t;
                }
            }
        } else {
            throw new CadenaVacia();
        }
        return null;
    }

    public String verObjeto(String ID) throws DatoNulo {

        // Se le pasa un id, y si lo encuentra en la lista, lo muestra!
        // Si no, retorne una cadena vacia!

        for (T t : lista) {
            if (t.getId().equals(ID)) {
                return t.toString();
            }
        }
        return "";
    }

    public String verTodaVentanilla() throws DatoNulo {
        // Se le pasa un id, y si lo encuentra en la lista, lo muestra!
        StringBuilder sb = new StringBuilder();

        for (T t : lista) {
                sb.append((t).verVentanilla()+"\n\n");
        }
        return sb.toString();
    }

    public String verVentanillaEspe(String id){
            String rta = "";
            for (T t : lista){
                if(t.getId().equals(id)){
                    rta =  t.verVentanilla();
                }
            }
            return rta;
    }

    public String verReservaConIdCliente(String IDCliente){
        String rta = "";
        for (T t : lista){
            if(((Reserva)t).getIdCliente().equals(IDCliente)){
                rta = t.verVentanilla();
            }
        }
        return rta;
    }

    public String buscarClienteConDni(String DNI){
        String clienteId = "";
        for (T t : lista){
            if(((Cliente)t).getDNI().equals(DNI)){
                clienteId = t.getId();
            }
        }
        return clienteId;
    }

    public String mostrarDisponibles() {
        // Recorre la lista de servicios, mostrando solo los que NO esten ocupados!

        // Almacenimiento NO es SET ni ARRAY!! Por eso no permite iterarlo!
        // Como solucion casteamos T, y la java nos permite usar los metodos del objeto casteado!

        StringBuilder sb = new StringBuilder();
        for (T t : lista) {
            if (!((Servicio) t).getEstadoServicio()) {
                sb.append(t.verVentanilla());
            }
        }
        return sb.toString();
    }

    public String mostrarInhabilitados() {
        // Recorre la lista de servicios, mostrando solo los que esten ocupados!

        StringBuilder sb = new StringBuilder();

        for (T t : lista) {
            if (((Servicio) t).getEstadoServicio()) {
                sb.append(((Servicio) t).toString() + "\n");
            }
        }
        return sb.toString();
    }

    public void verificarHistoriaCliente(String ID) {
        StringBuilder sb = new StringBuilder();
        for (T t : lista) {
            if (((Reserva) t).getIdCliente().equals(ID)) {
                sb.append(t.toString());
                // Verifica que en la coleccioon HistorialReserva haya alguna reserva con el ID recibido, si es asi
                // se muestra por pantalla!
            }
        }
    }

    public void verificarHistoriaEmpleado(String ID) {
        StringBuilder sb = new StringBuilder();
        for (T t : lista) {
            if (((Empleado) t).getId().equals(ID)) {
                sb.append(t.toString());
                // Verifica que en la coleccion Historial exista algun registro con el ID
                // del empleado! Si es así lo muestra!
            }
        }
    }

    // A partir de aqui, estan los metodos para guardar o levantar archivos en las respectivas BDD!

    public void cargarServicio(JSONArray array) {

        // Recibe por parametro un JSONArray cargado de datos, en
        // este caso tiene los datos de todos los servicios de todo
        // el balneario!

        for (int i = 0; i < array.length(); i++) {
            try {
                agregarObjeto((T) Servicio.JsonToServicio(array.getJSONObject(i)));
                // Mientras que el JSONArray tenga datos (JSONObject, que en
                // realidad son servicios) que agregue a esta lista(Lista de servicios
                // ya que llamamos al metodo desde la lista de servicios(quiero suponer))
                // uno por uno los JSONObject (Servicios) del JSONArray(ex archivo.json)
                // y listo, transformo un archivo.json a un archivo.java (no un archivo, TODO
                // el arreglo!!)
            } catch (DatoNulo e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void cargarCocheras(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            try {
                agregarObjeto((T) Cochera.JsonToCochera(array.getJSONObject(i)));
            } catch (DatoNulo e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void cargarAsistencia(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            try {
                agregarObjeto((T) AsistenciaPasillo.JsonToAsistenciaPasillo(array.getJSONObject(i)));
            } catch (DatoNulo e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void cargarPuestos(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            try {
                agregarObjeto((T) Puesto.JsonToPuesto(array.getJSONObject(i)));
            } catch (DatoNulo e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void cargarMedicos(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            try {
                agregarObjeto((T) Medico.JsonToMedico(array.getJSONObject(i)));
            } catch (DatoNulo e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void cargarReservas(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            try {
                agregarObjeto((T) Reserva.JsonToReserva(array.getJSONObject(i)));
            } catch (DatoNulo e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException();
            }
        }
    }

    public void cargarClientes(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            try {
                agregarObjeto((T) Cliente.JsonToCliente(array.getJSONObject(i)));
            } catch (DatoNulo e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException();
            }
        }
    }

    public void cargarEmpleados(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {
            try {
                agregarObjeto((T) Empleado.JsonToEmpleado(array.getJSONObject(i)));
            } catch (DatoNulo e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Aca la parte de guardar la coleccion en un JSONArray para posteriormente
    // subirlos al archivo.json

    public JSONArray guardarServicios() {
        JSONArray array = new JSONArray();
        for (T t : lista) {
            // Crea un JSONArray, y en el guarda TODOS los datos
            // de los servicios (tenemos que llamar a este metodo
            // desde la BDD de servicios por su puesto) una vez guardado lo
            // retorna!
            array.put(((Servicio) t).ServicioToJson());
        }
        return array;
    }

    public JSONArray guardarCocheras() {
        JSONArray array = new JSONArray();
        for (T t : lista) {
            array.put(((Cochera) t).CocheraToJson());
        }
        return array;
    }

    public JSONArray guardarPuestos() {
        JSONArray array = new JSONArray();
        for (T t : lista) {
            array.put(((Puesto) t).PuestoToJson());
        }
        return array;
    }

    public JSONArray guardarPlayeros() {
        JSONArray array = new JSONArray();
        for (T t : lista) {
            array.put(((AsistenciaPasillo) t).AsistenciaPasilloToJson());
        }
        return array;
    }

    public JSONArray guardarMedicos() {
        JSONArray array = new JSONArray();
        for (T t : lista) {
            array.put(((Medico) t).MedicoToJson());
        }
        return array;
    }

    public JSONArray guardarClientes() {
        JSONArray array = new JSONArray();
        for (T t : lista) {
            array.put(((Cliente) t).ClienteToJson());
        }
        return array;
    }

    public JSONArray guardarEmpleados() {
        JSONArray array = new JSONArray();
        for (T t : lista) {
            array.put(((Empleado) t).EmpleadoToJson());
        }
        return array;
    }

    public JSONArray guardarReservas() {
        JSONArray array = new JSONArray();
        for (T t : lista) {
            array.put(((Reserva) t).ReservaToJson());
        }
        return array;
    }


}
