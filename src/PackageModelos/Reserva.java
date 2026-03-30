package PackageModelos;

import PackageAbstract.Modelo;
import PackageEnumeradores.TipoContrato;
import PackageException.CadenaVacia;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Reserva extends Modelo {

    // Aca iria el ID del cliente, que en SI está, pero los vamos a tratar desde la clase padre abstracta "Modelo"!
    private String idCliente;
    private String idServicio;
    private String idCochera;
    private List<String> IdsPersonas;
    private Check check;

    public Reserva(String idCliente, String idServicio, String idCochera,int duracionReserva,TipoContrato tipoContrato,String fechaIngreso,String fechaEgreso) {
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.idCochera = idCochera;
        this.IdsPersonas = new ArrayList<>();
        check = new Check(fechaIngreso,fechaEgreso,duracionReserva,tipoContrato);
    }

    public Reserva() {
        this.IdsPersonas = new ArrayList<>();
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdCochera(String idCochera) {
        this.idCochera = idCochera;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setCheck(Check check){
        this.check = check;
    }
    public void setFechaIngreso(String fechaIngreso) {
        this.check.setFechaIngreso(fechaIngreso);
    }

    public void setFechaEgreso(String fechaEgreso) {

        this.check.setFechaEgreso(fechaEgreso);

    }

    public void setDuracionReserva(int duracionReserva) {

        this.check.setDuracionReserva(duracionReserva);
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.check.setTipoContrato(tipoContrato);
    }

    public String getIdCliente(){
        return this.idCliente;
    }

    public void agregarFamiliares(String idCliente) throws CadenaVacia {
        if(idCliente != null){
            IdsPersonas.add(idCliente);
        }else{
            throw new CadenaVacia();
        }
    }

    @Override
    public String verVentanilla() {
        return "\nReserva transcurrida formalmente desde el "+this.check.getFechaIngreso()+ " hasta el "+
                this.check.getFechaEgreso()+".\nEl respectivo ID del servicio es "+this.idServicio+" y el titular "+
                "\ntiene ID en "+this.idCliente+"\nSi desea saber mas datos del cliente puede ir al bonus track!;)\n"+
                "IdReserva: "+this.getId();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : IdsPersonas){
            sb.append(s+" | ");
        }
        return "Reserva{" +
                "ID='" + super.getId() + '\'' +
                "idCliente='" + idCliente + '\'' +
                ", idServicio=" + idServicio +
                ", IdsFamiliares=" + sb +
                ", check=" + check +
                '}';
    }

    public JSONObject ReservaToJson(){

        JSONObject o = new JSONObject();
        JSONArray array = new JSONArray();

        try{
            o.put("IDClienteTitular", this.idCliente);
            o.put("IDReserva",        super.getId());
            o.put("ServicioReservado",this.idServicio);
            o.put("CocheraReservada",this.idCochera);
            o.put("CheckReserva",this.check.CheckToJson());
            for (String s : IdsPersonas){
                array.put(s);
            }
            o.put("ListaDeFamiliares",array);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }

    public static Reserva JsonToReserva(JSONObject o){

        Reserva r = new Reserva();

        try{
            JSONArray array = o.getJSONArray("ListaDeFamiliares");
            r.setIdCliente(o.getString("IDClienteTitular"));
            r.setId(o.getString("IDReserva"));
            r.setIdServicio(o.getString("ServicioReservado"));
            r.setIdCochera(o.getString("CocheraReservada"));
            r.setCheck(Check.JsonToCheck(o.getJSONObject("CheckReserva")));
            for(int i = 0;i < array.length(); i++){
                r.agregarFamiliares(array.getString(i));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return r;
    }
}
// La ide del estas clases es que sea un MODELO, pero gestionar los clientes
// desde las clases gestoras!