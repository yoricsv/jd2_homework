package pro.yoric.HitCounter;

import java.io.*;

public class DataController
    implements IDataController
{
    IFileInstance file = FileInstance.getInstance(false);

    @Override
    public String getInfo ()
        throws IOException
    {
        BufferedReader reader =
            new BufferedReader(
                new FileReader(file.getFile(false))
            );

        quantity = reader.readLine();
        reader.close();

        return quantity;
    }

    @Override
    public void setInfo (int newValue)
        throws IOException
    {
        BufferedWriter fbw =
            new BufferedWriter(
                 new FileWriter (file.getFile(false), false)
        );

        fbw.write(String.valueOf(newValue));

        fbw.flush();
        fbw.close();
    }

    public void reset()
        throws IOException
    {
        FileWriter fbw =
            new FileWriter (file.getFile(false), false);

        fbw.write(String.valueOf(0));

        fbw.flush();
        fbw.close();
    }

    private String quantity;
}
