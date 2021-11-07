package icai.dtc.isw.domain;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.dao.CustomerDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class MapaMenu extends JFrame{
    //variables y comtenedores
    private JLabel etiquetaSu;
    private JPanel pnlCentral, pnlSuperior;
    private JButton btnH, btnR, btnE, btnM, btnMu, btnP;
    private JComboBox<String> opciones;
    private JButton btnIz1, btnIz2, btnIz3, btnIz4, btnIz5;
    private JButton btnPerfil;
    private JButton    btnIn1, btnIn2;
    private JScrollPane scroll;




    public void contruyepnlCentral(){
        pnlCentral = new JPanel();
        ImageIcon image1 = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madridcentro.jpg", null);
        JLabel label1 = new JLabel(image1, JLabel.LEFT);
        pnlCentral.add(label1);
    }

    public void contruyepnlSuperior(Customer customer){
        pnlSuperior = new JPanel(new FlowLayout());
        opciones= new JComboBox<String>();

        etiquetaSu = new JLabel("Para ver más información haga click en el mapa");
        Font aux=etiquetaSu.getFont();
        etiquetaSu.setFont(new Font(aux.getFontName(), aux.getStyle(), 16));

        btnH = new JButton("Hoteles");
        btnR = new JButton("Restaurantes");
        btnE = new JButton("Eventos");
        btnM = new JButton("Monumentos");
        btnMu = new JButton("Museos");
        btnP = new JButton("Parques");

        opciones.addItem("INFO");
        opciones.addItem("Mi perfil");
        opciones.addItem("Mi Agenda");
        opciones.addItem("Mi Chat");
        opciones.addItem("Mis favoritos");
        opciones.addItem("Información importante");
        opciones.addItem("Cerrar sesión");


        opciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String opcion = (String)opciones.getSelectedItem();
                if(opcion!=null){
                    if(opcion.equals("Mi perfil")){

                        new InfoUsuario(customer);
                        dispose();
                    }
                    if(opcion.equals("Mi Agenda")){
                        new Agenda(customer);
                        dispose();
                    }
                    if(opcion.equals("Información importante")){
                        System.out.println("En proceso");
                    }
                    if(opcion.equals("Mi Chat")){
                        System.out.println("En proceso");
                    }
                    if(opcion.equals("Mis favoritos")){
                        System.out.println("En proceso");
                    }
                    if(opcion.equals("Cerrar sesión")){
                        JOptionPane.showMessageDialog(null,"Adios, vuelva pronto!");
                        dispose();
                    }

                }
            }
        });


        btnH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Hotel> listaH= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("hotel",listaH);
                session.put("perfil",customer);
                client.enviar("/getHoteles",session);

            }
        });
        btnR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Restaurante> listaR = new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("restaurantes",listaR);
                session.put("perfil",customer);
                client.enviar("/getRestaurantes",session);

            }
        });
        btnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Evento> listaE= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("eventos",listaE);
                session.put("perfil",customer);
                client.enviar("/getEventos",session);

            }
        });
        btnM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Monumento> listaM= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("monumento",listaM);
                session.put("perfil",customer);
                client.enviar("/getMonumentos",session);

            }
        });
        btnMu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Museo> listaM= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("museo",listaM);
                session.put("perfil",customer);
                client.enviar("/getMuseos",session);

            }
        });
        btnP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Parque> listaP= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("parques",listaP);
                session.put("perfil",customer);
                client.enviar("/getParques",session);
            }
        });

        pnlSuperior.add(opciones);
        pnlSuperior.add(btnH);
        pnlSuperior.add(btnR);
        pnlSuperior.add(btnE);
        pnlSuperior.add(btnM);
        pnlSuperior.add(btnMu);
        pnlSuperior.add(btnP);

    }


    public MapaMenu(Customer customer){

        contruyepnlCentral();
        contruyepnlSuperior(customer);
        //contruyeVentana();

        this.add(pnlSuperior,BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);

        //Configuramos el frame
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    /*public static void main (String [] inforux){
        Customer prueba = new Customer(null, null, 0, null, null, 0, "usuario", "contraseña", 0);
        new MapaMenu(prueba);
    }*/
}
