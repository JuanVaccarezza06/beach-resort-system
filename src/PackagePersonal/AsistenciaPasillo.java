package PackagePersonal;

import PackageAbstract.AtencionCliente;
import PackageException.CadenaVacia;
import PackageModelos.Check;
import PackageModelos.Reserva;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AsistenciaPasillo extends AtencionCliente {

    // Con simplemente hacer que playero sea hija de atencionCliente, playero hereda todos
    // los metodos y atributos de la clase abstracta Modelo!

    private int nroPasillo;
    private int cantPlayeros;
    private List<String> equipamentoAsignado;

    public AsistenciaPasillo(String horario, double pagaHorasExtra, int nroPasillo, int cantPlayeros) {
        super(horario, pagaHorasExtra);
        this.nroPasillo = nroPasillo;
        this.cantPlayeros = cantPlayeros;
        equipamentoAsignado = new ArrayList<>();
    }

    public AsistenciaPasillo() {
        this.equipamentoAsignado = new ArrayList<>();
    }

    public void setNroPasillo(int nroPasillo) {
        this.nroPasillo = nroPasillo;
    }

    public void setCantPlayeros(int cantPlayeros) {
        this.cantPlayeros = cantPlayeros;
    }

    public void agregarHerramienta(String herramienta) throws CadenaVacia {
        if (!herramienta.isEmpty()) {
            equipamentoAsignado.add(herramienta);
        } else {
            throw new CadenaVacia();
        }
    }
    // Al no utilizar estos metodos, no les doy cuerpo, pero nunca esta de mas tenerlos!
    @Override
    public String verVentanilla(){return "";}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : equipamentoAsignado) {
            sb.append(s + " | ");
        }
        return "AsistenciaPasillo{" +
                super.toString() +
                "IdPuesto=" + super.getId() +
                " nroPasillo=" + nroPasillo +
                ", cantPlayeros=" + cantPlayeros +
                ", equipamentoAsignado=" + sb +
                '}';
    }

    public JSONObject AsistenciaPasilloToJson(){

        JSONObject o = new JSONObject();
        JSONArray array = new JSONArray();

        try{
            o.put("IDEquipoPlayeros",super.getId());
            o.put("HorarioTrabajoAsistencia",super.getHorario());
            o.put("PagaHorasExtra",super.getPagaHorasExtra());
            o.put("PasilloAsignado",this.nroPasillo);
            o.put("CantidadPlayeros",this.cantPlayeros);
            for (String s : equipamentoAsignado){
                array.put(s);
            }
            o.put("EquipamentoAsignado",array);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }

    public static AsistenciaPasillo JsonToAsistenciaPasillo(JSONObject o){

        AsistenciaPasillo a = new AsistenciaPasillo();

        try{
            JSONArray array = o.getJSONArray("EquipamentoAsignado");
            a.setId(o.getString("IDEquipoPlayeros"));
            a.setHorario(o.getString("HorarioTrabajoAsistencia"));
            a.setPagaHorasExtra(o.getDouble("PagaHorasExtra"));
            a.setNroPasillo(o.getInt("PasilloAsignado"));
            a.setCantPlayeros(o.getInt("CantidadPlayeros"));
            for(int i = 0;i < array.length(); i++){
                a.agregarHerramienta(array.getString(i));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return a;
    }

}

