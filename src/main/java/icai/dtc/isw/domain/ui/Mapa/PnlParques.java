package icai.dtc.isw.domain.ui.Mapa;

import icai.dtc.isw.domain.ui.Usuario.Customer;
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
        int contador=0;
        panelCentro = new JPanel((new GridLayout(size*2,1)));
        panelCentro.setBackground(new Color(174, 214, 241));
        for (Parque l : lista) {
            int indice = contador;
            JLabel label = new JLabel(indice+"_"+l.getNombre()+"; Dirección: "+l.getDireccion()+ "; Horario: "+l.getHorario()+"\n");
            JLabel espacio = new JLabel(" ");
            label.setFont(fuente);
            panelCentro.add(label);
            panelCentro.add(espacio);
            contador=contador+1;
        }
        btnVolver.setBackground(new Color(52, 152, 219));
        btnVolver.setForeground(Color.WHITE);
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
