package icai.dtc.isw.dao;

import icai.dtc.isw.domain.ui.Agenda.Agenda;
import icai.dtc.isw.domain.ui.Agenda.FranjaHoraria;
import icai.dtc.isw.domain.ui.Usuario.Customer;
import icai.dtc.isw.domain.ui.*;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AgendaDAOTest extends TestCase {

    private static AgendaDAO dao;
    private static FranjaHoraria franja;
    private static Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
        dao = new AgendaDAO();
    }


    @Test
    public void testAddAgenda() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        franja = new FranjaHoraria("00:00-1:00", " viernes 31", "diciembre", "Noche vieja", "2021");
        dao.addAgenda(franja,customer);
        assertEquals(franja.getHora(),"00:00-1:00");
    }

    @Test
    public void testDeleteAgenda() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);
        franja = new FranjaHoraria("00:00-1:00", " viernes 31", "diciembre", "Noche vieja", "2021");
        dao.deleteAgenda(franja,customer);
    }

    @Test
    public void testGetInfo() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","contraseña",0);

        ArrayList<FranjaHoraria> lista = new ArrayList<>();
        dao.getInfo(lista,customer);
        assertEquals(lista.get(0).getHora(),"00:00-1:00");
    }


}
