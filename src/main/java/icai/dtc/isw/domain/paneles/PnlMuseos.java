package icai.dtc.isw.domain.paneles;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.localidad.Museo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PnlMuseos extends JFrame {
    private JPanel panelCentro = new JPanel((new GridLayout()));
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");

    public PnlMuseos(ArrayList<Museo> lista, Customer perfil){
        super("Información de todos los hoteles disponibles");
        Font fuente = new Font("Tahoma", Font.ITALIC, 17);
        int size = lista.size();
        //String nombre, String direccion, String horario, String contacto, String precio, String tipoMuseo
        panelCentro = new JPanel((new GridLayout(size,1)));
        for (Museo l : lista) {
            JLabel label = new JLabel("\n -"+l.getNombre()+"; Dirección: "+l.getDireccion()+ "; Horario: "+l.getHorario()+"; Contacto: "+l.getContacto()+"; Precio: "+l.getPrecio()+"; El museo es de: "+l.getTipoMuseo()+"");
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
