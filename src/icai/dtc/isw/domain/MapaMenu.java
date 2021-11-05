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

public class MapaMenu {
    //variables y comtenedores
    private JLabel etiquetaSu;
    private JPanel pnlIzquierdo, pnlDerecho, pnlCentral;
    private JButton btnIz1, btnIz2, btnIz3, btnIz4, btnIz5;
    private JButton btnH, btnR, btnE, btnM, btnMu, btnP, btnPe;
    private JButton    btnIn1, btnIn2;
    private JScrollPane scroll;

    public void contruyepnlIzquierdo(){
        pnlIzquierdo = new JPanel();
        btnIz1=new JButton("General");
        btnIz2=new JButton("Zona norte");
        btnIz3=new JButton("Zona sur");
        btnIz4=new JButton("Zona este");
        btnIz5=new JButton("Zona oeste");
        pnlIzquierdo.setLayout(new BoxLayout(pnlIzquierdo,BoxLayout.Y_AXIS));
        //pnlIzquierdo.setBackground(Color.red);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz1);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz2);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz3);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz4);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz5);
        ImageIcon icon = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Restaurantes.PNG");
        JLabel label = new JLabel(icon);
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("CLICKED");
            }
        });
        pnlIzquierdo.add(label);
    }

    public void contruyepnlDerecho(){
        pnlDerecho = new JPanel();
        btnH = new JButton("Hoteles");
        btnR = new JButton("Restaurantes");
        btnE = new JButton("Eventos");
        btnM = new JButton("Monumentos");
        btnMu = new JButton("Museos");
        btnP = new JButton("Parques");
        btnPe = new JButton("Mi perfil");
        pnlDerecho.setLayout(new BoxLayout(pnlDerecho,BoxLayout.Y_AXIS));
        //pnlDerecho.setBackground(Color.blue);
        pnlDerecho.add(Box.createVerticalStrut(20));
        pnlDerecho.add(btnH);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnR);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnE);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnM);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnMu);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnP);
        pnlDerecho.add(Box.createVerticalStrut(350));
        pnlDerecho.add(btnPe);
    }

    public void contruyepnlCentral(){
        pnlCentral = new JPanel();
        ImageIcon image1 = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madridcentro.jpg", null);
        JLabel label1 = new JLabel(image1, JLabel.LEFT);
        pnlCentral.add(label1);
    }

    /*public void contruyepnlInferior(){
        pnlInferior = new JPanel();
        btnIn1=new JButton("Aceptar");
        btnIn2=new JButton("Cancelar");
        pnlInferior.setLayout(new FlowLayout());
        pnlInferior.setBackground(Color.green);
        pnlInferior.add(btnIn1);
        pnlInferior.add(btnIn2);
    }*/

    public void contruyeVentana(){
        JFrame frame = new JFrame("Mapa del centro de Madrid");
        //scroll = new JScrollPane(new JTextArea("JTextArea",10,15));
        etiquetaSu = new JLabel("Para ver más información sobre cada categoría haga click en los botones junto al mapa");
        Font aux=etiquetaSu.getFont();
        etiquetaSu.setFont(new Font(aux.getFontName(), aux.getStyle(), 16));
        frame.setLayout(new BorderLayout());

        //agregamos los pnles al frame principal
        frame.add(etiquetaSu,BorderLayout.NORTH);
        frame.add(pnlCentral, BorderLayout.CENTER);
        //frame.add(pnlIzquierdo,BorderLayout.WEST);
        frame.add(pnlDerecho,BorderLayout.EAST);
        //frame.add(pnlInferior,BorderLayout.SOUTH);
        //Configuramos el frame
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public MapaMenu(){
        //contruyepnlInferior();
        //contruyepnlIzquierdo();
        contruyepnlDerecho();
        contruyepnlCentral();
        contruyeVentana();

        btnH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Hotel> listaH= new ArrayList<>();

                Client client = new Client();
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("hotel",listaH);
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
                client.enviar("/getParques",session);
            }
        });
        btnPe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver mi perfil");
                //InfoUsuario iu = new InfoUsuario();
            }
        });
    }

    public static void main (String [] inforux){
        new MapaMenu();
    }
}
