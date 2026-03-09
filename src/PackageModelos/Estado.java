package PackageModelos;

import org.json.JSONException;
import org.json.JSONObject;

public class Estado {

    private boolean estado;
    private String motivo;

    public Estado(boolean estado, String motivo) {
        this.estado = estado;
        this.motivo = motivo;
    }

    public Estado() {
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "estado=" + estado +
                ", motivo='" + motivo + '\'' +
                '}';
    }

    public JSONObject EstadoToJson(){

        JSONObject o = new JSONObject();

        try{
            o.put("EstadoDelServicio",this.estado);
            o.put("MotivoDelEstado",this.motivo);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }

    public static Estado JsonToEstado(JSONObject o){

        Estado es = new Estado();

        try{
            es.setEstado(o.getBoolean("EstadoDelServicio"));
            es.setMotivo(o.getString("MotivoDelEstado"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        return es;
    }


}


