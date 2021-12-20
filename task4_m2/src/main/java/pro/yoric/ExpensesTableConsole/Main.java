package pro.yoric.ExpensesTableConsole;

import pro.yoric.ExpensesTableConsole.beans.Expense;
import pro.yoric.ExpensesTableConsole.controller.ExpensesController;
import pro.yoric.ExpensesTableConsole.data.DAO;
import pro.yoric.ExpensesTableConsole.data.IDAO;

import java.sql.Date;
import java.sql.SQLException;

public class Main
{
    public static void main(String... args)
        throws SQLException
    {
        IDAO<Expense> dao = new DAO<>();

//        dao.createRecord(
//            String.valueOf  (args[0]),
//            Integer.parseInt(args[1]),
//            Double.valueOf  (args[2])
//        );

        System.out.format("You passed - %d\n", args.length);

        for(String i : args)

        ExpensesController.printExpenses(dao.getAllRecords());
    }
}