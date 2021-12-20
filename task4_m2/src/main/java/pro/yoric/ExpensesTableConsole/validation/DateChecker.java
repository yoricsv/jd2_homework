package pro.yoric.ExpensesTableConsole.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ***************************************************** *
 *  THIS CLASS DESIGNED TO IMPROVE MY SKILLS IN PARSING  *
 *            A DATE VIA A REGULAR EXPRESSION            *
 *                                                       *
 *           TO WORK WITH THE DATE SHOULD USE A          *
 *             "SimpleDateFormat" (see below)            *
 * ***************************************************** *
 */

public class DateChecker
{
    // CONSTRUCTORS
    private DateChecker()
    {
        this.pattern =
            Pattern.compile(
                Pattern.quote(DATE_PATTERN)
            );
    }
//    private DateChecker(String regex)
//        throws ParseException
//    {
//        this.pattern =
//            Pattern.compile(
//                Pattern.quote(
//                    regex
//                )
//            );
//    }



    public static boolean isValid(String text)
    {
        if (    text == null
            || !text.matches(
                    Pattern.quote("\\d{4}-[01]\\d-[0-3]\\d")
                )
            )
        {
            return false;
        }

        try
        {
            format.get().parse(text);
            return true;
        }
        catch (ParseException ex)
        {
            return false;
        }
    }

    public boolean isValidDate(final String inputDate)
    {
        matcher = pattern.matcher(inputDate);
        if (matcher.matches())
        {
            matcher.reset();

            if (matcher.find())
            {
                int day   = Integer.parseInt(matcher.group(1));
                int month = Integer.parseInt(matcher.group(2));
                int year  = Integer.parseInt(matcher.group(3));

            }
        }
        // if(
        //          year % 400 == 0
        //      || (
        //              year % 4   == 0
        //           && year % 100 != 0
        //          )
        //     )
        // else "((0?[1-9]|[12][0-8])([-/.])0?[2])" +
        return inputDate.matcher(pattern);
    }

    public String getRegex()
    {
        return pattern.pattern();
    }

    public String isDateValidBySimpleDateFormat(final String inputDate)
        throws ParseException
    {
        return
            new SimpleDateFormat("dd-MM-yyyy")
                .format(inputDate);
    }


    // FIELDS
    /** DATE FORMAT (dd-mm-yyyy)
     *  WITH SEPARATORS '-' OR '/' OR '.'
     *
     * NOTE:
     * The regex is divided into 4 groups.
     * The first 3 are to check the maximum
     * number of days in a month.
     * The 4th group - year.
     *
     *  ^ - locate in to the string begin
     *  | - means 'or'
     *  [-/.] -> separators '-' or '/' or '.'
     *
     * FIRST GROUP:
     * 0?[1-9]      -> (01-09 or 1-9)
     * [12][0-9]    -> (10-19 or 20-29)
     * 3[01]        -> (30    or 31)
     * [-/.]        -> separators '-' or '/' or '.'
     * List of months in 31 days
     * 0?[13578]    -> (01,03,05,07,08,10,12
     *                  or 1,3,5,7,8,10,12)
     *
     * SECOND GROUP:
     * 0?[1-9]      -> (01-09 or 1-9)
     * [12][0-9]    -> (10-19 or 20-29)
     * [-/.]        -> separators '-' or '/' or '.'
     * Pattern for february
     * 0?[2]        -> (02    or 2)
     *
     * THIRD GROUP:
     * 0?[1-9]      -> (01-09 or 1-9)
     * [12][0-9]    -> (10-19 or 20-29)
     * 30           -> (30)
     * [-/.]        -> separators '-' or '/' or '.'
     * List of months in 30 days
     * 0?[469]|11   -> (04,06,09,11 or 4,6,9,11)
     *
     * FOURTH GROUP:
     * [12][0-9]{3} -> (1000-2999)
     */
    private static final String DATE_PATTERN =
        "^("                                +
            "("                             +
                "(0?[1-9]|[12][0-9]|3[01])" +
                "([-/.])"                   +
                "(0?[13578]|(10|12))"       +
            ")"                             +
        "|"                                 +
            "("                             +
                "(0?[1-9]|[12][0-9])"       +
                "([-/.])"                   +
                "(0?[2])"                   +
            ")"                             +
        "|"                                 +
            "("                             +
                "(0?[1-9]|[12][0-9]|30)"    +
                "([-/.])"                   +
                "(0?[469]|11)"              +
            ")"                             +
        ")"                                 +
        "([-/.])"                           +
        "([12][0-9]{3})$";
    private static final ThreadLocal<SimpleDateFormat> format =
        ThreadLocal.withInitial(
            () -> {
                SimpleDateFormat dateFormat =
                    new SimpleDateFormat(
                            "yyyy-MM-dd"
                    );
                dateFormat.setLenient(false);

                return dateFormat;
            }
        );
    private final Pattern pattern;
    private       Matcher matcher;
}
