package icai.dtc.isw.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.domain.InfoUsuario;
import icai.dtc.isw.domain.Restaurante;
import org.apache.log4j.Logger;

import icai.dtc.isw.configuration.PropertiesISW;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.message.Message;

public class Client {
	private String host;
	private int port;
	final static Logger logger = Logger.getLogger(Client.class);

	public void enviar(String contexto, HashMap<String, Object> session)
		{
		//Configure connections
		String host = PropertiesISW.getInstance().getProperty("host");
		int port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
		Logger.getRootLogger().info("Host: "+host+" port"+port);
		//Create a cliente class
		Client cliente=new Client(host, port);

		Message mensajeEnvio=new Message();
		Message mensajeVuelta=new Message();

		mensajeEnvio.setSession(session);
		mensajeEnvio.setContext(contexto);
		cliente.sent(mensajeEnvio,mensajeVuelta);
		
		
		switch (mensajeVuelta.getContext()) {

			case "/getCustomerResponse":
				ArrayList<Customer> customerList=(ArrayList<Customer>)(mensajeVuelta.getSession().get("Customer"));
				 for (Customer customer : customerList) {
						System.out.println("Nombre: "+customer.getNombreCompleto()+"; Edad: "+customer.getEdad()+ "; Nacionalidad: "+customer.getNacionalidad());
					}
				break;
			case "/getClienteResponse":
				Customer customer = (Customer)(mensajeVuelta.getSession().get("Usuario"));
				new InfoUsuario(customer);
				System.out.println("Usuario: "+customer.getUsuario());
				break;
			case "/addClienteResponse":
				System.out.println("\nSe ha enviado");
				if(mensajeVuelta.getComprobar()){
					System.out.println("\nSe ha introducido adecuadamente en la base de datos");
				}else System.out.println("\nNO se ha introducido adecuadamente en la base de datos");
				break;
			case "/updateClienteResponse":
				System.out.println("\nSe ha actualizado");
				break;
			case "/addClienteResponseError":
				System.out.println("\nEl cliente ya está en la base de datos");
				break;
			case "/getRestaurantesResponse":
				System.out.println("\nEstos son los restaurantes guardados en la base de datos");
				ArrayList<Restaurante> restauranteList=(ArrayList<Restaurante>)(mensajeVuelta.getSession().get("restaurantes"));
				for (Restaurante r : restauranteList) {
					System.out.println("Nombre: "+r.getNombre()+"; Dirección: "+r.getDireccion()+ "; Horario: "+r.getHorario());
				}
				break;
			default:
				Logger.getRootLogger().info("Option not found");
				System.out.println("\nError a la vuelta");
				break;
		
		}
		//System.out.println("3.- En Main.- El valor devuelto es: "+((String)mensajeVuelta.getSession().get("Nombre")));
	}
	public Client(){
	}

	public Client(String host, int port) {
		this.host=host;
		this.port=port;
	}
	

	public void sent(Message messageOut, Message messageIn) {
		try {

			System.out.println("Connecting to host " + host + " on port " + port + ".");

			Socket echoSocket = null;
			OutputStream out = null;
			InputStream in = null;

			try {
				echoSocket = new Socket(host, port);
				in = echoSocket.getInputStream();
				out = echoSocket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
				
				//Create the objetct to send
				objectOutputStream.writeObject(messageOut);
				
				// create a DataInputStream so we can read data from it.
		        ObjectInputStream objectInputStream = new ObjectInputStream(in);
		        Message msg=(Message)objectInputStream.readObject();
		        messageIn.setContext(msg.getContext());
		        messageIn.setSession(msg.getSession());
				messageIn.setComprobar(msg.getComprobar());
		        /*System.out.println("\n1.- El valor devuelto es: "+messageIn.getContext());
		        String cadena=(String) messageIn.getSession().get("Nombre");
		        System.out.println("\n2.- La cadena devuelta es: "+cadena);*/
				
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + host);
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Unable to get streams from server");
				System.exit(1);
			}		

			/** Closing all the resources */
			out.close();
			in.close();			
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}