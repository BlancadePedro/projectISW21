package icai.dtc.isw.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.ui.Usuario.Customer;
import icai.dtc.isw.domain.ui.Agenda.FranjaHoraria;
//import jdk.internal.org.objectweb.asm.commons.InstructionAdapter;

public class AgendaDAO {
    public static void addAgenda(FranjaHoraria lista,Customer perfil) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("INSERT INTO agenda (usuario,hora,dia,mes,descripcion,año) VALUES ('"+perfil.getUsuario()+"','"+lista.getHora()+"','"+lista.getDia()+"','"+lista.getMes()+"','"+lista.getDescripcion()+"','"+lista.getAño()+"')");
             ResultSet rs = pst.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteAgenda(FranjaHoraria lista,Customer perfil) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("DELETE FROM agenda WHERE usuario = '"+perfil.getUsuario()+"' and descripcion = '"+lista.getDescripcion()+"' and hora='"+lista.getHora()+"'");
             ResultSet rs = pst.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }


    public static void getInfo(ArrayList<FranjaHoraria> lista, Customer perfil) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM agenda WHERE usuario = '"+perfil.getUsuario()+"'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                    lista.add(new FranjaHoraria(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
