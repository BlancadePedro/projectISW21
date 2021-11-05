package icai.dtc.isw.domain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Calendario extends JFrame {
    private JPanel pnlcalendario = new JPanel(new GridLayout(24, 1));
    HashMap<Integer,Object> infoCal=new HashMap<Integer, Object>();

    public Calendario(){
        for(int i=0;i<24;i++){
            txtField(pnlcalendario);
            System.out.println(i);
            int indice = i+1;
            infoCal.put(indice,null);
        }

        this.add(pnlcalendario);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] argv){

        new Calendario();

    }

    public static void  txtField(JPanel panel){
        JTextField textField = new JTextField();
        panel.add(textField);

    }
}
