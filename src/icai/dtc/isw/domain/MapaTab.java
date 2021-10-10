package icai.dtc.isw.domain;

import java.awt.*;
import javax.swing.*;

public class MapaTab {
    final static String tabNorte = "Norte";
    final static String tabSur = "Sur";
    final static String tabEste = "Este";
    final static String tabOeste = "Oeste";
    final static int extraWindowWidth = 100;

    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        //Create the "cards".
        JPanel card1 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        ImageIcon image1 = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madridnorte.jpg", null);
        JLabel label1 = new JLabel(image1, JLabel.CENTER);
        card1.add(label1);

        JPanel card2 = new JPanel();
        ImageIcon image2 = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madridsur.jpg", null);
        JLabel label2 = new JLabel(image2, JLabel.CENTER);
        card2.add(label2);

        JPanel card3 = new JPanel();
        ImageIcon image3 = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madrideste.jpg", null);
        JLabel label3 = new JLabel(image3, JLabel.CENTER);
        card3.add(label3);

        JPanel card4 = new JPanel();
        ImageIcon image4 = new ImageIcon("./src/icai/dtc/isw/resources/FotosMapa/madridoeste.jpg", null);
        JLabel label4 = new JLabel(image4, JLabel.CENTER);
        card4.add(label4);

        tabbedPane.addTab(tabNorte, card1);
        tabbedPane.addTab(tabSur, card2);
        tabbedPane.addTab(tabEste, card3);
        tabbedPane.addTab(tabOeste, card4);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TabDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MapaTab demo = new MapaTab();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
