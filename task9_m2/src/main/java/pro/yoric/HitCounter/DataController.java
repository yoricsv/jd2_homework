package pro.yoric.HitCounter;

import java.io.*;

public class DataController
    implements IDataController
{
    IFileInstance file = FileInstance.getInstance();

    @Override
    public void doInit(String initValue)
    {
        file.doInit(initValue);
    }

    @Override
    public int getInfo()
        throws IOException
    {
        BufferedReader fbr =
            new BufferedReader(
                new FileReader(file.getPath())
        );

        int max = Integer.MIN_VALUE;                    // TODO: Delete if the file will be rewritable

        while ((content = fbr.readLine()) != null)
        {
            if (Integer.parseInt(content) > max)        // TODO: Delete if the file will be rewritable
                quantity = Integer.parseInt(content);
        }
        fbr.close();
        return quantity;
    }

    @Override
    public void setInfo(int newValue)
        throws IOException
    {
        BufferedWriter fbw =
            new BufferedWriter(
                 new FileWriter(file.getPath())
        );

        fbw.write(newValue);

        fbw.flush();
        fbw.close();
    }

    private int    quantity;
    private String content;
}
