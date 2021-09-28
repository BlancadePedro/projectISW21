package icai.dtc.isw.domain;
import icai.dtc.isw.domain.Customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Registro extends JFrame{
    public static void main(String[] argv){
        
        String usuario = JOptionPane.showInputDialog("Introduzca su nombre de usuario");
        String contraseña = JOptionPane.showInputDialog("Introduzca su contraseña");
        new Registro(usuario,contraseña);
        
     }
    private JPanel info = new JPanel(new GridLayout(6, 2));
    private JPanel registro = new JPanel((new FlowLayout()));

    private JLabel lblNombre = new JLabel("Nombre: ");
    private JLabel lblEdad = new JLabel("Edad: ");
    private JLabel lblNacionalidad = new JLabel("Nacionalidad: ");
    private JLabel lblDescripcion = new JLabel("Pequeña descripción: ");
    private JLabel lblCorreo = new JLabel("Correo: ");
    private JLabel lblTelefono = new JLabel("Nº teléfono: ");
    
    private JTextField txtNombre = new JTextField();
    private JTextField txtEdad = new JTextField();
    private JTextField txtNacionalidad = new JTextField();
    private JTextField txtDescripcion = new JTextField();
    private JTextField txtCorreo = new JTextField();
    private JTextField txtTelefono = new JTextField();

    private JButton btnRegistro = new JButton("Continuar");

    public Registro(String usuario, String contraseña){

        this.setLayout(new BorderLayout());
        this.setVisible(true);

        info.add(lblNombre);
        info.add(txtNombre);
        info.add(lblEdad);
        info.add(txtEdad);
        info.add(lblNacionalidad);
        info.add(txtNacionalidad);
        info.add(lblDescripcion);
        info.add(txtDescripcion);
        info.add(lblCorreo);
        info.add(txtCorreo);
        info.add(lblTelefono);
        info.add(txtTelefono);

        registro.add(btnRegistro);
        btnRegistro.addActionListener(new ActionListener(){
            String nombreCompleto, nacionalidad, descripcion ,correo;
            String edad, telefono,usuarioPerfil,contraseñaPerfil;
            //No estoy segura de si usuario y contraseña están bien
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
                nombreCompleto = txtNombre.getText();
                edad = txtEdad.getText();
                nacionalidad = txtNacionalidad.getText();
                descripcion = txtDescripcion.getText();
                telefono = txtTelefono.getText();
                correo = txtCorreo.getText();
                usuarioPerfil = usuario;
                contraseñaPerfil = contraseña;
                //Hay que cambiar el orden o aquí o en la base de datos
                dispose();
                Customer perfil = new Customer(correo,descripcion,Integer.parseInt(edad),nacionalidad,nombreCompleto,Integer.parseInt(telefono),usuarioPerfil,contraseñaPerfil);
                new InfoUsuario(perfil);

            }

        });
        this.add(info,BorderLayout.NORTH);
        this.add(registro, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(true);//Para que no se pueda redimensionar
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

}
