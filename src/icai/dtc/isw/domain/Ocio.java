package icai.dtc.isw.domain;
public class Ocio {
    private String nombre;
    private String direccion;

    public Ocio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString()
    {
        return nombre + direccion;
    }
}