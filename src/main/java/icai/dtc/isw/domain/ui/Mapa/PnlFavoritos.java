package icai.dtc.isw.domain.ui.Mapa;

import icai.dtc.isw.domain.ui.Usuario.Customer;
import icai.dtc.isw.domain.localidad.Hotel;
import icai.dtc.isw.domain.localidad.Museo;
import icai.dtc.isw.domain.localidad.Restaurante;
import icai.dtc.isw.domain.ocio.Evento;
import icai.dtc.isw.domain.ocio.Monumento;
import icai.dtc.isw.domain.ocio.Parque;
import icai.dtc.isw.domain.ui.MapaMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PnlFavoritos extends JFrame {
    private JPanel panelCentro;
    private JPanel panelSur = new JPanel((new BorderLayout()));
    private JButton btnVolver = new JButton("Cerrar");

    public PnlFavoritos(ArrayList<Object> barrioList, Customer perfil) {
        int size = barrioList.size();
        panelCentro = new JPanel((new GridLayout(size,2)));
        ArrayList<JButton> btnList = new ArrayList<JButton>();
        JButton btnEliminar;

        int contador=0;
        for (Object l : barrioList) {
            if (l instanceof Hotel){
                Hotel h = (Hotel)l;
                JLabel label = new JLabel("Nombre: "+h.getNombre()+"; Dirección: "+h.getDireccion()+ "; Horario: "+h.getHorario());
                panelCentro.add(label);
            }else if(l instanceof Restaurante){
                Restaurante r = (Restaurante)l;
                JLabel label = new JLabel("Nombre: "+r.getNombre()+"; Dirección: "+r.getDireccion()+ "; Horario: "+r.getHorario());
                panelCentro.add(label);
            }else if(l instanceof Museo) {
                Museo m = (Museo) l;
                JLabel label = new JLabel("Nombre: "+m.getNombre()+"; Dirección: "+m.getDireccion()+ "; Horario: "+m.getHorario());
                panelCentro.add(label);
            }else if(l instanceof Parque) {
                Parque p = (Parque) l;
                JLabel label = new JLabel("Nombre: "+p.getNombre()+"; Dirección: "+p.getDireccion()+ "; Horario: "+p.getHorario());
                panelCentro.add(label);
            }else if(l instanceof Monumento) {
                Monumento mo = (Monumento) l;
                JLabel label = new JLabel("Nombre: "+mo.getNombre()+"; Dirección: "+mo.getDireccion());
                panelCentro.add(label);
            }else if(l instanceof Evento) {
                Evento e = (Evento) l;
                JLabel label = new JLabel("Nombre: "+e.getNombre()+"; Dirección: "+e.getDireccion()+ "; Autor: "+e.getAutor());
                panelCentro.add(label);
            }
            btnEliminar = new JButton("Eliminar de favoritos");
            int finalContador = contador;
            btnEliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se ha pulsado boton de "+barrioList.get(finalContador));
                    MapaMenu.eliminarFavorito(barrioList.get(finalContador));
                    dispose();
                    //new PnlFavoritos(barrioList,perfil);
                }
            });
            btnList.add(btnEliminar);
            panelCentro.add(btnEliminar);
            contador=contador+1;
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

        this.setTitle("Estos son los lugares que tiene guardados en favoritos");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
