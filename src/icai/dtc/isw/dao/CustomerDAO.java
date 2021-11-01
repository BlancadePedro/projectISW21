package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.InicioSesionException;

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

	public static Customer getCliente(String usuario, String contraseña) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		Customer customer = null;
		try(PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			ResultSet rs = pst.executeQuery()) {
			System.out.println("Estamos dentro de getClientes()");
			while (rs.next()) {
				if(usuario.equals(rs.getString(7)) && (contraseña.equals(rs.getString(8)))){
					 customer = new Customer(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
					 System.out.println("He pasado la condicion del if y está en la base de datos");
				}else System.out.println("NO He pasado la condicion del if ");
		}


		}catch (SQLException  ex) {
			System.out.println(ex.getMessage());
		}
		return customer;
	}


	public static void addCliente(Customer perfil) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios(correo,descripcion,edad,nacionalidad,nombrecompleto,telefono,usuario,clave,foto) VALUES ('" + perfil.getCorreo() + "','" + perfil.getDescripcion() + "'," + perfil.getEdad() + ",'" + perfil.getNacionalidad() + "','" + perfil.getNombreCompleto() + "'," + perfil.getTelefono() + ",'" + perfil.getUsuario() + "','" + perfil.getClave() + "'," + perfil.getFoto()+")");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void cambiarFoto(int foto, Customer perfil) {

		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET foto ='"+ foto +"' WHERE usuario = '"+perfil.getUsuario()+"'");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}




}
