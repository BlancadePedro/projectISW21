package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;

public class CustomerControler {
	//Info localidades igual que este pero hay que cambiar la base de datos
	public void getCustomer(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}
	public void addCliente(Customer perfil){
		CustomerDAO.addCliente(perfil);
	}
	public void updateCliente(Customer perfil,int foto){CustomerDAO.cambiarFoto(foto, perfil);}



	//public void dropCliente(Customer usuario){CustomerDAO.dropCliente(usuario);}

}
