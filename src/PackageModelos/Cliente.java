package PackageModelos;
import PackageAbstract.Persona;
import org.json.JSONException;
import org.json.JSONObject;

public class Cliente extends Persona {

// Aca iria el ID del cliente, que en SI está, pero los vamos a tratar desde la clase padre abstracta "Modelo"!

    private boolean titular;

    public Cliente(boolean titular,String nombreCompleto, String numeroTelefono, String email, String DNI, String origen) {
        super(nombreCompleto,numeroTelefono,email,DNI,origen);
        this.titular = titular;
    }

    public Cliente(){
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }



    @Override
    public String verVentanilla() {
        String rta = "";
       if(titular){
            rta = "El cliente "+this.getNombreCompleto()+" es una persona cuya información ha sido registrada con carácter titular"+
                   "Su identificación oficial está asociada al documento DNI "+this.getDNI()+", y su origen es "+this.getOrigen()+"."+
                   "Para establecer contacto, el cliente ha proporcionado su número telefónico "+this.getNumeroTelefono()+" y su correo electrónico "+this.getEmail()+
                   "Este registro garantiza que el cliente puede ser identificado de manera precisa y que su información es adecuada para fines "+
                   "administrativos y contractuales.";
       }else{
           rta = "El cliente "+this.getNombreCompleto()+" es una persona cuya información ha sido registrada con carácter no titular"+
                   "Su identificación oficial está asociada al documento DNI "+this.getDNI()+", y su origen es "+this.getOrigen()+"."+
                   "Para establecer contacto, el cliente ha proporcionado su número telefónico "+this.getNumeroTelefono()+" y su correo electrónico "+this.getEmail()+
                   "Este registro garantiza que el cliente puede ser identificado de manera precisa y que su información es adecuada para fines "+
                   "administrativos y contractuales.";
       }
return rta;
    }

    //Metodos NO convencionales

    @Override
    public String toString() {
        return "Cliente{" +
                super.toString() +
                "titular='" + this.titular+ '\'' +
                '}';
    }

    public JSONObject ClienteToJson(){

        JSONObject o = new JSONObject();

        try{
            o.put("IdDelCliente",super.getId());
            o.put("NombreCompletoCliente",super.getNombreCompleto());
            o.put("NumeroTelefonoCliente",super.getNumeroTelefono());
            o.put("ClienteDNI",super.getDNI());
            o.put("EmailDelCliente",super.getEmail());
            o.put("OrigenDelCliente",super.getOrigen());
            o.put("TitularidadCliente",this.titular);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }

    public static Cliente JsonToCliente(JSONObject o){

        Cliente c = new Cliente();

        try{
            c.setId(o.getString("IdDelCliente"));
            c.setNombreCompleto(o.getString("NombreCompletoCliente"));
            c.setNumeroTelefono(o.getString("NumeroTelefonoCliente"));
            c.setDNI(o.getString("ClienteDNI"));
            c.setEmail(o.getString("EmailDelCliente"));
            c.setOrigen(o.getString("OrigenDelCliente"));
            c.setTitular(o.getBoolean("TitularidadCliente"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        return c;
    }

}

// La ide del estas clases es que sea un MODELO, pero gestionar los clientes
// desde las clases gestoras!