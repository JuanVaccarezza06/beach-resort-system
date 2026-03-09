package PackagePersonal;

import PackageAbstract.AtencionCliente;
import PackageInterfaces.ICalcularAlquiler;
import PackageModelos.Empleado;
import org.json.JSONException;
import org.json.JSONObject;

public class Puesto extends AtencionCliente implements ICalcularAlquiler {

    private String nombrePuesto;
    private double tarifaAlquiler;
    private boolean ventaAlcohol;
    private double metrosCuadrados;

    public Puesto(String horario,double pagaHorasExtra,String nombrePuesto,double tarifaAlquiler,boolean ventaAlcohol, double metrosCuadrados) {
        super(horario,pagaHorasExtra);
        this.nombrePuesto = nombrePuesto;
        this.tarifaAlquiler = tarifaAlquiler;
        this.ventaAlcohol = ventaAlcohol;
        this.metrosCuadrados = metrosCuadrados;
    }


    public Puesto() {
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public void setTarifaAlquiler(double tarifaAlquiler) {
        this.tarifaAlquiler = tarifaAlquiler;
    }

    public void setVentaAlcohol(boolean ventaAlcohol) {
        this.ventaAlcohol = ventaAlcohol;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    @Override
    public String verVentanilla() {
        String rta = "";
        if(ventaAlcohol){
            rta = "El puesto "+this.nombrePuesto+" opera dentro de un horario de "+this.getHorario()+". " +
                    "Su tarifa de alquiler es de "+tarifaAlquiler+" y ofrece una paga por horas extra de "+this.getPagaHorasExtra()+".\n " +
                    "Además, el puesto ocupa un espacio de "+this.metrosCuadrados+" metros cuadrados y cuenta con la venta de alcohol.";
        }else{
           rta = "El puesto "+this.nombrePuesto+" opera dentro de un horario de "+this.getHorario()+". "+
                    "Su tarifa de alquiler es de "+tarifaAlquiler+" y ofrece una paga por horas extra de "+this.getPagaHorasExtra()+".\n " +
                    "Además, el puesto ocupa un espacio de "+this.metrosCuadrados+" metros cuadrados. NO cuenta con la venta de alcohol!";
        }
        return rta;
    }

    @Override
    public double calcularAlquiler() {
        double precio = 250000*tarifaAlquiler;
        return precio;
    }

    @Override
    public String toString() {
        return "Puesto{" +
                "IDPuesto='" + super.getId() + '\'' +
                super.toString()+
                "nombrePuesto='" + nombrePuesto + '\'' +
                ", tarifaAlquiler=" + tarifaAlquiler +
                ", ventaAlcohol=" + ventaAlcohol +
                ", metrosCuadrados=" + metrosCuadrados +
                '}';
    }


    public JSONObject PuestoToJson(){

        JSONObject o = new JSONObject();

        try{
            o.put("IDPuestoBalneario",super.getId());
            o.put("NombreDelPuesto",this.nombrePuesto);
            o.put("TarifaDelPuesto",this.tarifaAlquiler);
            o.put("PermisoVentaAlcohol",this.ventaAlcohol);
            o.put("MetrosCuadradosPuesto",this.metrosCuadrados);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return o;
    }

    public static Puesto JsonToPuesto(JSONObject o){

        Puesto p = new Puesto();

        try{
            p.setId(o.getString("IDPuestoBalneario"));
            p.setNombrePuesto(o.getString("NombreDelPuesto"));
            p.setTarifaAlquiler(o.getDouble("TarifaDelPuesto"));
            p.setVentaAlcohol(o.getBoolean("PermisoVentaAlcohol"));
            p.setMetrosCuadrados(o.getDouble("MetrosCuadradosPuesto"));
        }catch (JSONException f){
            f.printStackTrace();
        }
        return p;
    }

}
// La clase padre de todos los comercios/Puntos de venta del balneario!