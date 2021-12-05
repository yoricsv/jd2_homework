package pro.yoric.ExpensesTableConsole.validation;

import java.sql.ResultSet;

public interface ISimpleChecker<T>
{
    void      isDBRecordExist(
                    T   entityObject,
                    int recordId
                );
    void      isDBUpdateSuccess(int DMLStatement);
    ResultSet isResultSetReceived(ResultSet resultSet);
}
