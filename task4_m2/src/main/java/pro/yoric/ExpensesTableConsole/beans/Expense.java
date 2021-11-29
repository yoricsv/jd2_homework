package pro.yoric.ExpensesTableConsole.beans;

import java.util.Date;

public class Expense
{
   // CONSTRUCTORS
   public Expense() { }
   public Expense(
           int    expenses_id,
           String pay_date,
           int    receiver,
           double value
      )
   {
      this.expenses_id = expenses_id;
      this.pay_date    = pay_date;
      this.receiver    = receiver;
      this.value       = value;
   }


   // GETTERS
   public int    getExpensesId()
   {
      return expenses_id;
   }
   public String getPayDate()
   {
      return pay_date;
   }
   public int    getReceiver()
   {
      return receiver;
   }
   public double getValue()
   {
      return value;
   }


   // SETTERS
   public void setExpensesId(int expenses_id)
   {
      this.expenses_id = expenses_id;
   }
   public void setPayDate(String pay_date)
   {
      this.pay_date = pay_date;
   }
   public void setReceiver(int receiver)
   {
      this.receiver = receiver;
   }
   public void setValue(double value)
   {
      this.value = value;
   }


   // TO STRING
   @Override
   public String toString()
   {
      return
           "Expense{"          +
              "expenses_id = " + expenses_id +
              ", pay_date = "  + pay_date    +
              ", receiver = "  + receiver    +
              ", value = "     + value       +
           '}';
   }

   // FIELDS
   private int    expenses_id;
   private String pay_date;
   private int    receiver;
   private double value;
}
