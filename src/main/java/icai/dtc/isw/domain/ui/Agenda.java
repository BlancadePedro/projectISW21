package icai.dtc.isw.domain.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.controler.AgendaControler;
import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.localidad.Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Agenda extends JFrame{
    JPanel pnlInfo;
    JPanel pnlBotones;
    public Agenda(Customer perfil, ArrayList<FranjaHoraria> lista){
        Font fuente = new Font("Tahoma", Font.ITALIC, 17);
        int size = lista.size();
        //String nombre, String direccion, String horario, String contacto, String precio, String estrellas, String mascotas, String public
        pnlInfo = new JPanel((new GridLayout(size,4)));
        for (FranjaHoraria l : lista) {
            JLabel hora = new JLabel("Hora: "+l.getHora());
            JLabel dia = new JLabel("Día: "+l.getDia());
            JLabel mes = new JLabel("Mes: "+l.getMes());
            JLabel descripcion = new JLabel("Descripcion: "+l.getDescripcion());
            JLabel espacio = new JLabel(" ");
            pnlInfo.add(hora);
            pnlInfo.add(dia);
            pnlInfo.add(mes);
            pnlInfo.add(descripcion);
            //pnlInfo.add(espacio);
        }

        this.add(pnlInfo,BorderLayout.CENTER);
        //this.add(pnlBotones,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}