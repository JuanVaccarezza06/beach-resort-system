package PackageModelos;

import PackageAbstract.Persona;
import PackageEnumeradores.Turno;
import org.json.JSONException;
import org.json.JSONObject;

public class Medico extends Persona {

    private Turno turnoAsignado;
    private boolean presencialidad;

    public Medico(String nombreCompleto, String numeroTelefono, String email, String DNI, String origen,Turno turnoAsignado, boolean presencialidad) {
        super(nombreCompleto, numeroTelefono, email, DNI, origen);
        this.turnoAsignado = turnoAsignado;
        this.presencialidad =  presencialidad;
    }

    public Medico() {
    }

    public void setPresencialidad(boolean presencialidad) {
        this.presencialidad = presencialidad;
    }

    public void setTurnoAsignado(Turno turnoAsignado) {
        this.turnoAsignado = turnoAsignado;
    }


    @Override
    public String verVentanilla() {
String rta = "";
        if(turnoAsignado == Turno.MAÑANA){
            rta = "El médico "+this.getNombreCompleto()+"está especializado en el área de guardias medicas y tiene un rol clave en la atención de pacientes. " +
                    "Su número de identificación es DNI "+this.getDNI()+" y su origen es "+this.getOrigen()+".\n" +
                    "El turno asignado al médico es matutino, lo que le permite organizar sus horarios y tareas dentro de la institución. " +
                    "Además, el médico tiene asignada una presencialidad rotativa, lo que define si su atención es en modalidad presencial o en una guardia cercana." +
                    "Para contacto, se dispone de su número telefónico "+this.getNumeroTelefono()+" y su correo electrónico "+this.getEmail()+".\n" +
                    "Este médico está registrado en nuestra BDD, garantizando su correcta asignación de responsabilidades en la atención de la salud.";
        }else if(turnoAsignado == Turno.TARDE){
            rta = "El médico "+this.getNombreCompleto()+"está especializado en el área de guardias medicas y tiene un rol clave en la atención de pacientes. " +
                    "Su número de identificación es DNI "+this.getDNI()+" y su origen es "+this.getOrigen()+".\n" +
                    "El turno asignado al médico es diurno, lo que le permite organizar sus horarios y tareas dentro de la institución. " +
                    "Además, el médico tiene asignada una presencialidad rotativa, lo que define si su atención es en modalidad presencial o en una guardia cercana." +
                    "Para contacto, se dispone de su número telefónico "+this.getNumeroTelefono()+" y su correo electrónico "+this.getEmail()+".\n" +
                    "Este médico está registrado en nuestra BDD, garantizando su correcta asignación de responsabilidades en la atención de la salud.";
        }else{
            rta = "El médico "+this.getNombreCompleto()+" está especializado en el área de guardias medicas y tiene un rol clave en la atención de pacientes. " +
                    "Su número de identificación es DNI "+this.getDNI()+" y su origen es "+this.getOrigen()+".\n" +
                    "El turno asignado al médico es nocturno, lo que le permite organizar sus horarios y tareas dentro de la institución. " +
                    "Además, el médico tiene asignada una presencialidad rotativa, lo que define si su atención es en modalidad presencial o en una guardia cercana." +
                    "Para contacto, se dispone de su número telefónico "+this.getNumeroTelefono()+" y su correo electrónico "+this.getEmail()+".\n" +
                    "Este médico está registrado en nuestra BDD, garantizando su correcta asignación de responsabilidades en la atención de la salud.";
        }
return rta;
    }

    // Metodos NO convencionales


    @Override
    public String toString() {
        return "Medico{" +
                super.toString()+
                "turnoAsignado=" + turnoAsignado +
                ", Presencialidad=" + presencialidad +
                '}';
    }

    public JSONObject MedicoToJson(){

        JSONObject o = new JSONObject();

        try{
            o.put("MedicoID",super.getId());
            o.put("NombreCompletoMedico",super.getNombreCompleto());
            o.put("NumeroTelefonoMedico",super.getNumeroTelefono());
            o.put("MedicoDNI",super.getDNI());
            o.put("EmailDelMedico",super.getEmail());
            o.put("OrigenDelMedico",super.getOrigen());
            o.put("TurnoAsignado",this.turnoAsignado);
            o.put("Presencialidad",this.presencialidad);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }

    public static Medico JsonToMedico(JSONObject o){

        Medico m = new Medico();

        try{
            m.setId(o.getString("MedicoID"));
            m.setNombreCompleto(o.getString("NombreCompletoMedico"));
            m.setNumeroTelefono(o.getString("NumeroTelefonoMedico"));
            m.setDNI(o.getString("MedicoDNI"));
            m.setEmail(o.getString("EmailDelMedico"));
            m.setOrigen(o.getString("OrigenDelMedico"));
            m.setTurnoAsignado(Turno.valueOf(o.getString("TurnoAsignado")));
            m.setPresencialidad((o.getBoolean("Presencialidad")));
        }catch (JSONException f){
            f.printStackTrace();
        }
        return m;
    }

}
