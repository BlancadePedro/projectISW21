package icai.dtc.isw.domain;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.dao.ConnectionDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.server.SocketServer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.*;


public class PanelInicio extends JFrame{
    public static void main(String[] argv){


       new PanelInicio();

    }
    private JPanel panelNorte = new JPanel((new BorderLayout()));
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton registro = new JButton("resgistro");
    private JButton inicioSesion = new JButton("inicio sesión");
    private JLabel foto = new JLabel();

    public PanelInicio(){
        super("Smart City");
        panelSur.add(registro, BorderLayout.EAST);
        panelSur.add(inicioSesion, BorderLayout.WEST);

        Image imagen = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/smartCity.png").getImage();
        ImageIcon icono = new ImageIcon(imagen.getScaledInstance(250, 250 , Image.SCALE_SMOOTH));
        foto.setIcon(icono);
        panelNorte.add(foto,BorderLayout.CENTER);

        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = JOptionPane.showInputDialog("Introduzca su nombre de usuario");
                String contraseña = JOptionPane.showInputDialog("Introduzca su contraseña");
                Customer perfilException = new Customer(null, null, 0, null, null, 0, usuario, contraseña, 0);

                if (SocketServer.comprobacion(perfilException)==null){
                    new Registro(usuario, contraseña);
                    dispose();
                }
                else try {
                    throw new RegistroException();
                } catch (RegistroException ex) {
                    ex.printStackTrace();
                }
            }
        });

        inicioSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = JOptionPane.showInputDialog("Introduzca su nombre de usuario");
                String contraseña = JOptionPane.showInputDialog("Introduzca su contraseña");
                Customer perfilException = new Customer(null, null, 0, null, null, 0, usuario, contraseña, 0);
                if (SocketServer.comprobacion(perfilException)!=null){
                    Client client = new Client();
                    HashMap<String, Object> session = new HashMap<String, Object>();
                    session.put("usuario",usuario);
                    session.put("contraseña", contraseña);
                    client.enviar("/getUsuario",session);

                    dispose();
                }
                else try {
                    throw new InicioSesionException();
                } catch (InicioSesionException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelSur, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


}
