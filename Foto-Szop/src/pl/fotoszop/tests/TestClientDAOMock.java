package pl.fotoszop.tests;

import org.junit.Test;
import pl.fotoszop.mocks.ClientDAOMock;
import pl.fotoszop.model.Client;
import pl.fotoszop.modelinterfaces.IClient;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClientDAOMock {

    @Test
    public void testDelete() {
        ArrayList<Client> clients = new ArrayList<Client>();
        ClientDAOMock clientsDao = new ClientDAOMock();
        assertTrue(clientsDao.delete(1));
    }

    @Test
    public void testGetClientById() {
        ArrayList<Client> clients = new ArrayList<Client>();
        ClientDAOMock clientsDao = new ClientDAOMock();
        IClient c = clientsDao.getClientById(1);
        assertEquals("Janusz", c.getName());
    }

    @Test
    public void testSaveOrUpdate() {
        Client c = new Client(0, "Jeremiasz", "Jurkowski", "Nienaszow 5", "96065211111", "56565544565", "jan@o2.pl");
        ArrayList<Client> clients = new ArrayList<Client>();
        //autoinkrementacja programowa w ClientDAOMock
        ClientDAOMock clientsDao = new ClientDAOMock();
        assertEquals(7, clientsDao.saveOrUpdate(c));
    }
}
