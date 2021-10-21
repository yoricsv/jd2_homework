package pro.yoric.HitCounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataControllerTest
{

    DataController iController;

    @org.junit.Before
    public void setUp() throws Exception {
        iController = new DataController();
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
        IFileInstance _file = FileInstance.getInstance();
        _file.getFile();
//        newFile.setInfo("1234test");
        //When
//        ticketDao.saveNewTicket(newTicket);
        //Then
//        Ticket ticket = ticketDao.readAllTickets().get(0);
//        assertNotNull(ticket);
//        assertEquals("1234test", ticket.getLicensePlateNumber());
//        ticketDao.deleteAll();
    }
}