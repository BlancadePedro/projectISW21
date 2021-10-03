package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;

public class CustomerDAO {
	
	
	
	public static void getClientes(ArrayList<Customer> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Customer(rs.getString(1),rs.getString(2),rs.getInt(3), rs.getString(4),
									   rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}

	public static void addCliente(Customer perfil) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios(correo,descripcion,edad,nacionalidad,nombrecompleto,telefono,usuario,clave) VALUES ('"+perfil.getCorreo()+"','"+perfil.getDescripcion()+"',"+perfil.getEdad()+",'"+perfil.getNacionalidad()+"','"+perfil.getNombreCompleto()+"',"+perfil.getTelefono()+",'"+perfil.getUsuario()+"','"+perfil.getClave()+"')");
			 ResultSet rs = pst.executeQuery()){

		} catch (SQLException ex) {
 		//Esto se puede quitar?
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {

		ArrayList<Customer> lista=new ArrayList<Customer>();
		CustomerDAO.getClientes(lista);
		
		 for (Customer customer : lista) {			
			System.out.println("Nombre: "+customer.getNombreCompleto()+"; Edad: "+customer.getEdad()+ "; Nacionalidad: "+customer.getNacionalidad());
		}
	
	}

}
