package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;

public class CustomerControler {

	public void getCustomer(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}

	public void addCliente(Customer perfil){
		CustomerDAO.addCliente(perfil);
	}
	public void checkCliente(Customer usuario){CustomerDAO.checkCliente(usuario);}
	public void dropCliente(Customer usuario){CustomerDAO.dropCliente(usuario);}


}
