package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.AgendaDAO;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.dao.MapaDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.localidad.Hotel;
import icai.dtc.isw.domain.ocio.Monumento;
import icai.dtc.isw.domain.localidad.Museo;
import icai.dtc.isw.domain.localidad.Restaurante;
import icai.dtc.isw.domain.ocio.Evento;
import icai.dtc.isw.domain.ocio.Parque;
import icai.dtc.isw.domain.ui.Agenda;
import icai.dtc.isw.domain.ui.FranjaHoraria;

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
