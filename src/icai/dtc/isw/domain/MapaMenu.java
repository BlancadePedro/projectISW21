 package icai.dtc.isw.domain;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;

public class MapaMenu {
    //variables y comtenedores
    private JLabel etiquetaSu;
    private JPanel pnlIzquierdo, pnlDerecho, pnlCentral;
    private JButton btnIz1, btnIz2, btnIz3, btnIz4, btnIz5;
    private JButton btnH, btnR, btnE, btnM, btnMu, btnP, btnPe;
    private JButton    btnIn1, btnIn2;
    private JScrollPane scroll;

    public void contruyepnlIzquierdo(){
        pnlIzquierdo = new JPanel();
        btnIz1=new JButton("General");
        btnIz2=new JButton("Zona norte");
        btnIz3=new JButton("Zona sur");
        btnIz4=new JButton("Zona este");
        btnIz5=new JButton("Zona oeste");
        pnlIzquierdo.setLayout(new BoxLayout(pnlIzquierdo,BoxLayout.Y_AXIS));
        //pnlIzquierdo.setBackground(Color.red);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz1);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz2);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz3);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz4);
        pnlIzquierdo.add(Box.createVerticalStrut(40));
        pnlIzquierdo.add(btnIz5);
    }

    public void contruyepnlDerecho(){
        pnlDerecho = new JPanel();
        btnH = new JButton("Hoteles");
        btnR = new JButton("Restaurantes");
        btnE = new JButton("Eventos");
        btnM = new JButton("Monumentos");
        btnMu = new JButton("Museos");
        btnP = new JButton("Parques");
        btnPe = new JButton("Mi perfil");

        btnH.setIcon(new ImageIcon(new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Hoteles.PNG").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
        btnR.setIcon(new ImageIcon(new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Restaurantes.PNG").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
        btnE.setIcon(new ImageIcon(new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Eventos.PNG").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
        btnM.setIcon(new ImageIcon(new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Monumentos.PNG").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
        btnMu.setIcon(new ImageIcon(new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Museo.PNG").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
        btnP.setIcon(new ImageIcon(new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Parques.PNG").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
        btnPe.setIcon(new ImageIcon(new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/Perfil.PNG").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));


        pnlDerecho.setLayout(new BoxLayout(pnlDerecho,BoxLayout.Y_AXIS));
        //pnlDerecho.setBackground(Color.blue);
        pnlDerecho.add(Box.createVerticalStrut(20));
        pnlDerecho.add(btnH);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnR);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnE);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnM);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnMu);
        pnlDerecho.add(Box.createVerticalStrut(40));
        pnlDerecho.add(btnP);
        pnlDerecho.add(Box.createVerticalStrut(290));
        pnlDerecho.add(btnPe);
    }

    public void contruyepnlCentral(){
        pnlCentral = new JPanel();
        ImageIcon image1 = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madridcentro.jpg", null);
        JLabel label1 = new JLabel(image1, JLabel.LEFT);
        pnlCentral.add(label1);
    }

    /*public void contruyepnlInferior(){
        pnlInferior = new JPanel();
        btnIn1=new JButton("Aceptar");
        btnIn2=new JButton("Cancelar");
        pnlInferior.setLayout(new FlowLayout());
        pnlInferior.setBackground(Color.green);
        pnlInferior.add(btnIn1);
        pnlInferior.add(btnIn2);
    }*/

    public void contruyeVentana(){
        JFrame frame = new JFrame("Mapa del centro de Madrid");
        etiquetaSu = new JLabel("Para ver más información sobre cada categoría haga click en los botones junto al mapa");
        Font aux=etiquetaSu.getFont();
        etiquetaSu.setFont(new Font(aux.getFontName(), aux.getStyle(), 16));
        frame.setLayout(new BorderLayout());

        //agregamos los paneles al frame principal
        frame.add(etiquetaSu,BorderLayout.NORTH);
        frame.add(pnlCentral, BorderLayout.CENTER);
        //frame.add(pnlIzquierdo,BorderLayout.WEST);
        frame.add(pnlDerecho,BorderLayout.EAST);
        //frame.add(pnlInferior,BorderLayout.SOUTH);
        //Configuramos el frame
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public MapaMenu(){
        //contruyepnlInferior();
        //contruyepnlIzquierdo();
        contruyepnlDerecho();
        contruyepnlCentral();
        contruyeVentana();

        btnH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver hoteles");
            }
        });
        btnR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver restaurantes");
            }
        });
        btnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver eventos");
            }
        });
        btnM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver monumentos");
            }
        });
        btnMu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver museos");
            }
        });
        btnP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver parques");
            }
        });
        btnPe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ver mi perfil");
                //InfoUsuario iu = new InfoUsuario();
            }
        });
    }

    public static void main (String [] inforux){
        new MapaMenu();
    }
}
