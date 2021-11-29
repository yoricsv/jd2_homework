package pro.yoric.ExpensesTableConsole.beans;

public class Receiver
{
    // CONSTRUCTORS
    public Receiver(
            int    receiver_no,
            String name
        )
    {
        this.receiver_no = receiver_no;
        this.name        = name;
    }


    // GETTERS
    public int    getReceiver_no()
    {
        return receiver_no;
    }
    public String getName()
    {
        return name;
    }


    // SETTERS
    public void setReceiver_no(int receiver_no)
    {
        this.receiver_no = receiver_no;
    }
    public void setName(String name)
    {
        this.name = name;
    }


    // TO STRING
    @Override
    public String toString()
    {
        return
            "Receiver{"        +
                "receiver_no=" + receiver_no +
                ", name='"     + name + '\'' +
            '}';
    }


    // FIELDS
    private int    receiver_no;
    private String name;
}
