package pro.yoric.HitCounter;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class DataControllerTest
{
    private final IDataController iController = setUp();
    @Test

    public DataController setUp()
    {

        return new DataController();
    }

    @Test
    public void testInstance()
    {
        assertNotNull(iController);
    }

    @Test
    public void testSetInfo ()
        throws IOException
    {
        iController.setInfo (5);
        iController.setInfo (3);
        iController.setInfo (12);
        iController.setInfo (9);
    }

    @Test
    public void testGetInfo()
        throws IOException
    {
        iController.getInfo();

        assertEquals ("9", iController.getInfo());
    }

    @Test
    public void testReset()
        throws IOException
    {
        IDataController.reset();

        assertEquals ("0", iController.getInfo());
    }
}