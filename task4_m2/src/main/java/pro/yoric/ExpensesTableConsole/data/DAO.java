package pro.yoric.ExpensesTableConsole.data;

import pro.yoric.ExpensesTableConsole.beans.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD (Create Read Update Delete)
 */
public class DAO
{
    /** CREATE */
    // CONSTRUCTORS
    public DAO()
    {
        this(false);
    }
    public DAO(boolean useTestDataSource)
    {
        dataSource = new DataSource(useTestDataSource);
    }

    /** READ */
    public List<Expense> getAllExpenses()
        throws SQLException
    {
        Connection connection = dataSource.getConnection();
        Statement statement   = connection.createStatement();

        ResultSet resultSet   =
            statement.executeQuery(
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

        List<Expense> expenseList = new ArrayList<>();

        while (resultSet.next())
        {
            Expense expense =
                new Expense(
                    resultSet.getInt("expenses_id"),
                    resultSet.getDate("pay_date").toLocalDate(),
                    resultSet.getInt("receiver_no"),
                    resultSet.getDouble("value")
                );

            expenseList.add(expense);

//            System.out.println(expense.toString());
        }

        statement.close();
        connection.close();

        return expenseList;
    }
    public Expense getExpenseById(int expenses_id)
            throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement =
            connection.prepareStatement(
                "SELECT "               +
                    "expenses_id, "     +
                    "pay_date, "        +
                    "value, "           +
                    "name "             +
                "FROM "                 +
                    "t_expenses, "      +
                    "t_receivers "      +
                "WHERE "                +
                    "expenses_id = ? "  +
                "AND "                  +
                    "receiver = receiver_no;"
            );
        statement.setInt(1, expenses_id);

        ResultSet resultSet = statement.executeQuery();

        Expense expense = null;

        if(resultSet.next())
        {
            expense =
                new Expense(
                    resultSet.getInt("expenses_id"),
                    resultSet.getDate("pay_date").toLocalDate(),
                    resultSet.getInt("receiver_no"),
                    resultSet.getDouble("value")
                );
        }

        statement.close();
        connection.close();

        return expense;
    }


    /** UPDATE */
    public void saveNewExpense(Expense expense)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement =
            connection.prepareStatement(
                "INSERT INTO "      +
                    "t_expenses "   +
                "VALUES (?,?,?,?);"
            );
        statement.setInt   (1, expense.getExpensesId());
        statement.setDate  (2, Date.valueOf(expense.getPayDate()));
        statement.setInt   (3, expense.getReceiver());
        statement.setDouble(4, expense.getValue());

        statement.executeUpdate();

        statement.close();
        connection.close();
    }
    public void saveNewExpense(
            String pay_date,
            int    receiver,
            Double value
        )
            throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement =
            connection.prepareStatement(
                "INSERT INTO "      +
                    "t_expenses ("   +
                        "pay_date, " +
                        "receiver, " +
                        "value"      +
                    ")"              +
                "VALUES (?,?,?);"
            );
        statement.setDate  (2, Date.valueOf(pay_date));
        statement.setInt   (2, receiver);
        statement.setDouble(3, value);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }


    /** DELETE */
    public void deleteAllExpenses()
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        connection.prepareStatement(
            "TRUNCATE TABLE t_expenses"
        ).execute();

        connection.close();
    }
    public void deleteExpenseById(int expenses_id)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement =
            connection.prepareStatement(
                "DELETE FROM "      +
                    "t_expenses "   +
                "WHERE "            +
                    "expenses_id = ?;"
            );
        statement.setInt(1, expenses_id);
        statement.execute();

        statement.close();
        connection.close();
    }

    // FIELDS
    private final DataSource dataSource;
}
