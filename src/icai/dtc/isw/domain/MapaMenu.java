package icai.dtc.isw.domain;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.dao.CustomerDAO;

import javax.accessibility.Accessible;
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
    private JButton btnChueca, btnCondeDuque, btnMalasana, btnSalamanca, btnSalesas, btnLetras;
    private JButton btnAustrias, btnSol, btnPaseoArte, btnRetiro, btnMoncloa, btnLatina;
    private JButton    btnIn1, btnIn2;
    private JScrollPane scroll;




    public void contruyepnlCentral(){
        pnlCentral = new JPanel();
        /*ImageIcon image1 = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madridcentro.jpg", null);
        JLabel label1 = new JLabel(image1, JLabel.LEFT);
        pnlCentral.add(label1);*/

        //Click en los barrios
        Container c = new JLabel(new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madridcentro.jpg", null));
        c.setLayout(null);

        btnChueca = new JButton("CHUECA");
        btnChueca.setBackground(new Color(182,255,220));
        Dimension size = btnChueca.getPreferredSize();
        btnChueca.setBounds(809, 295, 100, size.height);
        c.add(btnChueca);
        btnChueca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Chueca");
            }
        });

        btnCondeDuque = new JButton("CONDE DUQUE");
        btnCondeDuque.setBackground(new Color(255,200,180));
        btnCondeDuque.setBounds(450, 70, 143, size.height);
        c.add(btnCondeDuque);
        btnCondeDuque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Conde Duque");
            }
        });

        btnMalasana = new JButton("MALASAÑA");
        btnMalasana.setBackground(new Color(220,190,255));
        btnMalasana.setBounds(580, 300, 120, size.height);
        c.add(btnMalasana);
        btnMalasana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Malasaña");
            }
        });

        btnSalamanca = new JButton("SALAMANCA");
        btnSalamanca.setBackground(new Color(255,180,210));
        btnSalamanca.setBounds(1218, 82, 142, size.height);
        c.add(btnSalamanca);
        btnSalamanca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Salamanca");
            }
        });

        btnSalesas = new JButton("SALESAS");
        btnSalesas.setBackground(new Color(190,224,255));
        btnSalesas.setBounds(960, 320, 100, size.height);
        c.add(btnSalesas);
        btnSalesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Salesas");
            }
        });

        btnLetras = new JButton("LETRAS");
        btnLetras.setBackground(new Color(186,121,93));
        btnLetras.setBounds(840, 640, 100, size.height);
        c.add(btnLetras);
        btnLetras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Letras");
            }
        });

        btnAustrias = new JButton("AUSTRIAS");
        btnAustrias.setBackground(new Color(224,224,224));
        btnAustrias.setBounds(400, 558, 110, size.height);
        c.add(btnAustrias);
        btnAustrias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Austrias");
            }
        });

        btnSol = new JButton("SOL");
        btnSol.setBackground(new Color(150,220,255));
        btnSol.setBounds(716, 595, 70, size.height);
        c.add(btnSol);
        btnSol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Sol");
            }
        });

        btnRetiro = new JButton("EL RETIRO");
        btnRetiro.setBackground(new Color(210,255,204));
        btnRetiro.setBounds(1172, 525, 110, size.height);
        c.add(btnRetiro);
        btnRetiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio El Retiro");
            }
        });

        btnPaseoArte = new JButton("PASEO DEL ARTE");
        btnPaseoArte.setBackground(new Color(255,230,80));
        btnPaseoArte.setBounds(1048, 606, 150, size.height);
        c.add(btnPaseoArte);
        btnPaseoArte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Paseo del Arte");
            }
        });

        btnMoncloa = new JButton("MONCLOA");
        btnMoncloa.setBackground(new Color(255,255,202));
        btnMoncloa.setBounds(140, 180, 110, size.height);
        c.add(btnMoncloa);
        btnMoncloa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio Moncloa");
            }
        });

        btnLatina = new JButton("LA LATINA");
        btnLatina.setBackground(new Color(220,90,120));
        btnLatina.setBounds(270, 725, 110, size.height);
        c.add(btnLatina);
        btnLatina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver barrio La Latina");
            }
        });

        pnlCentral.add(c);
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
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main (String [] inforux){
        Customer prueba = new Customer(null, null, 0, null, null, 0, "usuario", "contraseña", 0);
        new MapaMenu(prueba);
    }
}
