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

        botonesMapa(museo, pnlMapa,250,100);
        this.add(pnlMapa);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void botonesMapa(Object objects, JPanel panel, int x, int y){

        JButton btn = new JButton();
        Image imagen = null;

        if(objects instanceof Restaurante){
            System.out.println("Restaurante");
            imagen = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Restaurantes.PNG").getImage();

        }
        if(objects instanceof Hotel){
            System.out.println("Hotel");
            imagen = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Hoteles.PNG").getImage();
        }
        if(objects instanceof Museo){
            System.out.println("Museo");
            imagen = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Museo.PNG").getImage();
        }
        if(objects instanceof  Monumento){
            System.out.println("Monumento");
            imagen = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Monumentos.PNG").getImage();
        }
        if(objects instanceof  Parque){
            System.out.println("Parque");
            imagen = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Parques.PNG").getImage();
        }
        if(objects instanceof  Evento){
            System.out.println("Evento");
            imagen = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Eventos.PNG").getImage();
        }
        ImageIcon icono = new ImageIcon(imagen.getScaledInstance(x, y , Image.SCALE_SMOOTH));
        btn.setIcon(icono);
        //btn.setSize(new Dimension(x,y));
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

