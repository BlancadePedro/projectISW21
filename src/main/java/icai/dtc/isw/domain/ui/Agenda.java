package icai.dtc.isw.domain.ui;

import icai.dtc.isw.dao.AgendaDAO;
import icai.dtc.isw.domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Agenda extends JFrame{

    private JPanel pnlBotones;
    private JPanel pnlFecha;
    private JButton btnAñadir = new JButton("Añadir");
    private JButton btnModificar = new JButton("Modificar");
    private JButton btnVolver = new JButton("Volver menú principal");

    public Agenda(Customer perfil, ArrayList<FranjaHoraria> lista){

        LocalDate hoy = LocalDate.now();
        String fecha = "Agenda para el día " + hoy.getDayOfMonth() + " de " + hoy.getMonth() + " de " + hoy.getYear();

        //lista = establecerID(lista);

        Font fuente = new Font("Tahoma", Font.ITALIC, 17);
        Font fuenteTitulo = new Font("Tahoma", Font.BOLD, 17);

        int size = lista.size();
        pnlFecha = new JPanel((new GridLayout(size,5)));
        pnlBotones = new JPanel(new FlowLayout());

        for (FranjaHoraria l : lista) {

            JLabel hora = new JLabel("Hora: "+l.getHora());
            hora.setFont(fuenteTitulo);
            JLabel dia = new JLabel("Día: "+l.getDia());
            dia.setFont(fuenteTitulo);
            JLabel mes = new JLabel("Mes: "+l.getMes());
            mes.setFont(fuenteTitulo);
            JLabel año = new JLabel("Año: "+l.getAño());
            año.setFont(fuenteTitulo);

            JLabel descripcion = new JLabel("Descripcion: "+l.getDescripcion());
            descripcion.setFont(fuenteTitulo);
            pnlFecha.add(hora);
            pnlFecha.add(dia);
            pnlFecha.add(mes);
            pnlFecha.add(año);

            pnlFecha.add(descripcion);
        }

        pnlBotones.add(btnAñadir);
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnVolver);

        btnModificar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Me voy a modificar mi agenda");

                new ModificarAgenda(perfil, lista);
                dispose();
            }
        });


        btnAñadir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println("Me voy a modificar mi agenda");

                new AñadirAgenda(perfil,size);
                dispose();

            }
        });


        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                new MapaMenu(perfil);
                dispose();

            }
        });


        this.add(pnlFecha,BorderLayout.CENTER);
        this.add(pnlBotones,BorderLayout.SOUTH);
        this.setTitle(fecha);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /*public static ArrayList<FranjaHoraria> establecerID(ArrayList<FranjaHoraria> lista,Customer perfil){
        int size = lista.size();
        ArrayList<FranjaHoraria> listaNueva= new ArrayList<>();
        for(int i = 0; i<size;i++){
            lista.get(i).setIdAgenda(i+1);
            AgendaDAO.updateAgenda(lista.get(i), perfil);
        }
        return listaNueva;
    }*/

}