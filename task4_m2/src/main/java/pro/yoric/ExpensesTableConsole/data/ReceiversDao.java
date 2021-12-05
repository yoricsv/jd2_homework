package pro.yoric.ExpensesTableConsole.data;

import pro.yoric.ExpensesTableConsole.beans.Receiver;
import pro.yoric.ExpensesTableConsole.validation.EasyDBChecker;
import pro.yoric.ExpensesTableConsole.validation.ISimpleChecker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD (Create Read Update Delete)
 */
public class ReceiversDao
    extends DAO<Receiver>
{
    // INSTANCES
    ISimpleChecker<Receiver> checker = new EasyDBChecker<>();

    /** CREATE */
    // CONSTRUCTORS
    public ReceiversDao()
    {
        this(false);
    }
    public ReceiversDao(boolean useTestDataSource)
    {
        DataSource dataSource = new DataSource(useTestDataSource);
    }

    @Override
    public void createRecord(Receiver receiver)
        throws SQLException
    {
        receiver_no = receiver.getReceiverNo();
        name        = receiver.getName();

        handleQuery(
            "INSERT INTO "      +
                "t_receivers "  +
            "VALUES ("          +
                receiver_no     +
                ","             +
                name            +
            ");"
        );
    }

    public void createRecord(String name)
        throws SQLException
    {
        handleQuery(
            "INSERT INTO "      +
                "t_receivers "  +
            "VALUES ("          +
                name            +
            ");"
        );
    }


    /** READ */
    @Override
    public List<Receiver> getAllRecords()
        throws SQLException
    {
        return
            handleQueryGetList(
                "SELECT "           +
                    "receiver_no, " +
                    "name "         +
                "FROM "             +
                    "t_receivers;"
            );
    }
    @Override
    public Receiver getRecord(int recordId)
        throws SQLException
    {
        return
            handleQueryGetObject(
                "SELECT "            +
                    "receiver_no, "  +
                    "name "          +
                "FROM "              +
                    "t_receivers "   +
                "WHERE "             +
                    "receiver_no = " + recordId + ";"
            );
    }


    /** UPDATE */
    @Override
    public void updateRecord(int recordId)
        throws SQLException
    {
        Receiver receiver = getRecord(recordId);

        checker.isDBRecordExist(receiver, recordId);

        receiver_no = receiver.getReceiverNo();
        name        = receiver.getName();

        handleQuery(
            "UPDATE "            +
                "t_receivers ("  +
            "SET "               +
                "receiver_no = " + receiver_no +
                ", "             +
                "name = "        + name        +
            "WHERE "             +
                "receiver_no = " + recordId    + " ;"
        );
    }


    /** DELETE */
    @Override
    public void deleteAllRecords()
        throws SQLException
    {
        handleQuery(
            "TRUNCATE TABLE " +
                "t_receivers"
        );
    }
    @Override
    public void deleteRecord(int recordId)
        throws SQLException
    {
        handleQuery(
            "DELETE FROM "       +
                "t_receivers "   +
            "WHERE "             +
                "receiver_no = " + recordId + ";"
        );
    }


    private List<Receiver> getList(ResultSet resultSet)
            throws SQLException
    {
        List<Receiver> list = new ArrayList<>();

        while (resultSet.next())
        {
            list.add(
                new Receiver(
                    resultSet.getInt   ("receiver_no"),
                    resultSet.getString("name")
                )
            );
        }

        return list;
    }
    private Receiver getBean(ResultSet resultSet)
            throws SQLException
    {
        return
            !resultSet.next() ?
                null          :
                new Receiver(
                    resultSet.getInt   ("receiver_no"),
                    resultSet.getString("name")
                );
    }

    // FIELDS
    private int    receiver_no;
    private String name;
}
