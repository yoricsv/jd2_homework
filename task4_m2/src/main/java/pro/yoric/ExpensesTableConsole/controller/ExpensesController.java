package pro.yoric.ExpensesTableConsole.controller;

import pro.yoric.ExpensesTableConsole.beans.Expense;

import java.util.List;

public class ExpensesController
{
    // INSTANSES
//    private final Expense expense;

    public ExpensesController()
//        throws ClassNotFoundException
    {
//        expense = new Expense();
    }


    public static void printExpenses(List<Expense> expenses)
    {
        String separator =
            "-----------------------------------------" +
            "-----------------------------------------" +
            "-----------------------------------------";

        for(Expense expense : expenses)
        {
            System.out.println(separator);

            System.out.format(
                "| %5d | %20s | %30s | %.2f |\n" +
                separator,
                expense.getId(),
                expense.getPayDate(),
                expense.getReceiver(),//.getName(),
                expense.getValue()
            );
        }
    }
}
