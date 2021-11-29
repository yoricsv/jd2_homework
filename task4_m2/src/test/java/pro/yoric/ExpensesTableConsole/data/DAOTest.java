package pro.yoric.ExpensesTableConsole.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import pro.yoric.ExpensesTableConsole.beans.Expense;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DAOTest
{
    // INSTANCES
    DAO dao;

    @Before
    public void setUp()
        throws Exception
    {
        dao = new DAO(true);
    }

    @Test
    public void testInstance()
    {
        assertNotNull(dao);
    }

    @Test
    public void getAllExpenses()
    {
    }

    @Test
    public void getExpenseById()
    {
    }

    @Test
    public void saveNewExpense()
        throws SQLException
    {
        // GIVEN
        Expense newExpense = new Expense();

        newExpense.setExpensesId(1234);
        newExpense.setPayDate("29.11.2021");
        newExpense.setReceiver(1);
        newExpense.setValue(12540.0);

        // WHEN
        dao.saveNewExpense(newExpense);

        // THEN
        Expense expense = dao.getAllExpenses().get(1234);

        assertNotNull(expense);

        assertEquals(1234,         expense.getExpensesId());
        assertEquals("29.11.2021", expense.getPayDate());
        assertEquals(1,            expense.getReceiver());
        assertEquals("12540.0",    String.valueOf(expense.getValue()));

        dao.deleteAllExpenses();
    }

    @Test
    public void deleteAllExpenses()
    {
    }

    @Test
    public void deleteExpenseById()
    {
    }

    @After
    public void tearDown()
            throws Exception
    {
    }
}