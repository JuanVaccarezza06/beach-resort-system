package PackageAbstract;

public abstract class AtencionCliente extends Modelo{

    private String horario;
    private double pagaHorasExtra;

    public AtencionCliente(String horario, double pagaHorasExtra) {
        this.horario = horario;
        this.pagaHorasExtra = pagaHorasExtra;
    }

    public AtencionCliente() {
    }

    public String getHorario() {
        return horario;
    }
    public double getPagaHorasExtra() {
        return pagaHorasExtra;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setPagaHorasExtra(double pagaHorasExtra) {
        this.pagaHorasExtra = pagaHorasExtra;
    }

    // Metodos NO convencionales

    @Override
    public String toString() {
        return
                "horario='" + horario + '\'' +
                ", pagaHorasExtra=" + pagaHorasExtra +
                '}';
    }


    // Esta clase NO va a ser instanciada, por lo tanto la hacemos abstracta
    // Esto NO quiere decir que no pueda tener atributos y distintos metodos!

    // Ademas esta clase y sdus hijas, heredan metodos como el .equals, ya que tienen su ID!



}
