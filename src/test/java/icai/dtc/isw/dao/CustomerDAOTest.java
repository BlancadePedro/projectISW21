package icai.dtc.isw.dao;

import icai.dtc.isw.domain.ui.Usuario.Customer;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerDAOTest extends TestCase {

    private static CustomerDAO dao;
    private static Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
        dao = new CustomerDAO();

    }

    @Test
    public void testGetCliente() {
        customer = new Customer("1","1",1,"1","1",1,"1","1",1);
        String usuario = dao.getCliente(customer.getUsuario(),customer.getClave()).getUsuario();
        assertEquals(usuario,"1");
    }

    @Test
    public void testAddCliente() {
        customer = new Customer("1","1",1,"1","1",1,"usuario","clave",1);
        dao.addCliente(customer);
        String usuario = customer.getUsuario();
        assertEquals(usuario, "usuario");
    }


}