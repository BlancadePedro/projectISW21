package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.*;

public class CustomerControler {

	//Relacionado con el usuario
	public void getCustomer(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}
	public Customer getCliente(String usuario, String contraseña){
		return CustomerDAO.getCliente(usuario, contraseña);}
	public void addCliente(Customer perfil){ CustomerDAO.addCliente(perfil);}
	public void updateCliente(Customer perfil,int foto){CustomerDAO.cambiarFoto(foto, perfil);}

	//Relacionado con las localidades
	public  void getRestaurantes(ArrayList<Restaurante> lista) {CustomerDAO.getRestaurantes(lista);}
	public void getHoteles(ArrayList<Hotel> lista) {
		CustomerDAO.getHoteles(lista);
	}
	public void getMuseos(ArrayList<Museo> lista) {
		CustomerDAO.getMuseos(lista);
	}
	//Relacionado ocio
	public  void getMonumentos(ArrayList<Monumento> lista) {CustomerDAO.getMonumentos(lista);}
	public void getParques(ArrayList<Parque> lista) {
		CustomerDAO.getParques(lista);
	}
	public void getEventos(ArrayList<Evento> lista) {
		CustomerDAO.getEventos(lista);
	}

}
