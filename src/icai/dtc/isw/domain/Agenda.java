package icai.dtc.isw.domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class Agenda extends JFrame{
    private JPanel pnlCentral;
    private JPanel pnlSur = new JPanel((new BorderLayout()));
    private JButton btnMapa, btnPerfil;

    public void construyepnlCentral() {
        pnlCentral = new JPanel(new GridLayout(26, 2, 2, 4));
        JLabel label0 = new JLabel("    00:00-1:00");
        JLabel label1 = new JLabel("    1:00-2:00");
        JLabel label2 = new JLabel("    2:00-3:00");
        JLabel label3 = new JLabel("    3:00-4:00");
        JLabel label4 = new JLabel("    4:00-5:00");
        JLabel label5 = new JLabel("    5:00-6:00");
        JLabel label6 = new JLabel("    6:00-7:00");
        JLabel label7 = new JLabel("    7:00-8:00");
        JLabel label8 = new JLabel("    8:00-9:00");
        JLabel label9 = new JLabel("    9:00-10:00");
        JLabel label10 = new JLabel("    10:00-11:00");
        JLabel label11 = new JLabel("    11:00-12:00");
        JLabel label12 = new JLabel("    12:00-13:00");
        JLabel label13 = new JLabel("    13:00-14:00");
        JLabel label14 = new JLabel("    14:00-15:00");
        JLabel label15 = new JLabel("    15:00-16:00");
        JLabel label16 = new JLabel("    16:00-17:00");
        JLabel label17 = new JLabel("    17:00-18:00");
        JLabel label18 = new JLabel("    18:00-19:00");
        JLabel label19 = new JLabel("    19:00-20:00");
        JLabel label20 = new JLabel("    20:00-21:00");
        JLabel label21 = new JLabel("    21:00-22:00");
        JLabel label22 = new JLabel("    22:00-23:00");
        JLabel label23 = new JLabel("    23:00-00:00");
        JTextField textFranja0 = new JTextField(20);
        JTextField textFranja1 = new JTextField(20);
        JTextField textFranja2 = new JTextField(20);
        JTextField textFranja3 = new JTextField(20);
        JTextField textFranja4 = new JTextField(20);
        JTextField textFranja5 = new JTextField(20);
        JTextField textFranja6 = new JTextField(20);
        JTextField textFranja7 = new JTextField(20);
        JTextField textFranja8 = new JTextField(20);
        JTextField textFranja9 = new JTextField(20);
        JTextField textFranja10 = new JTextField(20);
        JTextField textFranja11 = new JTextField(20);
        JTextField textFranja12 = new JTextField(20);
        JTextField textFranja13 = new JTextField(20);
        JTextField textFranja14 = new JTextField(20);
        JTextField textFranja15 = new JTextField(20);
        JTextField textFranja16 = new JTextField(20);
        JTextField textFranja17 = new JTextField(20);
        JTextField textFranja18 = new JTextField(20);
        JTextField textFranja19 = new JTextField(20);
        JTextField textFranja20 = new JTextField(20);
        JTextField textFranja21 = new JTextField(20);
        JTextField textFranja22 = new JTextField(20);
        JTextField textFranja23 = new JTextField(20);
        //String texto = textFranja0.getText();

        LocalDate hoy = LocalDate.now();
        JLabel labelFecha = new JLabel("Agenda para el día " + hoy.getDayOfMonth() + " de " + hoy.getMonth() + " de " + hoy.getYear());
        JLabel labelHueco = new JLabel("");

        pnlCentral.add(labelFecha);
        pnlCentral.add(labelHueco);
        pnlCentral.add(label0);
        pnlCentral.add(textFranja0);
        pnlCentral.add(label1);
        pnlCentral.add(textFranja1);
        pnlCentral.add(label2);
        pnlCentral.add(textFranja2);
        pnlCentral.add(label3);
        pnlCentral.add(textFranja3);
        pnlCentral.add(label4);
        pnlCentral.add(textFranja4);
        pnlCentral.add(label5);
        pnlCentral.add(textFranja5);
        pnlCentral.add(label6);
        pnlCentral.add(textFranja6);
        pnlCentral.add(label7);
        pnlCentral.add(textFranja7);
        pnlCentral.add(label8);
        pnlCentral.add(textFranja8);
        pnlCentral.add(label9);
        pnlCentral.add(textFranja9);
        pnlCentral.add(label10);
        pnlCentral.add(textFranja10);
        pnlCentral.add(label11);
        pnlCentral.add(textFranja11);
        pnlCentral.add(label12);
        pnlCentral.add(textFranja12);
        pnlCentral.add(label13);
        pnlCentral.add(textFranja13);
        pnlCentral.add(label14);
        pnlCentral.add(textFranja14);
        pnlCentral.add(label15);
        pnlCentral.add(textFranja15);
        pnlCentral.add(label16);
        pnlCentral.add(textFranja16);
        pnlCentral.add(label17);
        pnlCentral.add(textFranja17);
        pnlCentral.add(label18);
        pnlCentral.add(textFranja18);
        pnlCentral.add(label19);
        pnlCentral.add(textFranja19);
        pnlCentral.add(label20);
        pnlCentral.add(textFranja20);
        pnlCentral.add(label21);
        pnlCentral.add(textFranja21);
        pnlCentral.add(label22);
        pnlCentral.add(textFranja22);
        pnlCentral.add(label23);
        pnlCentral.add(textFranja23);
    }

    public void construyepnlSur() {
        pnlSur = new JPanel();
        btnMapa = new JButton("Ir al mapa");
        btnPerfil = new JButton("Mi perfil");
        pnlCentral.add(btnMapa);
        pnlCentral.add(btnPerfil);
    }

    public void construyeVentana() {
        this.setLayout(new BorderLayout());

        //agregamos el panel al frame principal
        this.add(pnlCentral, BorderLayout.NORTH);
        this.add(pnlSur, BorderLayout.SOUTH);
        //Configuramos el frame
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public Agenda(Customer perfil) {
        construyepnlCentral();
        construyepnlSur();
        construyeVentana();

        btnMapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MapaMenu(perfil);
                dispose();
            }
        });

        btnPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoUsuario(perfil);
                dispose();
            }
        });
    }

}