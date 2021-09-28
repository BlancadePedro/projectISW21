package icai.dtc.isw.domain;
public class Restaurante extends Localidad{
    private String tipoComida;
    

    public Restaurante(String nombre, String direccion, String horario, String contacto, String precio, String tipoComida) {
        super(nombre, direccion, horario, contacto, precio);
        this.tipoComida = tipoComida;

    }
    public String getTipoComida() {
        return tipoComida;
    }
    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
}
