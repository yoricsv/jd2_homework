package pro.yoric.ExpensesTableConsole.data;

import pro.yoric.ExpensesTableConsole.beans.Receiver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceiversDao
{
    /** CREATE */
    // CONSTRUCTORS
    public ReceiversDao()
    {
        this(false);
    }
    public ReceiversDao(boolean useTestDataSource)
    {
        dataSource = new DataSource(useTestDataSource);
    }

    /** READ */
    public List<Receiver> getAllReceivers()
        throws SQLException
    {
        Connection connection = dataSource.getConnection();
        Statement statement   = connection.createStatement();

        ResultSet resultSet   =
            statement.executeQuery(
                "SELECT "               +
                    "receiver_no, "     +
                    "name "             +
                "FROM "                 +
                    "t_receivers;"
            );

        List<Receiver> receiversList = new ArrayList<>();

        while (resultSet.next())
        {
            Receiver receiver =
                new Receiver(
                    resultSet.getInt   ("receiver_no"),
                    resultSet.getString("name")
                );

            receiversList.add(receiver);

//            System.out.println(receiver.toString());
        }

        statement.close();
        connection.close();

        return receiversList;
    }
    public Receiver getReceiverById(int receiverNumber)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement =
            connection.prepareStatement(
                "SELECT "               +
                    "receiver_no, "     +
                    "name "             +
                "FROM "                 +
                    "t_receivers "      +
                "WHERE "                +
                    "receiver_no = ? "
            );
        statement.setInt(1, receiverNumber);

        ResultSet resultSet = statement.executeQuery();

        Receiver receiver = null;

        if(resultSet.next())
        {
            receiver =
                new Receiver(
                    resultSet.getInt   ("receiver_no"),
                    resultSet.getString("name")
                );
        }

        statement.close();
        connection.close();

        return receiver;
    }


    /** UPDATE */
    public void saveNewReceiver(Receiver receiver)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement =
            connection.prepareStatement(
                "INSERT INTO "      +
                    "t_receivers "   +
                "VALUES (?,?);"
            );
        statement.setInt    (1, receiver.getReceiverNo());
        statement.setString (2, receiver.getName());

        statement.executeUpdate();

        statement.close();
        connection.close();
    }
    public void saveNewReceiver(String receiverName)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement =
            connection.prepareStatement(
                "INSERT INTO "           +
                    "t_receivers (name)" +
                "VALUES (?);"
            );
        statement.setString (1, receiverName);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }


    /** DELETE */
    public void deleteAllReceivers()
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        connection.prepareStatement(
            "TRUNCATE TABLE t_receivers"
        ).execute();

        connection.close();
    }
    public void deleteReceiverById(int receiverNumber)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement =
            connection.prepareStatement(
                "DELETE FROM "      +
                    "t_receivers "   +
                "WHERE "            +
                    "receiver_no = ?;"
            );
        statement.setInt(1, receiverNumber);
        statement.execute();

        statement.close();
        connection.close();
    }

    // FIELDS
    private final DataSource dataSource;
}
