package icai.dtc.isw.domain.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.exception.InicioSesionException;
import icai.dtc.isw.domain.exception.RegistroException;
import icai.dtc.isw.server.SocketServer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;


public class PanelInicio extends JFrame{
    public static void main(String[] argv){


       new PanelInicio();

    }
    private JPanel panelNorte = new JPanel((new BorderLayout()));
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JPanel panelPrincipal;
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

        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelPrincipal.add(panelSur, BorderLayout.SOUTH);

        //ImageIcon image1 = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madridcentro.jpg", null);
        //Dimension size = new Dimension(image1.getIconWidth(),image1.getIconHeight());

        //panelPrincipal.setPreferredSize(size);
        this.add(panelPrincipal,BorderLayout.CENTER);
        this.pack();
        //this.setLayout(null);

        //this.setSize(size);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }


}