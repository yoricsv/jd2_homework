package pro.yoric.ExpensesTableConsole.data;

import pro.yoric.ExpensesTableConsole.beans.Expense;
import pro.yoric.ExpensesTableConsole.validation.EasyDBChecker;
import pro.yoric.ExpensesTableConsole.validation.ISimpleChecker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDao
    extends DAO<Expense>
{
    // INSTANCES
    ISimpleChecker<Expense> checker = new EasyDBChecker<>();

    // CONSTRUCTORS
    public ExpensesDao()
    {
        this(false);
    }
    public ExpensesDao(boolean useTestDataSource)
    {
        DataSource dataSource = new DataSource(useTestDataSource);
    }

    /** CREATE */
    @Override
    public void createRecord(Expense expense)
        throws SQLException
    {
        expenses_id = expense.getId();
        pay_date    = Date.valueOf(expense.getPayDate());
        receiver_no = expense.getReceiver();
        value       = expense.getValue();

        handleQuery(
            "INSERT INTO "      +
                "t_expenses "   +
            "VALUES ("          +
                expenses_id     +
                ","             +
                pay_date        +
                ","             +
                receiver_no     +
                ","             +
                value           +
            ");"
        );
    }
    public void createRecord(
            String payDate,
            int    receiver,
            Double value
        )
        throws SQLException
    {
        handleQuery(
            "INSERT INTO "       +
                "t_expenses ("   +
                    "pay_date, " +
                    "receiver, " +
                    "value"      +
                ")"              +
            "VALUES ("           +
                payDate          +
                ","              +
                receiver         +
                ","              +
                value            +
            ");"
        );
    }


    /** READ */
    @Override
    public List<Expense> getAllRecords()
        throws SQLException
    {
        return
            handleQueryGetList(
                "SELECT "               +
                    "pay_date, "        +
                    "value, "           +
                    "name "             +
                "FROM "                 +
                    "t_expenses, "      +
                    "t_receivers "      +
                "WHERE "                +
                    "receiver = receiver_no;"
            );
    }
    @Override
    public Expense getRecord(int recordId)
        throws SQLException
    {
        return
            handleQueryGetObject(
                "SELECT "               +
                    "expenses_id, "     +
                    "pay_date, "        +
                    "value, "           +
                    "name "             +
                "FROM "                 +
                    "t_expenses, "      +
                    "t_receivers "      +
                "WHERE "                +
                    "expenses_id = "    + recordId +
                "AND "                  +
                    "receiver = receiver_no;"
            );
    }


    /** UPDATE */
    @Override
    public void updateRecord(int recordId)
        throws SQLException
    {
        Expense expense = getRecord(recordId);

        checker.isDBRecordExist(expense, recordId);

        expenses_id = expense.getId();
        pay_date    = Date.valueOf(expense.getPayDate());
        receiver_no = expense.getReceiver();
        value       = expense.getValue();

        handleQuery(
            "UPDATE "            +
                "t_expenses ("   +
            "SET "               +
                "pay_date = "    + pay_date    +
                "receiver = "    + receiver_no +
                "value    = "    + value       +
            "WHERE "             +
                "expenses_id = " + expenses_id + " ;"
        );
    }


    /** DELETE */
    @Override
    public void deleteAllRecords()
        throws SQLException
    {
        handleQuery(
            "TRUNCATE TABLE " +
                "t_expenses"
        );
    }
    @Override
    public void deleteRecord(int recordId)
        throws SQLException
    {
        handleQuery(
            "DELETE FROM "       +
                "t_expenses "    +
            "WHERE "             +
                "expenses_id = " + recordId + ";"
        );
    }

    private Expense getBean(ResultSet resultSet)
            throws SQLException
    {
        return
            !resultSet.next() ?
                null          :
                new Expense(
                    resultSet.getInt   ("expenses_id"),
                    resultSet.getDate  ("pay_date").toLocalDate(),
                    resultSet.getInt   ("receiver_no"),
                    resultSet.getDouble("value")
                );
    }
    private List<Expense> getList(ResultSet resultSet)
            throws SQLException
    {
        List<Expense> list = new ArrayList<>();

        while (resultSet.next())
        {
            list.add(
                new Expense(
                    resultSet.getInt   ("expenses_id"),
                    resultSet.getDate  ("pay_date").toLocalDate(),
                    resultSet.getInt   ("receiver_no"),
                    resultSet.getDouble("value")
                )
            );
        }

        return list;
    }

    // FIELDS
    private int    expenses_id;
    private Date   pay_date;
    private int    receiver_no;
    private double value;
}
