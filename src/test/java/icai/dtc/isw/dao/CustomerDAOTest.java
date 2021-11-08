package icai.dtc.isw.dao;

import icai.dtc.isw.domain.Customer;
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
    public void testCambiarFoto(){
        customer = new Customer("1","1",1,"1","1",1,"1","1",1);
        dao.cambiarFoto(2,customer);
        assertEquals(dao.getCliente(customer.getUsuario(),customer.getClave()).getFoto(),2);
    }
}