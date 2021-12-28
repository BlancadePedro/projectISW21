package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.AgendaDAO;
import icai.dtc.isw.domain.ui.Usuario.Customer;
import icai.dtc.isw.domain.ui.Agenda.FranjaHoraria;

public class AgendaControler {
    public void getInfo(ArrayList<FranjaHoraria> lista, Customer customer) {
        AgendaDAO.getInfo(lista,customer);
    }
    public  void deleteAgenda(FranjaHoraria lista,Customer customer){
        AgendaDAO.deleteAgenda(lista,customer);}
    public void addAgenda(FranjaHoraria lista,Customer customer){
        AgendaDAO.addAgenda(lista,customer);
    }
    /*public void updateAgenda(ArrayList<FranjaHoraria> lista,Customer customer){
        AgendaDAO.updateAgenda(lista,customer);
    }*/
}
