package pro.yoric.ExpensesTableConsole.data;

import pro.yoric.ExpensesTableConsole.beans.IObjectModel;
import pro.yoric.ExpensesTableConsole.validation.EasyDBChecker;
import pro.yoric.ExpensesTableConsole.validation.ISimpleChecker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * CRUD (Create Read Update Delete)
 */
public class DAO<T extends IObjectModel>
    implements IDAO<T>
{
    // INSTANCES
    ISimpleChecker<T> checker = new EasyDBChecker<>();

    // CONSTRUCTORS
    public DAO()
    {
        this(false);
    }
    public DAO(boolean useTestDataSource)
    {
        dataSource = new DataSource(useTestDataSource);
    }

    /** CREATE */
    @Override
    public void    createRecord    (T   instance) throws SQLException { }
    /** READ */
    @Override
    public List<T> getAllRecords   ()             throws SQLException { return null; }
    @Override
    public T       getRecord       (int recordId) throws SQLException { return null; }
    /** UPDATE */
    @Override
    public void    updateRecord    (int recordId) throws SQLException { }
    /** DELETE */
    @Override
    public void    deleteAllRecords()             throws SQLException { }
    @Override
    public void    deleteRecord    (int recordId) throws SQLException { }

    // METHODS
    protected void    handleQuery(String sqlQuery)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement("?");
        statement.setString(1, sqlQuery);

        checker.isDBUpdateSuccess(statement.executeUpdate());

        statement.close();
        connection.close();
    }
    protected T       handleQueryGetObject(String sqlQuery)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement("?");
        statement.setString(1, sqlQuery);

        ResultSet resultSet = checker.isResultSetReceived(statement.executeQuery());

        T instance = getBean(resultSet);

        statement.close();
        connection.close();

        return instance;
    }
    protected List<T> handleQueryGetList(String sqlQuery)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement("?");
        statement.setString(1, sqlQuery);

        ResultSet resultSet = checker.isResultSetReceived(statement.executeQuery());

        List<T> list = getList(resultSet);

        statement.close();
        connection.close();

        return list;
    }
    private T       getBean(ResultSet resultSet) throws SQLException { return null; }
    private List<T> getList(ResultSet resultSet) throws SQLException { return null; }

    // FIELDS
    private final DataSource dataSource;
}
