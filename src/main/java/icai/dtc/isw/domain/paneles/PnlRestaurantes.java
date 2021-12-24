package icai.dtc.isw.domain.paneles;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.localidad.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

public class PnlRestaurantes extends JFrame {
    private JPanel panelCentro = new JPanel((new GridLayout()));
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");


    public PnlRestaurantes(ArrayList<Restaurante> lista, Customer perfil){
        super("Información de todos los restaurantes disponibles");
        Font fuente = new Font("Tahoma", Font.ITALIC, 17);
        int size = lista.size();
        //String nombre, String direccion, String horario, String contacto, String precio, String tipoComida
        panelCentro = new JPanel((new GridLayout(size,1)));
        for (Restaurante l : lista) {
            JLabel label = new JLabel("-"+l.getNombre()+"; Dirección: "+l.getDireccion()+ "; Horario: "+l.getHorario()+"; Contacto: "+l.getContacto()+"; Precio: "+l.getPrecio()+"; Es "+l.getTipoComida());
            label.setFont(fuente);
            panelCentro.add(label);
        }
        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent){

                dispose();

            }
        });

        addWindowListener(new WindowAdapter() {

        });

        panelSur.add(btnVolver, BorderLayout.CENTER);

        this.add(panelCentro,BorderLayout.CENTER);
        this.add(panelSur,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
