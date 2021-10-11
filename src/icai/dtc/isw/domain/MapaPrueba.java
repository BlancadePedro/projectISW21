package icai.dtc.isw.domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class MapaPrueba {
    //variables y comtenedores
    private JLabel etiquetaSu;
    private JPanel pnlIzquierdo, pnlDerecho, pnlCentral;
    private JButton btnIz1, btnIz2, btnIz3, btnIz4, btnIz5;
    private JButton btnDe1, btnDe2, btnDe3;
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
    }

    public void contruyepnlDerecho(){
        pnlDerecho = new JPanel();
        JButton btnH = new JButton("Hoteles");
        JButton btnR = new JButton("Restaurantes");
        JButton btnE = new JButton("Eventos");
        JButton btnM = new JButton("Monumentos");
        JButton btnMu = new JButton("Museos");
        JButton btnP = new JButton("Parques");
        pnlDerecho.setLayout(new BoxLayout(pnlDerecho,BoxLayout.Y_AXIS));
        //pnlDerecho.setBackground(Color.blue);
        pnlDerecho.add(Box.createVerticalStrut(40));
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
        JFrame frame = new JFrame("Mapa de Madrid");
        //scroll = new JScrollPane(new JTextArea("JTextArea",10,15));
        etiquetaSu = new JLabel("Mapa de madrid");
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

    public MapaPrueba(){
        //contruyepnlInferior();
        //contruyepnlIzquierdo();
        contruyepnlDerecho();
        contruyepnlCentral();
        contruyeVentana();
    }

    public static void main (String [] inforux){
        new MapaPrueba();
    }
}
