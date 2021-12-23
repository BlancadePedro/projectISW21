package icai.dtc.isw.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;

public class AgendaDAO {
    public static void addAgenda(Customer perfil,String horaAdd, String add) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("INSERT INTO agenda(usuario,hora,descripcion) VALUES ('" + perfil.getUsuario() + "','" + horaAdd + "'," + add + "");
             ResultSet rs = pst.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteAgenda(Customer perfil, String horaDelete, String delete) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("DELETE FROM agenda WHERE usuario = '" + perfil.getUsuario() + "' and hora = '"+ horaDelete+"'");
             ResultSet rs = pst.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void updateAgenda(Customer perfil, String horaUpdate, String update) {
        Connection con = ConnectionDAO.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement("UPDATE  agenda SET descripcion ='" + update + "' WHERE usuario = '" + perfil.getUsuario() + "' and hora = '"+horaUpdate+"'");
             ResultSet rs = pst.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
