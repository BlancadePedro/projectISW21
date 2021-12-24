package icai.dtc.isw.domain.paneles;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.ocio.Parque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PnlParques extends JFrame {
    private JPanel panelCentro = new JPanel((new GridLayout()));
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");

    public PnlParques(ArrayList<Parque> lista, Customer perfil){
        super("Información de todos los parques disponibles");
        Font fuente = new Font("Tahoma", Font.ITALIC, 17);
        int size = lista.size();
        panelCentro = new JPanel((new GridLayout(size,1)));
        for (Parque l : lista) {
            JLabel label = new JLabel("-"+l.getNombre()+"; Dirección: "+l.getDireccion()+ "; Horario: "+l.getHorario()+"\n");
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
