package icai.dtc.isw.domain;

import java.io.Serializable;

public class Ocio implements Serializable {
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