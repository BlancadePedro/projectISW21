package icai.dtc.isw.domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class InfoUsuario extends JFrame
{
    public static void main(String[] argv){
        Customer perfil = new Customer("correo", "descripcion", 20, "nacionalidad","nombreCompleto", 646513445, "usuario","clave");
        new InfoUsuario(perfil);

    }
    private JPanel info = new JPanel(new GridLayout(6, 1));
    private JPanel pnlfoto = new JPanel((new BorderLayout()));

    
    private JLabel lblNombre = new JLabel();
    private JLabel lblEdad = new JLabel();
    private JLabel lblNacionalidad = new JLabel();
    private JLabel lblDescripcion = new JLabel();
    private JLabel lblCorreo = new JLabel();
    private JLabel lblTelefono = new JLabel();

    private JComboBox<String> opcionesFotos = new JComboBox<>();

    public InfoUsuario(Customer perfil) {
    
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        String nombre = perfil.getNombreCompleto();
        int edad = perfil.getEdad();
        String nacionalidad = perfil.getNacionalidad();
        String descripcion = perfil.getDescripcion();
        int telefono = perfil.getTelefono();
        String correo = perfil.getCorreo();

        lblNombre.setText(nombre);
        lblEdad.setText(String.valueOf(edad));
        lblNacionalidad.setText(nacionalidad);
        lblDescripcion.setText(descripcion);
        lblTelefono.setText(String.valueOf(telefono));
        lblCorreo.setText(correo);

        info.add(lblNombre);
        info.add(lblEdad);
        info.add(lblNacionalidad);
        info.add(lblDescripcion);
        info.add(lblCorreo);
        info.add(lblTelefono);

        opcionesFotos();
        pnlfoto.add(opcionesFotos, BorderLayout.NORTH);
        opcionesFotos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int res = opcionesFotos.getSelectedIndex();
                JLabel foto = new JLabel();

                if(res == 1){
                    //foto.setIcon(null);
                    foto.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Eventos.PNG"));
                }
                if(res == 2){
                    //foto.setIcon(null);
                    foto.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Hoteles.PNG"));
                }
                if(res == 3){
                    foto.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Museo.PNG"));
                }
                if(res == 4){
                    foto.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Monumentos.PNG"));
                }
                if(res == 5){
                    foto.setIcon(new ImageIcon("/home/blanca/IdeaProjects/projectISW19/src/icai/dtc/isw/resources/FotosMapa/Restaurantes.PNG"));
                }
                pnlfoto.add(foto,BorderLayout.CENTER);

            }
        });

        this.add(info,BorderLayout.EAST);
        this.add(pnlfoto,BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }
    public void opcionesFotos(){
        opcionesFotos.removeAllItems();
        opcionesFotos.addItem("Personaje 1");
        opcionesFotos.addItem("Personaje 2");
        opcionesFotos.addItem("Personaje 3");
        opcionesFotos.addItem("Personaje 4");
        opcionesFotos.addItem("Personaje 5");

    }


    
}
