package icai.dtc.isw.domain.paneles;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.ocio.Evento;
import icai.dtc.isw.domain.ui.InfoUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PnlEventos extends JFrame {
    private JPanel panelCentro = new JPanel((new GridLayout()));
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");

    public PnlEventos(ArrayList<Evento> lista, Customer perfil){

        super("Información de todos los eventos disponibles");
        Font fuente = new Font("Tahoma", Font.ITALIC, 17);
        int size = lista.size();
        //nombre, String direccion, String precio, String autor, String celebracion, String fecha
        panelCentro = new JPanel((new GridLayout(size,1)));
        for (Evento l : lista) {
            JLabel label = new JLabel("-"+l.getNombre()+"; Dirección: "+l.getDireccion()+ "; Autor: "+l.getAutor()+"; Precio: "+l.getPrecio()+"; Fecha: "+l.getFecha()+"; Es un "+l.getCelebracion()+"\n");
            label.setFont(fuente);
            panelCentro.add(label);
        }
        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent){

                dispose();

            }
        });

        panelSur.add(btnVolver);

        this.add(panelCentro,BorderLayout.CENTER);
        this.add(panelSur,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
