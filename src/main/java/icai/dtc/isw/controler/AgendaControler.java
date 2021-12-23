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

public class AgendaControler {
    public  void deleteAgenda(Customer customer,String horaDelete,String delete){
        AgendaDAO.deleteAgenda(customer,horaDelete,delete);}
    public void addAgenda(Customer customer,String horaAdd,String add){
        AgendaDAO.addAgenda(customer,horaAdd,add);
    }
    public void updateAgenda( Customer customer,String horaUpdate,String update){
        AgendaDAO.updateAgenda(customer,horaUpdate,update);
    }
}
