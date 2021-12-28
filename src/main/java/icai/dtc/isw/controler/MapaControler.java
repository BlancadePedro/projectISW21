package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.MapaDAO;
import icai.dtc.isw.domain.localidad.Hotel;
import icai.dtc.isw.domain.ocio.Monumento;
import icai.dtc.isw.domain.localidad.Museo;
import icai.dtc.isw.domain.localidad.Restaurante;
import icai.dtc.isw.domain.ocio.Evento;
import icai.dtc.isw.domain.ocio.Parque;

public class MapaControler {

    //Relacionado con las localidades
    public  void getRestaurantes(ArrayList<Restaurante> lista) {MapaDAO.getRestaurantes(lista);}
    public void getHoteles(ArrayList<Hotel> lista) {
        MapaDAO.getHoteles(lista);
    }
    public void getMuseos(ArrayList<Museo> lista) {
        MapaDAO.getMuseos(lista);
    }
    //Relacionado ocio
    public  void getMonumentos(ArrayList<Monumento> lista) {MapaDAO.getMonumentos(lista);}
    public void getParques(ArrayList<Parque> lista) {
        MapaDAO.getParques(lista);
    }
    public void getEventos(ArrayList<Evento> lista) {
        MapaDAO.getEventos(lista);
    }

}
