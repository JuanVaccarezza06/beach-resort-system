package PackageModelos;

import PackageAbstract.Modelo;
import PackageEnumeradores.TipoServicio;
import PackageException.ServicioDesocupado;
import PackageException.ServicioOcupado;
import PackageInterfaces.ICalcularPrecio;
import org.json.JSONException;
import org.json.JSONObject;


public class Servicio extends Modelo implements ICalcularPrecio {

    // Aca iria el ID del cliente, que en SI está, pero los vamos a tratar desde la clase padre abstracta "Modelo"!
    private TipoServicio tipoServicio;
    private double tarifa;
    private int cantPersonas;
    private String posicionServicio;
    private Estado estadoServicio;

    public Servicio(TipoServicio tipoServicio,double tarifa ,int cantPersonas, String posicionServicio, Estado estadoServicio) {
        this.tarifa = tarifa;
        this.tipoServicio = tipoServicio;
        this.cantPersonas = cantPersonas;
        this.posicionServicio = posicionServicio;
        this.estadoServicio = estadoServicio;
    }

    public Servicio() {
        // Se necesita el constructor vacio para poder crear el objeto en el metodo JsonToServicio!
    }
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    public void setPosicionServicio(String posicionServicio) {
        this.posicionServicio = posicionServicio;
    }
    public void setEstadoServicio(Estado estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public boolean getEstadoServicio(){
        return estadoServicio.getEstado();
    }

    @Override
    public double calcularPrecio() {
        double precio = 200*tarifa;
        return precio;
    }

    public void ocuparServicio() throws ServicioOcupado {
        if(!this.estadoServicio.getEstado()){
            this.estadoServicio.setEstado(true);
        }else{
            throw new ServicioOcupado("El servicio ya esta ocupado!");
        }
    }

    public void desocuparServicio() throws ServicioDesocupado {
        if(this.estadoServicio.getEstado()){
            this.estadoServicio.setEstado(false);
        }else{
            throw new ServicioOcupado("El servicio ya esta desocupado!");
        }
    }

    @Override
    public String toString() { // Hay que agregar un SB que muestere las beneficios!

        return "Servicio{" +
                "ID='" + super.getId() + '\'' +
                "tipoServicio=" + tipoServicio +
                ", tarifa=" + tarifa +
                ", cantPersonas=" + cantPersonas +
                ", estadoServicio=" + estadoServicio.getEstado() +
                ", motivoOcupacion=" + estadoServicio.getMotivo() +
                ", posicionServicio='" + posicionServicio + '\'' +
                '}';
    }
public String mostrarVentanillaEspe(String id){
        String rta = "";
        if(this.getId().equals(id)){
            rta = verVentanilla();
        }
        return rta;
}

    @Override
    public String verVentanilla() {
        String ventanilla =
                "----------------------------------------------------------------\n"+
                        tipoServicio+" con orientacion hacia la "+this.posicionServicio+
                        ", con una inversion de "+calcularPrecio()+ " pesos argentinos! Al"+
                        " invertir con nosotros tendra capacidad para "+cantPersonas+" personas o familiares!" +
                        "\n Si le interesa este nuestro servicio, su ID es "+super.getId()+
                        "\n----------------------------------------------------------------";
        return ventanilla;
    }

    public JSONObject ServicioToJson(){

        JSONObject o = new JSONObject();

        try{
            o.put("IDServicio",super.getId());
            o.put("TipoDeServicio",this.tipoServicio);
            // Implicitamente se uso el metodo toString() para subir el tipoEnumerador.
            // (se puede poner manualmente)
            o.put("TarifaDelServicio",this.tarifa);
            o.put("CantidadMaximaPersonas",this.cantPersonas);
            o.put("EstadoActualServicio",this.estadoServicio.EstadoToJson());
            o.put("PosicionDelServicio",this.posicionServicio);


        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }

    public static Servicio JsonToServicio(JSONObject o){

        Servicio s = new Servicio();

        try{
            s.setId(o.getString("IDServicio"));
            s.setTipoServicio(TipoServicio.valueOf(o.getString("TipoDeServicio")));
            // Cuando se sube al archivo un tipo dato Enumerador, se sube implicitamente con el metodo toString!
            // Ahora, si se subio como toString, como lo levanto del archivo y lo guardo como tipo Enumerador? Ahi
            // entra el metodo valueOf! Toma un String y lo transforma a tipoEnumerador!

            // Explicacion de docs.oracle.com:

            //Devuelve la constante de enumeración del tipo de enumeración especificado con el nombre especificado.
            // El nombre debe coincidir exactamente con un identificador utilizado para declarar una constante de enumeración de este tipo.
            // (No se permiten espacios en blanco extraños).

            s.setTarifa(o.getDouble("TarifaDelServicio"));
            s.setCantPersonas(o.getInt("CantidadMaximaPersonas"));
            s.setEstadoServicio(Estado.JsonToEstado(o.getJSONObject("EstadoActualServicio")));
            s.setPosicionServicio(o.getString("PosicionDelServicio"));

        }catch (JSONException e){
            e.printStackTrace();
        }
        return s;
    }

}

