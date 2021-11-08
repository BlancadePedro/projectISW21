package icai.dtc.isw.domain.paneles;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.localidad.Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PnlHoteles extends JFrame {
    private JPanel panelCentro = new JPanel((new GridLayout()));
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");

    public PnlHoteles(ArrayList<Hotel> lista, Customer perfil){
        int size = lista.size();
        panelCentro = new JPanel((new GridLayout(size,1)));
        for (Hotel l : lista) {
            JLabel label = new JLabel("Nombre: "+l.getNombre()+"; Dirección: "+l.getDireccion()+ "; Horario: "+l.getHorario());
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
