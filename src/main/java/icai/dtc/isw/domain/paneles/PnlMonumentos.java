package icai.dtc.isw.domain.paneles;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.ocio.Monumento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PnlMonumentos extends JFrame {
    private JPanel panelCentro = new JPanel((new GridLayout()));
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");

    public PnlMonumentos(ArrayList<Monumento> lista, Customer perfil){

        int size = lista.size();
        panelCentro = new JPanel((new GridLayout(size,1)));
        for (Monumento l : lista) {
            JLabel label = new JLabel("Nombre: "+l.getNombre()+"; Dirección: "+l.getDireccion());
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
