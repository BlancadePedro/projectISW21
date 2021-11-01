package icai.dtc.isw.domain;

import javax.swing.*;

public class RegistroException extends Exception{
    public RegistroException(){
        JOptionPane.showMessageDialog(null, "El usuario ya se encuentra en la base de datos");
    }
}
