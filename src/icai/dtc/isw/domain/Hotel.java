package icai.dtc.isw.domain;

public class Hotel extends Localidad{
    private String estrellas;
    private String mascotas;//Deja traer mascotas o no
    private String publico;//A que publico está dirigido: familias, parejas, conferencias...
    public Hotel(String nombre, String direccion, String horario, String contacto, String precio, String estrellas, String mascotas, String publico) {
        super(nombre, direccion, horario, contacto, precio);
        this.estrellas = estrellas;
        this.mascotas = mascotas;
        this.publico = publico;
    }

    public String getEstrellas() {
        return estrellas;
    }
    public String getMascotas() {
        return mascotas;
    }
    public String getPublico() {
        return publico;
    }

    public void setEstrellas(String estrellas) {
        this.estrellas = estrellas;
    }
    public void setMascotas(String mascotas) {
        this.mascotas = mascotas;
    }
    public void setPublico(String publico) {
        this.publico = publico;
    }
    
}
