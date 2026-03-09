package PackageModelos;

import PackageEnumeradores.TipoContrato;
import org.json.JSONException;
import org.json.JSONObject;

public class Check {

    private String fechaIngreso;
    private String fechaEgreso;
    private int duracionReserva;
    private TipoContrato tipoContrato;

    public Check(String fechaIngreso, String fechaEgreso, int duracionReserva, TipoContrato tipoContrato) {
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.duracionReserva = duracionReserva;
        this.tipoContrato = tipoContrato;
    }

    public Check(){

    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public void setDuracionReserva(int duracionReserva) {
        this.duracionReserva = duracionReserva;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public int getDuracionReserva() {
        return duracionReserva;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    // Metodos NO convencionales

    @Override
    public String toString() {
        return "Check{" +
                "fechaIngreso='" + fechaIngreso + '\'' +
                ", fechaEgreso='" + fechaEgreso + '\'' +
                ", duracionReserva=" + duracionReserva +
                ", tipoContrato=" + tipoContrato +
                '}';
    }

    public JSONObject CheckToJson(){

        JSONObject o = new JSONObject();

        try{
            o.put("CheckInFechaIngreso",this.fechaIngreso);
            o.put("CheckInFechaEgreso",this.fechaEgreso);
            o.put("TipoContrato",this.tipoContrato);
            // Implicitamente se uso el metodo toString() para subir el tipoEnumerador.
            // (se puede poner manualmente)
            o.put("DuracionDeReserva",this.duracionReserva);

        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }

    public static Check JsonToCheck(JSONObject o){

        Check c = new Check();

        try{
            c.setTipoContrato(TipoContrato.valueOf(o.getString("TipoContrato")));
            c.setFechaIngreso(o.getString("CheckInFechaIngreso"));
            c.setFechaEgreso(o.getString("CheckInFechaEgreso"));
            c.setDuracionReserva(o.getInt("DuracionDeReserva"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        return c;
    }
}
