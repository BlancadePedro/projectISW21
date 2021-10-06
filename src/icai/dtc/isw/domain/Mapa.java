package icai.dtc.isw.domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;



public class Mapa extends JFrame {

    private static JPanel pnlMapa = new JPanel(new FlowLayout());

    public static void main(String[] argv){

        new Mapa();

    }


    
    public Mapa(){
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        //Compobacion de que funciona-> Lo dejo por si se necesita, pero se podría borrar

        Restaurante restaurante = new Restaurante("nombre","direccion","horario","contacto","precio","tipoComida");
        Hotel hotel = new Hotel("nombre", "direccion", "horario", "contacto", "precio", "estrellas", "mascotas", "publico");
        Museo museo = new Museo("nombre", "direccion", "horario", "contacto", "precio","tipoMuseo");
        Evento evento = new Evento("nombre", "direccion", "precio", "autor", "celebracion", "fecha");
        Monumento monumento = new Monumento("nombre", "direccion");
        Parque parque = new Parque("nombre", "direccion");

        botonesMapa(museo, pnlMapa,100,100);
        this.add(pnlMapa);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void botonesMapa(Object objects, JPanel panel, int x, int y){

        JButton btn = new JButton();

        if(objects instanceof Restaurante){
            System.out.println("Restaurante");
            btn.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Restaurantes.PNG"));
        }
        if(objects instanceof Hotel){
            System.out.println("Hotel");
            btn.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Hoteles.PNG"));
        }
        if(objects instanceof Museo){
            System.out.println("Museo");
            btn.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Museo.PNG"));
        }
        if(objects instanceof  Monumento){
            System.out.println("Monumento");
            btn.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Monumentos.PNG"));
        }
        if(objects instanceof  Parque){
            System.out.println("Parque");
            btn.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Parques.PNG"));
        }
        if(objects instanceof  Evento){
            System.out.println("Evento");
            btn.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Eventos.PNG"));
        }

        btn.setBounds(x,y,5,5);
        panel.add(btn);

        btn.addActionListener(new ActionListener() {
            //Prueba para ver si funciona -> Rellenar info base de datos (ALE)
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(objects.toString());
            }
        });
    }






    

    
}

