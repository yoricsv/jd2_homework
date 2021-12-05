package pro.yoric.ExpensesTableConsole.data;

import pro.yoric.ExpensesTableConsole.beans.IObjectModel;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T extends IObjectModel>
{
    /** CREATE */
    void    createRecord    (T   instance) throws SQLException;
    /** READ */
    List<T> getAllRecords   ()             throws SQLException;
    T       getRecord       (int recordId) throws SQLException;
    /** UPDATE */
    void    updateRecord    (int recordId) throws SQLException;
    /** DELETE */
    void    deleteAllRecords()             throws SQLException;
    void    deleteRecord    (int recordId) throws SQLException;
}
