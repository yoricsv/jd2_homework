package pro.yoric.ExpensesTableConsole.validation;

import java.sql.ResultSet;

/**
 * NOTE: All methods should return boolean or something,
 * but in this case, I just ignore it.
 * The reason is that I don't want to waste a lot of time
 * on the implementation of functions
 * that aren't specified in the task!!!
 */

public class EasyDBChecker<T>
    implements ISimpleChecker<T>
{
    @Override
    public void isDBRecordExist(
            T   entityObject,
            int recordId
        )
    {
        if(entityObject == null)
            System.err.println(
                "Record No:" + recordId + "- doesn't exist!"
            );
        else
        {
            System.out.println(
                "Enter new values separate them by \"space\":"
            );
            // TODO: create a class Reader, here is not necessary!
        }
    }

    @Override
    public void isDBUpdateSuccess(int dmlStatement)
    {
        if(dmlStatement != 0)
            System.out.println(
                "Update success! Rows: " + dmlStatement
            );
        else
            System.err.println(
                "Update failure! Try again later."
            );
    }

    @Override
    public ResultSet isResultSetReceived (ResultSet resultSet)
    {
        if(resultSet == null)
            System.err.println(
                "ResultSet object - not received!"
            );
        else
            System.out.println(
                "ResultSet received successfully."
            );

        return resultSet;
    }
}
