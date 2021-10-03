package icai.dtc.isw.domain;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	//Inicio de sesión
	private String clave;
	private String usuario;
	//Caracteristicas usuario
	private String nombreCompleto;
	private int edad;
	private String nacionalidad;
	private String descripcion;
	//Opcional
	private int telefono;
	private String correo;

	public Customer(String correo, String descripcion, int edad, String nacionalidad, String nombreCompleto, int telefono, String usuario, String clave) {
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
	}


	public String getUsuario() {
		return usuario;
	}

	public String getClave() {
		return clave;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}

	public String getNacionalidad() { return nacionalidad; }

	public String getDescripcion() {
		return descripcion;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return nombreCompleto + edad + nacionalidad;
	}
}











