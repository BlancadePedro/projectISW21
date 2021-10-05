package icai.dtc.isw.domain;

public class Evento extends Ocio{

    private String precio;
    private String autor;
    private String celebracion;//Concierto, lectura de libros, festival...
    private String fecha;

    public Evento(String nombre, String direccion, String precio, String autor, String celebracion, String fecha) {
        super(nombre, direccion);
        this.precio = precio;
        this.autor = autor;
        this.celebracion = celebracion;
        this.fecha = fecha;
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
