package icai.dtc.isw.domain;

public class Evento extends Localidad{
   
    private String autor;
    private String celebracion;//Concierto, lectur de libros, festival...

    public Evento(String nombre, String direccion, String horario, String contacto, String precio, String autor, String celebracion) {
        super(nombre, direccion, horario, contacto, precio);
        this.autor = autor;
        this.celebracion = celebracion;
    }

    public String getAutor() {
        return autor;
    }
    public String getCelebracion() {
        return celebracion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setCelebracion(String celebracion) {
        this.celebracion = celebracion;
    }

}
