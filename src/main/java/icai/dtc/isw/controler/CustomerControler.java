package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.localidad.Hotel;
import icai.dtc.isw.domain.ocio.Monumento;
import icai.dtc.isw.domain.localidad.Museo;
import icai.dtc.isw.domain.localidad.Restaurante;
import icai.dtc.isw.domain.ocio.Evento;
import icai.dtc.isw.domain.ocio.Parque;

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
	public void addFavorito(Object lugar, Customer perfil){CustomerDAO.addFavorito(lugar, perfil);
		System.out.println("ENTRO EN Controler /addFavorito");}

	////////////////////////////////

	//Relacionado con barrios
	public void getAustrias(ArrayList<Object> lista){CustomerDAO.getAustrias(lista);}
	public void getChueca(ArrayList<Object> lista){CustomerDAO.getChueca(lista);}
	public void getCondeDuque(ArrayList<Object> lista){CustomerDAO.getCondeDuque(lista);}
	public void getLatina(ArrayList<Object> lista){CustomerDAO.getLatina(lista);}
	public void getLavapies(ArrayList<Object> lista){CustomerDAO.getLavapies(lista);}
	public void getLetras(ArrayList<Object> lista){CustomerDAO.getLetras(lista);}
	public void getMalasana(ArrayList<Object> lista){CustomerDAO.getMoncloa(lista);}
	public void getMoncloa(ArrayList<Object> lista){CustomerDAO.getMoncloa(lista);}
	public void getPaseoArte(ArrayList<Object> lista){CustomerDAO.getPaseoArte(lista);}
	public void getRetiro(ArrayList<Object> lista){CustomerDAO.getRetiro(lista);}
	public void getSalamanca(ArrayList<Object> lista){CustomerDAO.getSalamanca(lista);}
	public void getSalesas(ArrayList<Object> lista){CustomerDAO.getSalesas(lista);}
	public void getSol(ArrayList<Object> lista){CustomerDAO.getSol(lista);}

}
