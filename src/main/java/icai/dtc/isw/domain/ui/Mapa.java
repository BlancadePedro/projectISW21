package icai.dtc.isw.domain.ui;

import icai.dtc.isw.domain.localidad.Hotel;
import icai.dtc.isw.domain.ocio.Monumento;
import icai.dtc.isw.domain.localidad.Museo;
import icai.dtc.isw.domain.localidad.Restaurante;
import icai.dtc.isw.domain.ocio.Evento;
import icai.dtc.isw.domain.ocio.Parque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Mapa extends JFrame {

    private static JPanel pnlMapa = new JPanel(new CardLayout());
    JPanel panelSuperior, panelInferior,panelInf1, panelInf2, panelInf3;
    JLabel etiqueta, etiqueta1, etiqueta2,etiqueta3;
    JComboBox combo;
    String [] vectorCadena = {"panel1","panel2","panel3"};

    /*public static void main(String[] argv){

        new Mapa();

    }*/


    
    public Mapa(){
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        //Compobacion de que funciona-> Lo dejo por si se necesita, pero se podría borrar


        //botonesMapa(museo, pnlMapa,250,100);
        this.add(pnlMapa);



        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

