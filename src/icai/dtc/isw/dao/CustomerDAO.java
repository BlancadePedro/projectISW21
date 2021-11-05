package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.InicioSesionException;
import icai.dtc.isw.domain.*;

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
			while (rs.next()) {
				if(usuario.equals(rs.getString(7)) && (contraseña.equals(rs.getString(8)))){
					 customer = new Customer(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				}
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


	/////////////////////////////////
	public static void getRestaurantes(ArrayList<Restaurante> lista) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM restaurantes");
			 ResultSet rs = pst.executeQuery()) {
			System.out.println("Estamos dentro de getRestaurantes()");
			while (rs.next()) {
				System.out.println("Estamos dentro de getRestaurantes() bucle");
				lista.add(new Restaurante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			System.out.println("Salimos de getRestaurantes()");

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

	}

	public static void getHoteles(ArrayList<Hotel> lista) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM hoteles");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Hotel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void getMuseos(ArrayList<Museo> lista) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM museos");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Museo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void getMonumentos(ArrayList<Monumento> lista) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM monumento");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Monumento(rs.getString(1), rs.getString(2)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void getParques(ArrayList<Parque> lista) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM parque");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Parque(rs.getString(1), rs.getString(2), rs.getString(3)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void getEventos(ArrayList<Evento> lista) {
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM evento");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Evento(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}
}
