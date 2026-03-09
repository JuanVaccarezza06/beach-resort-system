package PackageModelos;

import PackageAbstract.Persona;
import org.json.JSONException;
import org.json.JSONObject;

public class Empleado extends Persona {

// Aca iria el ID del cliente, que en SI está, pero los vamos a tratar desde la clase padre abstracta "Modelo"!

    private String idPuesto;

    public Empleado(String nombreCompleto, String numeroTelefono, String email, String DNI, String origen,String idPuesto) {
        super(nombreCompleto,numeroTelefono,email,DNI,origen);
        this.idPuesto = idPuesto;

    }
    public Empleado() {
    }

    public void serIdPuesto(String idPuesto) {
        this.idPuesto = idPuesto;
    }

    @Override
    public String verVentanilla() {
        String rta = "El empleado "+this.getNombreCompleto()+" ocupa el puesto con ID en "+this.idPuesto+" dentro de la empresa. " +
                "\nSu número de identificación es DNI "+this.getDNI()+" y su origen es "+this.getOrigen()+".\n" +
                "Para fines de contacto, se dispone de su número telefónico "+this.getNumeroTelefono()+" y su correo electrónico "+this.getEmail()+
                ".\nEl puesto desempeñado por el empleado está debidamente registrado con el ID [idPuesto], asegurando la correcta asignación de " +
                "responsabilidades y tareas dentro de la organización.";
        return rta;
    }
    // Metodos NO convencionales

    @Override
    public String toString() {
        return "Empleado{" +
                super.toString() +
                "IdPuesto='" + this.idPuesto+ '\'' +
                '}';
    }

    public JSONObject EmpleadoToJson(){

        JSONObject o = new JSONObject();

        try{
            o.put("EmpleadoID",super.getId());
            o.put("NombreCompletoEmpleado",super.getNombreCompleto());
            o.put("NumeroTelefonoEmpleado",super.getNumeroTelefono());
            o.put("EmpleadoDNI",super.getDNI());
            o.put("EmailDelEmpleado",super.getEmail());
            o.put("OrigenDelEmpleado",super.getOrigen());
            o.put("IdPuestoDelEmpleado",this.idPuesto);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }
    public static Empleado JsonToEmpleado(JSONObject o){

        Empleado e = new Empleado();

        try{
            e.setId(o.getString("EmpleadoID"));
            e.setNombreCompleto(o.getString("NombreCompletoEmpleado"));
            e.setNumeroTelefono(o.getString("NumeroTelefonoEmpleado"));
            e.setDNI(o.getString("EmpleadoDNI"));
            e.setEmail(o.getString("EmailDelEmpleado"));
            e.setOrigen(o.getString("OrigenDelEmpleado"));
            e.serIdPuesto((o.getString("IdPuestoDelEmpleado")));

        }catch (JSONException f){
            f.printStackTrace();
        }
        return e;
    }

}

