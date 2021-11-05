package icai.dtc.isw.domain;
public class Parque extends Ocio{

    private String horario;

    public Parque(String nombre, String direccion, String horario) {
        super(nombre, direccion);
        this.horario = horario;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
}
