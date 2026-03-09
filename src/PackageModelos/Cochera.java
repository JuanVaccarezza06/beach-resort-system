package PackageModelos;

import PackageAbstract.Modelo;
import org.json.JSONException;
import org.json.JSONObject;

public class Cochera extends Modelo {

    private String posicionCochera;

    public Cochera(String posicionCochera) {
        this.posicionCochera = posicionCochera;
    }

    public Cochera() {
    }

    public void setPosicionCochera(String posicionCochera) {
        this.posicionCochera = posicionCochera;
    }

    // Este metodo no va a tener cuerpo ya que en este caso no utilice! Pero no esta mal tener
    // para un futuro!
    @Override
    public String verVentanilla() {
return "";
    }

    // Metodos NO convencionales

    @Override
    public String toString() {
        return "Cochera{" +
                "idCochera='" + super.getId() + '\'' +
                ", posicionCochera='" + posicionCochera + '\'' +
                '}';
    }

    public JSONObject CocheraToJson(){

        JSONObject o = new JSONObject();

        try{
            o.put("CocheraID",super.getId());
            o.put("PosicionDeCochera",this.posicionCochera);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }

    public static Cochera JsonToCochera(JSONObject o){

        Cochera c = new Cochera();

        try{
            c.setId(o.getString("CocheraID"));
            c.setPosicionCochera(o.getString("PosicionDeCochera"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        return c;
    }
}
// La ide del estas clases es que sea un MODELO, pero gestionar los clientes
// desde las clases gestoras!