package icai.dtc.isw.domain.localidad;

import java.io.Serializable;

public class Localidad implements Serializable {
    private String nombre;
    private String direccion;
    private String horario;
    private String contacto;
    private String precio;

    public Localidad(String nombre, String direccion, String horario, String contacto, String precio) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.contacto = contacto;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getHorario() {
        return horario;
    }
    public String getContacto() {
        return contacto;
    }
    public String getPrecio() {
        return precio;
    }
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override 
    public String toString()
    {
        return nombre + direccion + horario + contacto;
    }

}
