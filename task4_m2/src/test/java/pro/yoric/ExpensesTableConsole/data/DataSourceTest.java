package pro.yoric.ExpensesTableConsole.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pro.yoric.ExpensesTableConsole.data.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DataSourceTest
{
    // INSTANCES
    DataSource dataSourceTroubleshoot;
    Connection connection;

    @Before
    public void setUp()
    {
        dataSourceTroubleshoot = new DataSource(true);
    }

    @Test
    public void testInstance()
    {
        assertNotNull(dataSourceTroubleshoot);
    }

    @Test
    public void testGetConnection()
        throws SQLException
    {
        // GIVEN
        connection = dataSourceTroubleshoot.getConnection();

        // THEN
        assertNotNull(connection);
        assertTrue(connection.isValid(1));
        assertFalse(connection.isClosed());
    }

    @After
    public void close()
        throws SQLException
    {
        connection.close();
    }
}



