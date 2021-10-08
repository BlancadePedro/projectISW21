package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;

public class CustomerDAO {


	public static void getClientes(ArrayList<Customer> lista) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Customer(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void addCliente(Customer perfil) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios(correo,descripcion,edad,nacionalidad,nombrecompleto,telefono,usuario,clave) VALUES ('" + perfil.getCorreo() + "','" + perfil.getDescripcion() + "'," + perfil.getEdad() + ",'" + perfil.getNacionalidad() + "','" + perfil.getNombreCompleto() + "'," + perfil.getTelefono() + ",'" + perfil.getUsuario() + "','" + perfil.getClave() + "')");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			//Esto se puede quitar?
			System.out.println(ex.getMessage());
		}
	}

	public static void dropCliente(String usuario) {
		Connection con = ConnectionDAO.getInstance().getConnection();

		try (PreparedStatement pst = con.prepareStatement("delete from usuarios where usuario =" + usuario);
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static boolean checkCliente(String usuario){
		Connection con = ConnectionDAO.getInstance().getConnection();

		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			 ResultSet rs = pst.executeQuery()) {
			while(rs.next()){
				if(usuario.equals(rs.getString(7))){
					System.out.println("Encontrado");
					return true;
				}else{
					System.out.println("NO Encontrado");
					return false;
				}
			}

		}catch (SQLException ex){
			System.out.println(ex.getMessage());
		}

		return false;
	}
}
