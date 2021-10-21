package pro.yoric.HitCounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataControllerTest
{

    IDataController iController;

    @org.junit.Before
    public void setUp() throws Exception {
        iController = new DataController(true);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInstance() {
        assertNotNull(iController);
    }


    @Test
    void testGetInfo()
    {
        //Given
        IFileInstance newFile = FileInstance.getInstance();
        newFile.getFile();
        newFile.setInfo("1234test");
        //When
        ticketDao.saveNewTicket(newTicket);
        //Then
        Ticket ticket = ticketDao.readAllTickets().get(0);
        assertNotNull(ticket);
        assertEquals("1234test", ticket.getLicensePlateNumber());
        ticketDao.deleteAll();
    }
}