package pro.yoric.ExpensesTableConsole.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSource
{
    // CONSTRUCTOR
    public DataSource(boolean useTestDataSource)
    {
        loadDriver();

        this.useTestDataSource = useTestDataSource;
    }

    private void loadDriver()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            logger.debug("Error loading driver: " + e);
        }
    }

    protected Connection getConnection()
        throws SQLException
    {
        return
            DriverManager
            .getConnection(
                useTestDataSource                               ?
                "jdbc:mysql://localhost:3306/db_task4_m2_test"  :
                "jdbc:mysql://localhost:3306/db_task4_m2",
                "root",
                "root"
            );
    }

    // FIELDS
    private final boolean useTestDataSource;

    private static final Logger logger =
        LoggerFactory
        .getLogger(
            DataSource.class
        );
}
