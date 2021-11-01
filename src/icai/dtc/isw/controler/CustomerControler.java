package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;

public class CustomerControler {

	public void getCustomer(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}
	public Customer getCliente(String usuario, String contraseña){
		return CustomerDAO.getCliente(usuario, contraseña);
	}
	public void addCliente(Customer perfil){ CustomerDAO.addCliente(perfil);}
	public void updateCliente(Customer perfil,int foto){CustomerDAO.cambiarFoto(foto, perfil);}



}
