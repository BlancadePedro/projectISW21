package icai.dtc.isw.domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InfoUsuario extends JFrame
{
   
    private JPanel info = new JPanel(new GridLayout(6, 1));
    private JPanel foto = new JPanel((new FlowLayout()));

    
    private JLabel lblNombre = new JLabel();
    private JLabel lblEdad = new JLabel();
    private JLabel lblNacionalidad = new JLabel();
    private JLabel lblDescripcion = new JLabel();
    private JLabel lblCorreo = new JLabel();
    private JLabel lblTelefono = new JLabel();

    public InfoUsuario(Customer perfil) {
    
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        foto.setBackground(Color.BLACK);

        String nombre = perfil.getNombreCompleto();
        int edad = perfil.getEdad();
        String nacionalidad = perfil.getNacionalidad();
        String descripcion = perfil.getDescripcion();
        int telefono = perfil.getTelefono();
        String correo = perfil.getCorreo();

        lblNombre.setText(nombre);
        lblEdad.setText(String.valueOf(edad));
        lblNacionalidad.setText(nacionalidad);
        lblDescripcion.setText(descripcion);
        lblTelefono.setText(String.valueOf(telefono));
        lblCorreo.setText(correo);

        info.add(lblNombre);
        info.add(lblEdad);
        info.add(lblNacionalidad);
        info.add(lblDescripcion);
        info.add(lblCorreo);
        info.add(lblTelefono);

        this.add(info,BorderLayout.CENTER);
        this.add(foto,BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}
