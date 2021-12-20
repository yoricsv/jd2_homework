package pro.yoric.ExpensesTableConsole.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EasyInputChecker
{
    public EasyInputChecker() { }

    private static LocalDate parseDate(String dateString)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    // FIELDS
    String DATE_FORMAT_REG =
        "^(0[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[0-2])-\\d{4}$";
    private static final String INCORRECT_INPUT_MSG =
        "Incorrect input data. You should enter date(dd-MM-yyyy), receiver, value";
    private static final String WRONG_DATE_OR_VALUE_MSG =
        "Wrong date or value. Date format dd-MM-yyy and value must be greater than 0";

    public static void start(String[] args)
    {
        Validator validator = Validator.take();

        if (args.length != 3)
            throw
                new InvalidateArgumentException(
                    INCORRECT_INPUT_MSG
                );

        String dateString   = args[0];
        String receiverName = args[1];
        double value        = Double.parseDouble(args[2]);


        /** DATE */
        if (   !validator.isValidDate(dateString)
            || !validator.isValidValue(value)
            )
            throw
                new InvalidateArgumentException(
                    WRONG_DATE_OR_VALUE_MSG
                );
        LocalDate date = parseDate(dateString);


        /** RECEIVERS */
        ReceiverService receiverService =
            ReceiverService.retrieve();
        Receiver receiver =
            receiverService
            .findByName(receiverName);
        if (receiver == null)
            receiver =
                receiverService
                .save(
                    new Receiver(
                        receiverName
                    )
                );

        /** EXPENSES */
        ExpenseService expenseService =
            ExpenseService.retrieve();
        Expense expense =
            expenseService
            .save(
                new Expense(
                    date,
                    receiver,
                    value
                )
            );
        List<Expense> expenses =
            expenseService.findAll();



        /** PRINT */
        printExpenses(expenses);
    }
}
